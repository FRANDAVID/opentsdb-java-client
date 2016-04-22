package org.opentsdb.client;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.opentsdb.client.builder.IQueryBuilder;
import org.opentsdb.client.builder.MetricBuilder;
import org.opentsdb.client.response.ErrorDetail;
import org.opentsdb.client.response.QueryResponse;
import org.opentsdb.client.response.Response;
import org.opentsdb.client.response.ResponseEntry;
import org.opentsdb.client.response.SimpleHttpResponse;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * HTTP implementation of a client.
 */
public class HttpClientImpl implements HttpClient
{

    private static Logger logger = Logger.getLogger(HttpClientImpl.class);

    private String serviceUrl;

    private Gson mapper;

    PoolingHttpClient httpClient = new PoolingHttpClient();

    public HttpClientImpl(String serviceUrl)
    {
        this.serviceUrl = serviceUrl;

        GsonBuilder builder = new GsonBuilder();
        mapper = builder.create();
    }

    @Override
    public Response pushMetrics(MetricBuilder builder) throws IOException
    {
        return pushMetrics(builder, ExpectResponse.STATUS_CODE);

    }

    @Override
    public Response pushMetrics(MetricBuilder builder,
            ExpectResponse expectResponse) throws IOException
    {
        checkNotNull(builder);

        // TODO 错误处理，比如IOException或者failed>0，写到队列或者文件后续重试。
        SimpleHttpResponse response = httpClient
                .doPost(buildUrl(serviceUrl, POST_API, expectResponse),
                        builder.build());

        return getResponse(response);
    }

    private String buildUrl(String serviceUrl, String postApiEndPoint,
            ExpectResponse expectResponse)
    {
        String url = serviceUrl + postApiEndPoint;

        switch (expectResponse)
        {
            case SUMMARY:
                url += "?summary";
                break;
            case DETAIL:
                url += "?details";
                break;
            default:
                break;
        }

        return url;
    }

    private Response getResponse(SimpleHttpResponse httpResponse)
    {
        Response response = new Response(httpResponse.getStatusCode());
        String content = httpResponse.getContent();
        if (StringUtils.isNotEmpty(content))
        {
            if (response.isSuccess())
            {
                ErrorDetail errorDetail = mapper.fromJson(content,
                        ErrorDetail.class);
                response.setErrorDetail(errorDetail);
            }
            else
            {
                logger.error("request failed!" + httpResponse);
            }
        }
        return response;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.opentsdb.client.HttpClient#queryMetrics(org.opentsdb.client.builder.IQueryBuilder)
     */
    @Override
    public QueryResponse queryMetrics(IQueryBuilder queryBuilder) throws IOException
    {
        checkNotNull(queryBuilder);
        SimpleHttpResponse response = httpClient.doPost(buildUrl(serviceUrl, QUERY_API, ExpectResponse.RESULTS), queryBuilder.build());
        if (response.getStatusCode() == 200)
        {
            String json = response.getContent();
            List<ResponseEntry> entries = mapper.fromJson(json, new TypeToken<List<ResponseEntry>>() {}.getType());
            QueryResponse qResponse = new QueryResponse();
            qResponse.setEntries(entries);
            return qResponse;
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.opentsdb.client.HttpClient#suggest(org.opentsdb.client.SuggestType, java.lang.String, int)
     */
    @Override
    public List<String> suggest(SuggestType type, String query, Integer max) throws IOException
    {
        checkNotNull(type, "Type is required!");
        JsonObject request = new JsonObject();
        request.addProperty("type", type.getName());
        if (query != null)
        {
            request.addProperty("q", query);
        }
        if (max != null)
        {
            request.addProperty("max", max);
        }
        SimpleHttpResponse response = httpClient.doPost(buildUrl(serviceUrl, SUGGEST_API, ExpectResponse.RESULTS), request.toString());
        if (response.getStatusCode() == 200)
        {
            String json = response.getContent();
            List<String> entries = mapper.fromJson(json, new TypeToken<List<String>>() {}.getType());
            return entries;
        }
        return null;
    }
}
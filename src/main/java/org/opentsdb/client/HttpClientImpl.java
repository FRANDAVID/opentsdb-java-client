package org.opentsdb.client;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.opentsdb.client.builder.IQueryBuilder;
import org.opentsdb.client.builder.MetricBuilder;
import org.opentsdb.client.response.DataPoint;
import org.opentsdb.client.response.ErrorDetail;
import org.opentsdb.client.response.QueryResponse;
import org.opentsdb.client.response.Response;
import org.opentsdb.client.response.ResponseEntry;
import org.opentsdb.client.response.SimpleHttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
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
                ErrorDetail errorDetail = mapper.fromJson(content,
                        ErrorDetail.class);
                response.setErrorDetail(errorDetail);
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
        System.out.println(queryBuilder.build());
        SimpleHttpResponse response = httpClient.doPost(buildUrl(serviceUrl, QUERY_API, ExpectResponse.RESULTS), queryBuilder.build());
        if (response.getStatusCode() == 200)
        {
            String json = response.getContent();
            System.out.println(json);
            List<ResponseEntry> entries = mapper.fromJson(json, new TypeToken<List<ResponseEntry>>() {}.getType());
            extractDataPoints(entries);
            QueryResponse qResponse = new QueryResponse();
            qResponse.setEntries(entries);
            return qResponse;
        }
        return null;
    }

    protected void extractDataPoints(List<ResponseEntry> entries)
    {
        for (ResponseEntry entry : entries)
        {
            entry.setDataPointsList(mapDatapoints(entry.getDataPoints()));
        }
    }

    // to handle duplicates we must deserialize datapoints by hand
    protected List<DataPoint> mapDatapoints(JsonObject json)
    {
        List<DataPoint> points = new ArrayList<DataPoint>();
        for (Entry<String, JsonElement> e : json.entrySet())
        {
            DataPoint p = new DataPoint();
            p.setTimestamp(e.getKey());
            p.setValue(e.getValue().getAsNumber());
            points.add(p);
        }
        return points;
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

    /* (non-Javadoc)
     * @see org.opentsdb.client.HttpClient#deleteMetrics(org.opentsdb.client.builder.IQueryBuilder)
     */
    @Override
    public boolean deleteMetrics(IQueryBuilder queryBuilder) throws IOException
    {
        checkNotNull(queryBuilder);
        System.out.println(queryBuilder.build());
        SimpleHttpResponse response = httpClient.doPost(buildUrl(serviceUrl, QUERY_API, ExpectResponse.RESULTS), queryBuilder.build());
        if (response.getStatusCode() == 200)
        {
            return true;
        }
        return false;
    }
}
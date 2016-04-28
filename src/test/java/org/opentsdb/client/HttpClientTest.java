package org.opentsdb.client;

import java.io.IOException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.opentsdb.client.builder.Aggregator;
import org.opentsdb.client.builder.BaseQueryBuilder;
import org.opentsdb.client.builder.IQueryBuilder;
import org.opentsdb.client.builder.MetricBuilder;
import org.opentsdb.client.builder.Query;
import org.opentsdb.client.response.QueryResponse;
import org.opentsdb.client.response.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Ignore
public class HttpClientTest
{
    private Gson mapper = new GsonBuilder().create();

    HttpClientImpl client = new HttpClientImpl("http://192.168.120.120:4242");

    @Test
    public void test_pushMetrics_DefaultRetries()
    {

        MetricBuilder builder = MetricBuilder.getInstance();

        builder.addMetric("metric3.test1").setDataPoint(2, 30L)
                .addTag("tag1", "tab1value").addTag("tag2", "tab2value");

        builder.addMetric("metric3.test1").setDataPoint(3, 30L)
                .addTag("tag1", "tab2value").addTag("tag2", "tab2value");

        builder.addMetric("metric3.test2").setDataPoint(2, 232.34)
                .addTag("tag3", "tab3value");

        try
        {
            Response response = client.pushMetrics(builder,
                    ExpectResponse.SUMMARY);
            System.out.println(response);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryMetrics() throws IOException
    {
        Query query = new Query();
        query.setAggregator(Aggregator.SUM);
        query.setMetric("metric3.test1");
        IQueryBuilder queryBuilder = BaseQueryBuilder.getInstance().setStart(1l).addQuery(query);
        QueryResponse response = client.queryMetrics(queryBuilder);
        System.out.println(mapper.toJson(response.getEntries().get(0)));
        System.out.println(response.getEntries().get(0).getDataPointsList());
    }

    @Test
    public void testSuggest() throws IOException
    {
        List<String> suggests = client.suggest(SuggestType.METRICS, "metric1.", 100);
        System.out.println(suggests);
    }
}
/**
 *
 */
package org.opentsdb.client.builder;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * @author kmittag
 */
public class QueryBuilderTest
{

    @Test
    public void testBaseQueryBuilder() throws IOException
    {
        String expected = "{\"start\":1,\"end\":2,\"queries\":[{\"aggregator\":\"sum\",\"metric\":\"metric1\",\"filters\":[],\"tsuids\":[],\"downsample\":\"5s-avg\"}]}";
        Query query = new Query();
        query.setAggregator(Aggregator.SUM);
        query.setMetric("metric1");
        query.setDownsample("5s-avg");
        IQueryBuilder queryBuilder = BaseQueryBuilder.getInstance().setStart(1l).setEnd(2l).addQuery(query);
        String queryString = queryBuilder.build();
        System.out.println(expected);
        System.out.println(queryString);
        assertEquals(expected, queryString);
    }

    @Test
    public void testDeleteQueryBuilder() throws IOException
    {
        String expected = "{\"delete\":true,\"start\":1,\"end\":2,\"queries\":[{\"aggregator\":\"sum\",\"metric\":\"metric1\",\"filters\":[],\"tsuids\":[]}]}";
        Query query = new Query();
        query.setAggregator(Aggregator.SUM);
        query.setMetric("metric1");
        IQueryBuilder queryBuilder = DeleteQueryBuilder.getInstance().setDelete(true).setStart(1l).setEnd(2l).addQuery(query);
        String queryString = queryBuilder.build();
        System.out.println(queryString);
        assertEquals(expected, queryString);
    }
}

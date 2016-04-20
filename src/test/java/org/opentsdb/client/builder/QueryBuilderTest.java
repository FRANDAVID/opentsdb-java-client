/**
 *
 */
package org.opentsdb.client.builder;

import static org.junit.Assert.*;

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
        String expected = "{\"start\":1,\"end\":2,\"queries\":[{\"aggregator\":\"sum\",\"metric\":\"metric1\",\"filters\":[],\"tsuids\":[]}]}";
        Query query = new Query();
        query.setAggregator(Aggregator.SUM.getName());
        query.setMetric("metric1");
        IQueryBuilder queryBuilder = BaseQueryBuilder.getInstance().setStart(1l).setEnd(2l).addQuery(query);
        String queryString = queryBuilder.build();
        System.out.println(expected);
        System.out.println(queryString);
        assertEquals(expected, queryString);
    }

}

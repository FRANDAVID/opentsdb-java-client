/**
 *
 */
package org.opentsdb.client.builder;

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
        Query query = new Query();
        query.setAggregator(Aggregator.SUM.getName());
        query.setMetric("metric1");
        IQueryBuilder queryBuilder = BaseQueryBuilder.getInstance().setStart(1).addQuery(query);
        String queryString = queryBuilder.build();
        System.out.println(queryString);
    }

}

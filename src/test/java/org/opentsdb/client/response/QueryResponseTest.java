/**
 *
 */
package org.opentsdb.client.response;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author kmittag
 */
public class QueryResponseTest
{
    private Gson mapper = new GsonBuilder().create();

    @Test
    public void testQueryResponse() throws IOException
    {
        String json = Resources.toString(
                Resources.getResource("queryresponse.json"), Charsets.UTF_8);
        List<ResponseEntry> entries = mapper.fromJson(json, new TypeToken<List<ResponseEntry>>() {}.getType());
        QueryResponse response = new QueryResponse();
        response.setEntries(entries);
        System.out.println(mapper.toJson(response.getEntries().get(0)));
        assertEquals(1, response.getEntries().size());
        assertEquals("tsd.hbase.puts", response.getEntries().get(0).getMetric());
        System.out.println(response.getEntries().get(0).getDataPoints());
        System.out.println(response.getEntries().get(0).getDataPointsList());
    }
}

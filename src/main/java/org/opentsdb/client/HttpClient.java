package org.opentsdb.client;

import java.io.IOException;
import java.util.List;

import org.opentsdb.client.builder.IQueryBuilder;
import org.opentsdb.client.builder.MetricBuilder;
import org.opentsdb.client.response.QueryResponse;
import org.opentsdb.client.response.Response;

public interface HttpClient extends Client
{

    public Response pushMetrics(MetricBuilder builder,
            ExpectResponse exceptResponse) throws IOException;

    public QueryResponse queryMetrics(IQueryBuilder queryBuilder) throws IOException;
    
    public boolean deleteMetrics(IQueryBuilder queryBuilder) throws IOException;

    public List<String> suggest(SuggestType type, String query, Integer max) throws IOException;
}
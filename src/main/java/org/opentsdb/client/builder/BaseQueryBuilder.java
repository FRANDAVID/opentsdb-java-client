/**
 *
 */
package org.opentsdb.client.builder;

import static com.google.common.base.Preconditions.checkState;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author kmittag
 */
public class BaseQueryBuilder implements IQueryBuilder
{

    @SerializedName("start")
    @Expose
    private Long start;

    @SerializedName("end")
    @Expose
    private Long end;

    @SerializedName("queries")
    @Expose
    private List<Query> queries = new ArrayList<Query>();

    private transient Gson mapper;

    /**
     * 
     */
    private BaseQueryBuilder()
    {
        GsonBuilder builder = new GsonBuilder();
        mapper = builder.create();
    }

    /**
     * Returns a new query builder
     *
     * @return base query builder
     */
    public static BaseQueryBuilder getInstance()
    {
        return new BaseQueryBuilder();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.opentsdb.client.builder.IQueryBuilder#build()
     */
    @Override
    public String build() throws IOException
    {
        checkNotNull(start, "start timestamp is required!");
        checkState(queries.size() > 0, "at least one query is required!");
        for (Query q : queries)
        {
            checkNotNull(q, "query should not be null!");
            checkNotNull(q.getMetric(), q + " query needs a given metric");
            checkNotNull(q.getAggregator(), q + " query needs a given aggregator");
        }
        return mapper.toJson(this);
    }

    /**
     *
     * @return
     *         The start
     */
    public Long getStart()
    {
        return start;
    }

    /**
     *
     * @param start
     *            The start
     */
    public BaseQueryBuilder setStart(Long start)
    {
        this.start = start;
        return this;
    }

    /**
     *
     * @return
     *         The end
     */
    public Long getEnd()
    {
        return end;
    }

    /**
     *
     * @param end
     *            The end
     */
    public BaseQueryBuilder setEnd(Long end)
    {
        this.end = end;
        return this;
    }

    /**
     *
     * @return
     *         The queries
     */
    public List<Query> getQueries()
    {
        return queries;
    }

    /**
     *
     * @param queries
     *            The queries
     */
    public BaseQueryBuilder setQueries(List<Query> queries)
    {
        this.queries = queries;
        return this;
    }

    public BaseQueryBuilder addQuery(Query query)
    {
        this.queries.add(query);
        return this;
    }

}

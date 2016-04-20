/**
 *
 */
package org.opentsdb.client.builder;

/**
 * @author kmittag
 */
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Query
{

    @SerializedName("aggregator")
    @Expose
    private String aggregator;

    @SerializedName("metric")
    @Expose
    private String metric;

    @SerializedName("rate")
    @Expose
    private String rate;

    @SerializedName("filters")
    @Expose
    private List<Filter> filters = new ArrayList<Filter>();

    @SerializedName("tsuids")
    @Expose
    private List<String> tsuids = new ArrayList<String>();

    /**
     *
     * @return
     *         The aggregator
     */
    public String getAggregator()
    {
        return aggregator;
    }

    /**
     *
     * @param aggregator
     *            The aggregator
     */
    public void setAggregator(String aggregator)
    {
        this.aggregator = aggregator;
    }

    /**
     *
     * @return
     *         The metric
     */
    public String getMetric()
    {
        return metric;
    }

    /**
     *
     * @param metric
     *            The metric
     */
    public void setMetric(String metric)
    {
        this.metric = metric;
    }

    /**
     *
     * @return
     *         The rate
     */
    public String getRate()
    {
        return rate;
    }

    /**
     *
     * @param rate
     *            The rate
     */
    public void setRate(String rate)
    {
        this.rate = rate;
    }

    /**
     *
     * @return
     *         The filters
     */
    public List<Filter> getFilters()
    {
        return filters;
    }

    /**
     *
     * @param filters
     *            The filters
     */
    public void setFilters(List<Filter> filters)
    {
        this.filters = filters;
    }

    /**
     *
     * @return
     *         The tsuids
     */
    public List<String> getTsuids()
    {
        return tsuids;
    }

    /**
     *
     * @param tsuids
     *            The tsuids
     */
    public void setTsuids(List<String> tsuids)
    {
        this.tsuids = tsuids;
    }

}

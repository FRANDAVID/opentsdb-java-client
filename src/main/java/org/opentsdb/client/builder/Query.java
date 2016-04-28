/**
 *
 */
package org.opentsdb.client.builder;

/**
 * @author kmittag
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Query
{

    @SerializedName("aggregator")
    @Expose
    private Aggregator aggregator;

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

    @SerializedName("downsample")
    @Expose
    private String downsample;

    /**
     *
     * @return
     *         The aggregator
     */
    public Aggregator getAggregator()
    {
        return aggregator;
    }

    /**
     *
     * @param aggregator
     *            The aggregator
     */
    public void setAggregator(Aggregator aggregator)
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Query [aggregator=" + aggregator + ", metric=" + metric + ", rate=" + rate + ", filters=" + filters + ", tsuids=" + tsuids + ", downsample="
                + downsample + "]";
    }

    /**
     * @return the downsample
     */
    public String getDownsample()
    {
        return downsample;
    }

    /**
     * @param downsample
     *            the downsample to set
     */
    public void setDownsample(String downsample)
    {
        this.downsample = downsample;
    }

    // public void setDownsample(Aggregator aggregator, int time, String unit)
    // {
    // this.downsample = "" + time + unit + "-" + aggregator.getName();
    // }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aggregator == null) ? 0 : aggregator.hashCode());
        result = prime * result + ((downsample == null) ? 0 : downsample.hashCode());
        result = prime * result + ((filters == null) ? 0 : filters.hashCode());
        result = prime * result + ((metric == null) ? 0 : metric.hashCode());
        result = prime * result + ((rate == null) ? 0 : rate.hashCode());
        result = prime * result + ((tsuids == null) ? 0 : tsuids.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Query other = (Query) obj;
        if (aggregator == null)
        {
            if (other.aggregator != null) return false;
        }
        else if (!aggregator.equals(other.aggregator)) return false;
        if (downsample == null)
        {
            if (other.downsample != null) return false;
        }
        else if (!downsample.equals(other.downsample)) return false;
        if (filters == null)
        {
            if (other.filters != null) return false;
        }
        else if (!filters.equals(other.filters)) return false;
        if (metric == null)
        {
            if (other.metric != null) return false;
        }
        else if (!metric.equals(other.metric)) return false;
        if (rate == null)
        {
            if (other.rate != null) return false;
        }
        else if (!rate.equals(other.rate)) return false;
        if (tsuids == null)
        {
            if (other.tsuids != null) return false;
        }
        else if (!tsuids.equals(other.tsuids)) return false;
        return true;
    }

}

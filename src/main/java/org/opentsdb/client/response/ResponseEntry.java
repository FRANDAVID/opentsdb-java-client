/**
 *
 */
package org.opentsdb.client.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author kmittag
 */
@Generated("org.jsonschema2pojo")
public class ResponseEntry
{

    @SerializedName("metric")
    @Expose
    private String metric;

    @SerializedName("tags")
    @Expose
    private Map<String, String> tags;

    @SerializedName("aggregatedTags")
    @Expose
    private List<String> aggregatedTags = new ArrayList<String>();

    @SerializedName("annotations")
    @Expose
    private List<Annotation> annotations = new ArrayList<Annotation>();

    @SerializedName("globalAnnotations")
    @Expose
    private List<Annotation> globalAnnotations = new ArrayList<Annotation>();

    @SerializedName("tsuids")
    @Expose
    private List<String> tsuids = new ArrayList<String>();

    @SerializedName("dps")
    @Expose
    private Map<String, Number> dataPoints;

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
     *         The tags
     */
    public Map<String, String> getTags()
    {
        return tags;
    }

    /**
     *
     * @param tags
     *            The tags
     */
    public void setTags(Map<String, String> tags)
    {
        this.tags = tags;
    }

    /**
     *
     * @return
     *         The aggregatedTags
     */
    public List<String> getAggregatedTags()
    {
        return aggregatedTags;
    }

    /**
     *
     * @param aggregatedTags
     *            The aggregatedTags
     */
    public void setAggregatedTags(List<String> aggregatedTags)
    {
        this.aggregatedTags = aggregatedTags;
    }

    /**
     *
     * @return
     *         The annotations
     */
    public List<Annotation> getAnnotations()
    {
        return annotations;
    }

    /**
     *
     * @param annotations
     *            The annotations
     */
    public void setAnnotations(List<Annotation> annotations)
    {
        this.annotations = annotations;
    }

    /**
     *
     * @return
     *         The globalAnnotations
     */
    public List<Annotation> getGlobalAnnotations()
    {
        return globalAnnotations;
    }

    /**
     *
     * @param globalAnnotations
     *            The globalAnnotations
     */
    public void setGlobalAnnotations(List<Annotation> globalAnnotations)
    {
        this.globalAnnotations = globalAnnotations;
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

    /**
     *
     * @return
     *         The dps
     */
    public Map<String, Number> getDataPoints()
    {
        return dataPoints;
    }

    /**
     *
     * @param dps
     *            The dps
     */
    public void setDataPoints(Map<String, Number> dps)
    {
        this.dataPoints = dps;
    }

}

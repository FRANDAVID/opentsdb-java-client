/**
 *
 */
package org.opentsdb.client.builder;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author kmittag
 */
@Generated("org.jsonschema2pojo")
public class Filter
{

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("tagk")
    @Expose
    private String tagk;

    @SerializedName("filter")
    @Expose
    private String filter;

    @SerializedName("groupBy")
    @Expose
    private Boolean groupBy;

    /**
     *
     * @return
     *         The type
     */
    public String getType()
    {
        return type;
    }

    /**
     *
     * @param type
     *            The type
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     *
     * @return
     *         The tagk
     */
    public String getTagk()
    {
        return tagk;
    }

    /**
     *
     * @param tagk
     *            The tagk
     */
    public void setTagk(String tagk)
    {
        this.tagk = tagk;
    }

    /**
     *
     * @return
     *         The filter
     */
    public String getFilter()
    {
        return filter;
    }

    /**
     *
     * @param filter
     *            The filter
     */
    public void setFilter(String filter)
    {
        this.filter = filter;
    }

    /**
     *
     * @return
     *         The groupBy
     */
    public Boolean getGroupBy()
    {
        return groupBy;
    }

    /**
     *
     * @param groupBy
     *            The groupBy
     */
    public void setGroupBy(Boolean groupBy)
    {
        this.groupBy = groupBy;
    }

}

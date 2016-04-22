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

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((filter == null) ? 0 : filter.hashCode());
        result = prime * result + ((groupBy == null) ? 0 : groupBy.hashCode());
        result = prime * result + ((tagk == null) ? 0 : tagk.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Filter other = (Filter) obj;
        if (filter == null)
        {
            if (other.filter != null) return false;
        }
        else if (!filter.equals(other.filter)) return false;
        if (groupBy == null)
        {
            if (other.groupBy != null) return false;
        }
        else if (!groupBy.equals(other.groupBy)) return false;
        if (tagk == null)
        {
            if (other.tagk != null) return false;
        }
        else if (!tagk.equals(other.tagk)) return false;
        if (type == null)
        {
            if (other.type != null) return false;
        }
        else if (!type.equals(other.type)) return false;
        return true;
    }

}

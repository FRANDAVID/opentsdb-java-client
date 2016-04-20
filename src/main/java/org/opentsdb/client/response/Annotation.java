/**
 *
 */
package org.opentsdb.client.response;

import java.util.Map;

/**
 * @author kmittag
 */
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Annotation
{

    @SerializedName("tsuid")
    @Expose
    private String tsuid;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("notes")
    @Expose
    private String notes;

    @SerializedName("custom")
    @Expose
    private Map<String, String> custom;

    @SerializedName("endTime")
    @Expose
    private Long endTime;

    @SerializedName("startTime")
    @Expose
    private Long startTime;

    /**
     *
     * @return
     *         The tsuid
     */
    public String getTsuid()
    {
        return tsuid;
    }

    /**
     *
     * @param tsuid
     *            The tsuid
     */
    public void setTsuid(String tsuid)
    {
        this.tsuid = tsuid;
    }

    /**
     *
     * @return
     *         The description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     *
     * @param description
     *            The description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     *
     * @return
     *         The notes
     */
    public String getNotes()
    {
        return notes;
    }

    /**
     *
     * @param notes
     *            The notes
     */
    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    /**
     *
     * @return
     *         The custom
     */
    public Map<String, String> getCustom()
    {
        return custom;
    }

    /**
     *
     * @param custom
     *            The custom
     */
    public void setCustom(Map<String, String> custom)
    {
        this.custom = custom;
    }

    /**
     *
     * @return
     *         The endTime
     */
    public Long getEndTime()
    {
        return endTime;
    }

    /**
     *
     * @param endTime
     *            The endTime
     */
    public void setEndTime(Long endTime)
    {
        this.endTime = endTime;
    }

    /**
     *
     * @return
     *         The startTime
     */
    public Long getStartTime()
    {
        return startTime;
    }

    /**
     *
     * @param startTime
     *            The startTime
     */
    public void setStartTime(Long startTime)
    {
        this.startTime = startTime;
    }

}

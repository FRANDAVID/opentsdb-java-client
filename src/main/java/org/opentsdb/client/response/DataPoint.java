/**
 *
 */
package org.opentsdb.client.response;

import com.google.gson.annotations.Expose;

/**
 * @author kmittag
 */
public class DataPoint
{
    @Expose
    private String timestamp;
    
    @Expose
    private Number value;

    /**
     * @return the timestamp
     */
    public String getTimestamp()
    {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }

    /**
     * @return the value
     */
    public Number getValue()
    {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Number value)
    {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "DataPoint [timestamp=" + timestamp + ", value=" + value + "]";
    }
    
    
    
}

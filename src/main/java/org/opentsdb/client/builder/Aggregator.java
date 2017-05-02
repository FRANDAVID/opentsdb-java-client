/**
 *
 */
package org.opentsdb.client.builder;

import com.google.gson.annotations.SerializedName;

/**
 * @author kmittag
 */
public enum Aggregator
{
    @SerializedName("mimmin")
    MIMMIN("mimmin"),
    @SerializedName("ep95r3")
    EP95R3("ep95r3"),
    @SerializedName("p999")
    P999("p999"),
    @SerializedName("count")
    COUNT("count"),
    @SerializedName("dev")
    DEV("dev"),
    @SerializedName("ep95r7")
    EP95R7("ep95r7"),
    @SerializedName("sum")
    SUM("sum"),
    @SerializedName("ep90r3")
    EP90R3("ep90r3"),
    @SerializedName("ep90r7")
    EP90R7("ep90r7"),
    @SerializedName("avg")
    AVG("avg"),
    @SerializedName("min")
    MIN("min"),
    @SerializedName("ep50r7")
    EP50R7("ep50r7"),
    @SerializedName("max")
    MAX("max"),
    @SerializedName("mimmax")
    MIMMAX("mimmax"),
    @SerializedName("p99")
    P99("p99"),
    @SerializedName("ep99r7")
    EP99R7("ep99r7"),
    @SerializedName("ep999r7")
    EP999R7("ep999r7"),
    @SerializedName("ep50r3")
    EP50R3("ep50r3"),
    @SerializedName("ep999r3")
    EP999R3("ep999r3"),
    @SerializedName("ep75r3")
    EP75R3("ep75r3"),
    @SerializedName("p90")
    P90("p90"),
    @SerializedName("ep75r7")
    EP75R7("ep75r7"),
    @SerializedName("p50")
    P50("p50"),
    @SerializedName("p75")
    P75("p75"),
    @SerializedName("p95")
    P95("p95"),
    @SerializedName("ep99r3")
    EP99R3("ep99r3"),
    @SerializedName("zimsum")
    ZIMSUM("zimsum");

    String name;

    /**
     * 
     */
    private Aggregator(String name)
    {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

   
    
    
}

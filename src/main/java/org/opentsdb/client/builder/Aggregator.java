/**
 *
 */
package org.opentsdb.client.builder;

/**
 * @author kmittag
 */
public enum Aggregator
{
    MIMMIN("mimmin"),
    EP95R3("ep95r3"),
    P999("p999"),
    COUNT("count"),
    DEV("dev"),
    EP95R7("ep95r7"),
    SUM("sum"),
    EP90R3("ep90r3"),
    EP90R7("ep90r7"),
    AVG("avg"),
    MIN("min"),
    EP50R7("ep50r7"),
    MAX("max"),
    MIMMAX("mimmax"),
    P99("p99"),
    EP99R7("ep99r7"),
    EP999R7("ep999r7"),
    EP50R3("ep50r3"),
    EP999R3("ep999r3"),
    EP75R3("ep75r3"),
    P90("p90"),
    EP75R7("ep75r7"),
    P50("p50"),
    P75("p75"),
    P95("p95"),
    EP99R3("ep99r3"),
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

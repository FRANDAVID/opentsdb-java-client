/**
 *
 */
package org.opentsdb.client;

/**
 * @author kmittag
 */
public enum SuggestType
{
    METRICS("metrics"),
    TAGK("tagK"),
    TAGV("tagV");

    String name;

    /**
     * 
     */
    private SuggestType(String name)
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

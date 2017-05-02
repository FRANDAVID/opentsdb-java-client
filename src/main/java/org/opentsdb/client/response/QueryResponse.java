/**
 *
 */
package org.opentsdb.client.response;

/**
 * @author kmittag
 */
import java.util.ArrayList;
import java.util.List;

public class QueryResponse
{
    List<ResponseEntry> entries = new ArrayList<ResponseEntry>();

    /**
    * 
    */
    public QueryResponse()
    {
    }

    /**
     * @return the entries
     */
    public List<ResponseEntry> getEntries()
    {
        return entries;
    }

    /**
     * @param entries the entries to set
     */
    public void setEntries(List<ResponseEntry> entries)
    {
        this.entries = entries;
    }
    
    
}
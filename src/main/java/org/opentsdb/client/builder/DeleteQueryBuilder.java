/**
 *
 */
package org.opentsdb.client.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author kmittag
 */
public class DeleteQueryBuilder extends BaseQueryBuilder
{
 
    @SerializedName("delete")
    @Expose
    private Boolean delete;
    
    /**
     * 
     */
    protected DeleteQueryBuilder()
    {
       super();
    }
    
    
    /**
     * Returns a new query builder
     *
     * @return base query builder
     */
    public static DeleteQueryBuilder getInstance()
    {
        return new DeleteQueryBuilder();
    }
    
    @Override
    public String build() throws IOException
    {
        checkNotNull(delete, "delete option is required!");
        return mapper.toJson(this);
    }

    /**
     * @return the delete
     */
    public Boolean getDelete()
    {
        return delete;
    }

    /**
     * @param delete the delete to set
     */
    public DeleteQueryBuilder setDelete(Boolean delete)
    {
        this.delete = delete;
        return this;
    }
    
    /**
    *
    * @return
    *         The start
    */
   public Long getStart()
   {
       return start;
   }

   /**
    *
    * @param start
    *            The start
    */
   public DeleteQueryBuilder setStart(Long start)
   {
       this.start = start;
       return this;
   }

   /**
    *
    * @return
    *         The end
    */
   public Long getEnd()
   {
       return end;
   }

   /**
    *
    * @param end
    *            The end
    */
   public DeleteQueryBuilder setEnd(Long end)
   {
       this.end = end;
       return this;
   }

   /**
    *
    * @return
    *         The queries
    */
   public List<Query> getQueries()
   {
       return queries;
   }

   /**
    *
    * @param queries
    *            The queries
    */
   public DeleteQueryBuilder setQueries(List<Query> queries)
   {
       this.queries = queries;
       return this;
   }

   public DeleteQueryBuilder addQuery(Query query)
   {
       this.queries.add(query);
       return this;
   }

}

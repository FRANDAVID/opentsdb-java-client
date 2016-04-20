///**
// *
// */
//package org.opentsdb.client.builder;
//
//import java.util.ArrayList;
//import java.util.List;
//import javax.annotation.Generated;
//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;
//
///**
// * @author kmittag
// */
//@Generated("org.jsonschema2pojo")
//public class BaseQuery implements IQuery
//{
//
//    @SerializedName("start")
//    @Expose
//    private Integer start;
//
//    @SerializedName("end")
//    @Expose
//    private Integer end;
//
//    @SerializedName("queries")
//    @Expose
//    private List<Query> queries = new ArrayList<Query>();
//
//    /**
//     *
//     * @return
//     *         The start
//     */
//    public Integer getStart()
//    {
//        return start;
//    }
//
//    /**
//     *
//     * @param start
//     *            The start
//     */
//    public void setStart(Integer start)
//    {
//        this.start = start;
//    }
//
//    /**
//     *
//     * @return
//     *         The end
//     */
//    public Integer getEnd()
//    {
//        return end;
//    }
//
//    /**
//     *
//     * @param end
//     *            The end
//     */
//    public void setEnd(Integer end)
//    {
//        this.end = end;
//    }
//
//    /**
//     *
//     * @return
//     *         The queries
//     */
//    public List<Query> getQueries()
//    {
//        return queries;
//    }
//
//    /**
//     *
//     * @param queries
//     *            The queries
//     */
//    public void setQueries(List<Query> queries)
//    {
//        this.queries = queries;
//    }
//
//    public void addQuery(Query query)
//    {
//        this.queries.add(query);
//    }
//
//}
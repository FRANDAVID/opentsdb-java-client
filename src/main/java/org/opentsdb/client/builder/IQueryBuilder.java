/**
 *
 */
package org.opentsdb.client.builder;

import java.io.IOException;

/**
 * @author kmittag
 */
public interface IQueryBuilder
{
    public String build() throws IOException;
}

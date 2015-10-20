package org.opentsdb.client;

import java.io.IOException;

import org.opentsdb.client.builder.MetricBuilder;
import org.opentsdb.client.response.Response;

public interface Client {

	// weijin add test 
	// 2015-10-20 second test
	// 第3次修改
	public final static Integer GIT=0;
	public final static String POST_API = "/api/put";

	/**
	 * Sends metrics from the builder to the KairosDB server.
	 *
	 * @param builder
	 *            metrics builder
	 * @return response from the server
	 * @throws IOException
	 *             problem occurred sending to the server
	 */
	Response pushMetrics(MetricBuilder builder) throws IOException;

}

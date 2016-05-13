package org.opentsdb.client.response;

/**
 * @author argan
 *
 */
public class SimpleHttpResponse {
	private int statusCode;
	private String statusContent;
	private String content;

	public boolean isSuccess() {
		return statusCode == 200 || statusCode == 204;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

    /**
     * @return the statusContent
     */
    public String getStatusContent()
    {
        return statusContent;
    }

    /**
     * @param statusContent the statusContent to set
     */
    public void setStatusContent(String statusContent)
    {
        this.statusContent = statusContent;
    }
	
	

}

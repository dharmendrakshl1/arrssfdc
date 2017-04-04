package com.arris.sfdc.pojo;

import java.io.Serializable;

public class SessionBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 599350175346802093L;
	
	private String sessionId;
	private String sessionIdGeneratedDateTime;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getSessionIdGeneratedDateTime() {
		return sessionIdGeneratedDateTime;
	}
	public void setSessionIdGeneratedDateTime(String sessionIdGeneratedDateTime) {
		this.sessionIdGeneratedDateTime = sessionIdGeneratedDateTime;
	}
	
}

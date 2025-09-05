package com.databricksConnectionSample.utils;

/**
 * General Utility functions for Databricks
 */
public class DatabricksConnectionSampleUtils {

	public static String constructJDBCURL(String host, String httpPath, String token) {
		return "jdbc:databricks://" + 
				host + 
				":443/default;transportMode=http;ssl=1;httpPath=" + 
				httpPath + 
				";AuthMech=3;UID=token;PWD=" + 
				token;
	}
}

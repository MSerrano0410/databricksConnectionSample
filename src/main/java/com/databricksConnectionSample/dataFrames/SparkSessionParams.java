package com.databricksConnectionSample.dataFrames;

import org.apache.spark.sql.SparkSession;
import com.databricksConnectionSample.constants.DatabricksConnectionSampleConstants;
import com.databricksConnectionSample.utils.DatabricksConnectionSampleUtils;

/**
 * Object holding parameters to establish a Spark session
 */
public class SparkSessionParams {
	private String appName;
	private String delimiter;
	private String jdbcUrl;
	private String user;
	private SparkSession session;
	
	public SparkSessionParams(String host, String httpPath, String token, 
			String appName, String delimiter, 
			String user) {
		this.jdbcUrl = DatabricksConnectionSampleUtils.constructJDBCURL(
				host,
				httpPath,
				token
		);
		
		this.appName = appName;
		this.delimiter = delimiter;
		this.user = user;
		this.setSession();
	}
	
	//default values
	public SparkSessionParams(String appName) {
		this.jdbcUrl = DatabricksConnectionSampleUtils.constructJDBCURL(
				DatabricksConnectionSampleConstants.DATABRICKS_HOST,
				DatabricksConnectionSampleConstants.DATABRICKS_HTTP_PATH,
				DatabricksConnectionSampleConstants.DATABRICKS_TOKEN
		);
		
		this.appName = appName;
		this.delimiter = ",";
		this.user = "local";
		this.setSession();
	}
	
	public SparkSessionParams(String appName, String host, String httpPath, String token) {
		this.jdbcUrl = DatabricksConnectionSampleUtils.constructJDBCURL(
				host,
				httpPath,
				token
		);
		
		this.appName = appName;
		this.delimiter = ",";
		this.user = "local";
		this.setSession();
	}
	
	public String getAppName() {
		return appName;
	}
	
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	public String getDelimiter() {
		return delimiter;
	}
	
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public SparkSession getSession() {
		return session;
	}

	public void setSession() {
		this.session = SparkSession.builder()
				.appName(this.appName)
				.master("local[*]")
				.getOrCreate();
	}
}

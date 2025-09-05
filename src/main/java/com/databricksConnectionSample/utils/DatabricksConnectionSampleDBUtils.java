package com.databricksConnectionSample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import com.databricksConnectionSample.constants.DatabricksConnectionSampleConstants;
import com.databricksConnectionSample.tables.DatabricksTable;
import com.databricksConnectionSample.tables.DatabricksTableColumn;

/**
 * Class for DB utils. Has constructors for both default databricks
 * connection details (in Constants), or custom details in constructor.
 */
public class DatabricksConnectionSampleDBUtils {
	private String databricks_host;
	private String databricks_http_path;
	private String databricks_token;
	private String jdbcUrl;
	
	public DatabricksConnectionSampleDBUtils() {
		this.databricks_host = DatabricksConnectionSampleConstants.DATABRICKS_HOST;
		this.databricks_http_path = DatabricksConnectionSampleConstants.DATABRICKS_HTTP_PATH;
		this.databricks_token = DatabricksConnectionSampleConstants.DATABRICKS_TOKEN;
		this.jdbcUrl = setJDBCUrl();
	}
	
	public DatabricksConnectionSampleDBUtils(String host, String http_path, String token) {
		this.databricks_host = host;
		this.databricks_http_path = http_path;
		this.databricks_token = token;
		this.jdbcUrl = setJDBCUrl();
	}
	
	public String setJDBCUrl() {
		return DatabricksConnectionSampleUtils.constructJDBCURL(
				this.databricks_host, 
				this.databricks_http_path, 
				this.databricks_token);
	}
	
	/**
	 * Executes a query
	 * TODO: Get ResultSet and check for exceptions from Databricks
	 * @param query - String query to run.
	 * @return true if successful, false otherwise.
	 */
	public boolean executeDBQuery(String query) {
		try {
			Connection conn = DriverManager.getConnection(this.jdbcUrl);
			Statement statement = conn.createStatement();
			statement.execute(query);			
			conn.close();
			statement.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void writeDataFrame(Dataset<Row> df, String dbName, String tableName) {
		df.write()
		.format(DatabricksConnectionSampleConstants.JDBC_SPARK_FORMAT)
		.option("url", this.jdbcUrl)
		.option("dbtable", tableName)
		.option("user", DatabricksConnectionSampleConstants.JDBC_SPARK_DEFAULT_USER);
		
	}
/********QUERY/JAVA OBJECT BUILDERS**********/
	
	/**
	 * Creates a database in databricks.
	 * TODO: Have output in console or in slf4j log for pass/fail
	 * @param dbName - database name
	 * @return true if query successful, false otherwise
	 */
	public boolean createDatabricksDB(String dbName) {
		String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
		return executeDBQuery(createDatabaseSQL);
	}
	
	/**
	 * Creates a table in the given database.
	 * @param dbName
	 * @param tableName
	 * @param initialSchema
	 * @return
	 */
	public boolean createDatabricksTable(String dbName, String tableName, List<DatabricksTableColumn> initialSchema) {
		DatabricksTable table = new DatabricksTable(dbName, tableName, initialSchema);
		return executeDBQuery(table.constructCreateTableString());
	}
}

package com.databricksConnectionSample.dataFrames;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

/**
 * Sets DataFrame object with given Spark Session parameters
 */
public class DataframeSparkSession {
	public SparkSessionParams params;
	public Dataset<Row> dataFrame;
	public String mode;
	public String filePath;
	public boolean header;
	public boolean inferSchema;
	
	public DataframeSparkSession(SparkSessionParams params, String mode, String filePath,
			boolean header, boolean inferSchema) {
		this.params = params;
		this.mode = mode;
		this.filePath = filePath;
		this.header = header;
		this.inferSchema = inferSchema;
		setDataFrame();
	}
	
	public DataframeSparkSession(SparkSessionParams params, String filePath) {
		this.params = params;
		this.mode = "PERMISSIVE";
		this.filePath = filePath;
		this.header = true;
		this.inferSchema = true;
		setDataFrame();
	}
	
	public void setDataFrame() {
		/*
		this.dataFrame = this.params.getSession().read()
				.option("header", this.header)
				.option("inferSchema", this.inferSchema)
				.option("mode", this.mode)
				.csv(this.filePath);
				*/
	}

	public Dataset<Row> getDataFrame() {
		return dataFrame;
	}
	
	public void showDataFrame() {
		if (this.dataFrame != null) {
			this.dataFrame.show();
		}
	}
}

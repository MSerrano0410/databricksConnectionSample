package com.databricksConnectionSample.main;

import com.databricks.sdk.WorkspaceClient;
import com.databricks.sdk.service.compute.ClusterDetails;
import com.databricks.sdk.service.compute.ListClustersRequest;
import com.databricksConnectionSample.constants.DatabricksConnectionSampleConstants;
import com.databricksConnectionSample.dataFrames.DataframeSparkSession;
import com.databricksConnectionSample.dataFrames.SparkSessionParams;
import com.databricksConnectionSample.utils.DatabricksConnectionSampleDBUtils;
import com.databricks.sdk.core.DatabricksConfig;

public class DatabricksConnectionMain {
	public static void main(String[] args) {
		//DatabricksConfig cfg = new DatabricksConfig();
		WorkspaceClient currentWorkspace = new WorkspaceClient();
		DatabricksConnectionSampleDBUtils dbConnection = new DatabricksConnectionSampleDBUtils();
		dbConnection.createDatabricksDB("file_compare");
		
		//this can be obtained from a schema, say, in csv format provided by the client.
		dbConnection.createDatabricksTable("file_compare", "imrf_payee_state_41762", 
				DatabricksConnectionSampleConstants.IRMF_PAYEE_COLUMN_LIST);
		
		//load csv into a dataframe object
		SparkSessionParams params = new SparkSessionParams("Example CSV Read");
		DataframeSparkSession session = new DataframeSparkSession(params, "C:/Users/MarvinCorser/Downloads/sample.csv");
		session.showDataFrame();
	}
}

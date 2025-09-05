package com.databricksConnectionSample.constants;

import java.util.List;

import com.databricksConnectionSample.tables.DatabricksTableColumn;

public class DatabricksConnectionSampleConstants {
	public static final String DATABRICKS_HOST = "dbc-30ed1d89-a23d.cloud.databricks.com";
	public static final String DATABRICKS_TOKEN = "dapi0f68cee593ee1e86d66e87e1301c0f5e";
	public static final String DATABRICKS_HTTP_PATH = "/sql/1.0/warehouses/d99691dd28ceed75";
	public static final String DATABRICKS_SERVER_HOSTNAME = "dbc-30ed1d89-a23d.cloud.databricks.com";
	public static final String OAUTH_URL = "https://dbc-30ed1d89-a23d.cloud.databricks.com/oidc";
	public static final String DB_NAME = "file_compare";
	
	//SPARK CONSTANTS
	public static final String JDBC_SPARK_FORMAT = "jdbc";
	public static final String JDBC_SPARK_DEFAULT_USER = "token";
	
	//TODO: Put into separate object, maybe read in from a local file
	//into a Map that gets passed to the create table function	
			
	public static final List<DatabricksTableColumn> IRMF_PAYEE_COLUMN_LIST = List.of(
		    new DatabricksTableColumn("separate_cd", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("valid_ind", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("primary_tin", "VARCHAR", 9, null, false),
		    new DatabricksTableColumn("student_ind", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("dist_code_1099k", "VARCHAR", 2, null, false),
		    new DatabricksTableColumn("merch_category_cd", "VARCHAR", 4, null, false),
		    new DatabricksTableColumn("student_ind_grad", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("reserve2", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("ind1099k", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("document_code", "VARCHAR", 2, null, false),
		    new DatabricksTableColumn("payer_tin", "VARCHAR", 9, null, false),
		    new DatabricksTableColumn("payer_tin_type", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("amended_indicator", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("tax_year", "VARCHAR", 4, null, false),
		    new DatabricksTableColumn("payment_cd_1", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("payment_sign_1", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payment_amt_1", "VARCHAR", 11, null, false),
		    new DatabricksTableColumn("payment_cd_2", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("payment_sign_2", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payment_amt_2", "VARCHAR", 11, null, false),
		    new DatabricksTableColumn("payment_cd_3", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("payment_sign_3", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payment_amt_3", "VARCHAR", 11, null, false),
		    new DatabricksTableColumn("payment_cd_4", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("payment_sign_4", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payment_amt_4", "VARCHAR", 11, null, false),
		    new DatabricksTableColumn("payment_cd_5", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("payment_sign_5", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payment_amt_5", "VARCHAR", 11, null, false),
		    new DatabricksTableColumn("payment_cd_6", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("payment_sign_6", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payment_amt_6", "VARCHAR", 11, null, false),
		    new DatabricksTableColumn("payment_cd_7", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("payment_sign_7", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payment_amt_7", "VARCHAR", 11, null, false),
		    new DatabricksTableColumn("payment_cd_8", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("payment_sign_8", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payment_amt_8", "VARCHAR", 11, null, false),
		    new DatabricksTableColumn("payment_cd_9", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("payment_sign_9", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payment_amt_9", "VARCHAR", 11, null, false),
		    new DatabricksTableColumn("payment_cd_10", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("payment_sign_10", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payment_amt_10", "VARCHAR", 11, null, false),
		    new DatabricksTableColumn("payment_cd_11", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("payment_sign_11", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payment_amt_11", "VARCHAR", 11, null, false),
		    new DatabricksTableColumn("payment_cd_12", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("payment_sign_12", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payment_amt_12", "VARCHAR", 11, null, false),
		    new DatabricksTableColumn("payment_cd_13", "VARCHAR", 3, null, false),
		    new DatabricksTableColumn("payment_sign_13", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payment_amt_13", "VARCHAR", 11, null, false),
		    new DatabricksTableColumn("payer_acct_num", "VARCHAR", 20, null, false),
		    new DatabricksTableColumn("perfection_history", "VARCHAR", 2, null, false),
		    new DatabricksTableColumn("change_tin_ind", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("chng_nm_ctrl_ind", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("payee_name_line_1", "VARCHAR", 50, null, false),
		    new DatabricksTableColumn("payee_name_line_2", "VARCHAR", 40, null, false),
		    new DatabricksTableColumn("payee_address", "VARCHAR", 40, null, false),
		    new DatabricksTableColumn("payee_city_state", "VARCHAR", 40, null, false),
		    new DatabricksTableColumn("payee_zip_cd", "VARCHAR", 9, null, false),
		    new DatabricksTableColumn("payer_name_line_1", "VARCHAR", 40, null, false),
		    new DatabricksTableColumn("payer_name_line_2", "VARCHAR", 40, null, false),
		    new DatabricksTableColumn("payer_address_line", "VARCHAR", 40, null, false),
		    new DatabricksTableColumn("payer_city_state_zip", "VARCHAR", 40, null, false),
		    new DatabricksTableColumn("direct_sales", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("gambling_cd", "VARCHAR", 1, null, false),
		    new DatabricksTableColumn("item_desc", "VARCHAR", 38, null, false),
		    new DatabricksTableColumn("bond_cusip", "VARCHAR", 13, null, false),
		    new DatabricksTableColumn("job_id", "VARCHAR", 50, null, false),
		    new DatabricksTableColumn("source_file_nm", "VARCHAR", 11, null, true)
		);
}

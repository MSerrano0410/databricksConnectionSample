------------------TOKEN GENERATION------------------------
1) Log into your Databricks account in a web browser.
2) Navigate to your user account icon (top-right corner), then go to Settings.
3) Under the User tab, click Developer
4) Next to Access tokens, click Manage
5) Click Generate new token and fill out the required fields.
6) Copy the generated token to a file you have saved locally; IT WILL NOT BE ACCESSIBLE AFTER YOU CLOSE THE WINDOW.

------------------AUTHENTICATION METHODS------------------
Environment variables:
Set these environment variables. By default, Databricks CLI uses these variables for
authentication:

DATABRICKS_HOST

This environment variable is set to the URL of either your Databricks account console (http://accounts.cloud.databricks.com) or your Databricks workspace URL (https://{workspace-id}.cloud.databricks.com). Choose a host URL type based on the type of operations your code performs. Specifically, if you're using Databricks account-level CLI commands or REST API requests, set this variable to your Databricks account URL. If you're using Databricks workspace-level CLI commands or REST API requests, use your Databricks workspace URL.

DATABRICKS_ACCOUNT_ID

Used for Databricks account operations. This is your Databricks account ID. To get it, see Locate your account ID.

DATABRICKS_CLIENT_ID

(Service principal OAuth only) The client ID you were assigned when creating your service principal.

DATABRICKS_CLIENT_SECRET

(Service principal OAuth only) The client secret you generated when creating your service principal.




Configuration file:
Create a .databrickscfg in your home directory (C:/Users/YourUsername on Windows) with the following (assuming just one DEFAULT profile, which is used by default):
[DEFAULT]

host = https://your-host-URL-for-Databricks
token = your-generated-API-token

You'd then have to set the DATABRICKS_CONFIG_PROFILE environment variable to point to this config file. This option is used automatically by Databricks CLI if the above environment variables are not found.



Hard-coding:
Not recommended for production builds, but generally a fine temporary workaround for local environments. You'd need to instantiate a WorkspaceClient in your Java code as follows:
DatabricksConfig cfg = new DatabricksConfig()
				.setHost("https://your-Databricks-URL")
				.setToken("your-generated-api-token");
		WorkspaceClient currentWorkspace = new WorkspaceClient(cfg);
		
Coding Notes:
Add the following:
- ability to read a schema from a .csv file to populate a table
- read files recursively from a given volume and compare them based on naming convention provided (mainly prefixes/suffixes/codes)
- identify if files are structured (i.e. csv files) or unstructured (i.e. txt files) and compare based on that. For instance, csvs have rows/columns while txt files have lines
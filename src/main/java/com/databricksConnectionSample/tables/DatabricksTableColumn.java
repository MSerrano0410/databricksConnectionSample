package com.databricksConnectionSample.tables;

/**
 * Represents a table column definition in a Databricks DB
 */
public class DatabricksTableColumn {
	private String columnName;
	private String columnDatatype;
	private int columnSize;
	private String defaultValue;
	private boolean isPrimaryKey;
	
	public DatabricksTableColumn(String columnName,
			String columnDatatype,
			int columnSize,
			String defaultValue,
			boolean isPrimaryKey) {
		this.columnName = columnName;
		this.columnDatatype = columnDatatype;
		this.columnSize = columnSize;
		this.defaultValue = defaultValue;
		this.isPrimaryKey = isPrimaryKey;
	}
	
	public String getDefaultValue() {
		return defaultValue;
	}
	
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	public String getColumnDatatype() {
		return columnDatatype;
	}
	
	public void setColumnDatatype(String columnDatatype) {
		this.columnDatatype = columnDatatype;
	}
	
	public int getColumnSize() {
		return columnSize;
	}
	
	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
	}
	
	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}
	
	public void setPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}
	
	/**
	 * Constructs the string used to insert into the CREATE TABLE
	 * statement for the table
	 * @return
	 */
	public String constructCreateColumnString() {
		String createTableString = this.columnName + " " + this.columnDatatype;
		if (this.columnSize != 0) {
			createTableString += "(" + this.columnSize + ")";
		}
		
		if (this.defaultValue != null) {
			createTableString += " DEFAULT '" + this.defaultValue + "'";
		}
		
		return createTableString;
	}
}

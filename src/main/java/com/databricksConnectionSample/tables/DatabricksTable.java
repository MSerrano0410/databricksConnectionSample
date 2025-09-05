package com.databricksConnectionSample.tables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HashMap of DatabricksTableColumn items with add, remove, and SQL
 * query functions, and search
 */
public class DatabricksTable {
	private HashMap<String, DatabricksTableColumn> table;
	private String dbName;
	private String tableName;
	private DatabricksTableColumn primaryKeyColumn;
	public DatabricksTable(String tableName) {
		this.setTableName(tableName);
	}
	
	public DatabricksTable(String dbName, String tableName, DatabricksTableColumn initialColumn) {
		this.dbName = dbName;
		this.tableName = tableName;
		this.table = new HashMap<String, DatabricksTableColumn>();
		this.setTableName(tableName);
		insertSingleColumnToTable(initialColumn);
	}
	
	public DatabricksTable(String dbName, String tableName, List<DatabricksTableColumn> initialSchema) {
		this.dbName = dbName;
		this.tableName = tableName;
		this.table = new HashMap<String, DatabricksTableColumn>();
		for (DatabricksTableColumn column : initialSchema) {
			insertSingleColumnToTable(column);
		}
	}
	
	public void insertSingleColumnToTable(DatabricksTableColumn column) {
		if (this.primaryKeyColumn == null && column.isPrimaryKey()) {
			this.primaryKeyColumn = column;
		}
		
		this.table.put(column.getColumnName(), column);
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public void setPrimaryKeyColumn(DatabricksTableColumn column) {
		this.primaryKeyColumn = column;
	}
	
	public DatabricksTableColumn getPrimaryKeyColumn() {
		return this.primaryKeyColumn;
	}
	
	public String constructCreateTableString() {
		String query = "CREATE TABLE IF NOT EXISTS " + 
				this.dbName + "." + this.tableName + "(";
		int iteratorCounter = 1;
		for (Map.Entry<String, DatabricksTableColumn> columnDef : this.table.entrySet()) {
			query += columnDef.getValue().constructCreateColumnString();
			if (iteratorCounter < this.table.entrySet().size()) {
				query += ", ";
			}
			iteratorCounter++;
		}
		
		query += ")";
		
		if (this.primaryKeyColumn != null) {
			query+= " PARTITIONED BY (" + this.primaryKeyColumn.getColumnName() + ")";
		}
		
		return query;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
}

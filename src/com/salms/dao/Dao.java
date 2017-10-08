package com.salms.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
	protected static String dbClassName  = " ";
	protected static String dbUrl = " ";
	protected static String dbUser = " ";
	protected static String dbPwd = "";
	
	protected static String second = null;
	
	public static Connection conn= null;
		static {
			try {
				if(conn == null) {
					Class.forName(dbClassName).newInstance();
					conn = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
				}
				}catch (Exception ee){
					ee.printStackTrace();
				}
			}
		
	public static boolean addSupplierInfo(salmsSupplier supplierInfo) {
		
		if (supplierInfo==null) return false;
		return insert(
				);
		
	}
}

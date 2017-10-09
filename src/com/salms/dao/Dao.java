package com.salms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import model.salmsSupplier;


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
		return insert("insert tb_gysinfo values('" + supplierInfo.getId() + "','"
				+ supplierInfo.getName() + "','" + supplierInfo.getNickName() + "','"
				+ supplierInfo.getAddress() + "','" + supplierInfo.getZipCode() + "','"
				+ supplierInfo.getTel() + "','" + supplierInfo.getFax() + "','"
				+ supplierInfo.getContactPpl() + "','" + supplierInfo.getContactTel() + "','"
				+ supplierInfo.geteMail() + "','" + supplierInfo.getBankBranch() + "')");
		
	}
	public static int updateGys(salmsSupplier gysInfo) {
		return update("update tb_gysinfo set jc='" + gysInfo.getNickName()
				+ "',address='" + gysInfo.getAddress() + "',bianma='"
				+ gysInfo.getZipCode() + "',tel='" + gysInfo.getTel()
				+ "',fax='" + gysInfo.getFax() + "',lian='" + gysInfo.getContactPpl()
				+ "',ltel='" + gysInfo.getContactTel() + "',mail='"
				+ gysInfo.geteMail() + "',yh='" + gysInfo.getBankBranch()
				+ "' where id='" + gysInfo.getId() + "'");
	}
}

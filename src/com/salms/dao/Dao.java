package com.salms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.salmsSupplier;
import model.salmsItem;


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
	private Dao() {
	}
	// 读取所有客户信息
//	public static List getKhInfos() {
//		List list = findForList("select id,khname from tb_khinfo");
//		return list;
//	}
//	// 读取所有供应商信息
//	public static List getGysInfos() {
//		List list = findForList("select id,name from tb_gysinfo");
//		return list;
//	}
		
	public static boolean addSupplierInfo(salmsSupplier supplierInfo) {
		
		if (supplierInfo==null) return false;
		return insert("insert tb_gysinfo values('" + supplierInfo.getId() + "','"
				+ supplierInfo.getName() + "','" + supplierInfo.getNickName() + "','"
				+ supplierInfo.getAddress() + "','" + supplierInfo.getZipCode() + "','"
				+ supplierInfo.getTel() + "','" + supplierInfo.getFax() + "','"
				+ supplierInfo.getContactPpl() + "','" + supplierInfo.getContactTel() + "','"
				+ supplierInfo.geteMail() + "','" + supplierInfo.getBankBranch() + "')");
		
	}
	public static int updateGys(salmsSupplier supplierInfo) {
		return update("update tb_gysinfo set jc='" + supplierInfo.getNickName()
				+ "',address='" + supplierInfo.getAddress() + "',bianma='"
				+ supplierInfo.getZipCode() + "',tel='" + supplierInfo.getTel()
				+ "',fax='" + supplierInfo.getFax() + "',lian='" + supplierInfo.getContactPpl()
				+ "',ltel='" + supplierInfo.getContactTel() + "',mail='"
				+ supplierInfo.geteMail() + "',yh='" + supplierInfo.getBankBranch()
				+ "' where id='" + supplierInfo.getId() + "'");
	}
}

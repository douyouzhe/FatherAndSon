package com.salms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.crypto.provider.RSACipher;

import jdk.internal.dynalink.beans.StaticClass;
import model.salmsSupplier;
import sun.font.CreatedFontTracker;
import model.salmsCustomer;
import model.salmsItem;
import model.salmsStock;


public class Dao {
	private Dao() {
	}
// get jdbc connected
	public static Connection getConnection() throws Exception{
		final String driver = "com.mysql.jdbc.Driver";
		final String dbUrl = "jdbc:mysql://localhost:3306/dbSALMS";
	    final String dbUser = "root";
		final String dbPwd = "douzi0418";
		
		Connection conn = null;
		try {
			Class.forName(driver);
			System.out.println("Connecting to SALMS database...");
			conn = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			System.out.println("SALMS db connected!");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
// create all tables
	public static void creatSupplierTable() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String query = "CREATE TABLE IF NOT EXISTS "
					+ "tbSupplier"
					+ "(id int AUTO_INCREMENT primary key NOT NULL,"
					+ "name varchar(255),"
					+ "address varchar(255),"
					+ "zipCode varchar(255),"
					+ "tel varchar(255),"
					+ "fax varchar(255),"
					+ "contactPpl varchar(255),"
					+ "contactTel varchar(255),"
					+ "bankBranch varchar(255),"
					+ "eMail varchar(255)"
					+ ")";
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Table creation complete!");
			try {
				if(pstmt!=null) pstmt.close();
			}catch(SQLException se) {
			}
			
			try {
				if(conn!= null) conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	public static void creatItemTable() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String query = "CREATE TABLE IF NOT EXISTS "
					+ "tbItem"
					+ "(id int AUTO_INCREMENT primary key NOT NULL,"
					+ "itemName varchar(255),"
					+ "itemNickName varchar(255),"
					+ "itemOrigin varchar(255),"
					+ "itemUnit varchar(255),"
					+ "itemSize varchar(255),"
					+ "itemPackage varchar(255),"
					+ "batchNo varchar(255),"
					+ "govId varchar(255),"
					+ "supplierName varchar(255),"
					+ "memo varchar(255)"
					+ ")";
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Table creation complete!");
			try {
				if(pstmt!=null) pstmt.close();
			}catch(SQLException se) {
			}
			
			try {
				if(conn!= null) conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	public static void creatCustomerTable() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String query = "CREATE TABLE IF NOT EXISTS "
					+ "tbCustomer"
					+ "(id int AUTO_INCREMENT primary key NOT NULL,"
					+ "customerName varchar(255),"
					+ "customerNickName varchar(255),"
					+ "address varchar(255),"
					+ "zipCode varchar(255),"
					+ "tel varchar(255),"
					+ "fax varchar(255),"
					+ "contactPpl varchar(255),"
					+ "contactTel varchar(255),"
					+ "mail varchar(255),"
					+ "bankBrach varchar(255),"
					+ "accountNumber varchar(255)"
					+ ")";
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Table creation complete!");
			try {
				if(pstmt!=null) pstmt.close();
			}catch(SQLException se) {
			}
			
			try {
				if(conn!= null) conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	public static void creatStockTable() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String query = "CREATE TABLE IF NOT EXISTS "
					+ "tbStock"
					+ "(id int AUTO_INCREMENT primary key NOT NULL,"
					+ "stockName varchar(255),"
					+ "stockNickName varchar(255),"
					+ "stockOrigin varchar(255),"
					+ "stockSize varchar(255),"
					+ "unit varchar(255),"
					+ "unitPrice double(5,2),"
					+ "stockAmount int(10)"
					+ ")";
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Table creation complete!");
			try {
				if(pstmt!=null) pstmt.close();
			}catch(SQLException se) {
			}
			
			try {
				if(conn!= null) conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}

// add instance to tables	
	public static void addSupplier(salmsSupplier supplierInfo) throws Exception{		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			PreparedStatement added = conn.prepareStatement("INSERT INTO tbSupplier "
					//+ "(first, last) "
					+ "VALUES ('"+supplierInfo.getId()+"','"
					+supplierInfo.getName()+"','"
					+supplierInfo.getNickName()+"','"
					+supplierInfo.getAddress()+"','"
					+supplierInfo.getZipCode()+"','"
					+supplierInfo.getTel()+"','"
					+supplierInfo.getFax()+"','"
					+supplierInfo.getContactPpl()+"','"
					+supplierInfo.getContactTel()+"','"
					+supplierInfo.getBankBranch()+"','"
					+supplierInfo.geteMail()+"'"
					+ ")");
			added.executeUpdate();
			
	}catch(SQLException se) {
		se.printStackTrace();
	}
	catch (Exception e) {
		e.printStackTrace();
	}finally {
		System.out.println("Table creation complete!");
		try{
		   if(pstmt!=null)
		      conn.close();
		}catch(SQLException se){
		}
		try{
		   if(conn!=null)
		      conn.close();
		}catch(SQLException se){
		   se.printStackTrace();
		}
	}
	}
	public static void addItem(salmsItem itemInfo) throws Exception{		
		
		Connection conn = getConnection();
		PreparedStatement pstmt =  null;
		try {
			
			pstmt = conn.prepareStatement("INSERT INTO tbItem "
					+ "VALUES ('"+itemInfo.getId()+"','"
					+itemInfo.getItemName()+"','"
					+itemInfo.getItemNickName()+"','"
					+itemInfo.getItemOrigin()+"','"
					+itemInfo.getItemUnit()+"','"
					+itemInfo.getItemSize()+"','"
					+itemInfo.getItemPackage()+"','"
					+itemInfo.getBatchNo()+"','"
					+itemInfo.getGovId()+"','"
					+itemInfo.getMemo()+"','"
					+itemInfo.getSupplierName()+"'"
					+ ")");
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Table creation complete!");
			try{
			   if(pstmt!=null)
			      conn.close();
			}catch(SQLException se){
			}
			try{
			   if(conn!=null)
			      conn.close();
			}catch(SQLException se){
			   se.printStackTrace();
			}
		}
	}	
	public static void addCustomer(salmsCustomer customerInfo) throws Exception{		
		Connection conn = getConnection();
		PreparedStatement pstmt =  null;
		
		try {
			
			pstmt = conn.prepareStatement("INSERT INTO tbCustomer "
					+ "VALUES ('"+customerInfo.getId()+"','"
					+customerInfo.getCustomerName()+"','"
					+customerInfo.getCustomerNickName()+"','"
					+customerInfo.getAddress()+"','"
					+customerInfo.getZipCode()+"','"
					+customerInfo.getTel()+"','"
					+customerInfo.getFax()+"','"
					+customerInfo.getContactPpl()+"','"
					+customerInfo.getContactTel()+"','"
					+customerInfo.getMail()+"','"
					+customerInfo.getBankBranch()+"','"
					+customerInfo.getAccountNumber()+"'"
					+ ")");
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Table creation complete!");
			try{
			   if(pstmt!=null)
			      conn.close();
			}catch(SQLException se){
			}
			try{
			   if(conn!=null)
			      conn.close();
			}catch(SQLException se){
			   se.printStackTrace();
			}
		}
	}
	public static void addStock(salmsStock stockInfo) throws Exception{		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String query = " insert into tbStock (id, "
					+ "stockName, "
					+ "stockNickName, "
					+ "stockOrigin, "
					+ "stockSize, "
					+ "unit, "
					+ "unitPrice, "
					+ "stockAmount)"
				    + " values (?, ?, ?, ?, ?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,stockInfo.getId());
			pstmt.setString(2, stockInfo.getStockName());
			pstmt.setString(3, stockInfo.getStockNickName());
			pstmt.setString(4, stockInfo.getStockOrigin());
			pstmt.setString(5, stockInfo.getStockSize());
			pstmt.setString(6, stockInfo.getUnit());
			pstmt.setDouble(7, stockInfo.getUnitPrice());
			pstmt.setInt(8, stockInfo.getStockAmount());
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Table creation complete!");
			try{
			   if(pstmt!=null)
			      conn.close();
			}catch(SQLException se){
			}
			try{
			   if(conn!=null)
			      conn.close();
			}catch(SQLException se){
			   se.printStackTrace();
			}
		}
	}
//	get ALL info
	public static List getCustomerInfos() throws Exception {
		List list = findListFromDB("select id,khname from tb_khinfo");
		return list;
	}
	public static List getSupplierInfos() throws Exception{
		List ls = findListFromDB("select id, name from tbSupplier");
		return ls;
	}
	
//get info for one instance
//	public static salmsCustomer getKhInfo(salmsItem item) {
//		String where = "khname='" + item.getItemName() + "'";
//		if (item.getId() != 0)
//			where = "id='" + item.getId() + "'";
//		salmsCustomer info = new salmsCustomer();
//		ResultSet set = findFromResultSet("select * from tbCustomer where "
//				+ where);
//		try {
//			if (set.next()) {
//				info.setId(set.getInt(1));
//				info.setKhname(set.getString("khname").trim());
//				info.setJian(set.getString("jian").trim());
//				info.setAddress(set.getString("address").trim());
//				info.setBianma(set.getString("bianma").trim());
//				info.setFax(set.getString("fax").trim());
//				info.setHao(set.getString("hao").trim());
//				info.setLian(set.getString("lian").trim());
//				info.setLtel(set.getString("ltel").trim());
//				info.setMail(set.getString("mail").trim());
//				info.setTel(set.getString("tel").trim());
//				info.setXinhang(set.getString("xinhang").trim());
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return info;
//	}
	
//
	public static List findListFromDB(String sql) throws Exception {
		List<List> list = new ArrayList<List>();
		ResultSet rs = findFromResultSet(sql);
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int colCount = metaData.getColumnCount();
			while (rs.next()) {
				List<String> row = new ArrayList<String>();
				for (int i = 1; i <= colCount; i++) {
					String str = rs.getString(i);
					if (str != null && !str.isEmpty())
						str = str.trim();
					row.add(str);
				}
				list.add(row);
			}
			System.out.println("List generated from DB");
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	private static ResultSet findFromResultSet(String sql) throws Exception {
		Connection conn = getConnection();
		ResultSet rs = null;
		try {
			Statement stmt = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} 
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void main(String[] args) throws Exception {

	}
}

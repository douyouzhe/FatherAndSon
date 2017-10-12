package com.salms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.salmsSupplier;
import model.salmsCustomer;
import model.salmsItem;
import model.salmsStock;


public class Dao {
	private Dao() {
	}
// get jdbc connected
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String dbUrl = "jdbc:mysql://localhost:3306/dbSALMS";
			String dbUser = "root";
			String dbPwd = "douzi0418";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			System.out.println("SALMS db connected!");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}	
// create all tables
	public static void creatSupplierTable() throws Exception{
		try {
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
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
					+ ")");
			create.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Table creation complete!");
		}
	}
	public static void creatItemTable() throws Exception{
		try {
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
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
					+ ")");
			create.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Table creation complete!");
		}
	}
	public static void creatCustomerTable() throws Exception{
		try {
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
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
					+ ")");
			create.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Table creation complete!");
		}
	}
	public static void creatStockTable() throws Exception{
		try {
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+ "tbStock"
					+ "(id int AUTO_INCREMENT primary key NOT NULL,"
					+ "stockName varchar(255),"
					+ "stockNickName varchar(255),"
					+ "stockOrigin varchar(255),"
					+ "stockSize varchar(255),"
					+ "unit varchar(255),"
					+ "unitPrice double(5,2),"
					+ "stockAmount int(10)"
					+ ")");
			create.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Table creation complete!");
		}
	}
// add instance to tables	
	public static void addSupplier(salmsSupplier supplierInfo) throws Exception{		
		try {
			Connection conn = getConnection();
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
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Insertion complete!");
		}
	}
	public static void addItem(salmsItem itemInfo) throws Exception{		
		try {
			Connection conn = getConnection();
			PreparedStatement added = conn.prepareStatement("INSERT INTO tbItem "
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
			added.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Insertion complete!");
		}
	}	
	public static void addCustomer(salmsCustomer customerInfo) throws Exception{		
		try {
			Connection conn = getConnection();
			PreparedStatement added = conn.prepareStatement("INSERT INTO tbCustomer "
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
			added.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Insertion complete!");
		}
	}
	public static void addStock(salmsStock stockInfo) throws Exception{		
		try {
			Connection conn = getConnection();
			String query = " insert into tbStock (id, "
					+ "stockName, "
					+ "stockNickName, "
					+ "stockOrigin, "
					+ "stockSize, "
					+ "unit, "
					+ "unitPrice, "
					+ "stockAmount)"
				    + " values (?, ?, ?, ?, ?,?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1,stockInfo.getId());
			preparedStmt.setString(2, stockInfo.getStockName());
			preparedStmt.setString(3, stockInfo.getStockNickName());
			preparedStmt.setString(4, stockInfo.getStockOrigin());
			preparedStmt.setString(5, stockInfo.getStockSize());
			preparedStmt.setString(6, stockInfo.getUnit());
			preparedStmt.setDouble(7, stockInfo.getUnitPrice());
			preparedStmt.setInt(8, stockInfo.getStockAmount());
			preparedStmt.executeUpdate();
			conn.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("Insertion complete!");
		}
	}
	
	public static void main(String[] args) throws Exception {
//		getConnection();
//		creatSupplierTable();
//		creatItemTable();
	}
	
	
	
	
	
	
	
	
	
	


		
//	public static boolean addSupplierInfo(salmsSupplier supplierInfo) {
//		
//		if (supplierInfo==null) return false;
//		return insert("insert tb_gysinfo values('" + supplierInfo.getId() + "','"
//				+ supplierInfo.getName() + "','" + supplierInfo.getNickName() + "','"
//				+ supplierInfo.getAddress() + "','" + supplierInfo.getZipCode() + "','"
//				+ supplierInfo.getTel() + "','" + supplierInfo.getFax() + "','"
//				+ supplierInfo.getContactPpl() + "','" + supplierInfo.getContactTel() + "','"
//				+ supplierInfo.geteMail() + "','" + supplierInfo.getBankBranch() + "')");
//		
//	}
//	public static int updateGys(salmsSupplier supplierInfo) {
//		return update("update tb_gysinfo set jc='" + supplierInfo.getNickName()
//				+ "',address='" + supplierInfo.getAddress() + "',bianma='"
//				+ supplierInfo.getZipCode() + "',tel='" + supplierInfo.getTel()
//				+ "',fax='" + supplierInfo.getFax() + "',lian='" + supplierInfo.getContactPpl()
//				+ "',ltel='" + supplierInfo.getContactTel() + "',mail='"
//				+ supplierInfo.geteMail() + "',yh='" + supplierInfo.getBankBranch()
//				+ "' where id='" + supplierInfo.getId() + "'");
//	}
}

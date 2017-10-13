package model;

public class salmsItem implements java.io.Serializable{
	
	private int id;
	private String itemName;
	private String itemNickName;
	private String itemOrigin;
	private String itemUnit;
	private String itemSize;
	private String itemPackage;
	private String batchNo;
	private String govId;
	private String memo;
	private String supplierName;
	
	public salmsItem() {
	}

	public salmsItem(int id) {
		this.id = id;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemNickName() {
		return itemNickName;
	}
	public void setItemNickName(String itemNickName) {
		this.itemNickName = itemNickName;
	}
	public String getItemOrigin() {
		return itemOrigin;
	}
	public void setItemOrigin(String itemOrigin) {
		this.itemOrigin = itemOrigin;
	}
	public String getItemUnit() {
		return itemUnit;
	}
	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}
	public String getItemSize() {
		return itemSize;
	}
	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}
	public String getItemPackage() {
		return itemPackage;
	}
	public void setItemPackage(String itemPackage) {
		this.itemPackage = itemPackage;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getGovId() {
		return govId;
	}
	public void setGovId(String govId) {
		this.govId = govId;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String toString() {
		return getItemName();
	}
}

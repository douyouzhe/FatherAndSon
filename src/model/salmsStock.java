package model;

public class salmsStock implements java.io.Serializable{
    private int id;
    private String stockName;
    private String stockNickName;
    private String stockOrigin;
    private String stockSize;
    private String unit;
    private Double unitPrice;
    private Integer stockAmount;
    
    
    
	public salmsStock(int id) {
		this.id = id;
	}
	
	
	
	public salmsStock(int id, String stockName, String stockNickName, String stockOrigin, String stockSize,
			String unit, Double unitPrice, Integer stockAmount) {
		this.id = id;
		this.stockName = stockName;
		this.stockNickName = stockNickName;
		this.stockOrigin = stockOrigin;
		this.stockSize = stockSize;
		this.unit = unit;
		this.unitPrice = unitPrice;
		this.stockAmount = stockAmount;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockNickName() {
		return stockNickName;
	}
	public void setStockNickName(String stockNickName) {
		this.stockNickName = stockNickName;
	}
	public String getStockOrigin() {
		return stockOrigin;
	}
	public void setStockOrigin(String stockOrigin) {
		this.stockOrigin = stockOrigin;
	}
	public String getStockSize() {
		return stockSize;
	}
	public void setStockSize(String stockSize) {
		this.stockSize = stockSize;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getStockAmount() {
		return stockAmount;
	}
	public void setStockAmount(Integer stockAmount) {
		this.stockAmount = stockAmount;
	}
    
	public String toString() {
		return getStockName();
	}
}

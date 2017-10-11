package model;

public class salmsSupplier implements java.io.Serializable{
    private String id;
    private String name;
    private String nickName;
    private String address;
    private String zipCode;
    private String tel;
	private String fax;
    private String contactPpl;
    private String contactTel;
    private String bankBranch;
    private String eMail;
    
    public salmsSupplier() {
    	
    }
    
    public salmsSupplier(String id) {
        this.id = id;
    }
    
    public salmsSupplier(String id, String name, String nickName, String address, String zipCode, String tel, String fax, String contactPpl, String contactTel, String bankBranch, String eMail) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.address = address;
        this.zipCode = zipCode;
        this.tel = tel;
        this.fax = fax;
        this.contactPpl = contactPpl;
        this.contactTel = contactTel;
        this.bankBranch = bankBranch;
        this.eMail = eMail;
    }
    
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getContactPpl() {
		return contactPpl;
	}
	public void setContactPpl(String contactPpl) {
		this.contactPpl = contactPpl;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranck) {
		this.bankBranch = bankBranck;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}




}

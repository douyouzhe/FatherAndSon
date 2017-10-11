package model;

public class salmsCustomer implements java.io.Serializable{
	
    private String id;
    private String customerName;
    private String customerNickName;
    private String address;
    private String zipCode;
    private String tel;
    private String fax;
    private String contactPpl;
    private String contactTel;
    private String mail;
    private String bankBranch;
    private String accountNumber;
    
    
    public salmsCustomer() {
    }

	/** minimal constructor */
    public salmsCustomer(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public salmsCustomer(String id, String customerName, String customerNickName, String address, String zipCode, String tel, String fax, String contactPpl, String contactTel, String mail, String bankBranch, String accountNumber) {
        this.id = id;
        this.customerName = customerName;
        this.customerNickName = customerNickName;
        this.address = address;
        this.zipCode = zipCode;
        this.tel = tel;
        this.fax = fax;
        this.contactPpl = contactPpl;
        this.contactTel = contactTel;
        this.mail = mail;
        this.bankBranch = bankBranch;
        this.accountNumber = accountNumber;
    }
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerNickName() {
		return customerNickName;
	}
	public void setCustomerNickName(String customerNickName) {
		this.customerNickName = customerNickName;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
    
    

}

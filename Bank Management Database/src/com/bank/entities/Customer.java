package com.bank.entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Vector;

public class Customer {

	String Card,Name,F_Name,aadhar,Start,DOB,Gender,mobile,Address,City,State,pan,E_mail,Income,Education,Occupation,account_type;
	int year,date,month,pincode;
	boolean senior,existing;
	boolean Email_Alert,NetBanking,eState,Atm_card,Mobile_Banking,Cheque_book;
	boolean agreed;
	int pin,CustomerID,Balance,ExistingCustomerID;

	Vector<String> cols= new Vector<String>();
	Vector<Vector<String>> History= new Vector<Vector<String>>();
	
	public Vector<String> getCols() {
		return cols;
	}

	public void setCols(Vector<String> cols) {
		this.cols = cols;
	}

	public Vector<Vector<String>> getHistory() {
		return History;
	}

	public void setHistory(Vector<Vector<String>> history) {
		History = history;
	}

	public Customer() {
		
		cols.add("Time & Date");cols.add("Amount");cols.add("Action Type");
		
		Name="";F_Name="";aadhar="";Gender="";mobile="";Address="";City="";State="";pan="";E_mail="";Income="";Education="";Occupation="";account_type="";
		senior=false;existing=false;
		Email_Alert=false;NetBanking=false;eState=false;Atm_card=false;Mobile_Banking=false;Cheque_book=false;
		agreed=false;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getF_Name() {
		return F_Name;
	}

	public void setF_Name(String f_Name) {
		F_Name = f_Name;
	}
	public String getDOB() {
		return DOB;
	}

	public void setDOB(String f_Name) {
		DOB = f_Name;
	}
	public String getStart() {
		return Start;
	}

	public void setStart(String f_Name) {
		Start = f_Name;
	}
	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getE_mail() {
		return E_mail;
	}

	public void setE_mail(String e_mail) {
		E_mail = e_mail;
	}

	public String getIncome() {
		return Income;
	}

	public void setIncome(String income) {
		Income = income;
	}

	public String getEducation() {
		return Education;
	}

	public void setEducation(String education) {
		Education = education;
	}

	public String getOccupation() {
		return Occupation;
	}

	public void setOccupation(String occupation) {
		Occupation = occupation;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String month) {
		this.mobile = month;
	}
	
	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public boolean isSenior() {
		return senior;
	}

	public void setSenior(boolean senior) {
		this.senior = senior;
	}

	public boolean isExisting() {
		return existing;
	}

	public void setExisting(boolean existing) {
		this.existing = existing;
	}

	public boolean isEmail_Alert() {
		return Email_Alert;
	}

	public void setEmail_Alert(boolean email_Alert) {
		Email_Alert = email_Alert;
	}

	public boolean isNetBanking() {
		return NetBanking;
	}

	public void setNetBanking(boolean netBanking) {
		NetBanking = netBanking;
	}

	public boolean iseState() {
		return eState;
	}

	public void seteState(boolean eState) {
		this.eState = eState;
	}

	public boolean isAtm_card() {
		return Atm_card;
	}

	public void setAtm_card(boolean atm_card) {
		Atm_card = atm_card;
	}

	public boolean isMobile_Banking() {
		return Mobile_Banking;
	}

	public void setMobile_Banking(boolean mobile_Banking) {
		Mobile_Banking = mobile_Banking;
	}

	public boolean isCheque_book() {
		return Cheque_book;
	}

	public void setCheque_book(boolean cheque_book) {
		Cheque_book = cheque_book;
	}

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	public String getCard() {
		return Card;
	}

	public void setCard(String card) {
		this.Card = card;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int pin) {
		this.CustomerID = pin;
	}
	public int getBalance() {
		return Balance;
	}

	public void setBalance(int Balance) {
		this.Balance = Balance;
	}

	public int getExistingCustomerID() {
		return ExistingCustomerID;
	}

	public void setExistingCustomerID(int pin) {
		this.ExistingCustomerID = pin;
	}
}

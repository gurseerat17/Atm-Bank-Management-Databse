package com.bank.controller;

import java.sql.Connection;
import java.util.Date;
import java.util.Vector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.bank.view.Bank_History;
import com.bank.view.Bank_ThankYou;
import com.mysql.jdbc.ResultSetMetaData;
import com.bank.db.Dbconnection;
import com.bank.entities.Customer;

/*
*mysql>  create table Customer_Details(CustomerID INT AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(40) not null , Father_name VARCHAR(40), Gender VARCHAR(7) NOT NULL, Mobile VARCHAR(14) NOT NULL,Email VARCHAR(50),DOB VARCHAR(15) NOT NULL, Address VARCHAR(50) NOT NULL, City VARCHAR(20) NOT NULL, State VARCHAR(20)NOT NULL, Pincode INT NOT NULL,start_date VARCHAR(15) not null);
*Query OK, 0 rows affected (0.02 sec)
*
*mysql> create table Customer_Documents(CustomerID INT AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(40), Aadhar VARCHAR(40) NOT NULL, PAN VARCHAR(25) NOT NULL, Income VARCHAR(40) NOT NULL, Education VARCHAR(15), Ocupation  VARCHAR(15) NOT NULL,Senior TINYINT NOT NULL, Existing_Account TINYINT NOT NULL, Existing_CustomerID INT DEFAULT 0);
*Query OK, 0 rows affected (0.03 sec)
*
*mysql> create table Customer_Details(CustomerID INT AUTO_INCREMENT PRIMARY KEY, Name VARCHAR(40) not null , Father_name VARCHAR(40), Gender VARCHAR(7) NOT NULL, Mobile VARCHAR(14) NOT NULL,Email VARCHAR(50),DOB VARCHAR(15) NOT NULL, Address VARCHAR(50) NOT NULL, City VARCHAR(20) NOT NULL, State VARCHAR(20)NOT NULL, Pincode INT NOT NULL,start_date DATE);
*Query OK, 0 rows affected (0.03 sec)
*
*create table Services (Customer_ID INT auto_increment primary key ,NET_Banking TINYINT,Mobile_Banking TINYINT,ATM TINYINT, E_Statement TINYINT,CHEQUE TINYINT, EMAIL TINYINT)engine=innodb Auto_increment=6;
*Query OK, 0 rows affected (0.04 sec)
* 
*create table  Customer_ATM (Customer_ID INT auto_increment primary key,CARD_NUMBER VARCHAR(20), PIN int, Account_type VARCHAR(40),Balance int);
* 
* create table History (..)
*/
public class BankContoller {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static PreparedStatement preparedStatement;
	public static String Name;
	public static boolean storeCustomer(Customer new_entry) {
		try {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String d=df.format(new Date());
					connection=Dbconnection.dbConnection();
					String qry="insert into Customer_Details(Name,Father_name,Gender,Mobile,Email,DOB,Address,City,State,Pincode,start_date) values(?,?,?,?,?,?,?,?,?,?,?)";
					preparedStatement=connection.prepareStatement(qry);
					preparedStatement.setString(1, new_entry.getName());
					preparedStatement.setString(2, new_entry.getF_Name());
					preparedStatement.setString(3, new_entry.getGender());
					preparedStatement.setString(4, new_entry.getMobile());
					preparedStatement.setString(5, new_entry.getE_mail());
					preparedStatement.setString(6, new_entry.getYear()+"-"+new_entry.getMonth()+"-"+new_entry.getDate());
					preparedStatement.setString(7, new_entry.getAddress());
					preparedStatement.setString(8, new_entry.getCity());
					preparedStatement.setString(9, new_entry.getState());
					preparedStatement.setInt(10, new_entry.getPincode());
					preparedStatement.setString(11, d);

					int i=preparedStatement.executeUpdate();
					
					String qry2="insert into Customer_Documents(Name,Aadhar ,PAN , Income , Education , Ocupation ,Senior , Existing_Account ,Existing_CustomerID ) values(?,?,?,?,?,?,?,?,?)";
					preparedStatement=connection.prepareStatement(qry2);
					preparedStatement.setString(1, new_entry.getName());
					preparedStatement.setString(2, new_entry.getAadhar());
					preparedStatement.setString(3, new_entry.getPan());
					preparedStatement.setString(4, new_entry.getIncome());
					preparedStatement.setString(5, new_entry.getEducation());
					preparedStatement.setString(6, new_entry.getOccupation());
					preparedStatement.setBoolean(7, new_entry.isSenior());
					preparedStatement.setBoolean(8, new_entry.isExisting());
					if(new_entry.isExisting())
					preparedStatement.setInt(9, new_entry.getCustomerID());
					else preparedStatement.setInt(9, 0);
					int j=preparedStatement.executeUpdate();
					
					String qry3="insert into Customer_Accounts(Name ,CARD_NUMBER ,PIN , Account_type , Balance ) values(?,?,?,?,?)";
					preparedStatement=connection.prepareStatement(qry3);
					preparedStatement.setString(1, new_entry.getName());
					preparedStatement.setString(2, new_entry.getCard());
					preparedStatement.setInt(3, new_entry.getPin());
					preparedStatement.setString(4, new_entry.getAccount_type());
					preparedStatement.setInt(5, 0);
					
					int k=preparedStatement.executeUpdate();
					
					int l=1;
					
					if(new_entry.isAtm_card()) {
						String qry4="insert into Customer_ATM (CARD_NUMBER, PIN, Account_type,Balance) values(?,?,?,?)";
						preparedStatement=connection.prepareStatement(qry4);
						preparedStatement.setString(1, new_entry.getCard());
						preparedStatement.setInt(2, new_entry.getPin());
						preparedStatement.setString(3, new_entry.getAccount_type());
						preparedStatement.setInt(4, new_entry.getBalance());
						
						l=preparedStatement.executeUpdate();
					}
					
					
					String qry4="insert into Services (NET_Banking ,Mobile_Banking ,ATM , E_Statement ,CHEQUE , EMAIL) values(?,?,?,?,?,?)";
					preparedStatement=connection.prepareStatement(qry4);					
					preparedStatement.setBoolean(1, new_entry.isNetBanking());
					preparedStatement.setBoolean(2, new_entry.isMobile_Banking());
					preparedStatement.setBoolean(3, new_entry.isAtm_card());
					preparedStatement.setBoolean(4, new_entry.iseState());
					preparedStatement.setBoolean(5, new_entry.isCheque_book());
					preparedStatement.setBoolean(6, new_entry.isEmail_Alert());
					
					int m=preparedStatement.executeUpdate();
					if(m*i*l*j*k>0)
						return true;
				} catch (Exception e) {
					System.out.println("Store Data Exception "+e + new_entry.getName());
				}
				
				return false;
			}
	
	public static boolean verifyCustomer(Customer c) {
		try {
			
			connection=Dbconnection.dbConnection();
			String myQry="select * from Customer_Accounts where CustomerID=? and PIN=?";
			
			preparedStatement=connection.prepareStatement(myQry);
		
			preparedStatement.setInt(1, c.getCustomerID());
			preparedStatement.setInt(2, c.getPin());
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				Name=resultSet.getString(2);
				c.setName(resultSet.getString(2));
				c.setBalance(resultSet.getInt(6));
				c.setPin(resultSet.getInt(4));
				c.setAccount_type(resultSet.getString(5));
				
				String myQry2="select * from Customer_details where CustomerID=? ";
				
				preparedStatement=connection.prepareStatement(myQry2);
			
				preparedStatement.setInt(1, c.getCustomerID());
				resultSet=preparedStatement.executeQuery();
				
				if(resultSet.next()) {c.setE_mail(resultSet.getString(6));;return true;}
			}
		} catch (Exception e) {
			System.out.println("Verify  Data Exception "+e);
		}
		return false;
	}
	public static boolean verifyCustomer2(Customer c) {
		try {
			
			connection=Dbconnection.dbConnection();
			String myQry="select * from Customer_Accounts where CustomerID=? ";
			
			preparedStatement=connection.prepareStatement(myQry);
		
			preparedStatement.setInt(1, c.getCustomerID());
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				Name=resultSet.getString(2);
				c.setName(resultSet.getString(2));
				c.setBalance(resultSet.getInt(6));
				c.setPin(resultSet.getInt(4));
				c.setAccount_type(resultSet.getString(5));

				String myQry2="select * from Customer_details where CustomerID=? ";
				
				preparedStatement=connection.prepareStatement(myQry2);
			
				preparedStatement.setInt(1, c.getCustomerID());
				resultSet=preparedStatement.executeQuery();
				
				if(resultSet.next()) {c.setE_mail(resultSet.getString(6));;return true;}
			}
		} catch (Exception e) {
			System.out.println("Verify  Data Exception "+e);
		}
		return false;
	}
	public static boolean Deposit(Customer c) {
		try {
			
			connection=Dbconnection.dbConnection();
			String myQry="update Customer_Accounts set Balance=? where CustomerID=?";
			
			preparedStatement=connection.prepareStatement(myQry);

			preparedStatement.setInt(1, c.getBalance());
			preparedStatement.setInt(2, c.getCustomerID());
			int i=preparedStatement.executeUpdate();
			int j=1;
			if(c.isAtm_card()) {
			String myQry2="update Customer_Atm set Balance=? where PIN=?";
			
			preparedStatement=connection.prepareStatement(myQry2);

			preparedStatement.setInt(2, c.getPin());
			preparedStatement.setInt(1, c.getBalance());
			 j=preparedStatement.executeUpdate();
			}

			if(i*j>0){
//				Name=resultSet.getString(2);
				return true;				
			}
		} catch (Exception e) {
			System.out.println("Verify  Data Exception "+e);
		}
		return false;
		
	}

	public static boolean Withdraw(Customer c) {
		// TODO Auto-generated method stub
		try {
			
			connection=Dbconnection.dbConnection();
			String myQry="update Customer_Accounts set Balance=? where CustomerID=? or PIN=?";
			
			preparedStatement=connection.prepareStatement(myQry);

			preparedStatement.setInt(1, c.getBalance());
			preparedStatement.setInt(2, c.getCustomerID());
			preparedStatement.setInt(3, c.getPin());
			int i=preparedStatement.executeUpdate();
			
			int j=1;
			if(c.isAtm_card()) {
			String myQry2="update Customer_Atm set Balance=? where PIN=?";
			
			preparedStatement=connection.prepareStatement(myQry2);

			preparedStatement.setInt(2, c.getPin());
			preparedStatement.setInt(1, c.getBalance());
			j=preparedStatement.executeUpdate();}
			if(i*j>0){
				Name=resultSet.getString(2);
				return true;
			}
		} catch (Exception e) {
			System.out.println("Verify  Data Exception "+e);
		}
		return false;
	}

	public static boolean pinChange(Customer c) {
		// TODO Auto-generated method stub
		try {
			
			connection=Dbconnection.dbConnection();
			String myQry="update Customer_Accounts set PIN=? where CustomerID=?";
			
			preparedStatement=connection.prepareStatement(myQry);

			preparedStatement.setInt(1, c.getPin());
			preparedStatement.setInt(2, c.getCustomerID());
			int i=preparedStatement.executeUpdate();
			String card_no=resultSet.getString(3);

			String myQry2="update Customer_Atm set PIN=? where CARD_NUMBER=?";
			
			preparedStatement=connection.prepareStatement(myQry2);

			preparedStatement.setInt(1, c.getPin());
			preparedStatement.setString(2, card_no);
			int j=preparedStatement.executeUpdate();
			
			if(i*j>0){
				return true;
			}
		} catch (Exception e) {
			System.out.println("Verify  Data Exception "+e);
		}
		return false;
	}

	public static boolean verifyCustomer_atm(Customer c) {
		try {
			connection=Dbconnection.dbConnection();
			String qry="select * from Customer_ATM where CARD_NUMBER=? and PIN=?";
			preparedStatement=connection.prepareStatement(qry);
			
			preparedStatement.setString(1, c.getCard());
			preparedStatement.setInt(2, c.getPin());
			resultSet=preparedStatement.executeQuery();

			String Q="select * from Customer_Accounts where PIN=?";
			
			preparedStatement=connection.prepareStatement(Q);
			preparedStatement.setInt(1, c.getPin());
			ResultSet rs= preparedStatement.executeQuery();
			
			if(resultSet.next()&&rs.next()) {
//				c.setName(resultSet.getString(2));
				c.setBalance(resultSet.getInt(4));
				c.setAccount_type(resultSet.getString(3));
				c.setCustomerID(rs.getInt(1));
				return true;
			}
		}catch(Exception e){
			System.out.println("Verify Exception "+e);
		}
		return false;
	}

	public static void StoreTransaction(Customer c, Integer value, String string) {
		try {
			LocalDateTime dt= LocalDateTime.now();
			DateTimeFormatter dtime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		    String formattedDate = dt.format(dtime);
		    
			connection=Dbconnection.dbConnection();
			String qry="insert into History values(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(qry);
			preparedStatement.setInt(1,c.getCustomerID());
			preparedStatement.setInt(2, c.getPin());
			preparedStatement.setString(3, formattedDate);
			preparedStatement.setInt(4, value);
			preparedStatement.setString(5, string);
			
			int i=preparedStatement.executeUpdate();
		}catch(Exception e) {
			System.out.println("Storing Transaction " +e);
		}
		
	}

	public static void printHistory(Customer c, String string) {
		try {
			connection=Dbconnection.dbConnection();
			String qry="select * from History where Customer_ID=? ";
			preparedStatement=connection.prepareStatement(qry);
			
			preparedStatement.setInt(1, c.getCustomerID());
			resultSet=preparedStatement.executeQuery();
			java.sql.ResultSetMetaData meta = resultSet.getMetaData();
		    int colCount = meta.getColumnCount();
		    Vector headers = new Vector<String>();
	        headers.add("ID");headers.add("PIN");headers.add("Date & Time");headers.add("Amount");headers.add("Transaction");
		      
		    new Bank_History(headers,c,resultSet,colCount,string);
//			new Bank_ThankYou();
			
		}catch(Exception e){
			System.out.println("Verify Exception "+e);
		}
		
	}

	public static void getAllinfo(Customer c) {
		try {
			connection=Dbconnection.dbConnection();
			String qry="select * from Customer_Accounts where CustomerID=? ";
			preparedStatement=connection.prepareStatement(qry);
			
			preparedStatement.setInt(1, c.getCustomerID());
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				c.setBalance(resultSet.getInt(6));
				c.setAccount_type(resultSet.getString(5));
				c.setName(resultSet.getString(2));
				c.setCard(resultSet.getString(3));
			}
			qry="select * from Customer_details where CustomerID=? ";
			preparedStatement=connection.prepareStatement(qry);
			
			preparedStatement.setInt(1, c.getCustomerID());
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				c.setAddress(resultSet.getString(8));
				c.setCity(resultSet.getString(9));
				c.setState(resultSet.getString(10));
				c.setPin(resultSet.getInt(11));
				c.setStart(resultSet.getString(12));
				c.setMobile(resultSet.getString(6));
				c.setE_mail(resultSet.getString(5));
				c.setDOB(resultSet.getString(7));
				c.setF_Name(resultSet.getString(3));
				c.setGender(resultSet.getString(4));
			} 
			qry="select * from Customer_documents where CustomerID=? ";
			preparedStatement=connection.prepareStatement(qry);
			
			preparedStatement.setInt(1, c.getCustomerID());
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				c.setSenior(resultSet.getBoolean(8));
				c.setExisting(resultSet.getBoolean(9));
				if(c.isExisting())
				c.setExistingCustomerID(resultSet.getInt(10));
				else
					c.setExistingCustomerID(0);
				c.setEducation(resultSet.getString(6));
				c.setIncome(resultSet.getString(5));
				c.setOccupation(resultSet.getString(7));
				c.setAadhar(resultSet.getString(3));
				c.setPan(resultSet.getString(4));
			} 
			qry="select * from Services where Customer_ID=? ";
			preparedStatement=connection.prepareStatement(qry);
			
			preparedStatement.setInt(1, c.getCustomerID());
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {

				c.setAtm_card(resultSet.getBoolean(4));
				c.setCheque_book(resultSet.getBoolean(6));
				c.setEmail_Alert(resultSet.getBoolean(7));
				c.setNetBanking(resultSet.getBoolean(2));
				c.setMobile_Banking(resultSet.getBoolean(3));
				c.seteState(resultSet.getBoolean(5));
			} 
		}catch(Exception e){
			System.out.println("Verify Exception "+e);
		}
		
	}
	
}

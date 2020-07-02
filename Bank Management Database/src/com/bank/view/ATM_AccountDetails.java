package com.bank.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

import com.bank.controller.BankContoller;

import com.bank.entities.Customer;

public class ATM_AccountDetails extends JFrame implements ActionListener{
	Customer new_entry=new Customer();
	private JPanel contentPane;
	private JButton btnLogin ,btnReset,btnCancel ;
	private JRadioButton rdbtnSavingsAccount,rdbtnFixedDepositAccount,rdbtnCurrentAccount,rdbtnRecurringDepositAccount ;
	private JCheckBox chckbxNewCheckBox ,chckbxMobileBanking ,chckbxChequeBook,chckbxInternetBanking,chckbxEmailAllerts,chckbxEstatement,chckbxIHerebyDeclare;
	public ATM_AccountDetails(Customer entry) {
		new_entry=entry;
		setVisible(true);		
		setTitle("Welcome to the ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 781);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null); 
		JLabel lblWelcomeToAtm = new JLabel("ACCOUNT DETAILS");
		lblWelcomeToAtm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAtm.setFont(new Font("Sitka Small", Font.BOLD, 38));
		lblWelcomeToAtm.setBounds(36, 40, 548, 92);
		contentPane.add(lblWelcomeToAtm);

		btnLogin = new JButton("SUBMIT");
		btnLogin.setBackground(new Color(255, 250, 205));
		btnLogin.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnLogin.setBounds(184, 638, 125, 36);
		contentPane.add(btnLogin);
		
		JLabel lblPage = new JLabel("PAGE NO. 3");
		lblPage.setFont(new Font("Serif", Font.PLAIN, 19));
		lblPage.setBounds(542, 13, 100, 23);
		contentPane.add(lblPage);
		
		btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnReset.setBackground(new Color(255, 250, 205));
		btnReset.setBounds(328, 638, 125, 36);
		contentPane.add(btnReset);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnCancel.setBackground(new Color(255, 250, 205));
		btnCancel.setBounds(256, 685, 144, 36);
		contentPane.add(btnCancel);
		
		JLabel lblAccountType = new JLabel("Account Type :");
		lblAccountType.setFont(new Font("Sitka Small", Font.PLAIN, 23));
		lblAccountType.setBounds(72, 160, 189, 23);
		contentPane.add(lblAccountType);
		
		rdbtnSavingsAccount = new JRadioButton("Savings Account ");
		rdbtnSavingsAccount.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		rdbtnSavingsAccount.setBounds(72, 200, 189, 25);
		contentPane.add(rdbtnSavingsAccount);
		
		rdbtnFixedDepositAccount = new JRadioButton("Fixed Deposit Account ");
		rdbtnFixedDepositAccount.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		rdbtnFixedDepositAccount.setBounds(298, 200, 266, 25);
		contentPane.add(rdbtnFixedDepositAccount);
		
		rdbtnCurrentAccount = new JRadioButton("Current Account ");
		rdbtnCurrentAccount.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		rdbtnCurrentAccount.setBounds(72, 241, 189, 25);
		contentPane.add(rdbtnCurrentAccount);
		
		rdbtnRecurringDepositAccount = new JRadioButton("Recurring Deposit Account ");
		rdbtnRecurringDepositAccount.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		rdbtnRecurringDepositAccount.setBounds(298, 241, 275, 25);
		contentPane.add(rdbtnRecurringDepositAccount);
		
		JLabel lblCardNumber = new JLabel("Card Number :");
		lblCardNumber.setFont(new Font("Sitka Small", Font.PLAIN, 23));
		lblCardNumber.setBounds(72, 298, 189, 23);
		contentPane.add(lblCardNumber);
		
		JLabel lblPin = new JLabel("PIN:");
		lblPin.setFont(new Font("Sitka Small", Font.PLAIN, 23));
		lblPin.setBounds(72, 351, 189, 23);
		contentPane.add(lblPin);
		
		JLabel lblXxxx = new JLabel("XXXX");
		lblXxxx.setFont(new Font("Sitka Small", Font.PLAIN, 23));
		lblXxxx.setBounds(269, 351, 85, 23);
		contentPane.add(lblXxxx);
		
		JLabel lblXxxx_3 = new JLabel("XXXX-");
		lblXxxx_3.setFont(new Font("Sitka Small", Font.PLAIN, 23));
		lblXxxx_3.setBounds(269, 298, 85, 23);
		contentPane.add(lblXxxx_3);
		
		JLabel lblXxxx_2 = new JLabel("XXXX-");
		lblXxxx_2.setFont(new Font("Sitka Small", Font.PLAIN, 23));
		lblXxxx_2.setBounds(344, 298, 85, 23);
		contentPane.add(lblXxxx_2);
		
		JLabel lblXxxx_1 = new JLabel("XXXX-");
		lblXxxx_1.setFont(new Font("Sitka Small", Font.PLAIN, 23));
		lblXxxx_1.setBounds(417, 298, 85, 23);
		contentPane.add(lblXxxx_1);
		
		JLabel label_3 = new JLabel("XXXX");
		label_3.setFont(new Font("Sitka Small", Font.PLAIN, 23));
		label_3.setBounds(488, 298, 85, 23);
		contentPane.add(label_3);
		
		JLabel lblYourdigitCard = new JLabel("Your 16-Digit Card Number");
		lblYourdigitCard.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblYourdigitCard.setForeground(new Color(128, 128, 128));
		lblYourdigitCard.setBounds(72, 322, 160, 16);
		contentPane.add(lblYourdigitCard);
		
		JLabel lblItWouldAppear = new JLabel("It would appear on you ATM Card/Cheque Book & Statements");
		lblItWouldAppear.setForeground(Color.GRAY);
		lblItWouldAppear.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblItWouldAppear.setBounds(269, 322, 348, 16);
		contentPane.add(lblItWouldAppear);
		
		JLabel lbldigitPassword = new JLabel("4-Digit Password");
		lbldigitPassword.setForeground(Color.GRAY);
		lbldigitPassword.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lbldigitPassword.setBounds(72, 373, 160, 16);
		contentPane.add(lbldigitPassword);
		
		JLabel lblServicesRequired = new JLabel("Services Required :");
		lblServicesRequired.setFont(new Font("Sitka Small", Font.PLAIN, 23));
		lblServicesRequired.setBounds(72, 416, 248, 23);
		contentPane.add(lblServicesRequired);
		
		chckbxNewCheckBox = new JCheckBox("ATM Card");
		chckbxNewCheckBox.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		chckbxNewCheckBox.setBounds(72, 461, 213, 25);
		contentPane.add(chckbxNewCheckBox);
		
		chckbxMobileBanking = new JCheckBox("Mobile Banking");
		chckbxMobileBanking.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		chckbxMobileBanking.setBounds(72, 507, 213, 25);
		contentPane.add(chckbxMobileBanking);
		
		chckbxChequeBook = new JCheckBox("Cheque Book");
		chckbxChequeBook.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		chckbxChequeBook.setBounds(72, 555, 213, 25);
		contentPane.add(chckbxChequeBook);
		
		chckbxInternetBanking = new JCheckBox("Internet Banking");
		chckbxInternetBanking.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		chckbxInternetBanking.setBounds(311, 461, 213, 25);
		contentPane.add(chckbxInternetBanking);
		
		chckbxEmailAllerts = new JCheckBox("Email Allerts");
		chckbxEmailAllerts.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		chckbxEmailAllerts.setBounds(311, 507, 213, 25);
		contentPane.add(chckbxEmailAllerts);
		
		chckbxEstatement = new JCheckBox("E-Statement");
		chckbxEstatement.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		chckbxEstatement.setBounds(311, 555, 213, 25);
		contentPane.add(chckbxEstatement);
		
		chckbxIHerebyDeclare = new JCheckBox("I hereby declare that the above entered details are Correct to the Best of my Knowledge.");
		chckbxIHerebyDeclare.setBounds(72, 604, 545, 25);
		contentPane.add(chckbxIHerebyDeclare);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnCurrentAccount);bg.add(rdbtnFixedDepositAccount);bg.add(rdbtnSavingsAccount);bg.add(rdbtnRecurringDepositAccount);
		btnCancel.addActionListener(this);
		btnLogin.addActionListener(this);
		btnReset.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnLogin) {
			if(rdbtnCurrentAccount.isSelected())new_entry.setAccount_type("Current");
			else if(rdbtnFixedDepositAccount.isSelected())new_entry.setAccount_type("Fixed");
			else if(rdbtnRecurringDepositAccount.isSelected())new_entry.setAccount_type("Recurring");
			else if(rdbtnSavingsAccount.isSelected())new_entry.setAccount_type("Savings");
			if(chckbxChequeBook.isSelected())new_entry.setCheque_book(true);
			if(chckbxEmailAllerts.isSelected())new_entry.setEmail_Alert(true);//(true);
			if(chckbxEstatement.isSelected())new_entry.seteState(true);//(true);
			if(chckbxInternetBanking.isSelected())new_entry.setNetBanking(true);//(true);
			if(chckbxMobileBanking.isSelected())new_entry.setMobile_Banking(true);//(true);
			if(chckbxNewCheckBox.isSelected())new_entry.setAtm_card(true);//(true);
			
			Random rand = new Random();
			int pin=rand.nextInt(9999);
			
			int card_no1=rand.nextInt(9999);
			int card_no2=rand.nextInt(9999);
			int card_no3=rand.nextInt(9999);
			int card_no4=rand.nextInt(9999);
			
			String card= card_no1+" "+card_no2+" "+card_no3+" "+card_no4;
			
			new_entry.setPin(pin);
			new_entry.setCard(card);
			
			if(chckbxIHerebyDeclare.isSelected()) {
					new_entry.setAgreed(true);
			
					dispose();
			
					boolean status= BankContoller.storeCustomer(new_entry);
			
					if(status) {
						JOptionPane.showMessageDialog(null, "Thank You "+new_entry.getName());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Sorry "+new_entry.getName());
						new Bank_Login();				 
					}
					new Bank_ThankYou();
			
//			System.out.println(new_entry.getAddress()+new_entry.getCity()+new_entry.getF_Name()+new_entry.getName()+new_entry.getGender()+new_entry.getDate()+new_entry.getPincode());
//			System.out.println(new_entry.getAadhar()+new_entry.getAccount_type()+new_entry.getCustomerID()+new_entry.getMonth()+new_entry.getEducation()+new_entry.getE_mail()+new_entry.getIncome());
//			System.out.println(new_entry.getMobile()+new_entry.getOccupation()+new_entry.getPan()+new_entry.getState()+new_entry.getYear());
			}
			else { 
				JOptionPane.showMessageDialog(null, new_entry.getName()+", Kindly Confirm that you have filled the form carefully, to the best of your knowledge !");
			}
		}
		if(e.getSource()==btnCancel) {
			dispose();
		}
		if(e.getSource()==btnReset) {
			rdbtnCurrentAccount.setSelected(false);
			rdbtnFixedDepositAccount.setSelected(false);
			rdbtnRecurringDepositAccount.setSelected(false);
			rdbtnSavingsAccount.setSelected(false);
			chckbxChequeBook.setSelected(false);
			chckbxEmailAllerts.setSelected(false);
			chckbxEstatement.setSelected(false);
			chckbxIHerebyDeclare.setSelected(false);
			chckbxInternetBanking.setSelected(false);
			chckbxMobileBanking.setSelected(false);
			chckbxNewCheckBox.setSelected(false);
		}
	}
}

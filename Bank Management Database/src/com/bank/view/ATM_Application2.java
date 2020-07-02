package com.bank.view;

import java.util.*; 

import java.io.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.JRadioButton;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


import com.bank.entities.Customer;
public class ATM_Application2 extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_7;
	private JButton btnLogin;
	private JTextField textField;
	private JComboBox comboBox_3,comboBox_4,comboBox_2;
	private JRadioButton rdbtnNo,rdbtnYes ,radioButton ,radioButton_1;
	Customer new_entry=new Customer();
	public ATM_Application2(Customer entry) {
		new_entry=entry;

		setVisible(true);
		setTitle("Welcome to the bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 781);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 
		
		JLabel lblWelcomeToAtm = new JLabel("APPLICATION FORM ");
		lblWelcomeToAtm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAtm.setFont(new Font("Sitka Small", Font.BOLD, 38));
		lblWelcomeToAtm.setBounds(36, 40, 548, 92);
		contentPane.add(lblWelcomeToAtm);
		
		String[] religion= {"Hinduism","Sikhism","Islam","Christianity","Buddhism","Jainism","Zoroastrianism","Other Religions"};
		
		btnLogin = new JButton("NEXT");
		btnLogin.setBackground(new Color(255, 250, 205));
		btnLogin.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnLogin.setBounds(490, 667, 125, 36);
		contentPane.add(btnLogin);
//		btnLogin.addActionListener(this);
		JLabel lblPage = new JLabel("PAGE NO. 2");
		lblPage.setFont(new Font("Serif", Font.PLAIN, 19));
		lblPage.setBounds(542, 13, 100, 23);
		contentPane.add(lblPage);
		
		String [] categories= {"General","OBC","SC","ST","Other"};
		
		
		JLabel lblGender = new JLabel("Annual Income");
		lblGender.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblGender.setBounds(74, 161, 146, 22);
		contentPane.add(lblGender);
		
		String [] income= {"Less than Rs.100,000/-","Less than Rs.250,000/-","Less than Rs.500,000/-","Upto Rs.1,000,000/-","Above Rs.1,000,000/-"};
		
		comboBox_2 = new JComboBox(income);
		comboBox_2.setBounds(278, 161, 293, 22);
		contentPane.add(comboBox_2);
		
		JLabel lblEmailId = new JLabel("Educational ");
		lblEmailId.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblEmailId.setBounds(74, 222, 125, 22);
		contentPane.add(lblEmailId);
		
		String [] edu= {"Undergraduate","Graduate","Post Graduate","Doctrate","Post Doctrate","Other"};
		
		comboBox_3 = new JComboBox(edu);
		comboBox_3.setBounds(278, 232, 293, 22);
		contentPane.add(comboBox_3);
		
		JLabel lblMaritalStatus = new JLabel("Occupation");
		lblMaritalStatus.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblMaritalStatus.setBounds(74, 295, 146, 22);
		contentPane.add(lblMaritalStatus);
		
		String [] occ= {"Salaried","Self-Employed","Business","Student","Retired","Unemployed","Other"};

		comboBox_4 = new JComboBox(occ);
		comboBox_4.setBounds(278, 295, 293, 22);
		contentPane.add(comboBox_4);
		
		JLabel lblAddress = new JLabel("PAN Number");
		lblAddress.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblAddress.setBounds(74, 426, 146, 22);
		contentPane.add(lblAddress);
		
		JLabel lblState = new JLabel("Senior Citizen (60+)");
		lblState.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblState.setBounds(74, 488, 190, 22);
		contentPane.add(lblState);
		
		JLabel lblPincode = new JLabel("Existing Account ?");
		lblPincode.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblPincode.setBounds(74, 540, 190, 22);
		contentPane.add(lblPincode);
		
		JLabel lblMobileNumber = new JLabel("Adhaar Number");
		lblMobileNumber.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblMobileNumber.setBounds(74, 363, 146, 22);
		contentPane.add(lblMobileNumber);
		
		JLabel invalid;
		invalid = new JLabel("Invalid Number! ");
		invalid.setForeground(new Color(255, 0, 0));
		invalid.setVisible(false);
		invalid.setBounds(278,386,100,22);
		contentPane.add(invalid);
		
		textField_3 = new JTextField();
//		textField_3.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				try {
//					int temp= Integer.parseInt(textField_3.getText());
//					invalid.setVisible(false);
//				} catch (NumberFormatException e2) {
//					// TODO: handle exception
//					invalid.setVisible(true);
//				}
//			}
//		});
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(255, 250, 240));
		textField_3.setBounds(278, 361, 293, 27);
		contentPane.add(textField_3);
		
		JLabel invalid2;
		invalid2 = new JLabel("Invalid Number! ");
		invalid2.setForeground(new Color(255, 0, 0));
		invalid2.setVisible(false);
		invalid2.setBounds(278,612,100,22);
		contentPane.add(invalid2);
		
		textField_7 = new JTextField();
//		textField_7.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				try {
//					int temp= Integer.parseInt(textField_7.getText());
//					invalid2.setVisible(false);
//				} catch (NumberFormatException e2) {
//					// TODO: handle exception
//					invalid2.setVisible(true);
//				}
//			}
//		});

		textField_7.setColumns(10);
		textField_7.setBackground(new Color(255, 250, 240));
		textField_7.setBounds(278, 587, 293, 27);
		contentPane.add(textField_7);
		
		
		
		JLabel lblQualification = new JLabel("Qualification");
		lblQualification.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblQualification.setBounds(74, 241, 125, 22);
		contentPane.add(lblQualification);
		
		ButtonGroup bg=new ButtonGroup(),bg1=new ButtonGroup();
		
		rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBounds(316, 487, 62, 25);
		contentPane.add(rdbtnYes);
		
		radioButton = new JRadioButton("Yes");
		radioButton.setBounds(316, 539, 62, 25);
		contentPane.add(radioButton);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(444, 487, 62, 25);
		contentPane.add(rdbtnNo);
		
		radioButton_1 = new JRadioButton("No");
		radioButton_1.setBounds(444, 539, 62, 25);
		contentPane.add(radioButton_1);
		
		bg.add(rdbtnNo);bg.add(rdbtnYes);
		bg1.add(radioButton);bg1.add(radioButton_1);
		JLabel lblEnterCustomerId = new JLabel("Enter Customer ID");
		lblEnterCustomerId.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblEnterCustomerId.setBounds(74, 592, 190, 22);
		contentPane.add(lblEnterCustomerId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(255, 250, 240));
		textField.setBounds(278, 426, 293, 27);
		contentPane.add(textField);

		btnLogin.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		if(btnLogin==e.getSource()) {		
			
			
			new_entry.setIncome(comboBox_2.getSelectedItem().toString());
			new_entry.setEducation(comboBox_3.getSelectedItem().toString());
			new_entry.setOccupation(comboBox_4.getSelectedItem().toString());
			new_entry.setAadhar(textField_3.getText());
			new_entry.setPan(textField.getText());
			if(rdbtnNo.isSelected())new_entry.setSenior(false);
			else if(rdbtnYes.isSelected())new_entry.setSenior(true);
			if(radioButton.isSelected()) {
				new_entry.setExisting(true);
				new_entry.setExistingCustomerID(Integer.valueOf(textField_7.getText())); }
			else if(radioButton_1.isSelected()) {new_entry.setExisting(true);new_entry.setCustomerID(0);}

			dispose();
			new ATM_AccountDetails(new_entry);
		}
	}
}

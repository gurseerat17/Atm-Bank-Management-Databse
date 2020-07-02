package com.bank.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class ATM_Application1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	JTextField textField;
	ButtonGroup bg;
	JRadioButton rdbtnMale ,rdbtnFemale ,rdbtnOther ;
	JComboBox comboBox,comboBox_1,comboBox_2,comboBox_3;
	private JButton btnNext;
	public ATM_Application1() {

		JPanel contentPane;
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
		
		JLabel lblCardNumber = new JLabel("Name");
		lblCardNumber.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblCardNumber.setBounds(74, 159, 146, 22);
		contentPane.add(lblCardNumber);
		
		JLabel lblPin = new JLabel("Father's Name");
		lblPin.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblPin.setBounds(74, 204, 146, 22);
		contentPane.add(lblPin);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 240));
		textField.setBounds(327, 157, 244, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		btnNext= new JButton("NEXT");
		btnNext.setBackground(new Color(255, 250, 205));
		btnNext.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnNext.setBounds(481, 653, 125, 36);
		contentPane.add(btnNext);
		
		JLabel lblPage = new JLabel("PAGE NO. 1");
		lblPage.setFont(new Font("Serif", Font.PLAIN, 19));
		lblPage.setBounds(542, 13, 100, 23);
		contentPane.add(lblPage);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 250, 240));
		textField_1.setBounds(278, 202, 293, 27);
		contentPane.add(textField_1);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblDateOfBirth.setBounds(74, 249, 146, 22);
		contentPane.add(lblDateOfBirth);
		
		
		String dates[];
		dates = new String[31] ;
		for(int i=1;i<32;i++) {
			dates[i-1]= Integer.toString(i);			
		}

		String months[];
		months= new String[12] ;
		for(int i=1;i<13;i++) {
			months[i-1]= Integer.toString(i);			
		}
		String years[];
		years= new String[105] ;
		for(int i=1;i<105;i++) {
			years[i-1]= Integer.toString(i+1900);			
		}
		comboBox = new JComboBox(dates);
//		comboBox.setSelectedIndex(1);
//		comboBox.setMaximumRowCount(31);
		comboBox.setBounds(306, 249, 54, 22);
		contentPane.add(comboBox);
////		
		 comboBox_1 = new JComboBox(months);
////		comboBox_1.setSelectedIndex(1);
////		comboBox_1.setMaximumRowCount(12);
		comboBox_1.setBounds(394, 249, 54, 22);
		contentPane.add(comboBox_1);
		
		 comboBox_2 = new JComboBox(years);
////		comboBox_2.setSelectedIndex(1900);
////		comboBox_2.setMaximumRowCount(2001);
		comboBox_2.setBounds(497, 249, 74, 22);
		contentPane.add(comboBox_2);
//		
		JLabel lblDd = new JLabel("DD");
		lblDd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDd.setForeground(new Color(128, 128, 128));
		lblDd.setBounds(278, 252, 34, 16);
		contentPane.add(lblDd);
		
		JLabel lblMm = new JLabel("MM");
		lblMm.setForeground(Color.GRAY);
		lblMm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMm.setBounds(367, 252, 34, 16);
		contentPane.add(lblMm);
		
		JLabel lblYyyy = new JLabel("YYYY");
		lblYyyy.setForeground(Color.GRAY);
		lblYyyy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYyyy.setBounds(452, 251, 45, 16);
		contentPane.add(lblYyyy);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblGender.setBounds(74, 295, 146, 22);
		contentPane.add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(278, 294, 74, 25);
		contentPane.add(rdbtnMale);
		
		rdbtnFemale= new JRadioButton("Female");
		rdbtnFemale.setBounds(374, 294, 74, 25);
		contentPane.add(rdbtnFemale);
		
		rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBounds(471, 294, 74, 25);
		contentPane.add(rdbtnOther);
		
		bg= new ButtonGroup();
		bg.add(rdbtnOther);bg.add(rdbtnFemale);bg.add(rdbtnMale);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblEmailId.setBounds(74, 339, 146, 22);
		contentPane.add(lblEmailId);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 250, 240));
		textField_2.setBounds(278, 339, 293, 27);
		contentPane.add(textField_2);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblAddress.setBounds(74, 440, 146, 22);
		contentPane.add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblCity.setBounds(74, 488, 146, 22);
		contentPane.add(lblCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblState.setBounds(74, 536, 146, 22);
		contentPane.add(lblState);
		
		JLabel lblPincode = new JLabel("Pincode");
		lblPincode.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblPincode.setBounds(74, 587, 146, 22);
		contentPane.add(lblPincode);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblMobileNumber.setBounds(74, 386, 146, 22);
		contentPane.add(lblMobileNumber);
		
		JLabel invalid;
		invalid = new JLabel("Invalid Number! ");
		invalid.setForeground(new Color(255, 0, 0));
		invalid.setVisible(false);
		invalid.setBounds(278,409,100,22);
		contentPane.add(invalid);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					int temp= Integer.parseInt(textField_3.getText());
					invalid.setVisible(false);
				} catch (NumberFormatException e2) {
					// TODO: handle exception
					invalid.setVisible(true);
				}
			}
		});
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(255, 250, 240));
		textField_3.setBounds(278, 384, 293, 27);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(255, 250, 240));
		textField_4.setBounds(278, 438, 293, 27);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(255, 250, 240));
		textField_5.setBounds(278, 486, 293, 27);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(255, 250, 240));
		textField_6.setBounds(278, 534, 293, 27);
		contentPane.add(textField_6);
		
		JLabel invalid2;
		invalid2 = new JLabel("Invalid Number! ");
		invalid2.setForeground(new Color(255, 0, 0));
		invalid2.setVisible(false);
		invalid2.setBounds(278,611,100,22);
		contentPane.add(invalid2);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					int temp= Integer.parseInt(textField_7.getText());
					invalid2.setVisible(false);
				} catch (NumberFormatException e2) {
					// TODO: handle exception
					invalid2.setVisible(true);
				}
			}
		});

		textField_7.setColumns(10);
		textField_7.setBackground(new Color(255, 250, 240));
		textField_7.setBounds(278, 585, 293, 27);
		contentPane.add(textField_7);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Mr.", "Mrs.", "Ms.", "Dr."}));
		comboBox_3.setBounds(278, 159, 45, 22);
		contentPane.add(comboBox_3);

		btnNext.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnNext) {
			Customer new_entry= new Customer();
			new_entry.setName(comboBox_3.getSelectedItem().toString()+textField.getText());
			new_entry.setF_Name(textField_1.getText());
			new_entry.setDate(comboBox.getSelectedIndex()+1);
			new_entry.setMonth(comboBox_1.getSelectedIndex()+1);
			new_entry.setYear(comboBox_2.getSelectedIndex()+1900+1);
			if(rdbtnMale.isSelected())new_entry.setGender("Male");
			else if(rdbtnFemale.isSelected())new_entry.setGender("Female");
			else if(rdbtnOther.isSelected())new_entry.setGender("Other");
			new_entry.setE_mail(textField_2.getText());
			new_entry.setMobile(textField_3.getText() );
			new_entry.setAddress(textField_4.getText());
			new_entry.setCity(textField_5.getText());
			new_entry.setState(textField_6.getText());
			new_entry.setPincode(Integer.valueOf(textField_7.getText()));
			dispose();
			
			new ATM_Application2(new_entry);
		}
		
	}
}

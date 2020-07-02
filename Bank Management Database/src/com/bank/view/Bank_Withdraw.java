package com.bank.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.bank.controller.BankContoller;
import com.bank.entities.Customer;
public class Bank_Withdraw extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnDraw,btnCancel;
	Customer c=new Customer();
	public Bank_Withdraw(Customer new_entry) {
		c=new_entry;
		setVisible(true);
		setTitle("Welcome to the ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 475);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 

		setLocationRelativeTo(null); 
		JLabel lblWelcomeToAtm = new JLabel("ENTER AMOUNT YOU WANT");
		lblWelcomeToAtm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAtm.setFont(new Font("Sitka Small", Font.BOLD, 25));
		lblWelcomeToAtm.setBounds(45, 119, 548, 40);
		contentPane.add(lblWelcomeToAtm);
		
		btnDraw =  new JButton("WITHDRAW");
		btnDraw.setFont(new Font("Sitka Small", Font.PLAIN, 16));
		btnDraw.setBackground(new Color(255, 250, 205));
		btnDraw.setBounds(175, 293, 150, 36);
		contentPane.add(btnDraw);
		
		JLabel lblTransaction = new JLabel(" TO WITHDRAW IN RUPEES");
		lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaction.setFont(new Font("Sitka Small", Font.BOLD, 25));
		lblTransaction.setBounds(45, 155, 548, 40);
		contentPane.add(lblTransaction);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnCancel.setBackground(new Color(255, 250, 205));
		btnCancel.setBounds(337, 293, 107, 36);
		contentPane.add(btnCancel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(175, 209, 265, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnCancel.addActionListener(this);
		btnDraw.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(btnCancel==e.getSource()) {
			dispose();
			new Bank_Transaction(c);
			
		}
		if(btnDraw==e.getSource()) {
			dispose();
			c.setBalance(c.getBalance()-Integer.valueOf(textField.getText()));
			if(BankContoller.Withdraw(c)) {
				JOptionPane.showMessageDialog(null, "Kindly receive your Cash, "+BankContoller.Name);
				BankContoller.StoreTransaction(c,Integer.valueOf(textField.getText()),"Withdrawn from Bank");
			}
			new Bank_ThankYou();
		}
	}
}

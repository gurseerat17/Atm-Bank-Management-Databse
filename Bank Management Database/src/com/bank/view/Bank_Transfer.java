package com.bank.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.bank.controller.BankContoller;
import com.bank.controller.SendMail;
import com.bank.entities.Customer;

import javax.swing.JTextField;

public class Bank_Transfer extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnExit,btnTransfer,btnCancel;
	Customer c=new Customer();
	Customer c2=new Customer();
	private JLabel lblEnterTheAmount;
	private JLabel lblYouWantTo;
	private JTextField textField_1;
	public Bank_Transfer(Customer new_entry) {
		c=new_entry;
		setVisible(true);
		setTitle("Welcome to the ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 480);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 
		
		JLabel lblWelcomeToAtm = new JLabel("Enter the Receiver's CustomerID");
		lblWelcomeToAtm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAtm.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		lblWelcomeToAtm.setBounds(34, 43, 302, 62);
		contentPane.add(lblWelcomeToAtm);

		btnExit = new JButton("EXIT");
		btnExit.setBackground(new Color(255, 250, 205));
		btnExit.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnExit.setBounds(268, 337, 125, 36);
		contentPane.add(btnExit);
		
		btnTransfer =  new JButton("TRANSFER");
		btnTransfer.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnTransfer.setBackground(new Color(255, 250, 205));
		btnTransfer.setBounds(190, 255, 132, 36);
		contentPane.add(btnTransfer);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnCancel.setBackground(new Color(255, 250, 205));
		btnCancel.setBounds(334, 255, 125, 36);
		contentPane.add(btnCancel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(351, 47, 265, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblEnterTheAmount = new JLabel("Enter the Amount ");
		lblEnterTheAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheAmount.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		lblEnterTheAmount.setBounds(34, 118, 302, 32);
		contentPane.add(lblEnterTheAmount);
		
		lblYouWantTo = new JLabel("you want to Tranfer in Rupees");
		lblYouWantTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouWantTo.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		lblYouWantTo.setBounds(34, 152, 314, 23);
		contentPane.add(lblYouWantTo);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(351, 123, 265, 45);
		contentPane.add(textField_1);
		
		btnCancel.addActionListener(this);
		btnTransfer.addActionListener(this);
		btnExit.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnCancel) {
			dispose();
			new Bank_Transaction(c);
		}
		if(e.getSource()==btnTransfer) {
			dispose();
			c2.setCustomerID(Integer.valueOf(textField.getText()));
			if(BankContoller.verifyCustomer2(c2)) {
				c2.setBalance(c2.getBalance()+Integer.valueOf(textField_1.getText()));
				c.setBalance(c.getBalance()-Integer.valueOf(textField_1.getText()));
				
				Random rand=new Random();
				int security=rand.nextInt(9999);
				
				try {
					new  SendMail(c, "OTP", security);
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int temp =Integer.valueOf(JOptionPane.showInputDialog(null,"Enter the security OTP"));
				if(temp==security) {
				if(BankContoller.Withdraw(c) ) {
					if(BankContoller.Deposit(c2)) {
					JOptionPane.showMessageDialog(null, "Your Amount has been successfully Tranfered to " + c2.getName());
					BankContoller.StoreTransaction(c,Integer.valueOf(textField_1.getText()),"Tranfer to "+c2.getCustomerID());
					BankContoller.StoreTransaction(c2,Integer.valueOf(textField_1.getText()),"Tranfer from "+c.getCustomerID());
					}
					else System.out.println("Something went wrong.");
				}
				else System.out.println("Something went wrong..");
				new Bank_ThankYou();
				}
				else JOptionPane.showMessageDialog(null, "Incorrect OTP");
			}
			else System.out.println("We don't know the Sender");
		}
		if(e.getSource()==btnExit) {
			dispose();
		}
	}
}

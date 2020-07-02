package com.bank.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bank.controller.BankContoller;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


import com.bank.entities.Customer;

public class Bank_Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin,btnReset,btnNewUser;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bank_Login frame = new Bank_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Bank_Login() {
		setTitle("BANK NAME ONLINE PORTAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 570);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 
		
		JLabel lblWelcomeToAtm = new JLabel("BANK NAME");
		lblWelcomeToAtm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAtm.setFont(new Font("Sitka Small", Font.BOLD, 38));
		lblWelcomeToAtm.setBounds(118, 40, 428, 59);
		contentPane.add(lblWelcomeToAtm);
		
		JLabel lblCardNumber = new JLabel("CUSTOMER ID");
		lblCardNumber.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblCardNumber.setBounds(141, 164, 146, 22);
		contentPane.add(lblCardNumber);
		
		JLabel lblPin = new JLabel("PASSWORD");
		lblPin.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblPin.setBounds(141, 221, 146, 22);
		contentPane.add(lblPin);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 240));
		textField.setBounds(327, 157, 219, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 250, 240));
		passwordField.setBounds(327, 214, 219, 37);
		contentPane.add(passwordField);
		
		btnLogin = new JButton("SIGN IN");
		btnLogin.setBackground(new Color(255, 250, 205));
		btnLogin.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnLogin.setBounds(205, 310, 131, 36);
		contentPane.add(btnLogin);
		
		btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnReset.setBackground(new Color(255, 250, 205));
		btnReset.setBounds(355, 310, 131, 36);
		contentPane.add(btnReset);
		
		btnNewUser = new JButton("CREATE ACCOUNT");
		btnNewUser.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnNewUser.setBackground(new Color(255, 250, 205));
		btnNewUser.setBounds(205, 388, 281, 36);
		contentPane.add(btnNewUser);
		
		JLabel lblNewUser = new JLabel("New Here ?");
		lblNewUser.setBounds(308, 369, 77, 16);
		contentPane.add(lblNewUser);
		
		btnLogin.addActionListener(this);
		btnNewUser.addActionListener(this);
		btnReset.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {



		if(btnReset==e.getSource())
		{
			textField.setText("");
			passwordField.setText("");
		}
		if(btnNewUser==e.getSource())
		{dispose();
			new ATM_Application1();
		}
		if(btnLogin==e.getSource())
		{
			dispose();
			Customer c=new Customer();
			c.setCustomerID(Integer.valueOf(textField.getText()));
			c.setPin(Integer.valueOf(passwordField.getText()));
			boolean status =BankContoller.verifyCustomer(c);
			if(status)
			{
				JOptionPane.showMessageDialog(null, "Welcome "+BankContoller.Name);
				new Bank_Transaction(c);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "We don't know You... Please Create an Account first :)");
				
			}
		}
		
	}
}
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

public class ATM_Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin,btnReset;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM_Login frame = new ATM_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ATM_Login() {
		setTitle("Welcome to the ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 570);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 
		
		JLabel lblWelcomeToAtm = new JLabel("WELCOME TO ATM");
		lblWelcomeToAtm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAtm.setFont(new Font("Sitka Small", Font.BOLD, 38));
		lblWelcomeToAtm.setBounds(118, 40, 428, 59);
		contentPane.add(lblWelcomeToAtm);
		
		JLabel lblCardNumber = new JLabel("CARD NUMBER ");
		lblCardNumber.setFont(new Font("Sitka Small", Font.ITALIC, 18));
		lblCardNumber.setBounds(141, 164, 146, 22);
		contentPane.add(lblCardNumber);
		
		JLabel lblPin = new JLabel("PIN");
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
		btnLogin.setBounds(275, 381, 146, 36);
		contentPane.add(btnLogin);
		
		btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnReset.setBackground(new Color(255, 250, 205));
		btnReset.setBounds(275, 310, 146, 36);
		contentPane.add(btnReset);
		
		btnLogin.addActionListener(this);
		btnReset.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {



		if(btnReset==e.getSource())
		{
			textField.setText("");
			passwordField.setText("");
		}
		if(btnLogin==e.getSource())
		{
			dispose();
			Customer c=new Customer();
			c.setCard(textField.getText());
			c.setPin(Integer.valueOf(passwordField.getText()));
			boolean status =BankContoller.verifyCustomer_atm(c);
			if(status)
			{
				JOptionPane.showMessageDialog(null, "Welcome !");
				new ATM_Transaction(c);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "We don't know You ! Re-check your credentials");
				
			}
		}
		
	}
}
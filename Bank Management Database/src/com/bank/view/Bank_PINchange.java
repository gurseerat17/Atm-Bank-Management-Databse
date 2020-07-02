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

import javax.swing.JPasswordField;

public class Bank_PINchange extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JButton btnDeposit,btnLogin;
	Customer c= new Customer();
	public Bank_PINchange(Customer new_entry) {
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
		
		JLabel lblWelcomeToAtm = new JLabel("CHANGE YOUR PIN");
		lblWelcomeToAtm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAtm.setFont(new Font("Sitka Small", Font.BOLD, 32));
		lblWelcomeToAtm.setBounds(48, 53, 548, 40);
		contentPane.add(lblWelcomeToAtm);

		btnLogin = new JButton("CANCEL");
		btnLogin.setBackground(new Color(255, 250, 205));
		btnLogin.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnLogin.setBounds(227, 342, 191, 36);
		contentPane.add(btnLogin);
		
		btnDeposit =  new JButton("CHANGE PIN ");
		btnDeposit.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnDeposit.setBackground(new Color(255, 250, 205));
		btnDeposit.setBounds(227, 293, 191, 36);
		contentPane.add(btnDeposit);
		
		JLabel lblDailyWithdrawalLimit = new JLabel("Enter Current PIN");
		lblDailyWithdrawalLimit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDailyWithdrawalLimit.setFont(new Font("Sitka Small", Font.ITALIC, 19));
		lblDailyWithdrawalLimit.setBounds(99, 128, 218, 40);
		contentPane.add(lblDailyWithdrawalLimit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(342, 133, 117, 31);
		contentPane.add(passwordField);
		
		JLabel lblEnterNewPin = new JLabel("Enter New PIN");
		lblEnterNewPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterNewPin.setFont(new Font("Sitka Small", Font.ITALIC, 19));
		lblEnterNewPin.setBounds(99, 173, 218, 40);
		contentPane.add(lblEnterNewPin);
		
		JLabel lblReenterNewPin = new JLabel("Re-Enter New PIN");
		lblReenterNewPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblReenterNewPin.setFont(new Font("Sitka Small", Font.ITALIC, 19));
		lblReenterNewPin.setBounds(99, 222, 218, 40);
		contentPane.add(lblReenterNewPin);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(342, 178, 117, 31);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(342, 222, 117, 31);
		contentPane.add(passwordField_2);
		
		btnDeposit.addActionListener(this);
		btnLogin.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnDeposit) {//change pin
//			System.out.println(Integer.valueOf(passwordField_1.getText()));
//			System.out.println(Integer.valueOf(passwordField_2.getText()));
//			System.out.println(Integer.valueOf(passwordField_1.getText())-Integer.valueOf(passwordField_2.getText())==0 );
			if((passwordField_2.getText()!="" && Integer.valueOf(passwordField_1.getText())-Integer.valueOf(passwordField_2.getText())!=0 ) || Integer.valueOf(passwordField.getText())!=c.getPin())
				JOptionPane.showMessageDialog(null, "Kindly recheck your Pin!");
			else{
				dispose();
			c.setPin(Integer.valueOf(passwordField_1.getText()));
			if(BankContoller.pinChange(c))JOptionPane.showMessageDialog(null, "Your Password has been changed Successfully, "+c.getName());
			new Bank_ThankYou();
			}
		}
		if(e.getSource()==btnLogin) {//cancel
			dispose();
		}
	}
}

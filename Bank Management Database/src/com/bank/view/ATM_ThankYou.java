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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.bank.entities.Customer;

public class ATM_ThankYou extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnLogin, btnBack;
	Customer c=new Customer();
	public ATM_ThankYou(Customer new_entry) {
		c=new_entry;
		setVisible(true);
		setTitle("Welcome to the ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 382);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 
		
		JLabel lblWelcomeToAtm = new JLabel("THANK YOU ");
		lblWelcomeToAtm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAtm.setFont(new Font("Sitka Small", Font.BOLD, 38));
		lblWelcomeToAtm.setBounds(-17, 45, 548, 62);
		contentPane.add(lblWelcomeToAtm);

		btnLogin = new JButton("EXIT");
		btnLogin.setBackground(new Color(255, 250, 205));
		btnLogin.setFont(new Font("Sitka Small", Font.PLAIN, 29));
		btnLogin.setBounds(284, 206, 136, 54);
		contentPane.add(btnLogin);
		
		JLabel lblTransaction = new JLabel("FOR USING THE ATM");
		lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaction.setFont(new Font("Sitka Small", Font.BOLD, 32));
		lblTransaction.setBounds(0, 95, 548, 54);
		contentPane.add(lblTransaction);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Sitka Small", Font.PLAIN, 29));
		btnBack.setBackground(new Color(255, 250, 205));
		btnBack.setBounds(105, 206, 143, 54);
		contentPane.add(btnBack);
		
		btnBack.addActionListener(this);
		btnLogin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnBack) {
			dispose();
			new ATM_Transaction(c);
		}
		if(e.getSource()==btnLogin) {
			dispose();
		}
	}
}

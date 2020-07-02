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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.bank.controller.BankContoller;
import com.bank.entities.Customer;

public class ATM_fastCASH extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnCnl,btn100,btn500,btn1000,btn5000,btn10000,btn2000;
	Customer c=new Customer();
	public ATM_fastCASH(Customer new_entry) {
		c=new_entry;
		setVisible(true);
		setTitle("Welcome to the ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 552);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 
		
		JLabel lblWelcomeToAtm = new JLabel("SELECT YOUR ");
		lblWelcomeToAtm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAtm.setFont(new Font("Sitka Small", Font.BOLD, 38));
		lblWelcomeToAtm.setBounds(57, 40, 548, 62);
		contentPane.add(lblWelcomeToAtm);

		btnCnl = new JButton("CANCEL");
		btnCnl.setBackground(new Color(255, 250, 205));
		btnCnl.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnCnl.setBounds(234, 421, 172, 36);
		contentPane.add(btnCnl);
		
		btn500= new JButton("Rs. 500/-");
		btn500.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btn500.setBackground(new Color(255, 250, 205));
		btn500.setBounds(350, 178, 234, 36);
		contentPane.add(btn500);
		
		btn100 = new JButton("Rs. 100/-");
		btn100.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btn100.setBackground(new Color(255, 250, 205));
		btn100.setBounds(75, 178, 234, 36);
		contentPane.add(btn100);
		
		btn1000 = new JButton("Rs. 1000/-");

		btn1000.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btn1000.setBackground(new Color(255, 250, 205));
		btn1000.setBounds(75, 255, 234, 36);
		contentPane.add(btn1000);
		
		btn2000 = new JButton("Rs. 2000/-");
		btn2000.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btn2000.setBackground(new Color(255, 250, 205));
		btn2000.setBounds(350, 255, 234, 36);
		contentPane.add(btn2000);
		
		btn5000 = new JButton("Rs. 5000/-");
		btn5000.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btn5000.setBackground(new Color(255, 250, 205));
		btn5000.setBounds(75, 331, 234, 36);
		contentPane.add(btn5000);
		
		btn10000 = new JButton("Rs. 10,000/-");
		btn10000.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btn10000.setBackground(new Color(255, 250, 205));
		btn10000.setBounds(350, 331, 234, 36);
		contentPane.add(btn10000);
		
		JLabel lblTransaction = new JLabel("TRANSACTION");
		lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaction.setFont(new Font("Sitka Small", Font.BOLD, 38));
		lblTransaction.setBounds(57, 93, 548, 54);
		contentPane.add(lblTransaction);
		
		
		btnCnl.addActionListener(this);
		btn100.addActionListener(this);
		btn500.addActionListener(this);
		btn1000.addActionListener(this);
		btn5000.addActionListener(this);
		btn10000.addActionListener(this);
		btn2000.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn100) {
			dispose();c.setBalance(c.getBalance()-100);
			if(BankContoller.Withdraw(c)) {
				JOptionPane.showMessageDialog(null, "Kindly receive Rs.100/-");
				BankContoller.StoreTransaction(c,100,"Withdrawn from ATM");
			}
			new ATM_ThankYou(c);
		}
		if(e.getSource()==btn500) {
			dispose();c.setBalance(c.getBalance()-500);
			if(BankContoller.Withdraw(c)){
				JOptionPane.showMessageDialog(null, "Kindly receive Rs.500/-");
				BankContoller.StoreTransaction(c,500,"Withdrawn from ATM");
			}
			dispose();
			new ATM_ThankYou(c);
		}
		if(e.getSource()==btn1000) {
			dispose();c.setBalance(c.getBalance()-1000);
			if(BankContoller.Withdraw(c)){
				JOptionPane.showMessageDialog(null, "Kindly receive Rs.1,000/-");
				BankContoller.StoreTransaction(c,1000,"Withdrawn from ATM");
			}
			dispose();
			new ATM_ThankYou(c);
		}
		if(e.getSource()==btn2000) {
			dispose();c.setBalance(c.getBalance()-2000);
			if(BankContoller.Withdraw(c)){
				JOptionPane.showMessageDialog(null, "Kindly receive Rs.2,000/-");
				BankContoller.StoreTransaction(c,2000,"Withdrawn from ATM");
			}
			dispose();
			new ATM_ThankYou(c);
		}
		if(e.getSource()==btn5000) {
			dispose();c.setBalance(c.getBalance()-5000);
			if(BankContoller.Withdraw(c)){
				JOptionPane.showMessageDialog(null, "Kindly receive Rs.5,000/-");
				BankContoller.StoreTransaction(c,5000,"Withdrawn from ATM");
			}
			dispose();
			new ATM_ThankYou(c);
		}
		if(e.getSource()==btn10000) {
			dispose();c.setBalance(c.getBalance()-10000);
			if(BankContoller.Withdraw(c)){
				JOptionPane.showMessageDialog(null, "Kindly receive Rs.10,000/-");
				BankContoller.StoreTransaction(c,10000,"Withdrawn from ATM");
			}
			dispose();
			new ATM_ThankYou(c);
		}
		if(e.getSource()==btnCnl) {
			dispose();
			new ATM_Transaction(c);
		}
	}
}

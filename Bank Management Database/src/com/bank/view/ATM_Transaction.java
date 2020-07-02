package com.bank.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.bank.controller.BankContoller;

import com.bank.entities.Customer;

public class ATM_Transaction extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnCnl,btnCashWithdrawal,btnBalanceEnuiry , btnMiniStatement ,btnFastCash;  
	
	/**
	 * Create the frame.
	 */
	Customer c=new Customer();
	public ATM_Transaction(Customer new_entry) {
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
		btnCnl.setBounds(256, 363, 152, 36);
		contentPane.add(btnCnl);
		
		btnCashWithdrawal = new JButton("CASH WITHDRAWAL");
		btnCashWithdrawal.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnCashWithdrawal.setBackground(new Color(255, 250, 205));
		btnCashWithdrawal.setBounds(75, 180, 234, 36);
		contentPane.add(btnCashWithdrawal);
		
		btnFastCash = new JButton("FAST CASH");
		btnFastCash.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnFastCash.setBackground(new Color(255, 250, 205));
		btnFastCash.setBounds(75, 255, 234, 36);
		contentPane.add(btnFastCash);
		
		btnMiniStatement = new JButton("MINI STATEMENT");
		btnMiniStatement.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnMiniStatement.setBackground(new Color(255, 250, 205));
		btnMiniStatement.setBounds(350, 255, 234, 36);
		contentPane.add(btnMiniStatement);
		
		btnBalanceEnuiry = new JButton("BALANCE ENUIRY");
		btnBalanceEnuiry.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnBalanceEnuiry.setBackground(new Color(255, 250, 205));
		btnBalanceEnuiry.setBounds(350, 180, 234, 36);
		contentPane.add(btnBalanceEnuiry);
		
		JLabel lblTransaction = new JLabel("TRANSACTION");
		lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaction.setFont(new Font("Sitka Small", Font.BOLD, 38));
		lblTransaction.setBounds(57, 93, 548, 54);
		contentPane.add(lblTransaction);
		
		btnBalanceEnuiry.addActionListener(this);
		btnCashWithdrawal.addActionListener(this);
		btnFastCash.addActionListener(this);
		btnCnl.addActionListener(this);
		btnMiniStatement.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnCnl) {			//done
			dispose();
		}
		if(e.getSource()==btnCashWithdrawal) {	//done
			dispose();
			new ATM_Withdraw(c);
		}
		if(e.getSource()==btnFastCash) {	//done
			dispose();
			new ATM_fastCASH(c);
		}
		if(e.getSource()==btnBalanceEnuiry) { //done
			dispose();
			JOptionPane.showMessageDialog(null, "You currently have Rs. "+c.getBalance()+"/- in your "+c.getAccount_type()+" Account");			
		}
		if(e.getSource()==btnMiniStatement) {//done
			dispose();
			BankContoller.printHistory(c,"atm");
		}
	}
}

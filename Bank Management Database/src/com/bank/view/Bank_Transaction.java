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

public class Bank_Transaction extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnCnl,btnCashWithdrawal,btnDeposit,btnBalanceEnuiry , btnPinChange , btnHistory ,btnDetail;  
	private JButton btnTransfer;
	
	/**
	 * Create the frame.
	 */
	Customer c=new Customer();
	public Bank_Transaction(Customer new_entry) {
		c=new_entry;
		setVisible(true);
		setTitle("Welcome to the ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 552);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 

		setLocationRelativeTo(null); 
		JLabel lblWelcomeToAtm = new JLabel("SELECT YOUR ");
		lblWelcomeToAtm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAtm.setFont(new Font("Sitka Small", Font.BOLD, 38));
		lblWelcomeToAtm.setBounds(57, 40, 548, 62);
		contentPane.add(lblWelcomeToAtm);

		btnCnl = new JButton("CANCEL");
		btnCnl.setBackground(new Color(255, 250, 205));
		btnCnl.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnCnl.setBounds(255, 418, 152, 36);
		contentPane.add(btnCnl);
		
		btnCashWithdrawal = new JButton("CASH WITHDRAWAL");
		btnCashWithdrawal.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnCashWithdrawal.setBackground(new Color(255, 250, 205));
		btnCashWithdrawal.setBounds(379, 178, 241, 36);
		contentPane.add(btnCashWithdrawal);
		
		btnDeposit = new JButton("DEPOSIT");
		btnDeposit.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnDeposit.setBackground(new Color(255, 250, 205));
		btnDeposit.setBounds(75, 178, 141, 36);
		contentPane.add(btnDeposit);
		
		btnDetail = new JButton("ACCOUNT DETAILS");
		btnDetail.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnDetail.setBackground(new Color(255, 250, 205));
		btnDetail.setBounds(75, 255, 234, 36);
		contentPane.add(btnDetail);
		
		btnHistory = new JButton("TRANSACTION HISTORY");
		btnHistory.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnHistory.setBackground(new Color(255, 250, 205));
		btnHistory.setBounds(350, 255, 270, 36);
		contentPane.add(btnHistory);
		
		btnPinChange = new JButton("PIN CHANGE");
		btnPinChange.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnPinChange.setBackground(new Color(255, 250, 205));
		btnPinChange.setBounds(75, 331, 234, 36);
		contentPane.add(btnPinChange);
		
		btnBalanceEnuiry = new JButton("BALANCE ENUIRY");
		btnBalanceEnuiry.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnBalanceEnuiry.setBackground(new Color(255, 250, 205));
		btnBalanceEnuiry.setBounds(350, 331, 270, 36);
		contentPane.add(btnBalanceEnuiry);
		
		JLabel lblTransaction = new JLabel("TRANSACTION");
		lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaction.setFont(new Font("Sitka Small", Font.BOLD, 38));
		lblTransaction.setBounds(57, 93, 548, 54);
		contentPane.add(lblTransaction);
		
		btnTransfer = new JButton("TRANSFER");
		btnTransfer.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnTransfer.setBackground(new Color(255, 250, 205));
		btnTransfer.setBounds(228, 178, 141, 36);
		contentPane.add(btnTransfer);
		
		btnBalanceEnuiry.addActionListener(this);
		btnCashWithdrawal.addActionListener(this);
		btnDeposit.addActionListener(this);
		btnDetail.addActionListener(this);
		btnCnl.addActionListener(this);
		btnHistory.addActionListener(this);
		btnPinChange.addActionListener(this);;
		btnTransfer.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnCnl) {			//done
			dispose();
		}
		if(e.getSource()==btnCashWithdrawal) {	//done
			dispose();
			new Bank_Withdraw(c);
		}
		if(e.getSource()==btnDetail) {
			dispose();
			new Account_detail(c);
		}
		if(e.getSource()==btnPinChange) { //done
			dispose();
			new Bank_PINchange(c);
		}
		if(e.getSource()==btnBalanceEnuiry) { //done
			dispose();
			JOptionPane.showMessageDialog(null, "You currently have Rs. "+c.getBalance()+"/- in your "+c.getAccount_type()+" Account");
		}
		if(e.getSource()==btnDeposit) {  //done
			dispose();
			new Bank_Deposit(c);
		}
		if(e.getSource()==btnTransfer) {  //done
			dispose();
			new Bank_Transfer(c);
		}
		if(e.getSource()==btnHistory) {//done
			dispose();
			BankContoller.printHistory(c,"Bank");
		}
	}
}

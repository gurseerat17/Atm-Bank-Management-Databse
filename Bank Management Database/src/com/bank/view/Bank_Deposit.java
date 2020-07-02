package com.bank.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
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

public class Bank_Deposit extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnExit,btnDeposit,btnCancel;
	Customer c=new Customer();
	public Bank_Deposit(Customer new_entry) {
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
		
		JLabel lblWelcomeToAtm = new JLabel("ENTER AMOUNT YOU WANT");
		lblWelcomeToAtm.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToAtm.setFont(new Font("Sitka Small", Font.BOLD, 29));
		lblWelcomeToAtm.setBounds(57, 40, 548, 62);
		contentPane.add(lblWelcomeToAtm);

		btnExit = new JButton("EXIT");
		btnExit.setBackground(new Color(255, 250, 205));
		btnExit.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		btnExit.setBounds(268, 337, 125, 36);
		contentPane.add(btnExit);
		
		btnDeposit =  new JButton("DEPOSIT");
		btnDeposit.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnDeposit.setBackground(new Color(255, 250, 205));
		btnDeposit.setBounds(190, 255, 132, 36);
		contentPane.add(btnDeposit);
		
		JLabel lblTransaction = new JLabel(" TO DEPOSIT IN RUPEES");
		lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaction.setFont(new Font("Sitka Small", Font.BOLD, 29));
		lblTransaction.setBounds(57, 93, 548, 54);
		contentPane.add(lblTransaction);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnCancel.setBackground(new Color(255, 250, 205));
		btnCancel.setBounds(334, 255, 125, 36);
		contentPane.add(btnCancel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(190, 169, 265, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnCancel.addActionListener(this);
		btnDeposit.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnCancel) {
			dispose();
			new Bank_Transaction(c);
		}
		if(e.getSource()==btnDeposit) {
			dispose();
			c.setBalance(c.getBalance()+Integer.valueOf(textField.getText()));
			if(BankContoller.Deposit(c)) {
				JOptionPane.showMessageDialog(null, "Your Amount has been successfully Deopsited");
				BankContoller.StoreTransaction(c,Integer.valueOf(textField.getText()),"Deposited in Bank");
				try {
					new SendMail(c,"Money Deposit",Integer.valueOf(textField.getText()));
				} catch (AddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			new Bank_ThankYou();
		}
		if(e.getSource()==btnExit) {
			dispose();
		}
	}
}

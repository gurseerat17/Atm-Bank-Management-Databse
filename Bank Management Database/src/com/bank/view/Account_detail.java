package com.bank.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bank.controller.BankContoller;
import com.bank.entities.Customer;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;

public class Account_detail extends JFrame {

	private JPanel contentPane;
	public Account_detail(Customer c) {
//		System.out.println(c.getCustomerID());
		BankContoller.getAllinfo(c);
		setVisible(true);
		setTitle("Welcome to the ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1177, 572);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(50, 205, 50));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerId = new JLabel("Customer ID :");
		lblCustomerId.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblCustomerId.setForeground(new Color(50, 205, 50));
		lblCustomerId.setBounds(30, 25, 149, 16);
		contentPane.add(lblCustomerId);
		
		JLabel label = new JLabel("");
		label.setBounds(191, 26, 56, 16);
		contentPane.add(label);
		
		JLabel lblName = new JLabel("Name        :");
		lblName.setForeground(new Color(50, 205, 50));
		lblName.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblName.setBounds(30, 54, 149, 16);
		contentPane.add(lblName);
		
		JLabel lblFathersName = new JLabel("Father's Name :");
		lblFathersName.setForeground(new Color(50, 205, 50));
		lblFathersName.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblFathersName.setBounds(30, 83, 165, 16);
		contentPane.add(lblFathersName);
		
		JLabel lblGender = new JLabel("Gender      :");
		lblGender.setForeground(new Color(50, 205, 50));
		lblGender.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblGender.setBounds(30, 112, 149, 16);
		contentPane.add(lblGender);
		
		JLabel lblEmailId = new JLabel("Email ID     :");
		lblEmailId.setForeground(new Color(50, 205, 50));
		lblEmailId.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblEmailId.setBounds(30, 141, 165, 16);
		contentPane.add(lblEmailId);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setForeground(new Color(50, 205, 50));
		lblAddress.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblAddress.setBounds(30, 174, 149, 16);
		contentPane.add(lblAddress);
		
		JLabel lblDateOfBirth = new JLabel("Pincode :");
		lblDateOfBirth.setForeground(new Color(50, 205, 50));
		lblDateOfBirth.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblDateOfBirth.setBounds(30, 203, 149, 16);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblDateOfJoining = new JLabel("Mobile Number  :");
		lblDateOfJoining.setForeground(new Color(50, 205, 50));
		lblDateOfJoining.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblDateOfJoining.setBounds(30, 232, 176, 16);
		contentPane.add(lblDateOfJoining);
		
		JLabel lblDateOfBirth_1 = new JLabel("Date of Birth :");
		lblDateOfBirth_1.setForeground(new Color(50, 205, 50));
		lblDateOfBirth_1.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblDateOfBirth_1.setBounds(30, 261, 195, 16);
		contentPane.add(lblDateOfBirth_1);
		
		JLabel lblDateOfJoining_1 = new JLabel("Date of Joining :");
		lblDateOfJoining_1.setForeground(new Color(50, 205, 50));
		lblDateOfJoining_1.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblDateOfJoining_1.setBounds(30, 291, 195, 16);
		contentPane.add(lblDateOfJoining_1);
		
		JLabel lblAadharNumber = new JLabel("Aadhar Number :");
		lblAadharNumber.setForeground(new Color(50, 205, 50));
		lblAadharNumber.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblAadharNumber.setBounds(30, 320, 165, 16);
		contentPane.add(lblAadharNumber);
		
		JLabel lblPanCardNumber = new JLabel("PAN Card Number :");
		lblPanCardNumber.setForeground(new Color(50, 205, 50));
		lblPanCardNumber.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblPanCardNumber.setBounds(30, 349, 195, 16);
		contentPane.add(lblPanCardNumber);
		
		JLabel lblAnnualIncome = new JLabel("Annual Income :");
		lblAnnualIncome.setForeground(new Color(50, 205, 50));
		lblAnnualIncome.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblAnnualIncome.setBounds(30, 378, 227, 16);
		contentPane.add(lblAnnualIncome);
		
		JLabel lblEducationalQualification = new JLabel("Educational Qualification :");
		lblEducationalQualification.setForeground(new Color(50, 205, 50));
		lblEducationalQualification.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblEducationalQualification.setBounds(30, 407, 304, 21);
		contentPane.add(lblEducationalQualification);
		
		JLabel lblOccupation = new JLabel("Occupation   :");
		lblOccupation.setForeground(new Color(50, 205, 50));
		lblOccupation.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblOccupation.setBounds(30, 438, 176, 16);
		contentPane.add(lblOccupation);
		
		JLabel lblOtherAccounts = new JLabel("Senior Citizen :");
		lblOtherAccounts.setForeground(new Color(50, 205, 50));
		lblOtherAccounts.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblOtherAccounts.setBounds(30, 467, 195, 16);
		contentPane.add(lblOtherAccounts);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(404, 55, 56, 16);
		contentPane.add(label_1);
		
		JLabel lblAccountInformation = new JLabel("ACCOUNT INFORMATION");
		lblAccountInformation.setForeground(new Color(255, 255, 0));
		lblAccountInformation.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblAccountInformation.setBounds(857, 25, 227, 16);
		contentPane.add(lblAccountInformation);
		
		JLabel lblAtmCard = new JLabel("ATM Card :");
		lblAtmCard.setForeground(new Color(255, 255, 0));
		lblAtmCard.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblAtmCard.setBounds(727, 175, 149, 16);
		contentPane.add(lblAtmCard);
		
		JLabel lblBalance = new JLabel("Balance   :");
		lblBalance.setForeground(Color.YELLOW);
		lblBalance.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblBalance.setBounds(727, 146, 149, 16);
		contentPane.add(lblBalance);
		
		JLabel lblAccountType = new JLabel("Account Type :");
		lblAccountType.setForeground(Color.YELLOW);
		lblAccountType.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblAccountType.setBounds(727, 117, 159, 16);
		contentPane.add(lblAccountType);
		
		JLabel lblCardNumber = new JLabel("Card Number :");
		lblCardNumber.setForeground(Color.YELLOW);
		lblCardNumber.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblCardNumber.setBounds(727, 88, 149, 16);
		contentPane.add(lblCardNumber);
		
		JLabel label_3 = new JLabel("Customer ID :");
		label_3.setForeground(Color.YELLOW);
		label_3.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_3.setBounds(727, 55, 149, 16);
		contentPane.add(label_3);
		
		JLabel lblNetBanking = new JLabel("Net Banking :");
		lblNetBanking.setForeground(Color.YELLOW);
		lblNetBanking.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblNetBanking.setBounds(727, 204, 149, 16);
		contentPane.add(lblNetBanking);
		
		JLabel lblEMailAlerts = new JLabel("E- Mail Alerts :");
		lblEMailAlerts.setForeground(Color.YELLOW);
		lblEMailAlerts.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblEMailAlerts.setBounds(727, 294, 176, 16);
		contentPane.add(lblEMailAlerts);
		
		JLabel lblChequeBook = new JLabel("Cheque Book :");
		lblChequeBook.setForeground(Color.YELLOW);
		lblChequeBook.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblChequeBook.setBounds(727, 323, 149, 16);
		contentPane.add(lblChequeBook);
		
		JLabel lblAnyOtherAccounts = new JLabel("Any Other Accounts :");
		lblAnyOtherAccounts.setForeground(Color.YELLOW);
		lblAnyOtherAccounts.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblAnyOtherAccounts.setBounds(727, 352, 236, 16);
		contentPane.add(lblAnyOtherAccounts);
		
		JLabel lblDetailsOfOther = new JLabel("Details of Other Account :-");
		lblDetailsOfOther.setForeground(Color.YELLOW);
		lblDetailsOfOther.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblDetailsOfOther.setBounds(727, 381, 320, 16);
		contentPane.add(lblDetailsOfOther);
		
		JLabel lblEStatement = new JLabel("E Statement :");
		lblEStatement.setForeground(Color.YELLOW);
		lblEStatement.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblEStatement.setBounds(727, 265, 149, 16);
		contentPane.add(lblEStatement);
		
		JLabel lblMobileBanking = new JLabel("Mobile Banking :");
		lblMobileBanking.setForeground(Color.YELLOW);
		lblMobileBanking.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblMobileBanking.setBounds(727, 232, 176, 16);
		contentPane.add(lblMobileBanking);
		
		JLabel label_2 = new JLabel(c.getAccount_type());
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_2.setBounds(898, 116, 149, 16);
		contentPane.add(label_2);
		
		JLabel label_15 = new JLabel("Rs."+c.getBalance()+"");
		label_15.setForeground(Color.YELLOW);
		label_15.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_15.setBounds(898, 145, 149, 16);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel((c.isAtm_card()?"Yes":"No"));
		label_16.setForeground(Color.YELLOW);
		label_16.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_16.setBounds(898, 174, 149, 16);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel(c.isNetBanking()?"Yes":"No");
		label_17.setForeground(Color.YELLOW);
		label_17.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_17.setBounds(898, 203, 149, 16);
		contentPane.add(label_17);
		String s=c.getCard().substring(14);
		JLabel label_18 = new JLabel("XXXX-XXXX-XXXX-"+s);
		label_18.setForeground(Color.YELLOW);
		label_18.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_18.setBounds(877, 87, 270, 16);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel(""+c.getCustomerID());
		label_19.setForeground(Color.YELLOW);
		label_19.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_19.setBounds(898, 54, 149, 16);
		contentPane.add(label_19);
		
		JLabel label_20 = new JLabel(c.isEmail_Alert()?"Yes":"No");
		label_20.setForeground(Color.YELLOW);
		label_20.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_20.setBounds(908, 291, 149, 16);
		contentPane.add(label_20);
		
		JLabel label_21 = new JLabel(c.isCheque_book()?"Yes":"No");
		label_21.setForeground(Color.YELLOW);
		label_21.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_21.setBounds(898, 320, 149, 16);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel(c.isExisting()?"Yes":"No");
		label_22.setForeground(Color.YELLOW);
		label_22.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_22.setBounds(975, 349, 149, 16);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel("Customer ID :");
		label_23.setForeground(Color.YELLOW);
		label_23.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_23.setBounds(727, 409, 149, 16);
		contentPane.add(label_23);
		
		JLabel label_24 = new JLabel(c.iseState()?"Yes":"No");
		label_24.setForeground(Color.YELLOW);
		label_24.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_24.setBounds(898, 262, 149, 16);
		contentPane.add(label_24);
		
		JLabel label_25 = new JLabel(c.isMobile_Banking()?"Yes":"No");
		label_25.setForeground(Color.YELLOW);
		label_25.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_25.setBounds(915, 232, 149, 16);
		contentPane.add(label_25);
		
		JLabel label_26 = new JLabel(c.getCustomerID()+"");
		label_26.setForeground(new Color(50, 205, 50));
		label_26.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_26.setBounds(185, 26, 149, 16);
		contentPane.add(label_26);
		
		JLabel label_27 = new JLabel(c.getName());
		label_27.setForeground(new Color(50, 205, 50));
		label_27.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_27.setBounds(185, 55, 384, 16);
		contentPane.add(label_27);
		
		JLabel label_28 = new JLabel(c.getF_Name());
		label_28.setForeground(new Color(50, 205, 50));
		label_28.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_28.setBounds(214, 84, 465, 16);
		contentPane.add(label_28);
		
		JLabel label_29 = new JLabel(c.getGender());
		label_29.setForeground(new Color(50, 205, 50));
		label_29.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_29.setBounds(203, 113, 149, 16);
		contentPane.add(label_29);
		
		JLabel label_30 = new JLabel(c.getE_mail());
		label_30.setForeground(new Color(50, 205, 50));
		label_30.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_30.setBounds(207, 142, 520, 16);
		contentPane.add(label_30);
		
		JLabel label_31 = new JLabel(c.getAddress()+", "+c.getCity()+", "+c.getState());
		label_31.setForeground(new Color(50, 205, 50));
		label_31.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_31.setBounds(153, 175, 526, 16);
		contentPane.add(label_31);
		JLabel label_32 = new JLabel(c.getPin()+"");
		label_32.setForeground(new Color(50, 205, 50));
		label_32.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_32.setBounds(153, 203, 149, 16);
		contentPane.add(label_32);
		
		JLabel label_33 = new JLabel(c.getMobile());
		label_33.setForeground(new Color(50, 205, 50));
		label_33.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_33.setBounds(214, 233, 200, 16);
		contentPane.add(label_33);
		
		JLabel label_34 = new JLabel(c.getDOB());
		label_34.setForeground(new Color(50, 205, 50));
		label_34.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_34.setBounds(214, 262, 172, 16);
		contentPane.add(label_34);
		
		JLabel label_35 = new JLabel(c.getStart());
		label_35.setForeground(new Color(50, 205, 50));
		label_35.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_35.setBounds(224, 292, 190, 16);
		contentPane.add(label_35);
		
		JLabel label_36 = new JLabel(c.getAadhar());
		label_36.setForeground(new Color(50, 205, 50));
		label_36.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_36.setBounds(207, 321, 195, 16);
		contentPane.add(label_36);
		
		JLabel label_37 = new JLabel(c.getPan());
		label_37.setForeground(new Color(50, 205, 50));
		label_37.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_37.setBounds(236, 350, 208, 16);
		contentPane.add(label_37);
		
		JLabel label_38 = new JLabel(c.getIncome());
		label_38.setForeground(new Color(50, 205, 50));
		label_38.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_38.setBounds(214, 379, 377, 16);
		contentPane.add(label_38);
		
		JLabel label_39 = new JLabel(c.getEducation());
		label_39.setForeground(new Color(50, 205, 50));
		label_39.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_39.setBounds(346, 410, 322, 16);
		contentPane.add(label_39);
		
		JLabel label_40 = new JLabel(c.getOccupation());
		label_40.setForeground(new Color(50, 205, 50));
		label_40.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_40.setBounds(203, 438, 415, 16);
		contentPane.add(label_40);
		
		JLabel label_41 = new JLabel(c.isSenior()?"Yes":"No");
		label_41.setForeground(new Color(50, 205, 50));
		label_41.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_41.setBounds(237, 468, 149, 16);
		contentPane.add(label_41);

		if(c.isExisting()) {
		JLabel label_4 = new JLabel("Account Type :");
		label_4.setForeground(Color.YELLOW);
		label_4.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_4.setBounds(727, 438, 159, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Balance   :");
		label_5.setForeground(Color.YELLOW);
		label_5.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_5.setBounds(727, 468, 149, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel(""+c.getExistingCustomerID());
		label_6.setForeground(Color.YELLOW);
		label_6.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_6.setBounds(898, 410, 149, 16);
		contentPane.add(label_6);
		Customer c2=new Customer();
		c2.setCustomerID(c.getExistingCustomerID());
		BankContoller.verifyCustomer2(c2);
		
		JLabel label_7 = new JLabel(c2.getAccount_type());
		label_7.setForeground(Color.YELLOW);
		label_7.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_7.setBounds(898, 439, 149, 16);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Rs."+c2.getBalance()+"");
		label_8.setForeground(Color.YELLOW);
		label_8.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		label_8.setBounds(898, 468, 149, 16);
		contentPane.add(label_8);
		setLocationRelativeTo(null); 
		}
		setLocationRelativeTo(null); 
	}
}

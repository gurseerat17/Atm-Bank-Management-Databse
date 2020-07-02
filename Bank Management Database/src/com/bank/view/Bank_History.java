package com.bank.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.bank.entities.Customer;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.Font;

public class Bank_History extends JFrame{
	 JTable table;
	

	public Bank_History(Vector headers, Customer c, ResultSet resultSet, int colCount, String string) {
		getContentPane().setFont(new Font("Verdana", Font.PLAIN, 18));
		
		setVisible(true);
		getContentPane().setLayout(null);
		setSize(905, 553);
		setTitle("Transaction History");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		
		getContentPane().setBackground(new Color(230, 230, 250));
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setForeground(new Color(47, 79, 79));
		
			Vector<Vector<String>> Record = new Vector<Vector<String>>();

		try {
			
			while(resultSet.next()) {			     
				Vector<String> record = new Vector<String>();   
			          record.add(resultSet.getInt(1)+"");
			          record.add(resultSet.getInt(2)+"");
			          record.add(resultSet.getString(3));
			          record.add(resultSet.getInt(4)+"");
			          record.add(resultSet.getString(5));
			          Record.add(record);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: " +e);
			e.printStackTrace();
		}
		if(string=="Bank") {
		table = new JTable(Record,headers);
		Collections.reverse(Record);
		}
		else if(string=="atm") {
			Vector<Vector<String>> Mini_Record=new Vector<Vector<String>>();
			for(int i=0;i<5;i++) {
				Mini_Record.add(Record.get(i));
			}
			Collections.reverse(Mini_Record);
			table = new JTable(Mini_Record,headers);
		}
			
		table.setForeground(new Color(72, 61, 139));
		table.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
		table.setSurrendersFocusOnKeystroke(true);
		table.setBounds(45, 218, 263, -167);
		table.setBackground(new Color(224, 255, 255));
		getContentPane().add(table, BorderLayout.CENTER);
		table.setRowHeight(25);
		
		TableColumnModel col=table.getColumnModel();
		col.getColumn(0).setPreferredWidth(70);
		col.getColumn(1).setPreferredWidth(80);
		col.getColumn(2).setPreferredWidth(200);
		col.getColumn(3).setPreferredWidth(120);
		col.getColumn(4).setPreferredWidth(307);
		
//		getContentPane().add(table);

//		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
//		table.setDefaultRenderer(String.class, centerRenderer);
		
		DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
		centerRenderer1.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer1 );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer1 );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer1 );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer1 );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer1 );
		
		
//		table.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());
		table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 20));
		table.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        table.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        //table.setBorder(BorderFactory.createEtchedBorder());
		
		JScrollPane jscrollpane= new JScrollPane(table);
		getContentPane().add(jscrollpane);
		jscrollpane.setBackground(new Color(224, 255, 255));
		jscrollpane.setBounds(57, 65, 787, 377);
	}


}

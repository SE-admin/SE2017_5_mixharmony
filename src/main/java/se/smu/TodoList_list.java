package se.smu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TodoList_list extends JPanel{
	private JTable TodoList_table;
	
	TodoList_list(){
		setBackground(Color.WHITE);
		setBounds(0, 0, 584, 581);
		setLayout(null);

		Object[][] column =	{
				{null,null,null},
				{null,null,null},
				{null,null,null},
				{null,null,null},
				{null,null,null},
				{null,null,null},
				{null,null,null},
				{null,null,null},
				{null,null,null},
				{null,null,null},
				{null,null,null},
				{null,null,null},
				{null,null,null},
				{null,null,null},
				{null,null,null},
				{null,null,null}
			};
	
		String[] row = {
			"번호", "할 일", "마감 기한"
		};
		
	
	
		TodoList_table= new JTable();		
		TodoList_table.setBounds(27, 80, 533, 300);
		
		
		
		
		TodoList_table.setModel(new DefaultTableModel(column,row) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			/*
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			*/
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		TodoList_table.setBounds(23, 84, 538, 236);
		add(TodoList_table);
		
	
		//등록
		JButton add = new JButton("");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			
			}
		});
		add.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/todo_add.PNG")));
		add.setBorder(null);
		add.setBackground(Color.WHITE);
		add.setBounds(30, 350, 80, 50);
		add(add);
		
		
		//수정
		JButton edit = new JButton("");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		
			
				
			}
		});
		edit.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/todo_edit.PNG")));
		edit.setBorder(null);
		edit.setBackground(Color.WHITE);
		edit.setBounds(120, 350, 80, 50);
		add(edit);
		
		
		//삭제
		JButton del = new JButton("");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	
				
			
				
			}
		});
		del.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/todo_del.PNG")));
		del.setBorder(null);
		del.setBackground(Color.WHITE);
		del.setBounds(210, 350, 80, 50);
		add(del);
		
		
		//완료
		JButton done = new JButton("");
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		
			
				
			}
		});
		done.setIcon(new ImageIcon(MainFrame.class.getResource("/icon/todo_done.PNG")));
		done.setBorder(null);
		done.setBackground(Color.WHITE);
		done.setBounds(300, 350, 80, 50);
		add(done);
		
		
	}


	
	

}

package se.smu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class AllTodoListMain extends JPanel{
	
	
	private JTable todo_table;
	
	/**
	 * Create the panel.
	 */
	public AllTodoListMain() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 584, 581);
		setLayout(null);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 56);
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(null);
		
		JLabel todo_label = new JLabel("전체 할 일 목록");
		todo_label.setFont(new Font("바탕체", Font.PLAIN, 20));
		todo_label.setHorizontalAlignment(SwingConstants.CENTER);
		todo_label.setBounds(0, 0, 159, 56);
		panel.add(todo_label);
		

		int a;
		int b;
		
		if(MainFrame.Todo.length==0){
			a=1;
			b=1;
		}
		else{
			a=MainFrame.Todo.length;
			b=MainFrame.Todo[0].length;
		}
		
		Object[][] column = new Object[a][b];
		String[] row = {
			"과목명", "할 일", "중요도", "마감기한","실제마감일", "완료"
		};
		
		
		try {
			MainFrame.Todo=MainFrame.get_Todo();
			paintToDoTable(MainFrame.Todo,column);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e){
			e.getMessage();
		}
		
		
		todo_table = new JTable();		
		todo_table.setBounds(27, 80, 533, 174);
		todo_table.setModel(new DefaultTableModel(column,row){
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		

		
		todo_table.setRowSorter(new TableRowSorter(new DefaultTableModel(column,row)));
		

		
		JScrollPane scrollPane = new JScrollPane(todo_table);
		scrollPane.setBounds(0, 55, 584, 526);
		scrollPane.setBackground(Color.WHITE);
		add(scrollPane);
		
		

	}
	
	void paintToDoTable(String[][] Todo, Object[][] column){
		
		for(int i=0;i<Todo.length;i++){
			column[i][0] = Todo[i][0];
			column[i][1] = Todo[i][1];
			switch(Todo[i][8]){
			
			case "0":
				column[i][2] = "";
				break;
			case "1":
				column[i][2] = "o";
				break;
			case "2":
				column[i][2] = "oo";
				break;
			case "3":
				column[i][2] = "ooo";
				break;
			}
			
			column[i][3] = Todo[i][2]+"/"+Todo[i][3]+"/"+Todo[i][4];
			if(Todo[i][5].equals("0")&&Todo[i][6].equals("0")&&Todo[i][7].equals("0")){
				column[i][4]="";
			}
			else{
				column[i][4] = Todo[i][5]+"/"+Todo[i][6]+"/"+Todo[i][7];
			}
			
			column[i][5] = Todo[i][9];
			
		}
	}
	
	
}



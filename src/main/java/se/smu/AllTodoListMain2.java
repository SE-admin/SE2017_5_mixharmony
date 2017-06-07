package se.smu;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import se.smu.MainFrame;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;





public class AllTodoListMain2 extends JPanel implements ItemListener{
	private JTable todo_table;
	private String choice;
	public AllTodoListMain2() {

		setBackground(Color.WHITE);
		setBounds(0, 0, 584, 581);
		setLayout(null);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 56);
		panel.setBackground(Color.pink);
		add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("\uC804\uCCB4 \uD560 \uC77C \uBAA9\uB85D");
		label_1.setFont(new Font("���� ���", Font.PLAIN, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 0, 159, 56);
		panel.add(label_1);

		int a=0;
		int b;
		
		
		if(MainFrame.Todo.length==0){
			// todo����Ʈ�� �߰����� �ʾ�����
			
			a=1;
			b=1;
			
		}
		//todo[todo�� ����][todo �׸�]
		else{
			// a�� ���θ���Ʈ�� ����
			// b�� todo�׸��� ������ ����
			//a�� �����ؼ� ���̺��� ũ�⸦ ������ �� �ִ�.
			//a=40;
			b = MainFrame.Todo[0].length;
			
			
			for(int i=0; i<MainFrame.Todo.length; i++){
				if(MainFrame.Todo[i][9].equals("X"))
					a++;
			}
			
		}
		//ũ�� �����Ҵ�
		Object[][] column = new Object[a][b];
		//�޴�
		String[] row = {
			"�����", "�� ��", "�߿䵵", "��������","����������", "�Ϸ�"
		};
		
		
		try {
			//todo����Ʈ �ҷ�����
			MainFrame.Todo=MainFrame.get_Todo();
			//
			paint_Todo_table(MainFrame.Todo,column);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e){
			e.getMessage();
		}
		
		//todo��ü���̺� ����
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
		
		/*
		DefaultTableModel model = new DefaultTableModel(column2,row);
		todo_table.setModel(model);
		*/
		
		//�����ϴ� �Լ�
		todo_table.setRowSorter(new TableRowSorter(new DefaultTableModel(column,row)));
		
		//���ùڽ� �߰�
		JComboBox sorter = new JComboBox();
		sorter.addItem("�����"); 
		sorter.addItem("�� ��"); 
		sorter.addItem("�߿䵵"); 
		sorter.addItem("��������");
		sorter.addItem("����������");
		sorter.addItem("�Ϸ�");
		sorter.setBackground(Color.white);
		sorter.setBounds(396,249,102,25);
		sorter.addItemListener(this); 
		sorter.setVisible(true);
		add(sorter);

		

		//filter(MainFrame.Todo,column, row);
		filter();
		
		//todo_table.getRowSorter();
		
		//todo_table.sorterChanged(e);
		
		JScrollPane scrollPane = new JScrollPane(todo_table);
		scrollPane.setBounds(0, 55, 584, 526);
		scrollPane.setBackground(Color.WHITE);
		add(scrollPane);
		
		
		/*
		todo_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = todo_table.getSelectedRow();
				int col = 1;
				String value = (String) todo_table.getValueAt(row, col);
				
				if (e.getClickCount() == 2) {
					
					try {
						
						TodoList_Detail detail = new TodoList_Detail(MainFrame.find_list(value,MainFrame.Todo));
						
						MainFrame.main_panel.removeAll();
						MainFrame.main_panel.add(detail);
						
						
						detail.revalidate();
						detail.repaint();
						
					} catch (NullPointerException e1){
						e1.getMessage();
					}
				
				}
			}
		});
		*/
		
		

	
	
	
	}
	void filter(){
		JButton Filter = new JButton("���̱�");
		Filter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AllTodoListMain Test1 = new AllTodoListMain();
				
				MainFrame.main_panel.removeAll();
				MainFrame.main_panel.add(Test1);
			}
			
		});
		
		Filter.setFont(new Font("���� ���", Font.PLAIN, 12));
		Filter.setBounds(396, 350, 100, 20);
		Filter.setVisible(true);
		add(Filter);

		
	}
	
	//���Ӱ� ���� column������ �迭
	void paint_Todo_table(String[][] Todo, Object[][] column){
		int b = 0;
		for(int i=0;i<Todo.length;i++){
			if(Todo[i][9].equals("X")){
			column[b][0] = Todo[i][0];
			column[b][1] = Todo[i][1];
			
			switch(Todo[i][8]){
			
			case "0":
				column[b][2] = "";
				break;
			case "1":
				column[b][2] = "��";
				break;
			case "2":
				column[b][2] = "�ڡ�";
				break;
			case "3":
				column[b][2] = "�ڡڡ�";
				break;
			
			}
			
			column[b][3] = Todo[i][2]+"/"+Todo[i][3]+"/"+Todo[i][4];
			if(Todo[i][5].equals("0")&&Todo[i][6].equals("0")&&Todo[i][7].equals("0")){
				column[b][4]="";
			}
			else{
				column[b][4] = Todo[i][5]+"/"+Todo[i][6]+"/"+Todo[i][7];
			}
			
			column[b][5] = Todo[i][9];
			
			b++;
			
			}
			
		}
	}
	//üũ�ڽ��� �����ϴ� �Լ�(�����ʸ� ��ӹ����� ������ �ϴ� �Լ�) 
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		choice = (String)e.getItem(); 
		
	    switch(choice)
		{
		case "�����" :
			todo_table.getRowSorter().toggleSortOrder(0);
			break;
		case "�� ��" :
			todo_table.getRowSorter().toggleSortOrder(1);
			break;
		case "�߿䵵" :
			todo_table.getRowSorter().toggleSortOrder(2);
			break;
		case "��������" :
			todo_table.getRowSorter().toggleSortOrder(3);
			break;
		case "����������" :
			todo_table.getRowSorter().toggleSortOrder(4);
			break;
		case "�Ϸ�" :
			todo_table.getRowSorter().toggleSortOrder(5);
			break;
		}
	
	}
	
	
}


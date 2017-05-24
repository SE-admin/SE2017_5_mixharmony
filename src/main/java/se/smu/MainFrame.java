package se.smu;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	public static JPanel contentPane;
	
	public static JPanel main_panel;
	
	public static String [][] subject;
	
	public static String [][] Todo;
	
	
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
			    	MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MainFrame() {
		setTitle("소공이의 할 일(V.1.0)");
		
		try {
			subject = getSubject();
			
			Todo = get_Todo();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.black);
		contentPane.setBorder(null);
		contentPane.setBounds(0, 0, 584, 81);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		MenuPanel menu = new MenuPanel();
		contentPane.add(menu);
		
		main_panel = new JPanel();
		main_panel.setBounds(0, 81, 584, 581);
		getContentPane().add(main_panel);
		main_panel.setLayout(null);
		
		HomeMain Test2 = new HomeMain();
		Test2.setBounds(0, 0, 584, 581);
		main_panel.add(Test2);
		
	
	}
	public static String[][] getSubject() throws IOException{
		
		 File f = new File("subject_out.txt");

		    if (!f.isFile()) {
		    	f.createNewFile();
		    }

		BufferedReader br = new BufferedReader(new FileReader("subject_out.txt"));
		StringTokenizer token;
		int count_line=0;
		
		while(br.readLine()!=null){
			count_line++;
		}
		br.close();
		
		br = new BufferedReader(new FileReader("subject_out.txt"));
		
		String subject[][]= new String[count_line][7];
		

		for(int i=0;i<subject.length;i++){
			token= new StringTokenizer(br.readLine(),"`");
			
			for(int j=0;j<subject[i].length;j++){
				subject[i][j]=token.nextToken();
			}
			
		}
		
		br.close();
		return subject;
	}

	public static String[][] get_Todo() throws IOException{
		
		 File f = new File("Todo_out.txt");

		    if (!f.isFile()) {
		    	f.createNewFile();
		    }

		BufferedReader br = new BufferedReader(new FileReader("Todo_out.txt"));
		StringTokenizer token;
		int count_line=0;
		
		while(br.readLine()!=null){
			count_line++;
		}
		br.close();
		
		br = new BufferedReader(new FileReader("Todo_out.txt"));
		
		String Todo[][]= new String[count_line][10];
		

		for(int i=0;i<Todo.length;i++){
			token= new StringTokenizer(br.readLine(),"`");
			
			for(int j=0;j<Todo[i].length;j++){
				Todo[i][j]=token.nextToken();
			}
			
		}
		
		br.close();
		return Todo;
	}
	
	public static String[] findList(String value, String[][] list){
		
			for(int i=0;i<list.length;i++){
				for(int j=0;j<list[i].length;j++){
				
					if(list[i][j].equals(value)){
						return list[i];
					}
				}
			}
		
			return null;
		}
	
	
	
	
}

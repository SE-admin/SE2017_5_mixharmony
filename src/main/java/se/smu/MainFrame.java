package se.smu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame{
	
	public static JPanel main_title;
	
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
		

		//배경색 설정
		setBackground(Color.white);
		//어플리케이션 종료시 모든 window종료 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//크기와 좌표 지정(전체 크기)
		setBounds(100, 100, 600, 760);
		
		
		//메인 창 틀
		main_title = new JPanel();
		main_title.setBounds(0, 0, 600, 50);
		main_title.setBackground(Color.pink);
		add(main_title);
		main_title.setLayout(null);
		//메인 창 라벨
		JLabel main_label = new JLabel("5조-PENTA");
		main_label.setFont(new Font("고딕체", Font.PLAIN, 30));
		main_label.setHorizontalAlignment(SwingConstants.CENTER);
		main_label.setBounds(220, 0, 160, 50);
		main_title.add(main_label);
		
		
		
		//메뉴 패널 생성
		contentPane = new JPanel();
		//메뉴 패널 색
		contentPane.setBackground(Color.pink);
		contentPane.setBorder(null);
		contentPane.setBounds(0, 630, 600, 80);
		add(contentPane);
		contentPane.setLayout(null);
		MenuPanel menu = new MenuPanel();
		contentPane.add(menu);
		
		main_panel = new JPanel();
		main_panel.setBounds(0, 0, 600, 630);
		main_panel.setBackground(Color.pink);
		add(main_panel);
		main_panel.setLayout(null);
		
		HomeMain homemain = new HomeMain();
		main_panel.add(homemain);
		
	
	}
	
	//서브젝트 불러오기
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
	
	//todolist 불러오기
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

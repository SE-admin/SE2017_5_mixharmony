package se.smu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class MenuPanel extends JPanel{
	/**
	 * Create the panel.
	 * @return 
	 */

	
	public MenuPanel() {

		JPanel menu_panel = new JPanel();
		menu_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu_panel.setBackground(Color.darkGray);				/**/
		menu_panel.setBounds(0, 0, 584, 81);
		MainFrame.contentPane.add(menu_panel);
		menu_panel.setLayout(null);
		
		
		JButton add_button = new JButton("");
		JButton home_button = new JButton("");
		JButton list_button = new JButton("");
		
		add_button.setBorderPainted(false);
		home_button.setBorderPainted(false);
		list_button.setBorderPainted(false);

		add_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SubjectAdd addSub = new SubjectAdd();
				
			}
		});
		add_button.setIcon(new ImageIcon(MainFrame.class.getResource("/img/plus.PNG")));					/**/
		add_button.setBackground(Color.lightGray);															/**/
		add_button.setBounds(0, 0, 198, 81);
		menu_panel.add(add_button);
		
		
		
		home_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				HomeMain Test3 = new HomeMain();
				
				add_button.setBounds(0, 0, 198, 81);
				home_button.setBounds(196, 0, 198, 61);
				list_button.setBounds(391, 0, 193, 81);
				add_button.setIcon(new ImageIcon(MainFrame.class.getResource("/img/plus.PNG")));				/**/
				home_button.setIcon(new ImageIcon(MainFrame.class.getResource("/img/Home_2.PNG")));
				list_button.setIcon(new ImageIcon(MainFrame.class.getResource("/img/Todo_2.PNG")));				/**/
				
				MainFrame.contentPane.remove(menu_panel);
				MainFrame.main_panel.removeAll();
				MainFrame.contentPane.add(menu_panel);
				MainFrame.main_panel.add(Test3);
				
				
				Test3.revalidate();
				Test3.repaint();

			}
		});
		home_button.setBackground(Color.lightGray);
		home_button.setIcon(new ImageIcon(MainFrame.class.getResource("/img/Home_2.PNG")));
		home_button.setBounds(196, 0, 198, 61);
		menu_panel.add(home_button);
		


		list_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AllTodoListMain Test1 = new AllTodoListMain();
				
				add_button.setBounds(0, 0, 198, 61);
				home_button.setBounds(196, 0, 198, 81);
				list_button.setBounds(391, 0, 193, 81);
				add_button.setIcon(new ImageIcon(MainFrame.class.getResource("/img/plus.PNG")));					/**/
				home_button.setIcon(new ImageIcon(MainFrame.class.getResource("/img/Home_1.PNG")));
				list_button.setIcon(new ImageIcon(MainFrame.class.getResource("/img/Todo_1.PNG")));				/**/
				
				MainFrame.contentPane.remove(menu_panel);
				MainFrame.main_panel.removeAll();
				MainFrame.contentPane.add(menu_panel);
				MainFrame.main_panel.add(Test1);
				
				Test1.revalidate();
				Test1.repaint();
				
			}
		});

		add_button.setIcon(new ImageIcon(MainFrame.class.getResource("/img/plus.PNG")));					/**/
		add_button.setBackground(Color.lightGray);															/**/
		add_button.setBounds(0, 0, 198, 81);
		menu_panel.add(add_button);
		

		list_button.setIcon(new ImageIcon(MainFrame.class.getResource("/img/Todo_1.PNG")));					/**/
		list_button.setBackground(Color.lightGray);
		list_button.setBounds(392, 0, 192, 81);
		menu_panel.add(list_button);
		
		menu_panel.revalidate();
		menu_panel.repaint();
		
	}
	
}



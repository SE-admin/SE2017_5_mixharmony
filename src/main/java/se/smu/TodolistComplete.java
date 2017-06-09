package se.smu;


import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TodolistComplete extends JDialog {

	private final JPanel contentPanel = new JPanel();
		private JComboBox finish_year=null;
		private JComboBox finish_month=null;
		private JComboBox finish_date=null;
	/**
	 * Create the dialog.
	 */
	public TodolistComplete(String [] todo) throws IOException {
		setAlwaysOnTop(true);
		setBounds(100, 100, 350, 190);
		setModal(true);
		setLocationRelativeTo(MainFrame.main_panel);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel message = new JLabel("실제 마감일을 설정 해주세요");
		message.setBackground(Color.WHITE);
		message.setFont(new Font("바탕체", Font.PLAIN, 10));
		message.setBounds(100, 10, 178, 30);
		contentPanel.add(message);
		
		TodolistContents todolist_contents = new TodolistContents();
		
		finish_year = new JComboBox(todolist_contents.year);
		finish_year.setBounds(8, 40,103,50);
		finish_year.setSelectedItem("hahaha");
		contentPanel.add(finish_year);

		
		finish_month = new JComboBox(todolist_contents.month);
		finish_month.setBounds(118, 40,100,50);
		contentPanel.add(finish_month);
		
		finish_date = new JComboBox(todolist_contents.date);
		finish_date.setBounds(228, 40,100,50);
		contentPanel.add(finish_date);
		
		
		JButton cancel = new JButton("");
		cancel.setIcon(new ImageIcon(TodolistComplete.class.getResource("/img/cancel.PNG")));
		cancel.setBackground(Color.WHITE);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		cancel.setBorder(null);
		cancel.setBounds(168, 100, 147, 47);
		contentPanel.add(cancel);
		
		JButton confirm = new JButton("");
		confirm.setIcon(new ImageIcon(TodolistComplete.class.getResource("/img/confirm.PNG")));
		confirm.setBackground(Color.WHITE);
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		confirm.setBorder(null);
		confirm.setBounds(18, 100, 152, 47);
		contentPanel.add(confirm);
		
	}
}

package se.smu;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlarmPopup extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AlarmPopup(String[] Todo, int days) {
		setAlwaysOnTop(true);
		setBounds(100, 100, 319, 190);
		setModal(true);
		setLocationRelativeTo(MainFrame.main_panel);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		okButton.setBounds(188, 108, 73, 23);
		contentPanel.add(okButton);
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);
		
		
		JLabel label = new JLabel("D-"+days+"  남았습니다.");
		label.setBounds(10, 59, 186, 39);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel(Todo[1]);
		label_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label_1.setBounds(64, 10, 186, 39);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AlarmPopup.class.getResource("/icon/alarm.PNG")));
		label_2.setBounds(8, 0, 44, 60);
		contentPanel.add(label_2);

	}
}

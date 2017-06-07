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

public class ErrorPopup extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ErrorPopup() {
		setAlwaysOnTop(true);

		setBounds(100, 100, 319, 190);
		setModal(true);
		setLocationRelativeTo(MainFrame.main_panel);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel error_label = new JLabel("error");
			error_label.setFont(new Font("���� ���?", Font.PLAIN, 30));
			error_label.setBounds(146, 20, 92, 28);
			contentPanel.add(error_label);
		}
		{
			JLabel caution_image = new JLabel("");
			caution_image.setIcon(new ImageIcon(ErrorPopup.class.getResource("/img/caution.PNG")));
			caution_image.setBounds(85, 20, 49, 39);
			contentPanel.add(caution_image);
		}
		
		JButton ok_button = new JButton("OK");
		ok_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ok_button.setBounds(12, 81, 279, 61);
		contentPanel.add(ok_button);
	}
}
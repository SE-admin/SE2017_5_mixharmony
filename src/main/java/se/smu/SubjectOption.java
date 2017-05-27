package se.smu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class SubjectOption {
	 
    public SubjectOption() {
        final JFrame frame = new JFrame("Popup Menu Demo");
 
        // build poup menu
        final JPopupMenu popup = new JPopupMenu();
        // New project menu item
        JMenuItem menuItem = new JMenuItem("수정");
        menuItem.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
            	//
                JOptionPane.showMessageDialog(frame, "수정 선택!");
				//frame.removeAll();
				//frame.add(new Subject_Add());
            }
        });
        popup.add(menuItem);
        // New File menu item
        menuItem = new JMenuItem("삭제");
        menuItem.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "삭제 선택!");
            }
        });
        popup.add(menuItem);
        menuItem = new JMenuItem("To do list");
        menuItem.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
            	//
                JOptionPane.showMessageDialog(frame, "To do list 선택!");
				//frame.removeAll();
				//frame.add(new Subject_Add());
            }
        });
        popup.add(menuItem);
        
        
        
        
 
        // add mouse listener
        frame.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
 
            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(),
                            e.getX(), e.getY());
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
  
    }
	
}

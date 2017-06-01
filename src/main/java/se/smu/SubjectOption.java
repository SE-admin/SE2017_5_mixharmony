package se.smu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


import java.awt.Window.*;

public class SubjectOption extends JDialog{
	 
    public SubjectOption(String[] subject) {
        final JFrame frame = new JFrame("Popup Menu Demo");

    	
        // build poup menu
        final JPopupMenu popup = new JPopupMenu();
        // New project menu item
        JMenuItem menuItem = new JMenuItem("수정");
        menuItem.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
            	//
                //JOptionPane.showMessageDialog(frame, "수정 선택!");
				//frame.removeAll();
				//frame.add(new Subject_Add());
				SubjectModify subject_modi = new SubjectModify(subject);    //+++
				frame.removeAll();//+++
				frame.add(subject_modi);	//+++
            }
            
        });
        popup.add(menuItem);
        // New File menu item
        menuItem = new JMenuItem("삭제");
        menuItem.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(frame, "삭제 선택!");
            	//여기서부터 내가고친부

            	try{
            		Del_Popup dialog = new Del_Popup(0, subject);
            		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            		dialog.setVisible(true);
					SubjectDelete subject_del = new SubjectDelete(subject);
            	}catch(IOException e1){
            		e1.printStackTrace();
            	}
            	dispose();
            	//여기까지
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

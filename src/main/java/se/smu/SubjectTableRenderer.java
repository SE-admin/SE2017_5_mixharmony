package se.smu;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;

public class SubjectTableRenderer extends DefaultTableCellRenderer
{ 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) 
    { 
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        if (! isSelected) //���� ���õ� ���� ������ �������� �ʰ� ���� ������ ��쿡��? �������� �����Ѵ�
        {
        	if(value.equals("")){
        		
        			cell.setBackground(Color.WHITE);
        		
        	}
        	else if (row >= 0 && value != null)
            {
        		Object previous=null;
        		String[] temp = MainFrame.findList((String)value, MainFrame.subject);
        		
        		if(row==0){
        			previous=null;
        		}
        		else{
        			previous = table.getValueAt(row - 1, column);
        		}
                
                
                cell.setBackground(getColor(cell, Integer.parseInt(temp[6])));

                if (value.equals(previous))
                {
                    setText("");

                }
            }
   
        }
        return this;
    } 
    

	Color getColor(Component cell, int num){
		Color color = null;
		
		
		
		switch(num){
		
		case 0:
			return Color.gray;
		case 1:
			return Color.green;
		case 2:
			return Color.cyan;
		case 3:
			return Color.yellow;
		case 4:
			return Color.magenta;
		case 5:
			return Color.pink;
		case 6:
			return Color.orange;
		}
		
		
		return null;
	}
}


package se.smu;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class TodoList_Del{
	public TodoList_Del(String[] Todo) throws IOException{

	delete_subject(Todo);
	MainFrame.Todo=MainFrame.get_Todo();
	repaint();
}

	void delete_subject(String[] Todo) throws IOException{
		
		String [][] old_Todo = MainFrame.Todo;
		PrintWriter pw = new PrintWriter(new FileWriter("Todo_out.txt"));
		
		for(int i=0;i<old_Todo.length;i++){
				if(old_Todo[i][1].equals(Todo[1])){
					continue;
				}
				else{
					for(int j=0;j<old_Todo[i].length;j++){
						pw.print(old_Todo[i][j]+"`");
					}
					pw.println();
				}
			}
		pw.close();
	}
	
	void repaint(){
		AllTodoListMain TodoMain = new AllTodoListMain();
		
		MainFrame.main_panel.removeAll();
		MainFrame.main_panel.add(TodoMain);
			
			
		TodoMain.revalidate();
		TodoMain.repaint();
	}
}

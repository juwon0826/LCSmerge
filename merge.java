package test;

import java.util.LinkedList;

public class merge {	
	public void copytoright(LinkedList<Node> node1, LinkedList<Node> node2, int selectionstartpos, int selectionendpos){
		int length = node1.size();		
		for(int i = selectionstartpos; i < selectionendpos; i++){			
			node2.get(i).setString(node1.get(i).getString());
			node2.get(i).setIsAddedEnter(false);
		}
	}
	public void copytoleft(LinkedList<Node> node1, LinkedList<Node> node2, int selectionstartpos, int selectionendpos){
		int length = node1.size();		
		for(int i = selectionstartpos; i < selectionendpos; i++){			
			node1.get(i).setString(node2.get(i).getString());
			node1.get(i).setIsAddedEnter(false);
		}
	}
 
}
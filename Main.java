package compare;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException
	{
		LinkedList<node> L1 = new LinkedList<node>(), L2 = new LinkedList<node>();
		
		String fileName1 = "test1.txt";
		String fileName2 = "test2.txt";
		String oneLine1 = null;
		String oneLine2 = null;
		
		
		//test 텍스트 리스트에 넣기
		try {
			BufferedReader in1 = new BufferedReader(new FileReader(fileName1));
			BufferedReader in2 = new BufferedReader(new FileReader(fileName2));
			
			
			while((oneLine1 = in1.readLine()) != null){
				node oneLineNode = new node();
				oneLineNode.setString(oneLine1);
				L1.add(oneLineNode);
			}
			in1.close();
			
			while((oneLine1 = in2.readLine()) != null){
				node oneLineNode = new node();
				oneLineNode.setString(oneLine1);
				L2.add(oneLineNode);
			}
			in2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error : IOException");
		}
		
		String temp;
		System.out.println("<1번째 리스트 string>\n");
		for(int i = 0; i < L1.size(); i++){
			temp = L1.get(i).getString();
			System.out.println("[" + i + "] " + temp );
			
		}
		System.out.println("<2번째 리스트 string>\n");
		for(int i = 0; i < L2.size(); i++){
			temp = L2.get(i).getString();
			System.out.println("[" + i + "] " + temp );
			
		}
		
		LCS lcstest = new LCS();
		lcstest.makeTable(L1, L2);
		lcstest.calcLCS(L1, L2);
		
		System.out.println("<1번째 리스트 string LCS>\n");
		for(int i = 0; i < L1.size(); i++){
			if(L1.get(i).getIsLCS()){
			temp = L1.get(i).getString();
			
			System.out.println("[" + i + "] " + temp );
			}
			
		}
		System.out.println("<2번째 리스트 string LCS>\n");
		for(int i = 0; i < L2.size(); i++){
			if(L2.get(i).getIsLCS()){
				temp = L2.get(i).getString();
				
				System.out.println("[" + i + "] " + temp );
				}
			
		}
		EnterSync entersync = new EnterSync();
		entersync.enterSync(L1, L2);
		System.out.println("<1번째 리스트 string EnterSync>\n");
		for(int i = 0; i < L1.size(); i++){
			temp = L1.get(i).getString();
			System.out.println("[" + i + "] " + temp );
			
		}
		System.out.println("<2번째 리스트 string EnterSync>\n");
		for(int i = 0; i < L2.size(); i++){
			temp = L2.get(i).getString();
			System.out.println("[" + i + "] " + temp );
			
		}
		
		compare com = new compare();
		com.compareList(L1, L2);
		node temp_node;
		System.out.println("<1번째 리스트 string compare>\n");
		for(int i = 0; i < L1.size(); i++){
			temp_node = L1.get(i);
			System.out.println("[" + i + "] ");
			if(temp_node.getString_index() != null){
				for(int j = 0; j < temp_node.getString_index().length; j++){
					System.out.println(temp_node.getString().charAt(temp_node.getString_index()[j]));
				}
			}
		}
		System.out.println("<2번째 리스트 string compare>\n");
		for(int i = 0; i < L2.size(); i++){
			temp_node = L2.get(i);
			System.out.println("[" + i + "] ");
			if(temp_node.getString_index() != null){
				for(int j = 0; j < temp_node.getString_index().length; j++){
					System.out.println(temp_node.getString().charAt(temp_node.getString_index()[j]));
				}
			}
		}
		
		
	}
}

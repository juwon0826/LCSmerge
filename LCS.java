package compare;

import java.util.LinkedList;
public class LCS {
	private int[][] LCS_table;
	private int LCS_length;
	
	// �� LinkedList ���� LCS table ��� 
	public void makeTable(LinkedList<node> L1,LinkedList<node> L2) {
		
		L1.add(0, new node());
		L2.add(0,new node());
		
		
		int len1 = L1.size();
		int len2 = L2.size();
		
		// set the table
		this.LCS_table = new int[len2][len1];
		
		for(int i = 0; i < len1; i++)
			this.LCS_table[0][i] = 0;
		
		//Calculation table index and LCS length
		int max;
		for(int i = 1; i < len2; i++){
			max = 0;
			LCS_table[i][0] = 0;
			for(int j = 1; j < len1; j++){
				// �� ����� string ��
				String temp1 = L1.get(j).getString();
				String temp2 = L2.get(i).getString();
				if(temp1.equals(temp2)){
					max = LCS_table[i-1][j-1] + 1;
					LCS_table[i][j] = max;
				}
				else{
					if(LCS_table[i][j-1] > LCS_table[i-1][j])
						LCS_table[i][j] = LCS_table[i][j-1];
					else
						LCS_table[i][j] = LCS_table[i-1][j];
				}
			}
			
			if(LCS_length < max)
				LCS_length = max;
		}
		
	}
	// �� ��尣�� LCS table ���
	public void makeTable(node N1,node N2) {
		N1.setString("0" + N1.getString());
		N2.setString("0" + N2.getString());
		
		int len1 = N1.getString().length();
		int len2 = N2.getString().length();
		
		// set the table
		this.LCS_table = new int[len2][len1];
		for(int i = 0; i < len1; i++)
			LCS_table[0][i] = 0;
		
		//Calculation table index and LCS length
		int max;
		for(int i = 1; i < len2; i++){
			max = 0;
			LCS_table[i][0] = 0;
			for(int j = 1; j < len1; j++){
				
				// �� ����� ���ڿ��� ���ں�
				if(N1.getString().charAt(j) == N2.getString().charAt(i)){
					max = LCS_table[i-1][j-1] + 1;
					LCS_table[i][j] = max;
				}
				else{
					if(LCS_table[i][j-1] > LCS_table[i-1][j])
						LCS_table[i][j] = LCS_table[i][j-1];
					else
						LCS_table[i][j] = LCS_table[i-1][j];
				}
			}
			if(LCS_length < max)
				LCS_length = max;
		}
		
	}
	
	// �� LinkedList���� LCS ���
	public void calcLCS(LinkedList<node> L1, LinkedList<node> L2){
		
		int len1 = L1.size();
		int len2 = L2.size();
		int temp = this.LCS_length;
		int for_j = len1 - 1;
		 
		  //Calculation LCS
		  for (int i = len2-1; i >0; i--) {
		    for (int j = for_j; j > 0; j--) {
		      if (this.LCS_table[i][j] == temp && this.LCS_table[i][j - 1] == temp - 1 
		    		  && this.LCS_table[i - 1][j - 1] == temp - 1 && this.LCS_table[i - 1][j] == temp - 1) {
		        temp--;
		        L1.get(j).setIsLCS(true);
		        L2.get(i).setIsLCS(true);
		        for_j = j;
		        break;
		      }
		    }
		  }
		  this.LCS_table = null;
	}
	
	// �� node���� LCS ���
	public void calcLCS(node N1, node N2){
		
		int len1 = N1.getString().length();
		int len2 = N2.getString().length();
		
		int temp = this.LCS_length;
		int for_j = len1 - 1;
		 
		  //Calculation LCS
		  for (int i = len2-1; i >0; i--) {
		    for (int j = for_j; j > 0; j--) {
		      if (this.LCS_table[i][j] == temp && this.LCS_table[i][j - 1] == temp - 1 
		    		  && this.LCS_table[i - 1][j - 1] == temp - 1 && this.LCS_table[i - 1][j] == temp - 1) {
		        temp--;
		        N1.addString_index(j);
		        N2.addString_index(i);
		        for_j = j;
		        break;
		      }
		    }
		  }
		  this.LCS_table = null;
	}
	
	public LCS(){
		this.LCS_length = 0;
		this.LCS_table = null;
	}
	
	
	
}

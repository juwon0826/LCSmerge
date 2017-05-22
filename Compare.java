package test;

import java.util.LinkedList;

public class Compare {
	
	private LCS LCS_checker;
	
	public void compareList(LinkedList<Node> L1, LinkedList<Node> L2){
		for(int i = 0; i < L1.size()/*이 시점에서 두 리스트의 사이즈가 같아야 한다.*/; i++){
			LCS_checker = new LCS();
			LCS_checker.makeTable(L1.get(i), L2.get(i));
			LCS_checker.calcLCS(L1.get(i), L2.get(i));
			LCS_checker = null;
			
		}
	}
	
	public Compare(){
		this.LCS_checker = new LCS();
	}
	

}
package test;

import java.util.LinkedList;

public class Compare {
	
	private LCS LCS_checker;
	
	public void compareList(LinkedList<Node> L1, LinkedList<Node> L2){
		for(int i = 0; i < L1.size()/*�� �������� �� ����Ʈ�� ����� ���ƾ� �Ѵ�.*/; i++){
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
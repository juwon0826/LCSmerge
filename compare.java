package merge;

import java.util.LinkedList;

public class compare {
	
	private LCS lcs_checker;
	private EnterSync enter_sync;
	
	public void compareList(LinkedList<Node> L1, LinkedList<Node> L2){
		lcs_checker = new LCS();
		
		//두 리스트 간의 Long common String 찾기
		lcs_checker.makeTable(L1, L2);
		lcs_checker.calcLCS(L1, L2);
		lcs_checker = null;
		
		//enter 동기화
		enter_sync = new EnterSync();
		enter_sync.enterSync(L1, L2);
		enter_sync = null;
		
		//문자열간 Long common subsequence
		for(int i = 0; i < L1.size()/*이 시점에서 두 리스트의 사이즈가 같아야 한다.*/; i++){
			lcs_checker = new LCS();
			lcs_checker.makeTable(L1.get(i), L2.get(i));
			lcs_checker.calcLCS(L1.get(i), L2.get(i));
			lcs_checker = null;
			
		}
	}
	
}

package merge;

import java.util.LinkedList;

public class compare {
	
	private LCS lcs_checker;
	private EnterSync enter_sync;
	
	public void compareList(LinkedList<Node> L1, LinkedList<Node> L2){
		lcs_checker = new LCS();
		
		//�� ����Ʈ ���� Long common String ã��
		lcs_checker.makeTable(L1, L2);
		lcs_checker.calcLCS(L1, L2);
		lcs_checker = null;
		
		//enter ����ȭ
		enter_sync = new EnterSync();
		enter_sync.enterSync(L1, L2);
		enter_sync = null;
		
		//���ڿ��� Long common subsequence
		for(int i = 0; i < L1.size()/*�� �������� �� ����Ʈ�� ����� ���ƾ� �Ѵ�.*/; i++){
			lcs_checker = new LCS();
			lcs_checker.makeTable(L1.get(i), L2.get(i));
			lcs_checker.calcLCS(L1.get(i), L2.get(i));
			lcs_checker = null;
			
		}
	}
	
}

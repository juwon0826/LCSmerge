package merge;

import java.util.LinkedList;
public class EnterSync {
	
	public void enterSync(LinkedList<Node> L1, LinkedList<Node> L2){
		Node enterNode;
		for(int i = 0; i < L1.size() || i < L2.size(); i++){
			//�� ����Ʈ���� ���� ���ڿ��� ���� ��ġ�� ������ enter��� ����
			if(L1.get(i).getIsLCS() && !L2.get(i).getIsLCS()){
				//��带 ���� �����Ͽ� String�� "\n"��, isAddedEnter�� true�� �����.
				enterNode = new Node("\n",true);
				L1.add(i,enterNode);
				enterNode = null;
			}
			else if(!L1.get(i).getIsLCS() && L2.get(i).getIsLCS()){
				enterNode = new Node("\n",true);
				L2.add(i,enterNode);
				enterNode = null;
			}
			//�� ����Ʈ�� ���̸� ���߱� ���� enter��� ����
			if(i == L1.size() && i < L2.size()){
				enterNode = new Node("\n",true);
				L1.add(i,enterNode);
				enterNode = null;
			}
			else if(i < L1.size() && i == L2.size()){
				enterNode = new Node("\n",true);
				L2.add(i,enterNode);
				enterNode = null;
			}
		}
	}
}

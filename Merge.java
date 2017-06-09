package function;

import java.util.LinkedList;

import model.Node;
 
public class Merge {
	private boolean isCompared = true;
	private boolean isMerged = true;
	public void merge(LinkedList<Node> list1, LinkedList<Node> list2, int start, int end){
		for(int i = start; i <= end; i++){
			if(i >= list1.size()) {
				break;
			}
			
			if(list1.size() != list2.size()){		
				setIsCompared(false);
			}
			if(list1.get(i).getIsLCS() == false && isCompared == true){
				list1.get(i).setIsLCS(true);
				list2.get(i).setIsLCS(true);
				list2.get(i).setString(list1.get(i).getString());
				
				if(list2.get(i).getIsAddedEnter() == true) {
					list2.get(i).setIsAddedenter(false);
				}
			}
			else if(list1.get(i).getIsLCS() == true){
				setIsMerged(false);
			}
		}
	}

	public boolean getisMerged() {
		return isMerged;
	}

	public void setIsMerged(boolean isMerged) {
		this.isMerged = isMerged;
	}

	public boolean getisCompared() {
		return isCompared;
	}

	public void setIsCompared(boolean isCompared) {
		this.isCompared = isCompared;
	}
	
	
	
}
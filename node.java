package compare;
import java.util.Vector;

public class node {
	
	private String text;
	private int numOfEnter;
	private boolean isLCS;
	private boolean isAddedEnter;
	private int[] string_index;
	
	public String getString(){
		return this.text;
	};

	public boolean getIsLCS(){
		return this.isLCS;
	};
	public boolean getIsAddedEnter(){
		return this.isAddedEnter;
	};
	
	public void setString(String parm)
	{
		this.text = parm;
	};
	
	public void setIsLCS(boolean parm){
		this.isLCS = parm;
	};
	public void setIsAddedenter(boolean parm){
		this.isAddedEnter = parm;
	};
	public int[] getString_index(){
		return this.string_index;
	}
	public void addString_index(int i){
		if(string_index == null){
			this.string_index = new int[1];
			this.string_index[0] = i;
		}
		else{
			this.string_index = new int[string_index.length + 1];
			this.string_index[string_index.length - 1] = i;
		}
	}
	
	public  node(){
		this.text = null;
		this.numOfEnter = 0;
		this.isLCS = false;
		this.isAddedEnter = false;
	}
	
	public node(String parm1, boolean parm2){
		this.text = parm1;
		this.numOfEnter = 0;
		this.isLCS = false;
		this.isAddedEnter = parm2;
	}
	




}

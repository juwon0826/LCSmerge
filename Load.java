import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

class Load {
	private LinkedList<Node> loadList = null;
	private String fileName = null;
	
	Load(String fileName) {														// initialize
		loadList = new LinkedList<Node>();
		this.fileName = fileName;
	}
	
	void loadFromFile() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String oneLine = null;
			
			
			while((oneLine = in.readLine()) != null) {							// read each line until EOF
				Node oneLineNode = new Node();
				oneLineNode.setString(oneLine);
				
				loadList.add(oneLineNode);
			}
			
			in.close();
		} catch(IOException e) {
			System.out.println("Error : IOException");
		}
	}
	
	LinkedList<Node> getList() {												// return LinkedList
		return loadList;
	}
}

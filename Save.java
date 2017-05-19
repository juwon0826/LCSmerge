import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Save {
	private LinkedList<Node> saveList = null;
	private String fileName = null;
	
	Save(LinkedList<Node> stringList, String fileName) {							// initialize
		this.saveList = stringList;
		this.fileName = fileName;
	}
	
	void saveToFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			
			for(int i = 0; i < saveList.size(); i++) {								// write file until EOF
				if(saveList.get(i).getEnter()) {									// if boolean enter is true, continue
					continue;
				}
				
				out.write(saveList.get(i).getString());								// write oneLine to file
				out.newLine();														// make newLine
			}
			
			out.close();
		} catch(IOException e) {
			System.out.println("Error : IOException");
		}
	}
}

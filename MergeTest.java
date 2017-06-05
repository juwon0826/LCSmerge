package MergeTest;
import java.io.File;
import java.util.LinkedList;

import SimpleMerge.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;


public class MergeTest extends TestCase{

	@Test
	public void testLoad() {
		Load testLoad = new Load();
		testLoad.setFileName(new File("C:/Users/4F/Documents/s9 left.txt"));
		testLoad.loadFromFile();
		
		assertEquals(new File("C:/Users/4F/Documents/s9 left.txt"), testLoad.getFileName());
		
		LinkedList<Node> lList = null;
		lList = testLoad.getList();

		System.out.println(lList.get(0).getString());
		assertEquals(lList.get(0).getString(), "A");
		
	}
	
	
	
	
	
	

}
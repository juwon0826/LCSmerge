import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import function.Merge;
import model.Node;

public class JUnitToMergeTest {

	@Test
	public void mergetest() {//Merge가 된 경우
		Merge merge= new Merge();
		LinkedList<Node> llist = new LinkedList<Node>();
		LinkedList<Node> rlist = new LinkedList<Node>();

		Node node1 = new Node();
		node1.setString("Sample Text");
		llist.add(node1);
		Node node2 = new Node();
		node2.setString("Diffenet Text");
		rlist.add(node2);
		merge.merge(llist, rlist, 0, llist.size());
		
		assertTrue(merge.getisCompared());//
		assertEquals(llist.get(0).getString(), rlist.get(0).getString());
	}
	
	public void compareFailtest(){//Compare가 안 이루어진 경우
		Merge merge= new Merge();
		LinkedList<Node> llist = new LinkedList<Node>();
		LinkedList<Node> rlist = new LinkedList<Node>();

		Node node1 = new Node();
		node1.setString("Sample Text");
		llist.add(node1);
		Node node2 = new Node();
		node2.setString("Add Sample Text");
		llist.add(node2);
		Node node3 = new Node();
		node3.setString("Different Text");
		rlist.add(node1);
		merge.merge(llist, rlist, 0, llist.size());
		assertFalse(merge.getisCompared());
	}
	
	public void mergeFailtest(){//두 리스트가 같은 경우
		Merge merge= new Merge();
		LinkedList<Node> llist = new LinkedList<Node>();
		LinkedList<Node> rlist = new LinkedList<Node>();

		Node node1 = new Node();
		node1.setString("Sample Text");
		llist.add(node1);
		node1.setIsLCS(true);
		Node node2 = new Node();
		node2.setString("Sample Text");
		node2.setIsLCS(true);
		rlist.add(node2);
		merge.merge(llist, rlist, 0, llist.size());
		
		assertFalse(merge.getisMerged());
	}

}

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

public class TestCodeToUpdate {
	public static void main(String[] args) {
		LinkedList<Node> list = null;
		JTextArea textArea = null;
		
		TestCodeToUpdate test = new TestCodeToUpdate();
		textArea = test.makeWindow();
		
		Load load = new Load();
		load.openPopup();
		load.loadFromFile();																			// load file
		
		list = load.getList();
		
		Update update = new Update(list, textArea);
		update.listToArea();
		
		update.areaToList();
		
		System.out.println(list.get(0).getEnter());
		System.out.println(list.get(3).getEnter());
	}
	
	public JTextArea makeWindow() {
		JFrame frame = new JFrame("TestToUpdate");
		JTextArea textArea = new JTextArea(50,50);
		textArea.setEditable(false);
		
		frame.add(textArea);
		frame.pack();
		frame.setVisible(true);
		
		return textArea;
	}
}

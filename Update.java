import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;

public class Update {
	private JTextArea textArea = null;
	private LinkedList<Node> list = null;
	
	private DefaultHighlightPainter redPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
	private DefaultHighlightPainter yellowPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
    private DefaultHighlightPainter grayPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GRAY);
	
	Update(LinkedList<Node> list, JTextArea textArea) {
		this.list = list;
		this.textArea = textArea;
	}
	
	void areaToList() {
		// textArea strings move to list

		StringReader strings = new StringReader(textArea.getText());
		BufferedReader allString = new BufferedReader(strings);
		String oneLine = null;
		
		Highlighter.Highlight[] highlight = textArea.getHighlighter().getHighlights();
		int index = 0;
		
		try {
			while((oneLine = allString.readLine()) != null) {
				Node oneLineNode = new Node();
				oneLineNode.setString(oneLine);
				
				int lineLen = oneLineNode.getString().length();
				int highlightLen = 0;
				
				while(true) {
					int start = highlight[index].getStartOffset();
					int end = highlight[index].getEndOffset() - 1;
					
					int tempLen = (end - start);
					highlightLen += tempLen;
					
					if(lineLen == highlightLen) {
						if(highlight[index].getPainter().toString() == grayPainter.toString()) {
							oneLineNode.setEnter(true);
						}
						
						index++;
						break;
					}
					
					index++;
				}
			}
		} catch(IOException e) {
			
		}
	}
	
	void listToArea() {
		// print list to area
		
		if(list == null) {
			return;
		}
		
		textArea.setText("");
		
	    Highlighter hi = new MyHighlighter();
		textArea.setHighlighter(hi);
	    
		int start = 0;
        int end = 0 ;
        
		textArea.append(list.get(0).getString() + "\n");
		
		list.get(0).setEnter(true);
		list.get(3).setEnter(true);
        
		for(int i = 0; i < list.size(); i++) {
			if((i + 1) < list.size()) {
				textArea.append(list.get(i + 1).getString() + "\n");	
			}
			
		    try {
		        //look for newline char, and then toggle between white and gray painters.
		        end = start  + list.get(i).getString().length();
	            
	            if(list.get(i).getEnter() == true) {
	            	hi.addHighlight(start, end + 1, grayPainter);
	            }
	            
	            else if(list.get(i).getLcs() == true) {
	            	hi.addHighlight(start, end + 1, redPainter);
	            }
	            
	            else {
	            	hi.addHighlight(start, end + 1, yellowPainter);
	            }
	            
		        start = end+1;	            
		    } catch (BadLocationException e) {
		        e.printStackTrace();
		    }
		}
	}
}

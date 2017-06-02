package merge;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextArea;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.Box;

import java.util.LinkedList;

public class mergerGUI extends JFrame {
 private JPanel contentPane;
 static boolean edit1 =true;
 static boolean edit2 =true;
 /**
  * Launch the application.
  */
 LinkedList<Node> L1, L2;
 public static void main(String[] args) {
	 
	
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     mergerGUI frame = new mergerGUI();
     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }
 /**
  * Create the frame.
  */
 public mergerGUI() {
  setBackground(Color.WHITE);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100,800,600);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  contentPane.setLayout(new BorderLayout(0, 0));
  setContentPane(contentPane);
  
  JPanel panel = new JPanel();
  contentPane.add(panel, BorderLayout.NORTH);
  panel.setLayout(new GridLayout(0, 3, 0, 0));
  
  JPanel panel_1 = new JPanel();
  panel.add(panel_1);
  panel_1.setLayout(new GridLayout(0, 3, 0, 0));
  
  JButton btnNewButton_5 = new JButton("load");
  panel_1.add(btnNewButton_5);
  
  btnNewButton_5.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	      Load load = new Load();
	      load.openPopup();
	      load.loadFromFile();
	      L1 = load.getList();
	      
	    }
	});

  JButton btnNewButton = new JButton("edit");
  panel_1.add(btnNewButton);
 
  JButton btnNewButton_3 = new JButton("save");
  panel_1.add(btnNewButton_3);
  btnNewButton_3.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	      Save save = new Save(L1,"test1.txt");
	      save.saveToFile();
	      
	    }
	});
 
  JPanel panel_2 = new JPanel();
  panel.add(panel_2);
  
  JPanel panel_4 = new JPanel();
  panel.add(panel_4);
  panel_4.setLayout(new GridLayout(0, 3, 0, 0));
  
  JButton btnNewButton_1 = new JButton("load");
  panel_4.add(btnNewButton_1);
  
  btnNewButton_1.setEnabled(false); //���� change it
  btnNewButton_1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	 Load load = new Load();
		      load.openPopup();
		      load.loadFromFile();
		      L2 = load.getList();
	    }
	});
  JButton btnNewButton_2 = new JButton("edit");
  panel_4.add(btnNewButton_2);
 
  JButton btnNewButton_4 = new JButton("save");
  panel_4.add(btnNewButton_4);
  btnNewButton_4.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	Save save = new Save(L2,"test1.txt");
		      save.saveToFile();
	    }
	});
  JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
  contentPane.add(tabbedPane, BorderLayout.WEST);
  
  JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
  contentPane.add(tabbedPane_1, BorderLayout.EAST);
  
  JPanel panel_3 = new JPanel();
  contentPane.add(panel_3, BorderLayout.CENTER);
  panel_3.setLayout(new GridLayout(0, 3, 3, 3));
  

   JTextArea textArea_2 = new JTextArea(10,50);
    panel_3.add(textArea_2);
    //DO
    
    btnNewButton.addActionListener(new ActionListener() {
  	    public void actionPerformed(ActionEvent e) {
  	      edit2= !edit2;
  	      textArea_2.setEditable(edit2);
  	    }
  	});
   JScrollPane scrollPane = new JScrollPane(textArea_2);
  
   scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
   scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

   getContentPane().add(BorderLayout.CENTER,panel_3);

   panel_3.add(scrollPane);
 
  
  JPanel panel_5 = new JPanel();
  panel_5.setPreferredSize(new Dimension(100, 1000));
  panel_3.add(panel_5);
  panel_5.setLayout(new BorderLayout(0, 0));
  
  JPanel panel_6 = new JPanel();
  panel_5.add(panel_6, BorderLayout.NORTH);
  panel_6.setLayout(new GridLayout(0, 1, 0, 0));
  
  JButton btnNewButton_6 = new JButton("compare");
  panel_6.add(btnNewButton_6);
  btnNewButton_6.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	      compare comp = new compare();
	      comp.compareList(L1, L2);
	    }
	});
  JPanel panel_7 = new JPanel();
  panel_5.add(panel_7, BorderLayout.CENTER);
  panel_7.setLayout(new GridLayout(1, 0, 0, 0));
  
  JButton btnNewButton_7 = new JButton("<-");
  panel_7.add(btnNewButton_7);
  btnNewButton_7.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	      //Do it
	    }
	});
  JButton btnNewButton_8 = new JButton("->");
  panel_7.add(btnNewButton_8);
  btnNewButton_8.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	      //Do it
	    }
	});
  JTextArea textArea = new JTextArea(10,50);
  panel_3.add(textArea);
  btnNewButton_2.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	      //Do it
	    	edit1 = !edit1;
	    	textArea.setEditable(edit1);
	    	
	    	
	    }
	});
  
  JScrollPane scrollPane2 = new JScrollPane(textArea);
  scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
  scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
  getContentPane().add(BorderLayout.CENTER,panel_3);
  panel_3.add(scrollPane2);
 }
}
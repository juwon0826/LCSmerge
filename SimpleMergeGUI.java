import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import java.util.LinkedList;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class SimpleMergeGUI extends JFrame {
	private JPanel contentPane;
	static boolean edit1 = false;
	static boolean edit2 = false;
	LinkedList<Node> lFileList = null;
	LinkedList<Node> rFileList = null;

	public SimpleMergeGUI() {
		// create frame
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 800);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// create file manager panel
		JPanel fileManagerPanel = new JPanel();
		contentPane.add(fileManagerPanel, BorderLayout.NORTH);
		fileManagerPanel.setLayout(new GridLayout(0, 3, 0, 0));
		// 왼쪽 파일 left,edit,save를 담는 panel
		JPanel lFilePanel = new JPanel();
		fileManagerPanel.add(lFilePanel);
		lFilePanel.setLayout(new GridLayout(0, 3, 0, 0));
		// 제목 panel
		JPanel titlePanel = new JPanel();
		JLabel label = new JLabel("Simple Merge");
		titlePanel.add(label);
		fileManagerPanel.add(titlePanel);
		// 오른쪽 파일 left,edit,save를 담는 panel
		JPanel rFilePanel = new JPanel();
		fileManagerPanel.add(rFilePanel);
		rFilePanel.setLayout(new GridLayout(0, 3, 0, 0));

		// create text area panel
		JPanel textAreaPanel = new JPanel();
		contentPane.add(textAreaPanel, BorderLayout.CENTER);
		textAreaPanel.setLayout(new GridLayout(0, 3, 3, 3));
		// create left text area
		JTextArea lTextArea = new JTextArea(10, 50);
		textAreaPanel.add(lTextArea);
		lTextArea.setEditable(false);
		// create right text area
		JTextArea rTextArea = new JTextArea(10, 50);
		textAreaPanel.add(rTextArea);
		rTextArea.setEditable(false);

		// left file load
		JButton lFileLoadButton = new JButton("load");
		lFilePanel.add(lFileLoadButton);
	
		// left file edit
		JButton lFileEditButton = new JButton("edit");
		lFilePanel.add(lFileEditButton);
	
		lTextArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(lTextArea);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(BorderLayout.CENTER, textAreaPanel);
		// left file save
		JButton lFileSaveButton = new JButton("save");
		lFilePanel.add(lFileSaveButton);
		lFileSaveButton.setEnabled(false);
		// right file load
		JButton rFileLoadButton = new JButton("load");
		rFilePanel.add(rFileLoadButton);
	
		// right file edit
		JButton rFileEditButton = new JButton("edit");
		rFilePanel.add(rFileEditButton);
	
		rTextArea.setLineWrap(true);
		JScrollPane scrollPane2 = new JScrollPane(rTextArea);
		scrollPane2
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane2
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(BorderLayout.CENTER, textAreaPanel);

		// right file save
		JButton rFileSaveButton = new JButton("save");
		rFilePanel.add(rFileSaveButton);
		rFileSaveButton.setEnabled(false);
	

		textAreaPanel.add(scrollPane);
		// create function panel
		JPanel functionPanel = new JPanel();
		functionPanel.setPreferredSize(new Dimension(14, 39));
		textAreaPanel.add(functionPanel);
		functionPanel.setLayout(new BorderLayout(0, 0));
		// create compare panel
		JPanel comparePanel = new JPanel();
		functionPanel.add(comparePanel, BorderLayout.NORTH);
		comparePanel.setLayout(new GridLayout(0, 1, 0, 0));
		// create center button (compare & merge)
		JButton compareButton = new JButton("compare");
		comparePanel.add(compareButton);
		compareButton.setEnabled(false);
		// create merge panel
		JPanel mergePanel = new JPanel();
		functionPanel.add(mergePanel, BorderLayout.CENTER);
		mergePanel.setLayout(new GridLayout(1, 0, 0, 0));
		// merge right to left
		JButton leftMergeButton = new JButton("<-");
		mergePanel.add(leftMergeButton);		
		leftMergeButton.setEnabled(false);
		leftMergeButton.addActionListener(new ActionListener() {
			int start, end;
			public void actionPerformed(ActionEvent e) {				
				try {
					start = rTextArea.getLineOfOffset(rTextArea
							.getSelectionStart());
					end = rTextArea.getLineOfOffset(rTextArea.getSelectionEnd());
				} catch (Exception ex) {
				}
				Merge merge = new Merge();
				merge.merge(rFileList, lFileList, start, end);
				Update update = new Update(lFileList, lTextArea);
				update.listToArea(false);
			}
		});
		// merge left to right
		JButton rightMergeButton = new JButton("->");
		mergePanel.add(rightMergeButton);
		rightMergeButton.setEnabled(false);
		rightMergeButton.addActionListener(new ActionListener() {
			int start, end;
			public void actionPerformed(ActionEvent e) {
				try {
					start = lTextArea.getLineOfOffset(lTextArea.getSelectionStart());
					end = lTextArea.getLineOfOffset(lTextArea.getSelectionEnd());
				} catch (Exception ex) {
				}
				Merge merge = new Merge();
				merge.merge(lFileList, rFileList, start, end);
				Update update = new Update(rFileList, rTextArea);

				update.listToArea(false);
			}
		});
		textAreaPanel.add(scrollPane2);
		
		lFileLoadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Load load = new Load();
				load.openPopup();
				load.loadFromFile();
				lFileList = load.getList();
				Update update = new Update(lFileList, lTextArea);
				update.listToArea(true);
			}
		});
		lFileSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update update = new Update(lFileList, lTextArea);
				lFileList = update.areaToList();
				Save save = new Save(lFileList);
				save.openPopup();
				save.saveToFile();
			}
		});
		
		lFileEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit1 = !edit1;
				lTextArea.setEditable(edit1);
				lFileSaveButton.setEnabled(true);
				
			}
		});
		rFileLoadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Load load = new Load();
				load.openPopup();
				load.loadFromFile();
				rFileList = load.getList();
				Update update = new Update(rFileList, rTextArea);
				update.listToArea(true);
				
				
			}
		});	
		rFileEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit2 = !edit2;
				rTextArea.setEditable(edit2);
				rFileSaveButton.setEnabled(true);
		            if(edit2 == true && edit1 ==true){
		            	compareButton.setEnabled(true);
		            	
		            }
			}
		});
	
		rFileSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update update = new Update(rFileList, rTextArea);
				rFileList = update.areaToList();
				Save save = new Save(rFileList);
				save.openPopup();
				save.saveToFile();
				
			}
		});
		compareButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				LCS lcsChecker = new LCS();
				EnterSync enterSyncer = new EnterSync();
				Compare compare = new Compare();
				lcsChecker.makeTable(lFileList, rFileList);
				lcsChecker.calcLCS(lFileList, rFileList);
				enterSyncer.enterSync(lFileList, rFileList);
				compare.compareList(lFileList, rFileList);

				Update updateL = new Update(lFileList, lTextArea);
				Update updateR = new Update(rFileList, rTextArea);
				
				updateL.listToArea(false);
				updateR.listToArea(false);
				 rightMergeButton.setEnabled(true);
	             leftMergeButton.setEnabled(true);
			}
		});

	
	}
}
package test;

import java.awt.Color;

import java.awt.Insets;



import javax.swing.BorderFactory;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JTextPane;

import javax.swing.SwingUtilities;

import javax.swing.text.AttributeSet;

import javax.swing.text.SimpleAttributeSet;

import javax.swing.text.StyleConstants;

import javax.swing.text.StyleContext;



public class TextPaneTest extends JFrame {

    private JPanel topPanel;

    private JTextPane tPane;



    public TextPaneTest() {

        topPanel = new JPanel();



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);



        tPane = new JTextPane();

        tPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        tPane.setMargin(new Insets(5, 5, 5, 5));



        topPanel.add(tPane);



        appendToPane(tPane, "여기가 빨간 \n", Color.RED);

        appendToPane(tPane, "파란색 글자 ", Color.BLUE);

        appendToPane(tPane, "아마", Color.DARK_GRAY);

        appendToPane(tPane, "내가 다시 한번", Color.MAGENTA);

        appendToPane(tPane, "우리 가위 바위 보", Color.ORANGE);



        add(topPanel);

        pack();

        setVisible(true);

    }



    private void appendToPane(JTextPane tp, String msg, Color c) {

        StyleContext sc = StyleContext.getDefaultStyleContext();

        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,

                StyleConstants.Foreground, c);



        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "송조체");

        aset = sc.addAttribute(aset, StyleConstants.Alignment,

                StyleConstants.ALIGN_JUSTIFIED);
        
       



        int len = tp.getDocument().getLength();

        tp.setCaretPosition(len);

        tp.setCharacterAttributes(aset, false);

        tp.replaceSelection(msg);

    }



    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                new TextPaneTest();

            }

        });

    }

}
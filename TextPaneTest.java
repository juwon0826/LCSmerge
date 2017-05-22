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



        appendToPane(tPane, "���Ⱑ ���� \n", Color.RED);

        appendToPane(tPane, "�Ķ��� ���� ", Color.BLUE);

        appendToPane(tPane, "�Ƹ�", Color.DARK_GRAY);

        appendToPane(tPane, "���� �ٽ� �ѹ�", Color.MAGENTA);

        appendToPane(tPane, "�츮 ���� ���� ��", Color.ORANGE);



        add(topPanel);

        pack();

        setVisible(true);

    }



    private void appendToPane(JTextPane tp, String msg, Color c) {

        StyleContext sc = StyleContext.getDefaultStyleContext();

        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,

                StyleConstants.Foreground, c);



        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "����ü");

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
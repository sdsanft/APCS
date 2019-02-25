import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class head implements ActionListener{
	JFrame workFrame, breakFrame, timerFrame;
	JTextArea workText, breakText, timerText;
	JButton workButton, breakButton, timerButton;
	JSplitPane workSplitPane, breakSplitPane, timerSplitPane;
	JPanel workPane, breakPane, timerPane;
	Timer t;
	
	int time;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		workTimer();
	}
	
	public static void workTimer () {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run () {
				try {
					workGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void workGUI() throws IOException {
		new head();
	}
	
	public void workFrame() {
		workFrame = new JFrame("Start Working!");
		
		workText = new JTextArea ();
		workText.setPreferredSize(new Dimension(360, 60));
		workText.setOpaque(true);
		workText.setBackground(new Color(150, 200, 150));
		workText.append("Time to start working!\n");
		workText.append("Quote");
		workText.setEditable(false);
		
		workButton = new JButton();
		workButton.setPreferredSize(new Dimension(360, 40));
		workButton.setBackground(new Color(150, 150, 200));
		workButton.setText("Set Timer for 25 min");
		workButton.addActionListener(this);
		
		workSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, workText, workButton);
		workPane = new JPanel(new GridLayout(1,0));
		workPane.add(workSplitPane);
		
		workFrame.add(workPane);
		
		workFrame.pack();
		workFrame.setVisible(true);
	}
	
	public void timerFrame(int seconds, boolean working) {
		time = seconds;
		
		timerFrame = new JFrame("Timer");
		timerText = new JTextArea ();
		timerText.setPreferredSize(new Dimension(240, 60));
		timerText.setOpaque(true);
		timerText.setBackground(new Color(150, 200, 150));
		timerText.setEditable(false);
		
		timerButton = new JButton();
		timerButton.setPreferredSize(new Dimension(240, 40));
		timerButton.setBackground(new Color(150, 150, 200));
		timerButton.setText("Quit");
		timerButton.addActionListener(this);
		
		timerSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, timerText, timerButton);
		timerPane = new JPanel(new GridLayout(1,0));
		timerPane.add(timerSplitPane);
		
		timerFrame.add(timerPane);
		timerFrame.pack();
		timerFrame.setVisible(true);
		
		t = new javax.swing.Timer(1000, new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		        timerText.setText(displayTime());
		        time--;
		        
		        if(time < 0) {
		        	t.stop();
		        	timerFrame.dispose();
		    		if(working) {
		    			breakFrame();
		    		} else {
		    			workFrame();
		    		}
		        }
		    }
		});
		
		t.setInitialDelay(0);
		t.setRepeats(true);
		t.start();
	}
	
	public void breakFrame() {
		breakFrame = new JFrame("Break Time!");
		
		breakText = new JTextArea ();
		breakText.setPreferredSize(new Dimension(360, 60));
		breakText.setOpaque(true);
		breakText.setBackground(new Color(150, 200, 150));
		breakText.append("Time to take a break!\n");
		breakText.setEditable(false);
		
		breakButton = new JButton();
		breakButton.setPreferredSize(new Dimension(360, 40));
		breakButton.setBackground(new Color(150, 150, 200));
		breakButton.setText("Set Timer for 5 min");
		breakButton.addActionListener(this);
		
		breakSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, breakText, breakButton);
		breakPane = new JPanel(new GridLayout(1,0));
		breakPane.add(breakSplitPane);
		
		breakFrame.add(breakPane);
		
		breakFrame.pack();
		breakFrame.setVisible(true);
	}
	
	public head() {
		workFrame();
	}
	
	public String quote() {
		String s = "";
		
		return s;
	}
	
	public String displayTime() {
		String s;
		
		if(time % 60 < 10) {
			s = Integer.toString(time / 60) + ":0" + Integer.toString(time % 60);
		} else {
			s = Integer.toString(time / 60) + ":" + Integer.toString(time % 60);
		}
		
		return s;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(workButton)) {
			workFrame.dispose();
			timerFrame(25*60, true);
		} else if (e.getSource().equals(breakButton)) {
			breakFrame.dispose();
			timerFrame(3*60, false);
		} else if (e.getSource().equals(timerButton)) {
			t.stop();
			timerFrame.dispose();
		}
	}
}

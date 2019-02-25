import java.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class head implements ActionListener{
	JFrame frame;
	JTextArea title, name, namebox, time;
	JButton submit;
	JPanel panel;
	javax.swing.Timer t;
	Map<String, Date> m = new TreeMap<String, Date>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clock();
	}
	
	public static void clock () {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run () {
				new head();
			}
		});
	}
	
	public head() {
		clockGUI();
	}
	
	public void clockGUI() {
		frame = new JFrame("Clock in/out");
		
		title = new JTextArea();
		title.append("Work Clock");
		title.setAlignmentX(0.5f);
		title.setEditable(false);
		
		name = new JTextArea();
		name.append("Name:");
		name.setEditable(false);
		
		namebox = new JTextArea();
		namebox.setBackground(new Color(250, 250, 210));
		
		time = new JTextArea();
		time.setEditable(false);
		
		submit = new JButton();
		submit.setText("Submit");
		submit.addActionListener(this);
		
		panel = new JPanel(new GridLayout(5, 0));
		panel.setPreferredSize(new Dimension(360, 100));
		
		panel.add(title);
		panel.add(name);
		panel.add(namebox);
		panel.add(time);
		panel.add(submit);
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		t = new javax.swing.Timer(1000, new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    	Date date = new Date();
		        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
		        time.setText(dateFormat.format(date));
		    }
		});
		
		t.setInitialDelay(0);
		t.setRepeats(true);
		t.start();
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(submit)) {
			if(m.containsKey(namebox.getText())) {
				Date in = m.get(namebox.getText());
				Date out = new Date();
				String strDateFormat = "hh:mm:ss a";
		        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
				
				JFrame clockOut = new JFrame("Clocking Out");
				
				String timeElapsed = (out.getHours() - in.getHours()) + " hrs, " + (out.getMinutes() - in.getMinutes()) + " min";
				
				JTextArea text = new JTextArea();
				text.append(namebox.getText());
				text.append("\nYou clocked out at " + dateFormat.format(out));
				text.append("\nYou were clocked in for " + timeElapsed);
				text.setPreferredSize(new Dimension(240, 60));
				text.setEditable(false);
				
				clockOut.add(text);
				
				clockOut.pack();
				clockOut.setVisible(true);
				
				m.remove(namebox.getText());
				namebox.setText("");
			} else {
				Date in = new Date();
				String strDateFormat = "hh:mm:ss a";
		        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		        
		        m.put(namebox.getText(), in);
				
		        JFrame clockIn = new JFrame("Clocking in");
				
				JTextArea text = new JTextArea();
				text.append(namebox.getText());
				text.append("\nYou clocked in at " + dateFormat.format(in));
				text.setPreferredSize(new Dimension(240, 40));
				text.setEditable(false);
				
				clockIn.add(text);
				
				clockIn.pack();
				clockIn.setVisible(true);
				namebox.setText("");
			}
		}
	}
	
	public void windowClosing(WindowEvent e) {
		t.stop();
	}
}

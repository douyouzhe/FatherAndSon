package com.salms;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class salmsFrame {
	private JFrame frame;
	private JLabel backLabel;
	private JDesktopPane desktopPane;
	
	public salmsFrame(){
		frame = new JFrame("Sales & Logistic Management System");
		//frame.addComponentListener(new FrameListener());
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setBounds(100, 100, 1200, 1000);
		frame.getContentPane().setBackground(new Color(170, 188, 120));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backLabel = new JLabel();
		backLabel.setVerticalAlignment(SwingConstants.TOP);
		backLabel.setHorizontalAlignment(SwingConstants.CENTER);
		updateBackImage();
		desktopPane = new JDesktopPane();
		desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE));
		frame.getContentPane().add(desktopPane);
		//JTabbedPane navigationPanel = createNavigationPanel();
		//frame.getContentPane().add(navigationPanel, BorderLayout.NORTH);
		frame.setVisible(true);
	}
	
	private JTabbedPane createNavigationPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	private void updateBackImage() {
		if(backLabel != null) {
			int backw = salmsFrame.this.frame.getWidth();
			int backh = salmsFrame.this.frame.getHeight();
			backLabel.setSize(backw,backh);
			backLabel.setText("<html><body><image width = '"+ backw
					+ "'height ='"+ (backw-110)+"'src=" + salmsFrame.this.getClass().getResource("welcome.jpg")
					+"'></image></body></html>");
		}
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new salmsFrame();
			}
		});
		
	}
}

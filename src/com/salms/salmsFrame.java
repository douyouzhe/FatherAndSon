package com.salms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyVetoException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class salmsFrame {
	private JFrame frame;
	private JLabel backLabel;
	private JDesktopPane desktopPane;
	
	public salmsFrame(){
		frame = new JFrame("Sales & Logistic Management System");
		frame.addComponentListener(new FrameListener());
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setBounds(100, 100, 1000, 800);
		frame.getContentPane().setBackground(new Color(170, 188, 120));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backLabel = new JLabel();
		backLabel.setVerticalAlignment(SwingConstants.TOP);
		backLabel.setHorizontalAlignment(SwingConstants.CENTER);
		updateBackImage();
		desktopPane = new JDesktopPane();
		desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE));
		frame.getContentPane().add(desktopPane);
		JTabbedPane navigationPanel = createNavigationPanel(); 
		frame.getContentPane().add(navigationPanel, BorderLayout.NORTH);
		frame.setVisible(true);
	}
	private JTabbedPane createNavigationPanel() {
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFocusable(false);
		tabbedPane.setBackground(new Color(211, 230, 192));
		//tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		
	
		JPanel baseManagePanel = new JPanel(); // 鍩虹淇℃伅绠＄悊闈㈡澘
		baseManagePanel.setBackground(new Color(215, 223, 194));
		baseManagePanel.setLayout(new BoxLayout(baseManagePanel,
				BoxLayout.X_AXIS));
//		baseManagePanel.add(createFrameButton("瀹㈡埛淇℃伅绠＄悊", "KeHuGuanLi"));
//		baseManagePanel.add(createFrameButton("鍟嗗搧淇℃伅绠＄悊", "ShangPinGuanLi"));
//		baseManagePanel.add(createFrameButton("渚涘簲鍟嗕俊鎭鐞�", "GysGuanLi"));
		tabbedPane.addTab("    ukraine  ", null, baseManagePanel, "鍩虹淇℃伅绠＄悊");
		
		return tabbedPane;
	}
	
	private class FrameListener extends ComponentAdapter{
		public void componentResized(final ComponentEvent e) {
			updateBackImage();
		}
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
	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

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
	private Map<String,JInternalFrame>ifs=new HashMap<>();
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
		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		
	
		JPanel baseManagePanel = new JPanel(); // 鍩虹淇℃伅绠＄悊闈㈡澘
		baseManagePanel.setBackground(new Color(215, 223, 194));
		baseManagePanel.setLayout(new BoxLayout(baseManagePanel,
				BoxLayout.X_AXIS));
		baseManagePanel.add(createFrameButton("Customer Info", "Customer Info"));
		baseManagePanel.add(createFrameButton("Items Info", "Items Info"));
		baseManagePanel.add(createFrameButton("Supplier Info", "Supplier Info"));
		//tabbedPane.addTab("    ukraine  ", null, baseManagePanel, "鍩虹淇℃伅绠＄悊");
		JPanel depotManagePanel=new JPanel();
		depotManagePanel.setBackground(new Color(215,233,194));
		depotManagePanel.setLayout(new BoxLayout(depotManagePanel,BoxLayout.X_AXIS));
		depotManagePanel.add(createFrameButton("check the depot","check the depot"));
		depotManagePanel.add(createFrameButton("adjust the price","adjust the price"));
		JPanel sellManagePanel=new JPanel();
		sellManagePanel.setBackground(new Color(215,233,194));
		sellManagePanel.setLayout(new BoxLayout(sellManagePanel,BoxLayout.X_AXIS));
		sellManagePanel.add(createFrameButton("Sale report","Sale report"));
		sellManagePanel.add(createFrameButton("Sales return","Sales return"));
		JPanel searchStatisticPanel=new JPanel();
		searchStatisticPanel.setBounds(0,0,600,41);// how about previous panels?
		searchStatisticPanel.setLayout(new BoxLayout(searchStatisticPanel,BoxLayout.X_AXIS));
		searchStatisticPanel.setName("searchStatisticPanel");//same
		searchStatisticPanel.add(createFrameButton("Customers Info","Customers Info"));
		searchStatisticPanel.add(createFrameButton("Items Info","Items Info"));
		searchStatisticPanel.add(createFrameButton("Suppliers Info","Suppliers Info"));
		searchStatisticPanel.add(createFrameButton("Sale Info","Sale Info"));
		searchStatisticPanel.add(createFrameButton("Sale Return Info","Sale Return Info"));
		searchStatisticPanel.add(createFrameButton("Depot Info","Depot Info"));
		searchStatisticPanel.add(createFrameButton("Depot Return Info","Depot Return Info"));
		searchStatisticPanel.add(createFrameButton("Sale Rank","Sale Rank"));
		JPanel stockManagePanel=new JPanel();
		stockManagePanel.setBackground(new Color(215,223,194));
		stockManagePanel.setLayout(new BoxLayout(stockManagePanel,BoxLayout.X_AXIS));
		stockManagePanel.add(createFrameButton("Stock Report","Stock Report"));
		stockManagePanel.add(createFrameButton("Stock Return","Stock Return"));
		JPanel sysManagePanel=new JPanel();
		sysManagePanel.setBackground(new Color(215,233,194));
		sysManagePanel.setLayout(new BoxLayout(sysManagePanel,BoxLayout.X_AXIS));
		sysManagePanel.add(createFrameButton("Operator Manage","Operator Manage"));
		sysManagePanel.add(createFrameButton("Change Password","Chane Password"));
		sysManagePanel.add(createFrameButton("Permission Manage","Permission Manage"));
		
		tabbedPane.addTab("Base Information",null,baseManagePanel,"Base Information");
		tabbedPane.addTab("Stock Information",null,stockManagePanel,"Stock Information");
		tabbedPane.addTab("Sale Information",null,sellManagePanel,"Sale Information");
		tabbedPane.addTab("Depot Management",null,depotManagePanel,"Depot Management");
		tabbedPane.addTab("Syetem Management",null,sysManagePanel,"Syetem Management");
		
		return tabbedPane;

	}
	private JButton createFrameButton(String fName,String cName)
	{
		String imageUrl="res/ActionIcon/"+fName+".png";
		String imageUrl_roll="res/ActionIcon/"+fName+"_roll.png";
		String imageUrl_down="res/ActionIcon/"+fName+"_down.png";
		Icon icon=new ImageIcon(imageUrl);
		Icon icon_roll=null;
		if(imageUrl_roll!=null)
			icon_roll=new ImageIcon(imageUrl_roll);
		Icon icon_down=null;
		if(imageUrl_down!=null)
			icon_down=new ImageIcon(imageUrl_down);
		Action action=new openFrameAction(fName,cName,icon);
		JButton button=new JButton(action);
		button.setMargin(new Insets(0,0,0,0));
		button.setHideActionText(true);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
			if(icon_roll!=null)
				button.setRolloverIcon(icon_roll);
			if(icon_down!=null)
				button.setPressedIcon(icon_down);
			return button;
				
		
	}
	protected final class openFrameAction extends AbstractAction
	{
		private String FrameName=null;
		private openFrameAction() {}
		public openFrameAction(String cName,String fName,Icon icon)
		{
			this.FrameName=fName;
			putValue(Action.NAME,cName);
			putValue(Action.SHORT_DESCRIPTION,cName);
			putValue(Action.SMALL_ICON,icon);
			
		}
		public void actionPerformed(final ActionEvent e)//wtf
		{
			JInternalFrame jf=getIFrame(FrameName);
			jf.addInternalFrameListener(new InternalFrameAdapter()
			{
				public void internalFrameClosed(InternalFrameEvent e) {
					ifs.remove(FrameName);
				}
			});
			if(jf.getDesktopPane()==null) 
			{
				desktopPane.add(jf);
				jf.setVisible(true);
			}
			try
			{
				jf.setSelected(true);
			
			}catch(PropertyVetoException el)
			{
				el.printStackTrace();
			}
		}
	}
	private JInternalFrame getIFrame(String frameName)
	{
		JInternalFrame jf=null;
		if(!ifs.containsKey(frameName))
		{
			try {
				Class fClass=Class.forName("internalFrame."+frameName);
				Constructor constructor=fClass.getConstructor(null);
				jf=(JInternalFrame)constructor.newInstance(null);
				}catch(Exception e)
			{
					e.printStackTrace();
			}
		}else
			jf=ifs.get(frameName);
			return jf;

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

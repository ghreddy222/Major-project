package com;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Font;
import java.io.FileWriter;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import org.jfree.ui.RefineryUtilities;
import javax.swing.JTextField;
import java.util.Random;
import javax.swing.JComboBox;
import java.awt.Cursor;
import java.util.ArrayList;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Scrollbar;
import java.awt.SystemColor;
import java.awt.Component;
import java.awt.ComponentOrientation;
public class SensorPanel extends JFrame{
	Simulator node;
	JPanel p1,p2;
	int left,top;
	Font f1;
	JButton b1,b2,b3,b4,b5;
	JLabel l1,l2;
	static JLabel status;
	int size;
	JComboBox c1;
	boolean running = false; 
	SendData sd;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
public SensorPanel(int s){
	super("Cyber System Simulation Screen");
	size = s;
	
	f1 = new Font("Times New Roman",Font.BOLD,14);
	node = new Simulator(40);
	node.setAutoscrolls(true);
	node.setBounds(0, -28, 1370, 563);
	p1 = new JPanel();
	p1.setLayout(null);
	p1.add(node);
	p1.setBackground(new Color(128,0,0));
	getContentPane().add(p1,BorderLayout.CENTER);
	
	p2 = new JPanel();
	p2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	p2.setAutoscrolls(true);
	p2.setBackground(SystemColor.control);
	
	label = new JLabel("");
	
		l1 = new JLabel("Source ID");
		l1.setFont(f1);
	c1 = new JComboBox();
	c1.setFont(f1);
	
	label_1 = new JLabel("");
	
	b1 = new JButton("Source Placements");
	b1.setFont(f1);
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			SensorPlacement.randomNodes(size,600,500,node);
			node.option=0;
			node.repaint();
		}
	});
	
		b4 = new JButton("Chart");
		b4.setFont(f1);
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				int total = 0;
				int normal = 0;
				int strict = 0;
				int stealthy = 0;
				for(int i=0;i<node.device.size();i++) {
					Sensor sensor  = node.device.get(i);
					total = total + sensor.getTotal();
					normal = normal + sensor.getNormal();
					strict = strict + sensor.getStrict();
					stealthy = stealthy + sensor.getStealthy();
				}
				Chart chart1 = new Chart("Strictly & Stealthy Attack Detections",total,normal,strict,stealthy);
				chart1.pack();
				RefineryUtilities.centerFrameOnScreen(chart1);
				chart1.setVisible(true);
				
			}
		});
	
	label_2 = new JLabel("");
	label_2.setIcon(new ImageIcon("D:\\VulnerableCPS\\VulnerableCPS\\gtls.jpg"));
	
	label_3 = new JLabel("");
	
	label_4 = new JLabel("");
	
	label_5 = new JLabel("");
	
		b2 = new JButton("Start Simulation");
		b2.setFont(f1);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				sd = new SendData(node,true);
			}
		});
	
	label_6 = new JLabel("");
	
	label_7 = new JLabel("");
	
	label_8 = new JLabel("");
	
	label_9 = new JLabel("");
	
	label_10 = new JLabel("");
	
		b3 = new JButton("Stop Simulation");
		b3.setFont(f1);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				sd.setRunning(false);
			}
		});
	
	
		b5 = new JButton("Exit");
		b5.setFont(f1);
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}
		});
	
	label_11 = new JLabel("");
	
		status = new JLabel("Status:");
		status.setFont(f1);
	
	label_12 = new JLabel("");
	
	label_13 = new JLabel("");
	for(int i=1;i<=size;i++){
		c1.addItem("D"+i);
	}

	
	getContentPane().add(p2,BorderLayout.NORTH);
	
	label_14 = new JLabel("");
	
	label_15 = new JLabel("");
	GroupLayout gl_p2 = new GroupLayout(p2);
	gl_p2.setHorizontalGroup(
		gl_p2.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_p2.createSequentialGroup()
				.addGap(10)
				.addComponent(label_2)
				.addGap(34)
				.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_p2.createSequentialGroup()
						.addComponent(l1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addGap(4)
						.addComponent(c1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addComponent(b1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addComponent(status, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
				.addGap(37)
				.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
					.addComponent(b2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addComponent(b3, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
				.addGap(54)
				.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
					.addComponent(b4, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addComponent(b5, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
				.addGap(4)
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				.addGap(1073)
				.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
				.addGap(173)
				.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
			.addGroup(gl_p2.createSequentialGroup()
				.addGap(1883)
				.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
			.addGroup(gl_p2.createSequentialGroup()
				.addGap(1883)
				.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				.addGap(173)
				.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
				.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
	);
	gl_p2.setVerticalGroup(
		gl_p2.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_p2.createSequentialGroup()
				.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_p2.createSequentialGroup()
						.addGap(11)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_p2.createSequentialGroup()
						.addGap(11)
						.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
							.addComponent(l1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(c1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addComponent(b1)
						.addGap(36)
						.addComponent(status, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_p2.createSequentialGroup()
						.addGap(11)
						.addComponent(b2)
						.addGap(26)
						.addComponent(b3))
					.addGroup(gl_p2.createSequentialGroup()
						.addGap(11)
						.addComponent(b4)
						.addGap(26)
						.addComponent(b5))
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_p2.createSequentialGroup()
						.addGap(31)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_p2.createSequentialGroup()
						.addGap(31)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_p2.createSequentialGroup()
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_p2.createSequentialGroup()
						.addGap(31)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
				.addGap(5)
				.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
					.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
					.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
	);
	p2.setLayout(gl_p2);
	left = getInsets().left;
    top = getInsets().top;
		
}
}
package admin;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class admin implements ActionListener {
	//创建2个面板
Panel jp1=new Panel();
Panel jp2=new Panel();

	//创建4个按钮
JButton jb1=new JButton("日记管理");
JButton jb2=new JButton("备忘管理");
JButton jb3=new JButton("通讯管理");
JButton jb4=new JButton("财务管理");
JButton jb5=new JButton("用户管理");
JButton jb6=new JButton("退出系统");


    //创建卡片布局
CardLayout crd=new CardLayout();

    //创建卡片内部面板 
URJ urj=new URJ();
UBW ubw=new UBW();
UTX utx=new UTX();
UCW ucw=new UCW();
UU uu=new UU();
    //构造方法
public admin() {

	//创建窗体并设计标题
JFrame jfrm=new JFrame("管理员操作界面");
jfrm.setBounds(600, 200, 800, 500);
Container contentPane = jfrm.getContentPane();
contentPane.setLayout(null);
jp1.setBounds(5, 5, 500, 450);
jp1.setBackground(Color.WHITE);
jp1.setLayout(crd);
jp1.add(urj,"urj");
jp1.add(ubw,"ubw");
jp1.add(utx,"utx");
jp1.add(ucw,"ucw");
jp1.add(uu,"uu");
crd.show(jp1, "urj");
jp2.setBounds(500, 5, 200, 450);
//jp2.setBackground(Color.white);
jp2.setLayout(new GridLayout(5, 1, 0, 10));
//jp2.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
jb1.addActionListener(this);
jb2.addActionListener(this);
jb3.addActionListener(this);
jb4.addActionListener(this);
jb5.addActionListener(this);
jb6.addActionListener(this);
jp2.add(jb1);
jp2.add(jb2);
jp2.add(jb3);
jp2.add(jb4);
jp2.add(jb5);
jp2.add(jb6);
contentPane.add(jp1);
contentPane.add(jp2);	
jfrm.setVisible(true);	

}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() ==jb1)
		{
			crd.show(jp1, "urj");
		                }
		else if(e.getSource() == jb2)
		{
			crd.show(jp1, "ubw");
		                }
		else if(e.getSource() == jb3)
		{
			crd.show(jp1, "utx");
		                }
		else if(e.getSource() == jb4)
		{
			crd.show(jp1, "ucw");
		                }
		else if(e.getSource() == jb5)
		{
			crd.show(jp1, "uu");
		                }
	
		else if(e.getSource() == jb6)
		{
			System.exit(0);
		                }
		
		// TODO Auto-generated method stub

	}

}

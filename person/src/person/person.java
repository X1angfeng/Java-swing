package person;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class person implements ActionListener {

	//创建2个面板
JPanel jp1=new JPanel();
JPanel jp2=new JPanel();

	//创建2个按钮
JButton jb1=new JButton("日记本");
JButton jb2=new JButton("备忘录");
JButton jb3=new JButton("通讯录");
JButton jb4=new JButton("财务管理");
JButton jb5=new JButton("退出系统");

	//创建卡片布局
CardLayout crd=new CardLayout();

String userId;

	//创建卡片内部面板 
RJ rj=new RJ(userId);
BW bw=new BW(userId);
TX tx=new TX(userId);
CW cw=new CW(userId);
public person(String userId){
	
	this.userId = userId;	
    JFrame jfrm=new JFrame("用户操作界面");
    jfrm.setBounds(600, 200, 800, 500);
    Container contentPane = jfrm.getContentPane();
	contentPane.setLayout(null);
	jp1.setBounds(5, 5, 500, 450);
	jp1.setBackground(Color.white);
	jp1.setLayout(crd);
	jp1.add(rj,"rj");
	jp1.add(bw,"bw");
	jp1.add(tx,"tx");
	jp1.add(cw,"cw");
	crd.show(jp1, "rj");
	jp2.setBounds(550, 5, 200, 450);
	//jp2.setBackground(Color.white);
	jp2.setLayout(new GridLayout(5, 1, 0, 10));
	jp2.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
	jb1.addActionListener(this);
	jb2.addActionListener(this);
	jb3.addActionListener(this);
	jb4.addActionListener(this);
	jb5.addActionListener(this);
	jp2.add(jb1);
	jp2.add(jb2);
	jp2.add(jb3);
	jp2.add(jb4);
	jp2.add(jb5);
	contentPane.add(jp1);
	contentPane.add(jp2);	
	jfrm.setVisible(true);	

}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() ==jb1)
		{
			crd.show(jp1, "rj");
		                }
		else if(e.getSource() == jb2)
		{
			crd.show(jp1, "bw");
		}
		else if(e.getSource() == jb3)
		{
			crd.show(jp1, "tx");
		}
		else if(e.getSource() == jb4)
		{
			crd.show(jp1, "cw");
		}
		else if(e.getSource() == jb5)
			{
				System.exit(0);
			                }
		// TODO Auto-generated method stub

	}

}

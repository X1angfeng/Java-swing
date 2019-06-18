package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;
import javax.swing.*;

import admin.admin;
import person.StringUtil;
import person.person;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class login extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -28563928635402014L;
	public static String userId;
	//创建窗体并设计标题    
JFrame jfrm=new JFrame("个人信息管理系统"); 
	//创建3个面板
JPanel jp1=new JPanel();
JPanel jp2=new JPanel();
JPanel jp3=new JPanel();

	//创建3个标签
JLabel jl1=new JLabel("欢迎使用个人信息管理系统",JLabel.CENTER);
JLabel jl2=new JLabel("账        号:");
JLabel jl3=new JLabel("登录密码:");

	//创建2个文本输入框
JTextField jtf1=new JTextField(13);
JPasswordField jtf2=new JPasswordField(13);

    //创建2个按钮
JButton jb1=new JButton("😀登录");
JButton jb2=new JButton("😋注册");
JButton jb3=new JButton("😁取消");

	//创建2个单选按钮
JRadioButton jr1=new JRadioButton("用户");
JRadioButton jr2=new JRadioButton("管理员");

    //构造方法
public login() {

jfrm.setBounds(700, 200, 400, 400);   //设置窗体大小
Container contentPane = jfrm.getContentPane();  //顶层容器
contentPane.setLayout(null);
jp1.add(jl1);
jl1.setFont(new Font("宋体",1,15));  //背景色
jl1.setForeground(Color.blue);
jp1.setLayout(new FlowLayout(FlowLayout.CENTER));
jp2.add(jl2);
jp2.add(jtf1);
jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
jp3.add(jl3);
jp3.add(jtf2);
//jtf2.setEchoChar('*');
jp3.setLayout(new FlowLayout(FlowLayout.CENTER));
ButtonGroup grp=new ButtonGroup();
jr1.setBounds(285,105,150,20);
jr2.setBounds(285,155,150,20);
grp.add(jr1);
grp.add(jr2);
jr2.setSelected(true);
jfrm.add(jr1);
jfrm.add(jr2);
jfrm.add(jp1);
jfrm.add(jp2);
jfrm.add(jp3);
jfrm.add(jb1);
jfrm.add(jb2);
jfrm.add(jb3);
jb1.addActionListener(this);
jb2.addActionListener(this);
jb3.addActionListener(this);
jb1.setBounds(40,200,90,30);
jb2.setBounds(140,200,90,30);
jb3.setBounds(240,200,90,30);
contentPane.add(jb1);
contentPane.add(jp1);
contentPane.add(jp2);
contentPane.add(jp3);
jl1.setBounds(120, 30, 200, 40);
jp1.setBounds(40,50,300,60);
jp2.setBounds(25,100, 300, 60);
jp3.setBounds(25,150,300,60);
jfrm.setVisible(true);   //将窗体显示出来
jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1)
		{
if(jr2.isSelected())//管理员登录
		{
	            String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	            String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=java";
	            String userName="sa";
	            String userPwd="123";
				String mno = jtf1.getText();	//管理员账号
				String mpassword = new String(jtf2.getText()); //管理员密码
		try 
			    {
			    	Class.forName(driverName);
			                     }
			 catch(Exception e1) 
			    {
			    	e1.printStackTrace();
			                     }
		if(StringUtil.isEmpty(mno)){
	 		JOptionPane.showMessageDialog(null,"管理员账号不能为空");
	 		return;
	 	}
	 	else if(StringUtil.isEmpty(mpassword)){
	 		JOptionPane.showMessageDialog(null,"密码不能为空");
	 		return;
	 	}
try 
	{              
	Connection con=DriverManager.getConnection(dbURL,userName,userPwd); 
		Statement s= con.createStatement( );  
		String r1 = "select * from admindata" ;
		ResultSet rs=((java.sql.Statement) s).executeQuery(r1);
		rs.next(); 
		mno = rs.getString("aID").trim();
		mpassword = rs.getString("aPWD").trim();
	    s.close( );  
		con.close( );  
		if(StringUtil.isEmpty(mno)){
			JOptionPane.showMessageDialog(null,"用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(mpassword)){
			JOptionPane.showMessageDialog(null,"密码不能为空");
			return;
		}
if(mno.equals(jtf1.getText()) && mpassword.equals(jtf2.getText()))
			{
				  new admin();
				  jfrm.setVisible(false);
				                      }
else
		{
			JOptionPane.showMessageDialog(null, "管理员id或密码不正确！"); 
				      }}

		catch(Exception e1)
				 { 
					 e1.printStackTrace(); 
				 }}
if(jr1.isSelected())  //非管理员登陆
	{
	 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
     String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=java";
     String userName="sa";
     String userPwd="123";
	 userId = jtf1.getText();  //非管理员的账号
	 String passWord = new String(jtf2.getText());  //普通用户的密码
     try 
		 {
			   Class.forName(driverName);
			                          }
			    catch(Exception  e1) 
			    {
			      e1.printStackTrace();
			              }
     if(StringUtil.isEmpty(userId)){
 		JOptionPane.showMessageDialog(null,"用户名不能为空");
 		return;
 	}
 	else if(StringUtil.isEmpty(passWord)){
 		JOptionPane.showMessageDialog(null,"密码不能为空");
 		return;
 	}
 
try 
	{              
	  Connection con=DriverManager.getConnection(dbURL,userName,userPwd);// 
	  Statement s=(Statement) con.createStatement( );  
      String r1 = "select * from usedata where ID='"+jtf1.getText()+"'";
	  ResultSet rs=((java.sql.Statement) s).executeQuery(r1);
      rs.next();
	  userId = rs.getString("ID").trim();
	  passWord = rs.getString("PWD").trim(); 
	  s.close( );  
	  con.close( );  
	  
if(userId.equals(jtf1.getText()) && passWord.equals(jtf2.getText()))
				{
	new person(userId);
	jfrm.setVisible(false);
					      }
else {
	JOptionPane.showMessageDialog(null,"用户名或密码错误");
	return ;
}}
catch(Exception e1)
		 { 
			 e1.printStackTrace(); 
		 }}}
		         else if(e.getSource()==jb3)
		         {
		        	 System.exit(0);  
		          }
		         else if(e.getSource()==jb2)
		         {
		        	 new zhuce();  
		          }
		}
	public static void main(String[] args) {
		new login();
		}
		// TODO Auto-generated method stub

	}
	




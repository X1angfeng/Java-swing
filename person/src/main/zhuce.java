package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;

import person.StringUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class zhuce extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5317561136817123612L;
	public static String userId;
	//创建窗体并设计标题    
JFrame jfrm=new JFrame("个人信息管理系统"); 
	//创建3个面板
JPanel jp1=new JPanel();
JPanel jp2=new JPanel();
JPanel jp3=new JPanel();

	//创建3个标签
JLabel jl1=new JLabel("请注册后使用哦",JLabel.CENTER);
JLabel jl2=new JLabel("账        号:");
JLabel jl3=new JLabel("登录密码:");

	//创建2个文本输入框
JTextField jtf1=new JTextField(13);
JPasswordField jtf2=new JPasswordField(13);

    //创建2个按钮
JButton jb1=new JButton("ฅʕ•̫͡•ʔฅ注册");
JButton jb2=new JButton("(●'◡'●)返回");


    //构造方法
public zhuce() {

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
jb1.setSelected(true);

jfrm.add(jp1);
jfrm.add(jp2);
jfrm.add(jp3);
jfrm.add(jb1);
jfrm.add(jb2);
jb1.addActionListener(this);
jb2.addActionListener(this);
jb1.setBounds(80,200,110,30);
jb2.setBounds(200,200,110,30);
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

if(jb1.isSelected())  //非管理员登陆
	{
	 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
     String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=java";
     String userName="sa";
     String userPwd="123";
     userId = jtf1.getText();  //非管理员的账号
	 String passWord = new String(jtf2.getText());;  //普通用户的密码
    
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
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	 Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = java","sa","123");
	// 建立注册插入语句
	 String sql1 = "insert into usedata values ('"+jtf1.getText()+"','"+jtf2.getText()+"')";
	 
	 PreparedStatement pstm = conn.prepareStatement(sql1);
	 // 执行查询
	 pstm.executeUpdate();
	 
	 JOptionPane.showMessageDialog(null, "注册成功");
	 }
	catch(ClassNotFoundException cnfe){
	JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
	}catch(SQLException sqle){
	JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
	}
catch(Exception e1)
		 { 
			 e1.printStackTrace(); 
		 }}}
		         else if(e.getSource()==jb2)
		         {
		        	 new login();  
		          }
		}
	public static void main(String[] args) {
		new zhuce();
		}
		// TODO Auto-generated method stub

	}
	




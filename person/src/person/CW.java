package person;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

import main.login;

public class CW extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7102254763292865628L;
	JLabel jl1;
	JTable jt1;
	DefaultTableModel  model;
	JButton jb1,jb2;
	JPanel pan1,pan2;
	JScrollPane scrollPan ;
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=java";
	String userName="sa";
	String userPwd="123";
	String[] title = {"消费时间","消费项目","消费金额","剩余资金","总收入"};
	Object[][]  A={};
	int count;	
	public CW(String userId) {
		model = new DefaultTableModel(A,title); 
	    jt1 = new JTable(A,title);
	    jt1.setModel(model);
	    scrollPan = new JScrollPane(jt1);
	    scrollPan.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPan.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		scrollPan.setPreferredSize(new Dimension(300, 200));	
		jl1 = new JLabel("个人财务");
		jl1.setFont(new Font("黑体",1,30));
		jl1.setForeground(Color.BLUE);
		jb1 = new JButton("财务信息被👽抓走了");
		jb2 = new JButton("财务信息管理");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		pan1 = new JPanel();
		pan1.setLayout(null);
		pan2 = new JPanel();
		pan2.setLayout(new FlowLayout(FlowLayout.CENTER));
		pan2.add(jb1);
		pan2.add(jb2);
	    try 
	    {
	    	Class.forName(driverName);
	                       }
	    catch(Exception e) 
	    {
	        e.printStackTrace();
	                       }
		try 
		{
			Connection con=DriverManager.getConnection(dbURL,userName,userPwd); 
		   	Statement s=con.createStatement( ); 
		   	String r1="select ftime,project,fmoney,Balance,income from finance where ID='"+userId+"'";
		   	ResultSet rs=s.executeQuery(r1);
		   	int count = 0;	
		   	while(rs.next())
		   	{
		   		count++;
		   	}
		    Object[][]  A = new Object[count][10];
		    count = 0;
		    model.setRowCount(0);
		    rs=s.executeQuery(r1);
		    while(rs.next())
		    {
		    	A[count][0]=rs.getString("ftime");
		    	A[count][1]=rs.getString("project");
		    	A[count][2]=rs.getString("fmoney");
		    	A[count][3]=rs.getString("Balance");
		    	A[count][4]=rs.getString("income");
		    	model.addRow(A[count]);
		    	count++;
		    }
			s.close( );  
			con.close( );  
		}
		catch(Exception ex)
		 { 
		  ex.printStackTrace();
		   }
		pan1.add(jl1);
		pan1.add(scrollPan);
		//jl1.setBackground(Color.magenta);
		//jl1.setForeground(Color.BLACK);
		jl1.setBounds(190, 5, 400, 60);
		scrollPan.setBounds(10, 70, 470, 320);
		
		pan1.setSize(600, 600);
		//setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		add(pan1,BorderLayout.CENTER);add(pan2,BorderLayout.SOUTH);
	}
		// TODO Auto-generated constructor stub
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		   try 
		    {
		    	Class.forName(driverName);
		    }
		    catch(Exception e1) 
		    {
		    	e1.printStackTrace();
		          }
		   if(e.getSource() == jb2)
			{

				new finance(); 
				}
		   else if(e.getSource() == jb1)		//页面刷新
			{
			try 
		{
			Connection con=DriverManager.getConnection(dbURL,userName,userPwd);		   
			Statement s=con.createStatement( ); 
			String r1="select ftime,project,fmoney,Balance,income from finance  where ID='"+login.userId+"'";
		   ResultSet rs=s.executeQuery(r1);
			   	int count = 0;	
			   	while(rs.next())
			   	{
			   		count++;
			   	}
			    Object[][]  A = new Object[count][5];
			    count = 0;
			    model.setRowCount(0);
			    rs=s.executeQuery(r1);
			    while(rs.next())
			    {                     
			    	A[count][0]=rs.getString("ftime");
			    	A[count][1]=rs.getString("project");
			    	A[count][2]=rs.getString("fmoney");
			    	A[count][3]=rs.getString("Balance");
			    	A[count][4]=rs.getString("income");
			    	model.addRow(A[count]);
			    	count++;
			    }
				s.close( );  
				con.close( );  
			}
			catch(SQLException ex)
			{ 
			    JOptionPane.showMessageDialog(null, "SQLException: " +ex.getMessage( )); 
			}}}
		// TODO Auto-generated method stub

	}



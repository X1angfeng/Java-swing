package admin;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class UBW extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3869246393497680041L;
	JLabel jl1;
	JTable jt1;
	DefaultTableModel  model;
	JButton jb1,jb2,jb4;
	JPanel pan1,pan2;
	JScrollPane scrollPan ;
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=java";
	String userName="sa";
	String userPwd="123";
	String[] title = {"用户","时间","地点","事件"};
	Object[][]  A={};
	int count;	
	public UBW()
	{
	    model = new DefaultTableModel(A,title); 
	    jt1 = new JTable(A,title);
	    jt1.setModel(model);
	    scrollPan = new JScrollPane(jt1);
	    scrollPan.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPan.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		scrollPan.setPreferredSize(new Dimension(300, 200));	
		jl1 = new JLabel("用户备忘录管理");
		jl1.setFont(new Font("",1,30));
		jl1.setForeground(Color.BLUE);
		jb1 = new JButton("修改备忘信息");
		jb2 = new JButton("删除备忘信息");
		jb4 = new JButton("刷新数据");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb4.addActionListener(this);
		pan1 = new JPanel();
		pan1.setLayout(null);
		pan2 = new JPanel();
		pan2.setLayout(new FlowLayout(FlowLayout.CENTER));
		pan2.add(jb4);
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
    String r1="select * from memo";
    ResultSet rs=s.executeQuery(r1);
		   	int count = 0;	
           while(rs.next())
		   {
		   		count++;
		   	           }
		    Object[][]  A = new Object[count][4];
		    count = 0;
		    model.setRowCount(0);
		    rs=s.executeQuery(r1);
		    while(rs.next())
		    {   A[count][0]=rs.getString("ID");
		    	A[count][1]=rs.getString("mtime");
		    	A[count][2]=rs.getString("mlocation");
		    	A[count][3]=rs.getString("mevent");
		    	model.addRow(A[count]);
		    	count++;
		    }
			s.close( );  
			con.close( );  
		           }
		catch(SQLException ex)
		{ 
		   ex.printStackTrace();
		           }
		pan1.add(jl1);
		pan1.add(scrollPan);
		//jt1.setBackground(Color.black);
		//jl1.setForeground(Color.black);
		jl1.setBounds(190, 5, 400, 60);
		scrollPan.setBounds(10, 70, 470, 320);
		pan1.setSize(600, 600);
		//setBackground(Color.black);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		add(pan1,BorderLayout.CENTER);add(pan2,BorderLayout.SOUTH);
	                              }
	@Override
	
	public void actionPerformed(ActionEvent e) {
		Connection con = null;
		PreparedStatement prestmt= null ; //预处理
		
		
		try 
	    {
	    	Class.forName(driverName);
	              }
	    catch(Exception e1) 
	    {
	    	e1.printStackTrace();
	              }
		
		if(e.getSource() == jb1)
		{
	
			new umemo();
		}
		           
		 if(e.getSource() == jb2)
		{

			new umemo(); 
			}
		           
		
		else if(e.getSource() ==jb4)
		{
			try 
{
	Connection con1=DriverManager.getConnection(dbURL,userName,userPwd);// 
			   	Statement s=con1.createStatement( ); 
			   	String r1="select * from memo";
			   	ResultSet rs=s.executeQuery(r1);
			   	int count = 0;	
			   	while(rs.next())
			   	{
			   		count++;
			   	}
			    Object[][]  A = new Object[count][6];
			    count = 0;
			    model.setRowCount(0);
			    rs=s.executeQuery(r1);
			    while(rs.next())
			    {   
			    	A[count][0]=rs.getString("ID");
			    	A[count][1]=rs.getString("mtime");
			    	A[count][2]=rs.getString("mlocation");
			    	A[count][3]=rs.getString("mevent");
			    	model.addRow(A[count]);
			    	count++;
			    }
				s.close( );  
				con1.close( );  
			
			}
			catch(SQLException ex)
			{ 
			    ex.printStackTrace();
			}}}
		// TODO Auto-generated method stub

	}



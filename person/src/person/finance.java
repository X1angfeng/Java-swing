package person;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import main.login;
public class finance {
	    JFrame frm =new JFrame("财务信息管理");  //创建窗口对象
	    JLabel sj = new JLabel("消费时间:");   //创建标签对象
	    JLabel xm = new JLabel("消费项目:");   //创建标签对象
	    JLabel je = new JLabel("消费金额 :");   //创建标签对象
	    JLabel sy = new JLabel("剩余资金 :");   //创建标签对象
	    JLabel zs = new JLabel("总收入 :");   //创建标签对象
	    JLabel yh = new JLabel("用户名 :");   //创建标签对象
	    
	    JTextField ab=new JTextField(); //创建时间文本框
	    JTextField ac=new JTextField(); //创建项目文本框
	    JTextField ad=new JTextField(); //创建消费金额文本框
	    JTextField ae=new JTextField(); //创建剩余资金文本框
	    JTextField af=new JTextField(); //创建总收入文本框
	    JTextField ag=new JTextField(); //创建总收入文本框

	    JButton lr=new JButton("录入");//创建录入按钮
	    JButton sc=new JButton("删除");//创建录入按钮
	    JButton fh=new JButton("返回");//创建返回按钮
	    JButton xg=new JButton("修改");

	    
	    
	    
	    public finance()
		{

	    	  	    	
	      frm.setSize(500, 520);    //设置窗口大小
	      Container c = frm.getContentPane();
	      c.setBackground(Color.white);   //设置窗口颜色	
	      
	      sj.setForeground(Color.black); //设置标签前景颜色
	      sj.setLocation(60,20);  //标签位置
	      sj.setSize(90, 30);    //标签大小
	      
	      xm.setForeground(Color.black); //设置标签前景颜色
	      xm.setLocation(60,80);  //标签位置
	      xm.setSize(90, 30);    //标签大小
	      
	      je.setForeground(Color.black); //设置标签前景颜色
	      je.setLocation(60,140);  //标签位置
	      je.setSize(90, 30);    //标签大小
	      
	      sy.setForeground(Color.black); //设置标签前景颜色
	      sy.setLocation(60,200);  //标签位置
	      sy.setSize(90, 30);    //标签大小
	      
	      zs.setForeground(Color.black); //设置标签前景颜色
	      zs.setLocation(60,260);  //标签位置
	      zs.setSize(90, 30);    //标签大小
	      
	      yh.setForeground(Color.black); //设置标签前景颜色
	      yh.setLocation(60,320);  //标签位置
	      yh.setSize(90, 30);    //标签大小
	

	      
	      frm.setLayout(null);      //取消布局管理
	      

	      ab.setBounds(130,23,242,28);

	      ac.setBounds(130,83,242,28);

	      ad.setBounds(130,143,242,28);
	      
	      ae.setBounds(130,203,242,28);
	      
	      af.setBounds(130,263,242,28);
	      
	      ag.setBounds(130,323,242,28);
	      

	      lr.setBounds(40,380,100,60);//录入大小位置
	      sc.setBounds(150,380,100,60);//删除大小位置
	      fh.setBounds(370,380,100,60);//返回大小位置
	      xg.setBounds(260,380,100,60);
	    		  fh.addActionListener(new ActionListener() {
		  				public void actionPerformed(ActionEvent e) {	
		  					frm.setVisible(false);
		  				}		
		  			});  
	    		  xg.addActionListener(new ActionListener() {
		  				public void actionPerformed(ActionEvent e) {	
		  					try{Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							 Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = java","sa","123");
							// 建立查询条件
							 String sql = "update finance set project='"+ac.getText()+"',fmoney='"+ad.getText()+"',Balance='"+ae.getText()+"',income='"+af.getText()+"',ID='"+ag.getText()+"' where ftime='"+ab.getText()+"'and ID='"+login.userId+"'";
							 		
							 
							 PreparedStatement pstm = conn.prepareStatement(sql);
							 // 执行查询
							 pstm.executeUpdate();
							 
							 JOptionPane.showMessageDialog(frm, "修改成功");}
					
							catch(ClassNotFoundException cnfe){
							JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
						}catch(SQLException sqle){
							JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
							}
						}
		  			});  
	    		  
	    		  lr.addActionListener(new ActionListener() {
	  				public void actionPerformed(ActionEvent e) {	
	  					try{Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						 Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = java","sa","123");
						// 建立查询条件
						 String sql1 = "insert into finance (ftime,project,fmoney,Balance,income,ID) values ('"+ab.getText()+"','"+ac.getText()+"','"+ad.getText()+"','"+ae.getText()+"','"+af.getText()+"','"+ag.getText()+"')";
						 
						 PreparedStatement pstm = conn.prepareStatement(sql1);
						 // 执行查询
						 pstm.executeUpdate();
						 
						 JOptionPane.showMessageDialog(frm, "添加成功");}
				
						catch(ClassNotFoundException cnfe){
						JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
					}catch(SQLException sqle){
						JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
						}
					}
	  			});  
	    		  
	    		  
	    		  sc.addActionListener(new ActionListener() {
	  				public void actionPerformed(ActionEvent e) {	
	  					try{Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						 Connection conn2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName = java","sa","123");
						// 建立查询条件
						 String sql2 = " delete from finance where ftime ='"+ab.getText()+"' and ID='"+login.userId+"'";
						 
						 PreparedStatement pstm2 = conn2.prepareStatement(sql2);
						 // 执行查询
						 pstm2.executeUpdate();
						 
						 JOptionPane.showMessageDialog(frm, "删除成功");}
				
						catch(ClassNotFoundException cnfe){
						JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
					}catch(SQLException sqle){
						JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
						}
					}
	  				
	  			});  
	    		  
	    		 

				
	      frm.add(ab);
	      frm.add(ac);
	      frm.add(ad);
	      frm.add(ae);
	      frm.add(af);
	      frm.add(ag);
	      frm.add(lr);
	      frm.add(sj);
	      frm.add(xm);
	      frm.add(je);
	      frm.add(sy);
	      frm.add(zs);
	      frm.add(yh);
	      frm.add(sc);
	      frm.add(fh);
	      frm.add(xg);
	      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frm.setVisible(true);

		}
		public static void main(String[] args) {finance frm=new finance();}
	}



package person;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import main.login;
public class communication {
	    JFrame frm =new JFrame("通讯录信息操作");  //创建窗口对象
	    JLabel dh = new JLabel("电话号码:");   //创建标签对象
	    JLabel xm = new JLabel("姓名  :");   //创建标签对象
	    JLabel cs = new JLabel("城市 :");   //创建标签对象
	    JLabel sl = new JLabel("工作地点 :");   //创建标签对象
	    JLabel bz = new JLabel("备注 :");   //创建标签对象
	    JLabel yh = new JLabel("用户 :");   //创建标签对象
	    
	    JTextField ab=new JTextField(); //创建电话文本框
	    JTextField ac=new JTextField(); //创建姓名文本框
	    JTextField ad=new JTextField(); //创建城市文本框
	    JTextField ae=new JTextField(); //创建工作地点文本框
	    JTextField af=new JTextField(); //创建备注文本框
	    JTextField ag=new JTextField(); //创建备注文本框
	    
	    JButton lr=new JButton("录入");//创建录入按钮
	    JButton sc=new JButton("删除");//创建录入按钮
	    JButton fh=new JButton("返回");//创建返回按钮
	    JButton xg=new JButton("修改");

	    
	    
	    
	    public communication()
		{

	    	  	    	
	      frm.setSize(500, 520);    //设置窗口大小
	      Container c = frm.getContentPane();
	      c.setBackground(Color.white);   //设置窗口颜色	
	      
	      dh.setForeground(Color.black); //设置标签前景颜色
	      dh.setLocation(60,20);  //标签位置
	      dh.setSize(90, 30);    //标签大小
	      
	      xm.setForeground(Color.black); //设置标签前景颜色
	      xm.setLocation(60,80);  //标签位置
	      xm.setSize(90, 30);    //标签大小
	      
	      cs.setForeground(Color.black); //设置标签前景颜色
	      cs.setLocation(60,140);  //标签位置
	      cs.setSize(90, 30);    //标签大小
	      
	      sl.setForeground(Color.black); //设置标签前景颜色
	      sl.setLocation(60,200);  //标签位置
	      sl.setSize(90, 30);    //标签大小
	      
	      bz.setForeground(Color.black); //设置标签前景颜色
	      bz.setLocation(60,260);  //标签位置
	      bz.setSize(90, 30);    //标签大小
	      
	      yh.setForeground(Color.black); //设置标签前景颜色
	      yh.setLocation(60,320);  //标签位置
	      yh.setSize(90, 30); 

	      
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
							 String sql = "update communication set cname='"+ac.getText()+"',city='"+ad.getText()+"',place='"+ae.getText()+"',remarks='"+af.getText()+"', ID='"+ag.getText()+" 'where telephone='"+ab.getText()+"'and ID='"+login.userId+"'";
							 		
							 
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
						 String sql1 = "insert into communication (telephone,cname,city,place,remarks,ID) values ('"+ab.getText()+"','"+ac.getText()+"','"+ad.getText()+"','"+ae.getText()+"','"+af.getText()+"','"+ag.getText()+"')";
						 
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
						 String sql2 = " delete from communication where telephone ='"+ab.getText()+"' and ID='"+login.userId+"'";
						 
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
	      frm.add(dh);
	      frm.add(xm);
	      frm.add(bz);
	      frm.add(yh);  
	      frm.add(sl);
	      frm.add(cs);
	      frm.add(sc);
	      frm.add(fh);
	      frm.add(xg);
	      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frm.setVisible(true);

		}
		public static void main(String[] args) {communication frm=new communication();}
	}



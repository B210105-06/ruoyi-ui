package shixun;

	import java.awt.Color;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.*;

	import javax.swing.*;
	import javax.swing.*;
	import javax.swing.table.JTableHeader;
	import javax.swing.table.TableColumn;

	import java.sql.*;
	import java.util.Enumeration;
import java.util.Vector;
	public class  YuanzhangYe extends JFrame implements ActionListener{

		/**
		 * 辅导员查看学生请假信息模块
		 */
		JLabel imagelabel;;//背景图片
		JButton jb1=new JButton("审核请假信息");
		JButton jb2=new JButton("学生请假记录");
		JButton jb3=new JButton("已批假记录");
		JButton jb4=new JButton("通过审核");
		JButton jb6=new JButton("审核不通过");
		JButton jb5=new JButton("退出");
		JButton jb7=new JButton("修改密码");
		
		 Vector rowData,columnNames;  
		    JTable jt=null;  
		    JScrollPane jsp=null;  
		    Connection ct=null;  
		    ResultSet rs=null;      
		    Statement ps=null;
		    String name1;
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			YuanzhangYe y=new	YuanzhangYe(null);
		}



			
		
		
	public YuanzhangYe(String name){
		name1=name;
		this.setTitle(name1+"院长请假信息系统");
		this.setLocation(550,200);
		this.setSize(700,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		ImageIcon image=new ImageIcon("image/2.jpg");
		imagelabel = new JLabel(image);
	    imagelabel.setBounds(0,0,700,500);
		//JTable table=new JTable(tableValues,columnNames);//创建指定列名和数据的表格
//		JScrollPane scrollpane=new JScrollPane(table);//创建显示表格的滚动面板
//		//FitTableColumns(table);
//		table.setRowHeight(40);
	  // table.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer()); 
		
		//JTableAUTO_RESIZE_ALL_COLUMNS;
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//JTable.AUTO_RESIZE_OFF
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		 columnNames=new Vector();  
		    //设置列名  
		    columnNames.add("姓名");  
		    columnNames.add("学号");  
		    columnNames.add("专业");
		    columnNames.add("联系");  
		    columnNames.add("开始日期");  
		    columnNames.add("结束日期");  
		    columnNames.add("请假事由");  
		    columnNames.add("学生账号");  
		   
		    rowData = new Vector();  
		    //rowData可以存放多行,开始从数据库里取  
			 try {  
		         Class.forName("com.mysql.jdbc.Driver");
		 		//(2)获取数据库连接
				 Connection ct= DriverManager.getConnection("jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8", "root", "root");
		 		//Connection ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shixun?useUnicode=true&amp;characterEncoding=utf_8","root", "root");

		     //    Connection ct=DriverManager.getConnection("jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8","root", "aly66MYSQL!!!");
		 		//（3）创建SQL语句对象
		 		Statement ps=ct.createStatement();
		 		
		 		//(4)执行查询，返回结果集
		 		ResultSet rs=ps.executeQuery("SELECT * FROM user4");//读取数据表信息
		         
		       while(rs.next()){  
		             //rowData可以存放多行  
		             Vector hang=new Vector();  
		             hang.add(rs.getString(1));  
		             hang.add(rs.getString(2));  
		          //   hang.add(rs.getString(2).getBytes("lS08859-1"));  
		             hang.add(rs.getString(3));  
		          //   hang.add(rs.getInt(4));  
		             hang.add(rs.getString(4));  
		             hang.add(rs.getString(5));  
		             hang.add(rs.getString(6));  
		             hang.add(rs.getString(7));
		             hang.add(rs.getString(8));
		             //加入到rowData  
		             rowData.add(hang);  //将信息加进表格
		         }  
		     } catch (Exception e) {  
		         e.printStackTrace();  
		     } finally{  
		           
		             try {  
		                 if(rs!=null){  
		                 rs.close();  
		                 }  
		                 if(ps!=null){  
		                     ps.close();  
		                 }  
		                 if(ct!=null){  
		                     ct.close();  
		                 }  
		             } catch (SQLException e) {  
		                 e.printStackTrace();  
		             }  
		     
		        
		     //初始化Jtable  
		     jt = new JTable(rowData,columnNames);  
		     jt.setRowHeight(40);
		    jt.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer()); 
		    
		     //初始化 jsp  
		     jsp = new JScrollPane(jt);  
		    // FitTableColumns(jt); 
		     //把jsp放入到jframe  
			
		
		
		jb1.setOpaque(false);
		jb1.setFont(new Font("简宋",Font.PLAIN,18));
		jb2.setOpaque(false);
		jb2.setFont(new Font("简宋",Font.PLAIN,18));
		jb3.setOpaque(false);
		jb3.setFont(new Font("简宋",Font.PLAIN,18));
		jb4.setOpaque(false);
		jb4.setFont(new Font("简宋",Font.PLAIN,18));
		jb4.setForeground(Color.white);
		jb5.setForeground(Color.white);
		jb6.setForeground(Color.white);
		jb7.setForeground(Color.white);
		jb5.setOpaque(false);
		jb5.setFont(new Font("简宋",Font.PLAIN,18));
		jb6.setOpaque(false);
		jb6.setFont(new Font("简宋",Font.PLAIN,18));
		jb7.setOpaque(false);
		jb7.setFont(new Font("简宋",Font.PLAIN,18));
		jb1.setBackground(new Color(233,240,247));
		jb2.setBackground(new Color(233,240,247));
	    jb3.setBackground(new Color(233,240,247));
	    jb4.setBackground(new Color(233,240,247));
	    jb5.setBackground(new Color(233,240,247));
	    jb6.setBackground(new Color(233,240,247));
	    jb7.setBackground(new Color(233,240,247));



		jb1.setBounds(5, 0, 233, 50);
		jb2.setBounds(236, 0, 223, 50);
		jb3.setBounds(457, 0, 223, 50);
		jb4.setBounds(165, 400, 130, 50);
		jb5.setBounds(305, 400, 130, 50);
		jb6.setBounds(10, 400, 130, 50);
		//scrollpane.setBounds(5, 65, 675, 320);
		jsp.setBounds(5, 65, 675, 320);
		jb7.setBounds(440, 400, 130, 50);
		//jt.setBounds(30,80,620,300);
		//jt.setEditable(false);//设计文本框不能外部输入
		// jt.setFont(new Font("简宋",Font.PLAIN,18));
		jb1.addActionListener(this);	
		jb2.addActionListener(this);	
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		jb7.addActionListener(this);
		
	    this.add(jb1);
	    this.add(jb2);
	    this.add(jb3);
	    this.add(jb4);
	    this.add(jb5);
	    this.add(jb6);
	    this.add(jb7);
	   // this.add(jt);
	    //this.add(scrollpane);
	    this.add(jsp);
	    this.add(imagelabel);
	    this.setVisible(true);}
	//
//		FileReader fr=null;
//		//写入文件（输出流）
//		//FileWriter fw=null;
	//	
//		try {
//			//创建fir对象
//			fr = new FileReader("d:\\student1.txt");
//			
//			
//			int n=0;//实际读取的字符数
//			//读入到内存
//			char c[]=new char[10024];
//			
//			while((n=fr.read(c))!=-1){
//				//System.out.println(c);
//				String s= new String(c,0,n);
//				
//				jt.setText(s);
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
		
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource().equals(jb7)){//修改密码按钮事件
			 String s="院长";
			 ChangePassword cp=new ChangePassword(name1,s);
				this.dispose();
			 
			} 
		  if(e.getSource().equals(jb5)){//退出按钮事件
				//this.dispose();
			  System.exit(0);
			}  
		
		if(e.getSource().equals(jb3)){//已批假记录按钮事件
			//CounsellorLookRecord clr=new CounsellorLookRecord();
			
			YuanzhangYe3 y3=new YuanzhangYe3(name1);
			this.dispose();
			
		}  
		if(e.getSource().equals(jb2)){//学生请假记录按钮事件
			YuanzhangYe2 y=new	YuanzhangYe2(name1);
			this.dispose();
		}  
		if(e.getSource().equals(jb1)){//审核请假信息按钮事件
			JOptionPane.showMessageDialog(null, "你已处于当前界面");
		}  
		
		if(e.getSource().equals(jb4)){//通过审核按钮事件

	   int count=jt.getSelectedRow();//获取你选中的行号（记录）
	   //int coulumn=jt.getSelectedColumn();
	    String getname= jt.getValueAt(count,0).toString();//读取你获取行号的某一列的值（也就是字段）;

	    String getname1= jt.getValueAt(count,1).toString();
	    String getname2= jt.getValueAt(count,2).toString();
	    String getname3= jt.getValueAt(count,3).toString();
	    String getname4= jt.getValueAt(count,4).toString();
	    String getname5= jt.getValueAt(count,5).toString();
	    String getname6= jt.getValueAt(count,6).toString();
	    String getname7= jt.getValueAt(count,7).toString();
	   
	     System.out.println(getname+"    "+getname1+"     "+getname2+"    "+getname3+"  "+getname4+"   "+getname5+"   "+getname6+"    "+getname7);
		
	     try {  
	         Class.forName("com.mysql.jdbc.Driver");
	 		//(2)获取数据库连接
	 		
	 //	Connection ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shixun?useUnicode=true&amp;characterEncoding=utf_8","root", "root");
			 Connection ct= DriverManager.getConnection("jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8", "root", "root");
	    //     Connection ct=DriverManager.getConnection("jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8","root", "aly66MYSQL!!!");
	 		//（3）创建SQL语句对象
	 		Statement ps=ct.createStatement();
	 		
	 		//(4)执行查询，返回结果集
	 	//	ResultSet rs=ps.executeQuery("SELECT * FROM user2");
	 		String sql="delete from user4 where a='"+getname+"'";//在数据表中删除表格中所选行的内容
	 		
			//String sql="delete from byc where id='4'";   //SQL语句
	 		// Statement state=ct.createStatement(); 
	        ps.executeUpdate(sql);         //将sql语句上传至数据库执行
            String s="pass";
	        String sql1 = "INSERT INTO user3(a,b,c,d,e,f,g,h,i) VALUES('"+getname+"','"+getname1+"','"+getname2+"','"+getname3+"','"+getname4+"','"+getname5+"','"+getname6+"','"+getname7+"','"+s+"')";
			ps.executeUpdate(sql1);         //将sql语句上传至数据库执行


			
	     } catch (Exception e1) {  
	         e1.printStackTrace();  
	     } finally{  
	           
	             try {  
	            //    if(rs!=null){  
	            //     rs.close();  
	            //     }  
	                 if(ps!=null){  
	                     ps.close();  
	                 }  
	                 if(ct!=null){  
	                     ct.close();  
	                 }  
	             } catch (SQLException e1) {  
	                 e1.printStackTrace();  
	             }  
	             JOptionPane.showMessageDialog(null, "提交成功");
	         	YuanzhangYe y=new	YuanzhangYe(name1);//刷新表格信息
	     }}
			

	             
	             if(e.getSource().equals(jb6)){//审核不通过按钮事件
	            	 int count=jt.getSelectedRow();//获取你选中的行号（记录）
	            	  String getname= jt.getValueAt(count,0).toString();//读取你获取行号的某一列的值（也就是字段）;

	            	    String getname1= jt.getValueAt(count,1).toString();
	            	    String getname2= jt.getValueAt(count,2).toString();
	            	    String getname3= jt.getValueAt(count,3).toString();
	            	    String getname4= jt.getValueAt(count,4).toString();
	            	    String getname5= jt.getValueAt(count,5).toString();
	            	    String getname6= jt.getValueAt(count,6).toString();
	            	    String getname7= jt.getValueAt(count,7).toString();
	            	   
	            	     System.out.println(getname+"    "+getname1+"     "+getname2+"    "+getname3+"  "+getname4+"   "+getname5+"   "+getname6+"    "+getname7);
	            		
	            	     try {  
	            	         Class.forName("com.mysql.jdbc.Driver");
	            	 		//(2)获取数据库连接
	            	 		
	            //	 	Connection ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shixun?useUnicode=true&amp;characterEncoding=utf-8","root", "root");
							 Connection ct= DriverManager.getConnection("jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8", "root", "root");
	            	  //    	Connection ct=DriverManager.getConnection("jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8","root", "aly66MYSQL!!!");	        
	            	         
	            	         //（3）创建SQL语句对象
	            	 		Statement ps=ct.createStatement();
	            	 		
	            	 		//(4)执行查询，返回结果集
	            	 	//	ResultSet rs=ps.executeQuery("SELECT * FROM user2");
	            	 		String sql="delete from user4 where a='"+getname+"'";//在数据表中删除表格中所选行的内容
	            	 		
	            			//String sql="delete from byc where id='4'";   //SQL语句
	            	 		// Statement state=ct.createStatement(); 
	            	        ps.executeUpdate(sql);         //将sql语句上传至数据库执行

	            	//        String sql1 = "INSERT INTO user3(a,b,c,d,e,f,g,h) VALUES('"+getname+"','"+getname1+"','"+getname2+"','"+getname3+"','"+getname4+"','"+getname5+"','"+getname6+"','"+getname7+"')";
	            	//		ps.executeUpdate(sql1);         //将sql语句上传至数据库执行


	            			
	            	     } catch (Exception e1) {  
	            	         e1.printStackTrace();  
	            	     } finally{  
	            	           
	            	             try {  
	            	            //    if(rs!=null){  
	            	            //     rs.close();  
	            	            //     }  
	            	                 if(ps!=null){  
	            	                     ps.close();  
	            	                 }  
	            	                 if(ct!=null){  
	            	                     ct.close();  
	            	                 }  
	            	             } catch (SQLException e1) {  
	            	                 e1.printStackTrace();  
	            	             }  
	            	 
	         		JOptionPane.showMessageDialog(null, "提交成功");
	         		YuanzhangYe y=new	YuanzhangYe(name1);}//刷新
	             }
		}
		public static void FitTableColumns(JTable myTable) {
		    JTableHeader header = myTable.getTableHeader();
		    int rowCount = myTable.getRowCount();

		    Enumeration columns = myTable.getColumnModel().getColumns();
		    while (columns.hasMoreElements()) {
		        TableColumn column = (TableColumn) columns.nextElement();
		        int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
		        int width = (int) myTable.getTableHeader().getDefaultRenderer()
		                .getTableCellRendererComponent(myTable, column.getIdentifier(), false, false, -1, col)
		                .getPreferredSize().getWidth();
		        for (int row = 0; row < rowCount; row++) {
		            int preferedWidth = (int) myTable.getCellRenderer(row, col)
		                    .getTableCellRendererComponent(myTable, myTable.getValueAt(row, col), false, false, row, col)
		                    .getPreferredSize().getWidth();
		            width = Math.max(width, preferedWidth);
		        }
		        header.setResizingColumn(column);
		        column.setWidth(width + myTable.getIntercellSpacing().width + 10);
		    
		
		    }}

	}



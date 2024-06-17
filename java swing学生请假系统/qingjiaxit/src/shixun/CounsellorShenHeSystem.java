package shixun;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Connection;

import java.sql.*;
import java.util.Enumeration;
import java.util.Vector;
public class  CounsellorShenHeSystem extends JFrame implements ActionListener{

	/**
	 * 辅导员查看学生请假信息模块
	 */
	  JLabel imagelabel;;//背景图片
	JButton jb1=new JButton("审核请假信息");
	JButton jb2=new JButton("审核销假信息");
	JButton jb3=new JButton("学生请假记录");
	JButton jb4=new JButton("通过审核");
	JButton jb6=new JButton("审核不通过");
	JButton jb5=new JButton("退出");
	JButton jb7=new JButton("上交院长");
	JButton jb8=new JButton("修改密码");
	//JTextArea jt=new JTextArea();
//	String[] columnNames={"姓名","学号","专业","联系","开始日期","结束日期","请假状态","请假事由"};//定义表格列名数
//	String[][] tableValues={{"陈锦贤","182017331","计算机","15119747306","2019-9-23-17:55","2019-9-23-19:14","通过","因为想呆在宿舍"},{"21","22","23","24","25","26","27","28"},{"","","","","","","",""},
//			{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
//			{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
//			{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""}};//定义表格数据数组
//	
//			JTable table=new JTable(tableValues,columnNames);//创建指定列名和数据的表格
	
	 Vector rowData,columnNames;  
	    JTable jt=null;  
	    JScrollPane jsp=null;  
	    Connection ct=null;  
	    ResultSet rs=null;      
	    Statement ps=null;
	    String result;//该辅导员所管理的专业
//	    
//	    public static final String DBDRVER ="org.gjt.mm.mysql.Driver";
//		//定义MySQL数据库的连接地址
//		public static final String DBURL="jdbc:mysql://localhost:3306/shixun?characterEncoding=utf-8";
//		//MySQL数据库的连接用户名
//		public static final String DBUSER="root";
//		//MySQL数据库的连接密码
//		public static final String DBPASS="root";
	    int num1,num2,num3,num4,num5,num6,num7;
		String name1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 CounsellorShenHeSystem cshs=new  CounsellorShenHeSystem(null);
	}



		
	
	
public  CounsellorShenHeSystem(String name){
	
	name1=name;
	 check();//调用这个函数，读取登陆用户管理的专业的名字
	this.setTitle(name1+"辅导员管理请假信息系统");
	this.setLocation(550,200);
	this.setSize(700,500);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLayout(null);
	
	
	ImageIcon image=new ImageIcon("image/3.jpg");//设置背景图片
	imagelabel = new JLabel(image);
    imagelabel.setBounds(0,0,700,500);
	
	//JTable table=new JTable(tableValues,columnNames);//创建指定列名和数据的表格
//	JScrollPane scrollpane=new JScrollPane(table);//创建显示表格的滚动面板
//	//FitTableColumns(table);
//	table.setRowHeight(40);
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
	   String DBDRVER ="org.gjt.mm.mysql.Driver";
		//定义MySQL数据库的连接地址
	//	 String DBURL="jdbc:mysql://localhost:3306/shixun?characterEncoding=utf-8";
	   String DBURL="jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8";
	  // String DBURL="jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8";
		//MySQL数据库的连接用户名
		 String DBUSER="root";
		//MySQL数据库的连接密码
		 String DBPASS="root";
		// String DBPASS="aly66MYSQL!!!";
		 
		 try {  
	         Class.forName("com.mysql.jdbc.Driver");
	 		//(2)获取数据库连接
	 	//	Connection ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shixun?useUnicode=true&amp;characterEncoding=utf_8","root", "root");
	         ct=(Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);
	 		//（3）创建SQL语句对象
	 		Statement ps=ct.createStatement();
	 		
	 		//(4)执行查询，返回结果集
	 	//	ResultSet rs=ps.executeQuery("SELECT * FROM user2");
	 	String sql="select * from user2 where c='"+result+"'";  //假设要读的数据库表为user2
	 //String sql="SELECT * FROM user2";
		ResultSet rs=ps.executeQuery(sql);
	 	//	String sql="select * from cuserlist where name='"+name1+"'";
	       while(rs.next()){  
	    	   String a =rs.getString(1);
		      //  System.out.println(a);
		        String b =rs.getString(2);
		        String c =rs.getString(3);
		        String d =rs.getString(4);
		        String e =rs.getString(5);
		        String f =rs.getString(6);
		        String g =rs.getString(7);
		        String h =rs.getString(8);
	             Vector hang=new Vector();  
	             hang.add(a);  
	             hang.add(b);  
	          //   hang.add(rs.getString(2).getBytes("lS08859-1"));  
	             hang.add(c);  
	          //   hang.add(rs.getInt(4));  
	             hang.add(d);  
	             hang.add(e);  
	             hang.add(f);  
	             hang.add(g);
	             hang.add(h);
	             //rowData可以存放多行  
//	             Vector hang=new Vector();  
//	             hang.add(rs.getString(1));  
//	             hang.add(rs.getString(2));  
//	          //   hang.add(rs.getString(2).getBytes("lS08859-1"));  
//	             hang.add(rs.getString(3));  
//	          //   hang.add(rs.getInt(4));  
//	             hang.add(rs.getString(4));  
//	             hang.add(rs.getString(5));  
//	             hang.add(rs.getString(6));  
//	             hang.add(rs.getString(7));
	             //加入到rowData  
	             rowData.add(hang);  //把读取到的内容添加进表格
	             System.out.println(rs.getString(1));
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
	jb5.setOpaque(false);
	jb5.setFont(new Font("简宋",Font.PLAIN,18));
	jb6.setOpaque(false);
	jb6.setFont(new Font("简宋",Font.PLAIN,18));
	jb7.setOpaque(false);
	jb7.setFont(new Font("简宋",Font.PLAIN,18));
	jb8.setOpaque(false);
	jb8.setFont(new Font("简宋",Font.PLAIN,18));
	jb1.setBackground(new Color(233,240,247));
	jb2.setBackground(new Color(233,240,247));
    jb3.setBackground(new Color(233,240,247));
    jb4.setBackground(new Color(233,240,247));
    jb5.setBackground(new Color(233,240,247));
    jb6.setBackground(new Color(233,240,247));
    jb7.setBackground(new Color(233,240,247));
    jb8.setBackground(new Color(233,240,247));


	jb1.setBounds(5, 0, 233, 50);
	jb2.setBounds(236, 0, 223, 50);
	jb3.setBounds(457, 0, 223, 50);
	jb4.setBounds(230, 400, 223, 50);
	jb5.setBounds(450, 400, 223, 50);
	jb6.setBounds(10, 400, 223, 50);
	jb7.setBounds(150, 350, 450, 40);
	//scrollpane.setBounds(5, 65, 675, 320);
	jsp.setBounds(5, 65, 675, 280);
	jb8.setBounds(10, 350, 120, 40);
	jb8.setForeground(Color.white);
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
	jb8.addActionListener(this);
    this.add(jb1);
    this.add(jb2);
    this.add(jb3);
    this.add(jb4);
    this.add(jb5);
    this.add(jb6);
    this.add(jb7);
    this.add(jb8);
   
   // this.add(jt);
    //this.add(scrollpane);
    this.add(jsp);
    this.add(imagelabel);
    this.setVisible(true);}
//
//	FileReader fr=null;
//	//写入文件（输出流）
//	//FileWriter fw=null;
//	
//	try {
//		//创建fir对象
//		fr = new FileReader("d:\\student1.txt");
//		
//		
//		int n=0;//实际读取的字符数
//		//读入到内存
//		char c[]=new char[10024];
//		
//		while((n=fr.read(c))!=-1){
//			//System.out.println(c);
//			String s= new String(c,0,n);
//			
//			jt.setText(s);
//		}
//		
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		// TODO: handle exception
//	}
	
}


public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	 if(e.getSource().equals(jb8)){//修改密码按钮事件
		 String s="辅导员";
		 ChangePassword cp=new ChangePassword(name1,s);
			this.dispose();
		}  
	
	  if(e.getSource().equals(jb5)){//退出按钮事件
			this.dispose();
		}  
	
	if(e.getSource().equals(jb3)){//学生请假记录按钮事件
		//CounsellorLookRecord clr=new CounsellorLookRecord();
		CounsellorLookRecord clr=new CounsellorLookRecord(name1);
		this.dispose();
	}  
	if(e.getSource().equals(jb2)){//审核销假信息按钮事件
		JOptionPane.showMessageDialog(null, "对不起，该功能未开通");
	}  
	if(e.getSource().equals(jb1)){//审核请假信息按钮事件
		JOptionPane.showMessageDialog(null, "你已处于当前界面");
	}  
	
	if(e.getSource().equals(jb4)){//审核通过按钮事件

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
    System.out.println(getname+"    "+getname1+"     "+getname2+"    "+getname3+"  "+getname4+"   "+getname5+"   "+getname6+"    "+getname7);//控制台提醒输出内容
    String check1=getname4;
    String check2=getname5;
    String[] check3=check1.split("-");
    String[] check4=check2.split("-");
   // if(check3[4].equals("-")&&check3[6].equals("-")&&check4[4].equals("-")&&check4[6].equals("-")){
    	
    		 num1=Integer.parseInt(check3[2]);//日
    		 num2=Integer.parseInt(check4[2]);//日
    		 num7=Integer.parseInt(check3[1]);//月份
    		  num4=Integer.parseInt(check4[1]);//月份
    	   	  num5=Integer.parseInt(check3[1]);//月份
    	   	  System.out.println(num4);
    	   	 System.out.println(num3);
    	   	 System.out.println("没有");
    	if(num4==num5){//月份
    		 num3=num2-num1;
    	 }
   	 
    	if(num4>num5){
    		if(num7==2){
    			int n=29-num1;
    			
    		num3=n+num2;
    		}
    		if(num7==4||num7==6||num7==9||num7==11){
    			int n=30-num1;
    			num6=n+num2;
    		}
    		if(num7!=2||num7!=4||num7!=6||num7!=9||num7!=11){
    			int n=31-num1;
    			num3=n+num2;
    		}
    		
    	}
    	if(num3>3){
    		JOptionPane.showMessageDialog(null, "对不起,该请假时长超过3天,你没权限审核");
    	}
    		if(num3<3){
          System.out.println("时长为"+num3);
   
    
     String DBDRVER ="org.gjt.mm.mysql.Driver";
   		//定义MySQL数据库的连接地址
   	//	 String DBURL="jdbc:mysql://localhost:3306/shixun?characterEncoding=utf-8";
     String DBURL="jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8";
    // String DBURL="jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8";
   		//MySQL数据库的连接用户名
   		 String DBUSER="root";
   		//MySQL数据库的连接密码
   		 String DBPASS="root";
   		// String DBPASS="aly66MYSQL!!!";
     try {  
         Class.forName("com.mysql.jdbc.Driver");
 		//(2)获取数据库连接
 		
 //	Connection ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shixun?useUnicode=true&amp;characterEncoding=utf_8","root", "root");
 	//Connection ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shixun?useUnicode=true&amp;characterEncoding=gbk","root", "root");
         ct=(Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);
         //（3）创建SQL语句对象
 		Statement ps=ct.createStatement();
 		
 		//(4)执行查询，返回结果集
 	//	ResultSet rs=ps.executeQuery("SELECT * FROM user2");
 		String sql="delete from user2 where a='"+getname+"'";//删除表格中选择的行
 		
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
             CounsellorShenHeSystem cshs=new  CounsellorShenHeSystem(name1);//刷新内容
     }}
	}
//		  File f = new File("d:\\student1.txt");
//		  File f1 = new File("d:\\student2.txt");
//		//字节输出流
//		FileOutputStream fos=null;
//		FileOutputStream fos1=null;
//		
//		try {
//			fos = new FileOutputStream(f);
//			fos1 = new FileOutputStream(f1);
//		
//				String s1 = jt.getText()+"\r\n";//换行：/r/n
//				String s2 = "请假状态:"+"  "+"已通过审核";
//				String s3=jt.getText()+"\r\n";
//			//定义字节数组
//			byte []btyes = new byte[10024];
//			
//		
//			fos.write(s1.getBytes());
//			fos.write(s2.getBytes());
//			fos1.write(s3.getBytes());
//			fos1.write(s2.getBytes());
//			
//		} catch (Exception e1) {
//			e1.printStackTrace();
//			// TODO: handle exception
//		}finally{
//			try {
//				fos.close();
//				fos1.close();
//				
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//	//	JOptionPane.showMessageDialog(null, "提交成功");
//	
//	
//		
	//	jt.setText("");
             
             if(e.getSource().equals(jb6)){//审核不通过
            	 int count=jt.getSelectedRow();//获取你选中的行号（记录）
            	  String getname= jt.getValueAt(count,0).toString();//读取你获取行号的某一列的值（也就是字段）;

            	    String getname1= jt.getValueAt(count,1).toString();
            	    String getname2= jt.getValueAt(count,2).toString();
            	    String getname3= jt.getValueAt(count,3).toString();
            	    String getname4= jt.getValueAt(count,4).toString();
            	    String getname5= jt.getValueAt(count,5).toString();
            	    String getname6= jt.getValueAt(count,6).toString();
            	    String getname7= jt.getValueAt(count,7).toString();
            	    
            	    String check1=getname4;
            	    String check2=getname5;
            	    String[] check3=check1.split("-");
            	    String[] check4=check2.split("-");
            	    num1=Integer.parseInt(check3[2]);//日
              		 num2=Integer.parseInt(check4[2]);//日
              		 num7=Integer.parseInt(check3[1]);//月份
         
             	   num4=Integer.parseInt(check4[1]);//月份
             	  num5=Integer.parseInt(check3[1]);//月份
             		if(num4==num5){//月份
                 		 num3=num2-num1;
                 	 }
              	if(num4>num5){
              		if(num7==2){
              			int n=29-num1;
              			
              		num3=n+num2;
              		}
              		if(num7==4||num7==6||num7==9||num7==11){
              			int n=30-num1;
              			num3=n+num2;
              		}
              		if(num7!=2||num7!=4||num7!=6||num7!=9||num7!=11){
              			int n=31-num1;
              			num3=n+num2;
              		}
              		
              	}
              	if(num3>3){
              		JOptionPane.showMessageDialog(null, "对不起,该请假时长超过3天,你没权限审核");
              	}
              		if(num3<3){
            	     System.out.println(getname+"    "+getname1+"     "+getname2+"    "+getname3+"  "+getname4+"   "+getname5+"   "+getname6+"    "+getname7);
            	  
            	     String DBDRVER ="org.gjt.mm.mysql.Driver";
            			//定义MySQL数据库的连接地址
            		//	 String DBURL="jdbc:mysql://localhost:3306/shixun?characterEncoding=utf-8";
            	    String DBURL="jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8";
            	  //   String DBURL="jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8";
            			//MySQL数据库的连接用户名
            			 String DBUSER="root";
            			//MySQL数据库的连接密码
            			 String DBPASS="root";
            		//	 String DBPASS="aly66MYSQL!!!";
            	     try {  
            	         Class.forName("com.mysql.jdbc.Driver");
            	 		//(2)获取数据库连接
            	 		
            	 	//Connection ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shixun?useUnicode=true&amp;characterEncoding=utf_8","root", "root");
            	         ct=(Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);
            	         //（3）创建SQL语句对象
            	 		Statement ps=ct.createStatement();
            	 		
            	 		//(4)执行查询，返回结果集
            	 	//	ResultSet rs=ps.executeQuery("SELECT * FROM user2");
            	 		String sql="delete from user2 where a='"+getname+"'";//删除表格中选择的行
            	 		
            			//String sql="delete from byc where id='4'";   //SQL语句
            	 		// Statement state=ct.createStatement(); 
            	        ps.executeUpdate(sql);         //将sql语句上传至数据库执行

            	    //    String sql1 = "INSERT INTO user3(a,b,c,d,e,f,g,h) VALUES('"+getname+"','"+getname1+"','"+getname2+"','"+getname3+"','"+getname4+"','"+getname5+"','"+getname6+"','"+getname7+"')";
            		//	ps.executeUpdate(sql1);         //将sql语句上传至数据库执行


            			
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
            	 
         		JOptionPane.showMessageDialog(null, "提交成功");}
            	     CounsellorShenHeSystem cshs=new  CounsellorShenHeSystem(name1);//刷新内容
             }
             }  
             if(e.getSource().equals(jb7)){//上交院长按钮事件

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
            	   
            	    String check1=getname4;
            	    String check2=getname5;
            	    String[] check3=check1.split("-");
            	    String[] check4=check2.split("-");
            	    num1=Integer.parseInt(check3[2]);//日
           		 num2=Integer.parseInt(check4[2]);//日
           		 num7=Integer.parseInt(check3[1]);//月份
           	   num4=Integer.parseInt(check4[1]);//月份
           	  num5=Integer.parseInt(check3[1]);//月份
           	if(num4==num5){//月份
           		 num3=num2-num1;
           	 }
        
           	if(num4>num5){
           		if(num7==2){
           			int n=29-num1;
           			
           		num3=n+num2;
           		}
           		if(num7==4||num7==6||num7==9||num7==11){
           			int n=30-num1;
           			num3=n+num2;
           		}
           		if(num7!=2||num7!=4||num7!=6||num7!=9||num7!=11){
           			int n=31-num1;
           			num3=n+num2;
           		}
           		
           	}
           	if(num3<3){
           		JOptionPane.showMessageDialog(null, "对不起,该请假时长小于3天，不能上交院长");
           	}
           		if(num3>3){
            	     System.out.println(getname+"    "+getname1+"     "+getname2+"    "+getname3+"  "+getname4+"   "+getname5+"   "+getname6+"    "+getname7);
            	    
            	     String DBDRVER ="org.gjt.mm.mysql.Driver";
            	   		//定义MySQL数据库的连接地址
            	   	//	 String DBURL="jdbc:mysql://localhost:3306/shixun?characterEncoding=utf-8";
            	     String DBURL="jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8";
            	    // String DBURL="jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8";
            	   		//MySQL数据库的连接用户名
            	   		 String DBUSER="root";
            	   		//MySQL数据库的连接密码
            	   		 String DBPASS="root";
            	   	//	String DBPASS="aly66MYSQL!!!";
            	     try {  
            	         Class.forName("com.mysql.jdbc.Driver");
            	 		//(2)获取数据库连接
            	 		
            	 //	Connection ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shixun?useUnicode=true&amp;characterEncoding=utf_8","root", "root");
            	 	//Connection ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shixun?useUnicode=true&amp;characterEncoding=gbk","root", "root");
            	         ct=(Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);
            	         //（3）创建SQL语句对象
            	 		Statement ps=ct.createStatement();
            	 		
            	 		//(4)执行查询，返回结果集
            	 	//	ResultSet rs=ps.executeQuery("SELECT * FROM user2");
            	 		String sql="delete from user2 where a='"+getname+"'";//删除表格中选择的行
            	 		
            			//String sql="delete from byc where id='4'";   //SQL语句
            	 		// Statement state=ct.createStatement(); 
            	        ps.executeUpdate(sql);         //将sql语句上传至数据库执行

            	        String sql1 = "INSERT INTO user4(a,b,c,d,e,f,g,h) VALUES('"+getname+"','"+getname1+"','"+getname2+"','"+getname3+"','"+getname4+"','"+getname5+"','"+getname6+"','"+getname7+"')";
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
            	             CounsellorShenHeSystem cshs=new  CounsellorShenHeSystem(name1);//刷新内容
            	     }}
             }
	}
	public static void FitTableColumns(JTable myTable) {//设置表格自动适应内容
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
public void check(){//检查该用户是否存在，如果存在读取该用户所管理的专业
	Connection conn=null;
	DefaultTableModel model;

	  String DBDRVER ="org.gjt.mm.mysql.Driver";
			//定义MySQL数据库的连接地址
			String DBURL="jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8";
	//  String DBURL="jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8";
			//MySQL数据库的连接用户名
			 String DBUSER="root";
			//MySQL数据库的连接密码
			String DBPASS="root";
			// String DBPASS="aly66MYSQL!!!";
	try
	{
	Class.forName(DBDRVER);//加载驱动程序
	conn=(Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);//建立数据库连接
	Statement st=conn.createStatement();
	//String sql="select * from user3 where b='"+jt.getText()+"'";  //假设要读的数据库表为user
	String sql="select * from cuserlist where name='"+name1+"'";
	ResultSet results=st.executeQuery(sql);
	while (results.next()) { 
        String a =results.getString(1);
        String b =results.getString(2);
         result =results.getString(3);
 //       String c =results.getString(3);
//        String d =results.getString(4);
//        String h =results.getString(5);
//        String f =results.getString(6);
//        String g =results.getString(7);
//        String j =results.getString(8);		       
 //      String  p=a+b+c+d+h+f+g+j;
         String  p=a+b+result;
         System.out.println(p);
      //  if(jt.getText()==a){
        	//jt1.setText(p);
     //   jtextarea.setText("姓名"+a+"  "+"学号"+b+"  "+"专业"+c+"  "+"联系"+d+"\n"+"开始日期"+h+"  "+"结束日期"+f+"  "+"请假状态"+j+"\n"+"请假事由"+g);
     //   jtextarea.setFont(new Font("简宋",Font.PLAIN,15));
     //   jtextarea.setEditable(false);//设计文本框不能外部输入
 //       	System.out.println(p);
      //  }
	}
	
	
	       results.close();
	       conn.close();
	}catch(Exception e1){
	}
	 //this.dispose();
	}  

	
	
	
	


}



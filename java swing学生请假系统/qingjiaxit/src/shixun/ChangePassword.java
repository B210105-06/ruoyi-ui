package shixun;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

public class ChangePassword extends JFrame implements ActionListener{

	/**
	 * @param args
	 */
	 JLabel imagelabel;;//背景图片
	JLabel jl1=new JLabel("原始密码");
	JLabel jl2=new JLabel("修改密码");
	JLabel jl3=new JLabel("确认密码");
	JButton jb1=new JButton("确认");
	JButton jb2=new JButton("返回");
	JButton jb3=new JButton("退出");
	JPasswordField fieldPassword1 = new JPasswordField();
	JPasswordField fieldPassword2 = new JPasswordField();
	JPasswordField fieldPassword3 = new JPasswordField();
	String name1,panduan,result1,result2;
	public static final String DBDRVER ="org.gjt.mm.mysql.Driver";
	//定义MySQL数据库的连接地址
	//public static final String DBURL="jdbc:mysql://localhost:3306/shixun?characterEncoding=gbk";
	public static final String DBURL="jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8";
//	public static final String DBURL="jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8";
	//MySQL数据库的连接用户名
	public static final String DBUSER="root";
	//MySQL数据库的连接密码
	public static final String DBPASS="root";
	//public static final String DBPASS="aly66MYSQL!!!";
	Connection conn=null,conn2=null;
	String spassword1,spassword2,spassword3;
	 Statement ps=null;
	 String sql,sql1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			 ChangePassword cp=new ChangePassword(null,null);
			 

		       
			}    
	
	
	public ChangePassword(String name,String s){
		name1=name;
		panduan=s;
		this.setTitle(name1+"修改密码");
		this.setLocation(550,200);
		this.setSize(700,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		ImageIcon image=new ImageIcon("image/1.jpg");//设置背景图片
		imagelabel = new JLabel(image);
	    imagelabel.setBounds(0,0,800,550);
		
		jl1.setBounds(150,100,100,50);
		jl2.setBounds(150,170,100,50);
		jl3.setBounds(150,240,100,50);
		this.add(jl1);
		this.add(jl2);
		this.add(jl3);
		
		fieldPassword1.setBounds(260,105,220,40);
		fieldPassword2.setBounds(260,175,220,40);
		fieldPassword3.setBounds(260,245,220,40);
		this.add(fieldPassword1);
		this.add(fieldPassword2);
		this.add(fieldPassword3);
		
		jb1.setBounds(150,330,80,30);
		jb2.setBounds(270,330,80,30);
		jb3.setBounds(390,330,80,30);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		 this.add(imagelabel);  
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == jb1){
			check();
		}
    if (e.getSource() == jb2){
    	if(panduan.equals("学生")){//判断是不是学生用户
    		StudentSystem a=new StudentSystem(name1);
		}
		if(panduan.equals("辅导员")){//判断是不是辅导员用户
			 CounsellorShenHeSystem cshs=new  CounsellorShenHeSystem(name1);
		}
		if(panduan.equals("老师")){//判断是不是老师用户
			TeacherLookRecord TLR=new TeacherLookRecord(name1);
		}
		if(panduan.equals("院长")){//判断是不是院长用户
			YuanzhangYe y=new	YuanzhangYe(name1);
		}
			
		}
   if (e.getSource() == jb3){
	   System.exit(0);
	
   }
		
	}
	public void check(){

		try
		{
		Class.forName(DBDRVER);//加载驱动程序
		conn=(Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);//建立数据库连接
		Statement st=conn.createStatement();
		//String sql="select * from user3 where b='"+jt.getText()+"'";  //假设要读的数据库表为user
		//String sql="select * from userlist where name='"+name1+"'";
		if(panduan.equals("学生")){//判断是不是学生用户
			 sql="select * from userlist where name='"+name1+"'";
		}
		if(panduan.equals("辅导员")){//判断是不是辅导员用户
			 sql="select * from cuserlist where name='"+name1+"'";
		}
		if(panduan.equals("老师")){//判断是不是老师用户
			 sql="select * from tuserlist where name='"+name1+"'";
		}
		if(panduan.equals("院长")){//判断是不是院长用户
			 sql="select * from yuserlist where name='"+name1+"'";
		}
		ResultSet results=st.executeQuery(sql);
		while (results.next()) { 

	         result1 =results.getString(1);
	         result2 =results.getString(2);
	         System.out.println(result1+result2);
	  
		}
		
		
		       results.close();
		       conn.close();
		}catch(Exception e1){
		}
		register();
		 //this.dispose();
		}  

		
		
	
public void register(){
	 spassword1 = new String(fieldPassword1.getPassword());//原始密码
	 spassword2 = new String(fieldPassword2.getPassword());//修改密码
	 spassword3 = new String(fieldPassword3.getPassword());//确认密码
	//String sr=	textloginName.getText();//用户昵称
	//  String ab=fieldAccount.getText();//用户账号
	if(!spassword1.equals(result2)){
		JOptionPane op2=new JOptionPane();
		op2.showMessageDialog(null, "原始密码错误，请重新输入");
	}
	
//	if(spassword.length()==0){
//		JOptionPane op2=new JOptionPane();
//		op2.showMessageDialog(null, "密码不能为空");
//}
	if(!spassword2.equals(spassword3)){
		JOptionPane op3=new JOptionPane();
		op3.showMessageDialog(null, "密码两次输入不一样，请重新输入");
	}
	if(spassword1.equals(result2)){
		if(spassword2.equals(spassword3)){
			
			save();
		}
		
	}
	
	
	}

public void save(){
//    String DBDRVER ="org.gjt.mm.mysql.Driver";
//		//定义MySQL数据库的连接地址
//	//	 String DBURL="jdbc:mysql://localhost:3306/shixun?characterEncoding=utf-8";
////   String DBURL="jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8";
// String DBURL="jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8";
//		//MySQL数据库的连接用户名
//		 String DBUSER="root";
//		//MySQL数据库的连接密码
//		// String DBPASS="root";
//		String DBPASS="aly66MYSQL!!!";
 try {  
     Class.forName("com.mysql.jdbc.Driver");
		//(2)获取数据库连接
		
//	Connection ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shixun?useUnicode=true&amp;characterEncoding=utf_8","root", "root");
	//Connection ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shixun?useUnicode=true&amp;characterEncoding=gbk","root", "root");
     conn2=(Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);
     //（3）创建SQL语句对象
		Statement ps=conn2.createStatement();
		
	if(panduan.equals("学生")){
		 sql1="update userlist set pwd='"+spassword3+"' where name='"+result1+"'and pwd='"+result2+"'";
	}
	if(panduan.equals("辅导员")){
		 sql1="update cuserlist set pwd='"+spassword3+"' where name='"+result1+"'and pwd='"+result2+"'";
	}
	if(panduan.equals("老师")){
		 sql1="update tuserlist set pwd='"+spassword3+"' where name='"+result1+"'and pwd='"+result2+"'";
	}
	if(panduan.equals("院长")){
		 sql1="update yuserlist set pwd='"+spassword3+"' where name='"+result1+"'and pwd='"+result2+"'";
	}
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
             if(conn2!=null){  
                 conn2.close();  
             }  
         } catch (SQLException e1) {  
             e1.printStackTrace();  
         }  
         JOptionPane.showMessageDialog(null, "提交成功");
         //CounsellorShenHeSystem cshs=new  CounsellorShenHeSystem(name1);
 }}

}

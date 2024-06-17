package shixun;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import sql.*;

public class Guanliyuan extends JFrame implements ActionListener{
//	private JButton buttonRegister = new JButton("注    册");
//	private JTextField textloginName =new JTextField(); 
	 JLabel imagelabel;;//背景图片
	private JButton set = new JButton("上传");
	private JLabel name=new JLabel("选择要创建的账号");
	private JLabel name1=new JLabel("生成的密码");
	private JButton create = new JButton("创建账号");
	private JTextField fieldAccount = new JTextField();//创建的账号
	private JTextField password = new JTextField();//生成的密码
	private JTextField major= new JTextField();//属于专业
	private JLabel majorlabel=new JLabel();
	 JRadioButton jrb1=new JRadioButton("学生");
	 JRadioButton jrb2=new JRadioButton("教师");
	 JRadioButton jrb3=new JRadioButton("辅导员");
	 JRadioButton jrb4=new JRadioButton("院长");
	 ButtonGroup bg=new ButtonGroup();

		String panduan;//判断
		String sql;
		private    InputStreamReader isr;
		private 	BufferedReader br;
		private  	PrintWriter pw;
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == create){//创建账号按钮事件
			
			 Random random=new Random();  //随机函数  		
             int a=random.nextInt(100);//生成0-100的随机数字，只能创建一百个账号
           
		if(jrb1.isSelected()){//学生按钮被选中
		//	JOptionPane.showMessageDialog(null, "登录成功");
			//StudentSystem a=new StudentSystem();
			major.setBounds(150, 320, 233, 50);
			majorlabel.setText("所在专业");
			majorlabel.setBounds(440, 320, 133, 50);
		//	this.dispose();
			//System s=new System();
			  fieldAccount.setText("user"+a);//账号显示在文本框上
			  panduan="user";//记录用户类型
			  System.out.println(panduan);
			if(a>=10){//随机数大于10
				
				password.setText("100"+a);//密码显示在文本框上
			}
			if(a<10){//随机数小于10
				password.setText("1000"+a);
			}
			
			
			}	
		if(jrb2.isSelected()){//教师按钮被选中
			major.setBounds(0, 0, 0, 0);//关闭专业文本框
			majorlabel.setBounds(0, 0, 0, 0);//关闭专业文本标签
			  fieldAccount.setText("tuser"+a);
			  panduan="tuser";//记录用户类型
				if(a>=10){
					
					password.setText("100"+a);
				}
				if(a<10){
					password.setText("1000"+a);
				}
		}
		if(jrb3.isSelected()){//辅导员按钮被选中
			
			major.setBounds(150, 320, 233, 50);//显示专业文本框
			majorlabel.setText("管理的专业");
			majorlabel.setBounds(440, 320, 133, 50);
			  fieldAccount.setText("cuser"+a);
			  panduan="cuser";//记录用户类型
				if(a>=10){
					
					password.setText("100"+a);
				}
				if(a<10){
					password.setText("1000"+a);
				}
			
		}
	if(jrb4.isSelected()){//院长按钮被选中
			
			major.setBounds(150, 320, 233, 50);
			majorlabel.setText("所在院系");
			majorlabel.setBounds(440, 320, 133, 50);
			  fieldAccount.setText("yuser"+a);//账号显示在文本框上
			  panduan="yuser";//记录用户类型
				if(a>=10){
					
					password.setText("100"+a);
				}
				if(a<10){
					password.setText("1000"+a);
				}
			
		}
		
			JOptionPane.showMessageDialog(null, "创建成功");
			
		}
		if(e.getSource() == set){//上传按钮事件
			
			JOptionPane.showMessageDialog(null, "上传成功");
			check1();//调用函数
			//save();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Guanliyuan g=new Guanliyuan();
	}
	
public Guanliyuan(){
	this.setTitle("管理员界面");
	this.setLocation(550,200);
	this.setSize(700,500);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLayout(null);
	
	ImageIcon image=new ImageIcon("image/7.jpg");//设置背景图片
	imagelabel = new JLabel(image);
    imagelabel.setBounds(0,0,700,500);
	
	create.setBounds(400, 170, 133, 50);
	create.setForeground(Color.blue);
	create.setBackground(new Color(30, 144, 255));
	create.setOpaque(false);
	create.setBorder(null);
	
	set.setBounds(150, 380, 53, 50);
	set.setForeground(Color.blue);
	set.setBackground(new Color(30, 144, 255));
	set.setOpaque(false);
	set.setBorder(null);
	
	
	fieldAccount.setBounds(150, 170, 233, 50);
	fieldAccount.setForeground(Color.blue);
	//fieldAccount.setBackground(new Color(30, 144, 255));
	fieldAccount.setBackground(new Color(250, 250, 250));
	//fieldAccount.setOpaque(false);
	//fieldAccount.setBorder(null);
	fieldAccount.setEditable(false);//设置不可编辑
	
	password.setBounds(150, 250, 233, 50);
	password.setForeground(Color.blue);
	password.setBackground(new Color(250, 250, 250));
	password.setEditable(false);
	
	name.setBounds(460, 100, 133, 50);
	//name.setForeground(Color.blue);
	//name.setBackground(new Color(30, 144, 255));
	name.setOpaque(false);
	name.setBorder(null);
	
	
	name1.setBounds(430, 250, 133, 50);
	name1.setForeground(Color.white);
	name1.setBackground(new Color(30, 144, 255));
	name1.setOpaque(false);
	name1.setBorder(null);
	
	//major.setBounds(150, 320, 233, 50);
	major.setForeground(Color.blue);
	major.setBackground(new Color(250, 250, 250));
	//major.setEditable(false);
	
//	majorlabel.setBounds(440, 320, 133, 50);
//	name1.setForeground(Color.blue);
	majorlabel.setBackground(new Color(30, 144, 255));
	majorlabel.setOpaque(false);
	majorlabel.setBorder(null);
	
	
	
	bg.add(jrb1);
	bg.add(jrb2);
	bg.add(jrb3);
	bg.add(jrb4);
	
	jrb1.setBounds(150,110,70,30);
	jrb2.setBounds(220,110,70,30);
	jrb3.setBounds(290,110,100,30);
	jrb4.setBounds(390,110,70,30);
	
	
	
	
	this.add(jrb1);
	this.add(jrb2);
	this.add(jrb3);
	this.add(jrb4);
	this.add(name);
	this.add(name1);
	this.add(password);
	this.add(major);
	this.add(majorlabel);
	this.add(set);
	// pwd 监听enter键
	create.addActionListener(this);
	set.addActionListener(this);
	jrb1.addActionListener(this);	
	jrb2.addActionListener(this);	
	jrb3.addActionListener(this);	
	jrb4.addActionListener(this);	
	
	this.add(create);
	this.add(fieldAccount);
	this.add(imagelabel);
    this.setVisible(true);
    
}

public void check1() {//检查创建的账号是否存在，如存在则重新创建
	
	Connectionlain c = new Connectionlain();//调用类

	Connection conn = c.getConnect();

	PreparedStatement ps = null;
	ResultSet rs = null;

	try {
		ps = conn.prepareStatement("select *from userlist where  name=?");

	
		ps.setString(1, fieldAccount.getText());
	
		rs = ps.executeQuery();
		if (rs.next()) {//判断信息是否存在
			 
			JOptionPane.showMessageDialog(this, "该账号已存在,请重新获取账号");

		}else {
			System.out.println("成功");
          save();//调用函数
           
		} 

	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		//e1.printStackTrace();
	}
	 finally{  
         
        try {  
            
            rs.close();  
             
                 ps.close();  
            
               //  ct.close();  
              
         } catch (SQLException e1) {  
            e1.printStackTrace();  
         }  
    }  

}
public void save(){//保存创建的账号信息，上传到数据库
	// String spassword = new String(Verificationcode.getPassword());//密码
	 try {
		   // 注册mysql驱动程序
		   Class.forName("com.mysql.jdbc.Driver");//driver
		   System.out.println("找到Mysql数据库驱动程序");

	    } catch (Exception e1) {
		   System.out.println("在类路径上找不到Mysql驱动程序，" + "请检查类路径上是否加载mysql的jar包!");
	   }
	   // (3)获取数据库连接
	    Connection conn = null;// 同时按下CTRL+SHIFT+O
	  
	   try {
		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8", "root", "root");
		  // conn = DriverManager.getConnection("jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8", "root", "aly66MYSQL!!!");
		  //  conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/guanliyuan?charcterEncoding=utf8", "root", "root");//(url,username,password)
		    System.out.println("建立数据库连接成功");
		

	     } catch (Exception e1) {
	      	e1.printStackTrace();
	      	System.out.println("创建数据库连接失败！");
	      }

	//     （4）创建一个SQL语句执行（需要在Java执行SQL语句）
	      Statement stmt = null;
	       try {
	     	// 通过conn对象创建SQL语句对象
	     	stmt = conn.createStatement();
	     } catch (Exception e1) {
	     	e1.printStackTrace();
	   }

	       if(panduan.equals("user")){//判断是否为学生用户
	 //   String sql = "INSERT INTO userlist(id,name,pwd) VALUES('"+fieldAccount.getText()+"','"+textloginName.getText()+"','"+spassword+"')";
	sql= "INSERT INTO userlist(name,pwd,zhuanye)  VALUES('"+fieldAccount.getText()+"','"+password.getText()+"','"+major.getText()+"') ";//插入信息到数据表
    
	       }
	       if(panduan.equals("cuser")){//判断是否为辅导员用户
	    		 //   String sql = "INSERT INTO userlist(id,name,pwd) VALUES('"+fieldAccount.getText()+"','"+textloginName.getText()+"','"+spassword+"')";
	    		sql= "INSERT INTO cuserlist(name,pwd,zhuanye)  VALUES('"+fieldAccount.getText()+"','"+password.getText()+"','"+major.getText()+"')";
	    	    
	    		       }   
	       if(panduan.equals("tuser")){//判断是否为老师用户
	    		 //   String sql = "INSERT INTO userlist(id,name,pwd) VALUES('"+fieldAccount.getText()+"','"+textloginName.getText()+"','"+spassword+"')";
	    		sql= "INSERT INTO tuserlist(name,pwd)  VALUES('"+fieldAccount.getText()+"','"+password.getText()+"')";
	    	    
	    		       }   
	       if(panduan.equals("yuser")){//判断是否为院长用户
	    		 //   String sql = "INSERT INTO userlist(id,name,pwd) VALUES('"+fieldAccount.getText()+"','"+textloginName.getText()+"','"+spassword+"')";
	    	   sql= "INSERT INTO yuserlist(name,pwd,zhuanye)  VALUES('"+fieldAccount.getText()+"','"+password.getText()+"','"+major.getText()+"') ";
	    	    
	    		       }   
	       
	    try {
	  	// 执行SQL语句
	     	stmt.executeUpdate(sql);
	  	//  JOptionPane op7=new JOptionPane();
	   //  op7.showMessageDialog(null, "注册成功");
	   	System.out.println("数据插入成功");
	   	JOptionPane.showMessageDialog(this, "上传成功");
		
	    } catch (Exception e1) {
	    	e1.printStackTrace();
	  	System.out.println("插入失败");
	   }
	
 	//(6)关闭资源
	   try {
		  stmt.close();
		  conn.close();
	      } catch (Exception e1) {
		    e1.printStackTrace();
	   }
		
}
	

}



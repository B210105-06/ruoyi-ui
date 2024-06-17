package shixun;
import info.User;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.sql.*;
/**
 * 学生请假系统模块
 */



public class StudentSystem extends JFrame implements ActionListener{

	  JLabel imagelabel;;//背景图片
		JButton jb1=new JButton("学生申请请假");
		JButton jb2=new JButton("学生申请销假");
		JButton jb3=new JButton("查询请假记录");
		JButton jb4=new JButton("提交");
		JButton jb5=new JButton("退出");
		JButton jb6=new JButton("修改密码");
		
		 static JTextArea jt;
		 static  JTextField xmg;
		 static JTextField xhg;
		 static JTextField zyg;
		 static JTextField lxg;
		 static JTextField ksrqg;
		 static JTextField jsrqg;
		 String name1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentSystem a=new StudentSystem(null);
		}

	
public StudentSystem(String name){
	
	
	name1=name;
	this.setTitle(name1+"学生请假系统");
	this.setLocation(550,200);
	this.setSize(700,500);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLayout(null);
	
    
	ImageIcon image=new ImageIcon("image/4.jpg");//设置背景图片
	imagelabel = new JLabel(image);
    imagelabel.setBounds(0,0,700,500);
	
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
	  
	 jb1.setBackground(new Color(233,240,247));
	 jb2.setBackground(new Color(233,240,247));
	 jb3.setBackground(new Color(233,240,247));
	 jb4.setBackground(new Color(233,240,247));
	 jb5.setBackground(new Color(233,240,247));
	 jb6.setBackground(new Color(233,240,247));
	 
	 
	JLabel jl=new JLabel("请假申请");
	JLabel xm=new  JLabel("姓名");
	JLabel xh=new JLabel("学号");
	JLabel zy=new JLabel("专业");
	JLabel lx=new JLabel("联系");
	JLabel ksrq=new JLabel("开始日期");
	JLabel jsrq=new JLabel("结束日期");
	JLabel qjsy=new JLabel("请假事由");
	
	
	 jl.setFont(new Font("简宋",Font.PLAIN,18));
	 xm.setFont(new Font("简宋",Font.PLAIN,18));
	 xh.setFont(new Font("简宋",Font.PLAIN,18));
	 zy.setFont(new Font("简宋",Font.PLAIN,18));
	 lx.setFont(new Font("简宋",Font.PLAIN,18));
	 ksrq.setFont(new Font("简宋",Font.PLAIN,18));
	 jsrq.setFont(new Font("简宋",Font.PLAIN,18));
	 qjsy.setFont(new Font("简宋",Font.PLAIN,18));
	  
	 xmg=new JTextField();
	 xhg=new JTextField();
	 zyg=new JTextField();
	 lxg=new JTextField();
	 ksrqg=new JTextField("  格式(2019-9-25)");
	 jsrqg=new JTextField("  格式(2019-9-26)");
	//JTextField qjsyg=new JTextField();
	 jt=new JTextArea();
	
	 
	 xmg.setFont(new Font("简宋",Font.PLAIN,18));
	 xhg.setFont(new Font("简宋",Font.PLAIN,18));
	 zyg.setFont(new Font("简宋",Font.PLAIN,18));
	 lxg.setFont(new Font("简宋",Font.PLAIN,18));
	 ksrqg.setFont(new Font("简宋",Font.PLAIN,18));
	 jsrqg.setFont(new Font("简宋",Font.PLAIN,18));
	 jt.setFont(new Font("简宋",Font.PLAIN,18));
	 
	 xmg.setBorder(null);
	 xhg.setBorder(null);
	 zyg.setBorder(null);
	 lxg.setBorder(null);
	 ksrqg.setBorder(null);
	 jsrqg.setBorder(null);
	// qjsyg.setBorder(null);
	 
	 
	jb1.setBounds(5, 0, 233, 50);
	jb2.setBounds(236, 0, 223, 50);
	jb3.setBounds(457, 0, 223, 50);
	
	jl.setBounds(300,51,620,50);
	
	xm.setBounds(30,90,60,50);
	xmg.setBounds(68,102,110,30);
	
	xh.setBounds(190,90,50,50);
	xhg.setBounds(227,102,110,30);
	
	zy.setBounds(350,90,50,50);
	zyg.setBounds(389,102,110,30);
	
	lx.setBounds(517,90,50,50);
	lxg.setBounds(556,102,110,30);
	
	ksrq.setBounds(30,135,90,50);
	ksrqg.setBounds(105,145,170,30);
	
	jsrq.setBounds(300,135,90,50);
	jsrqg.setBounds(375,145,170,30);
	
	qjsy.setBounds(30,210,90,100);
	//jt.setBounds(30,210,90,100);
	jt.setBounds(105,200,555,130);
	
	
	jb4.setBounds(30,380,100,50);
	jb5.setBounds(140,380,100,50);
	jb6.setBounds(260,380,120,50);
	//this.add(upper);
	
	this.add(jb1);
	this.add(jb2);
	this.add(jb3);
	this.add(jl);
	this.add(xm);
	this.add(xmg);
	this.add(zy);
	this.add(zyg);
	this.add(xh);
	this.add(xhg);
	this.add(lx);
	this.add(lxg);
	this.add(ksrq);
	this.add(ksrqg);
	this.add(jsrq);
	this.add(jsrqg);
	this.add(qjsy);
	//this.add(qjsyg);
	this.add(jt);
	this.add(jb4);
	this.add(jb5);
	this.add(jb6);
	
	
	jb1.addActionListener(this);	
	jb2.addActionListener(this);	
	jb3.addActionListener(this);	
	jb4.addActionListener(this);	
	jb5.addActionListener(this);	
	jb6.addActionListener(this);	
	this.add(imagelabel);
	this.setVisible(true);
}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if( e.getSource().equals(jb6))//修改密码按钮事件
	        {
				String s="学生";
			 ChangePassword cp=new ChangePassword(name1,s);//调用类，跳转
				this.dispose();
	          

		       
			}     
		 // String input = e.getActionCommand();
		
		  if( e.getSource().equals(jb5))//退出按钮事件
	        {
				
				
				this.dispose();
	           // System.exit( 0 );

		       
			}     
		  if(e.getSource().equals(jb4)){//提交按钮事件
				
//			  File f = new File("d:\\student1.txt");
//				//字节输出流
//				FileOutputStream fos=null;
//				
//				try {
//					fos = new FileOutputStream(f);
//				
//					String s="姓名:"+"  "+xmg.getText()+"\r\n";
//					String s1="学号:"+"  "+xhg.getText()+"\r\n";
//					String s2="专业:"+"  "+zyg.getText()+"\r\n";
//				String s=xmg.getText();
//				String s1=xhg.getText();
//				String s2=zyg.getText();
//				
//				String s3="联系:"+"  "+lxg.getText()+"\r\n";
//				String s4="开始:"+"  "+ksrqg.getText()+"\r\n";
//				String s5="结束:"+"  "+jsrqg.getText()+"\r\n";
//					String s6 = "请假事由:"+"  "+jt.getText()+"\r\n";//换行：/r/n
//					String s7="请假信息已提交,等待审核通过";
//					//定义字节数组
//					byte []btyes = new byte[10024];
//					
//					fos.write(s.getBytes());
//					fos.write(s1.getBytes());
//					fos.write(s2.getBytes());
//					fos.write(s3.getBytes());
//					fos.write(s4.getBytes());
//					fos.write(s5.getBytes());
//					fos.write(s6.getBytes());
//					fos.write(s7.getBytes());
//					
//				} catch (Exception e1) {
//					e1.printStackTrace();
//					// TODO: handle exception
//				}finally{
//					try {
//						fos.close();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//				JOptionPane.showMessageDialog(null, "提交成功");
//				xmg.setText("");
//				xhg.setText("");
//				zyg.setText("");
//				lxg.setText("");
//				ksrqg.setText("");
//				jsrqg.setText("");
//				jt.setText("");
//				
				//String driver = "com.mysql.jdbc.Driver";
				String check1=ksrqg.getText();
				String check2=jsrqg.getText();
				 String[] check3=check1.split("-");
				 String[] check4=check2.split("-");
				
				  if(check3[1]==null&&check4[1]==null&&check3[2]==null&&check4[2]==null){		
						JOptionPane.showMessageDialog(null, "对不起，日期格式错误，请重新输入");
				  }
			  if(check3[1]!=null&&check4[1]!=null&&check3[2]!=null&&check4[2]!=null){			
					
				try {
					// 注册mysql驱动程序
					Class.forName("com.mysql.jdbc.Driver");//driver
					System.out.println("找到Mysql数据库驱动程序");

				} catch (Exception e1) {
					System.out.println("在类路径上找不到Mysql驱动程序，" + "请检查类路径上是否加载mysql的jar包!");
				}
				// (3)获取数据库连接
				Connection conn = null;// 同时按下CTRL+SHIFT+O
				// 通过JDBC工具类DriverManager来创建到Mysql的连接对象
				//String url = "jdbc:mysql://127.0.0.1:3306/Test";
				//String userName = "root";
				//String password = "root";
				try {
					// 第一个参数：数据库连接字符串url
					// JDBC URL格式:协议名+子协议名+数据源
					// 协议名固定为：jdbc
					// 子协议名：不同的数据库不一样，mysql的子协议名就是mysql
					// 数据源：具体指向那个数据库的信息
					// mysql例子 jdbc:mysql://127.0.0.1:3306/Test
					// 第二个参数：数据用户名
					// 第三个参数：数据库用户密码

					//conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shixun", "root", "root");//(url,username,password)
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8", "root", "root");//(url,username,password)
				//	conn = DriverManager.getConnection("jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8", "root", "aly66MYSQL!!!");//(url,username,password)
					System.out.println("建立数据库连接成功");
					

				} catch (Exception e1) {
					e1.printStackTrace();
					System.out.println("创建数据库连接失败！");
				}

				// （4）创建一个SQL语句执行（需要在Java执行SQL语句）
				Statement stmt = null;
				try {
					// 通过conn对象创建SQL语句对象
					stmt = conn.createStatement();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				// (5)执行SQL语句
			//	String sql = "INSERT INTO student(stu_name,stu_sex,stu_age) VALUES('zhjksan','n',root4)";
				//String sql = "INSERT INTO student(stu_name,stu_sex,stu_age) VALUES('"+xmg.getText()+"','"+xhg.getText()+"',"+zyg.getText()+")";
			//String sql = "INSERT INTO user(id,name,stuNum,pwd) VALUES('"+xmg.getText()+"','"+xhg.getText()+"',"+zyg.getText()+",'"+lxg.getText()+"')";
				
				
			//	String sql = "INSERT INTO user2(a,b,c,d,e,f,g) VALUES('"+xmg.getText()+"','"+xhg.getText()+"','"+zyg.getText()+"','"+lxg.getText()+"','"+ksrqg.getText()+"','"+jsrqg.getText()+"','"+jt.getText()+"')";
				String sql = "INSERT INTO user2(a,b,c,d,e,f,g,h) VALUES('"+xmg.getText()+"','"+xhg.getText()+"','"+zyg.getText()+"','"+lxg.getText()+"','"+ksrqg.getText()+"','"+jsrqg.getText()+"','"+jt.getText()+"','"+name1+"')";
				
				
				//String sql = "INSERT INTO student(xm,xh,zy,lx,ksrq,jsrq,jt) VALUES('s','s1','s2','s3','s4','s5','s6')";
				try {
					// 执行SQL语句
					stmt.executeUpdate(sql);
					System.out.println("数据插入成功");
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
				xmg.setText("");//清空文本框
				xhg.setText("");//清空文本框
				zyg.setText("");
				lxg.setText("");
				ksrqg.setText("");
				jsrqg.setText("");
				jt.setText("");
				

			}
		  
		  }

				
			
	
		if(e.getSource().equals(jb3)){//查询请假记录按钮事件
			
			StudentRecord SLR=new StudentRecord(name1);
			this.dispose();

		}  
		if(e.getSource().equals(jb2)){//学生申请销假按钮事件
			JOptionPane.showMessageDialog(null, "对不起，该功能未开通");
		}  
		if(e.getSource().equals(jb1)){//学生申请请假按钮事件
			JOptionPane.showMessageDialog(null, "你已处于当前界面");
		}  }
		 
	}   
	
		          
	
   

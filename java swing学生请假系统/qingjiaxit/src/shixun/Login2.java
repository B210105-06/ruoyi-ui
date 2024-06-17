package shixun;
import info.User;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;


import javax.swing.*;

import sql.CPYDDatabase;
import sql.CounsellorDatabase;
import sql.GuanliyuanDatabase;
import sql.TeacherDatabase;
import sql.YuanzhangDatabase;
public class Login2 extends JFrame implements ActionListener {	
	
	    JTextField fieldAccount = new JTextField(1000);
	   JPasswordField fieldPassword = new JPasswordField(1000);
	   JButton jb1 = new JButton("登 录");
	   JButton jb2=new JButton("退出");
	  JLabel label1;
	  JLabel label2=new JLabel("请假系统登录界面");
	  JRadioButton jrb1=new JRadioButton("学生");
	  JRadioButton jrb2=new JRadioButton("教师");
	  JRadioButton jrb3=new JRadioButton("辅导员");
	  JRadioButton jrb4=new JRadioButton("管理员");
	  JRadioButton jrb5=new JRadioButton("院长");
      ButtonGroup bg=new ButtonGroup();//设置按钮只能选一个
      JLabel imagelabel;;//背景图片
    //  JComboBox jc;
    //  String xiala[]={"学生","教师","辅导员","管理员","院长"};
public Login2(){
			this.setTitle("用户登录界面.....");
			this.setBounds(550, 200, 800, 500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(null);
			this.setVisible(true);
			
			ImageIcon image=new ImageIcon("image/1.jpg");//设置背景图片
			imagelabel = new JLabel(image);
		    imagelabel.setBounds(0,0,800,550);
		  
			 
//			 jc=new JComboBox(xiala);
//			 jc.setBounds(30,360,70,30);
//			 jc.addActionListener(this);	
//			 this.add(jc);
		   
			jb2.addActionListener(this);	
			
		    jb1.setBackground(new Color(233,240,247));
	        jb1.setForeground(new Color(30,57,91));
	        jb2.setBackground(new Color(233,240,247));

			JLabel label = new JLabel("账号");
		  
		    label.setOpaque(false);
			label.setBounds(150,140,100,50);
			//label.setForeground(Color.white);
			label.setFont(new Font("简宋",Font.PLAIN,18));
		    
			jb1.setForeground(Color.white);
			jb1.setFont(new Font("简宋",Font.PLAIN,18));
			jb2.setForeground(Color.white);
			jb2.setFont(new Font("简宋",Font.PLAIN,18));
		    
			// fieldAccount.setOpaque(false);
			 fieldAccount.setBorder(null);
			// fieldPassword.setOpaque(false);
			// fieldPassword.setBorder(null);
			jb1.setOpaque(false);
			jb2.setOpaque(false);
			jb1.setBorder(null);
			 jb2.setBorder(null);
			//label.setBackground(Color.red);
			//label.setForeground(Color.red);
		
			
			fieldAccount.setBounds(250, 140, 300, 50);
			
			
			label1 = new JLabel("  密 码   ");
			
			label1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			//label1.setForeground(Color.white);
			label1.setFont(new Font("简宋",Font.PLAIN,18));
		    
			//label1.setForeground(Color.red);
			label1.setBounds(145, 238, 100, 50);
			
			fieldPassword.setBounds(250, 240, 300, 50);
			fieldPassword.setBorder(null);
			
			
			jb1.setBounds(250,380,50,30);
			jb2.setBounds(450,380,50,30);
			jb1.addActionListener(this);
			
			label2.setBounds(300,50,200,30);
			label2.setFont(new Font("简宋",Font.PLAIN,18));
			
			
			bg.add(jrb1);
			bg.add(jrb2);
			bg.add(jrb3);
			bg.add(jrb4);
			bg.add(jrb5);
			
			jrb1.setFont(new Font("简宋",Font.PLAIN,18));
			jrb2.setFont(new Font("简宋",Font.PLAIN,18));
			jrb3.setFont(new Font("简宋",Font.PLAIN,18));
			jrb4.setFont(new Font("简宋",Font.PLAIN,18));
			jrb5.setFont(new Font("简宋",Font.PLAIN,18));
		
			jrb1.setBounds(80,330,70,30);
			jrb2.setBounds(180,330,70,30);
			jrb3.setBounds(280,330,100,30);
			jrb4.setBounds(400,330,100,30);
			jrb5.setBounds(520,330,70,30);
			
			
			
			this.add(label);
			this.add(label1);
			this.add(fieldAccount);
			this.add(fieldPassword);
			this.add(jb1);
			this.add(jb2);
			this.add(label2);
			this.add(jrb1);
		//	this.add(jrb2);
			this.add(jrb3);
		//	this.add(jrb4);
			this.add(jrb5);	// pwd 监听enter键
		
			fieldPassword.addActionListener(this);
			fieldAccount.addActionListener(this);
		
			jrb1.addActionListener(this);	
			jrb2.addActionListener(this);	
			jrb3.addActionListener(this);	
			jrb4.addActionListener(this);	
			jrb5.addActionListener(this);	
			jb1.addActionListener(this);
			
			 this.add(imagelabel);  
			
			this.setVisible(true);
			
			 
   }
		public void actionPerformed(ActionEvent e) {
//	String s=jc.getSelectedItem().toString();
//			if( e.getSource().equals(jc)){
//				System.out.println("处理");
//				System.out.println(s);
//			}
				
			if( e.getSource().equals(jb2))//退出按钮事件
	        {
				this.dispose();
	           // System.exit( 0 );
			}
			if(e.getSource() == fieldPassword|| e.getSource() == jb1){//登陆按钮事件
				// 获取帐号
				String account = fieldAccount.getText();
				// 获取密码
				String pwd = new String(fieldPassword.getPassword());
			
			//if (account.compareTo("root") == 0 && pwd.compareTo("root")==0 ){//没数据库时的验证方法
			

				User user = CPYDDatabase.userQquery(account);//连接到数据库
				User cuser =CounsellorDatabase.userQquery(account);//连接到数据库
				User tuser =TeacherDatabase.userQquery(account);//连接到数据库
				User guser =GuanliyuanDatabase.userQquery(account);//连接到数据库
				User yuser =YuanzhangDatabase.userQquery(account);//连接到数据库
				
				if(user != null && user.verifyPwd(pwd)){//判断账号密码是否存在
				if(jrb1.isSelected()){//学生按钮被选中
				//	if(s.equals("学生")){
					JOptionPane.showMessageDialog(null, "登录成功");
					StudentSystem a=new StudentSystem(fieldAccount.getText());//跳转到学生界面
					
					this.dispose();//关闭当前窗口
					//System s=new System();
				
					}				
				else {
					JOptionPane.showMessageDialog(null, "对不起，你不是学生用户");
					
				}
				}
			
				//else if (account.compareTo("root4") == 0 && pwd.compareTo("root4")==0 ){
				else if(tuser != null && tuser.verifyPwd(pwd)){
					if(jrb2.isSelected()){//教师按钮被选中
					//if(s.equals("教师")){
					JOptionPane.showMessageDialog(null, "登录成功");
					this.dispose();
					TeacherSystem TS=new TeacherSystem(fieldAccount.getText());
					}
					else JOptionPane.showMessageDialog(null, "对不起，你不是教师用户");
				}
				//else if(account.equals("root45")  && pwd.equals("root45")){
					else if(cuser != null && cuser.verifyPwd(pwd)){
					if(jrb3.isSelected()){//辅导员按钮被选中
					//	if(s.equals("辅导员")){
					JOptionPane.showMessageDialog(null, "登录成功");
					this.dispose();
					CounsellorSystem CS=new CounsellorSystem(fieldAccount.getText());
				
					}}
					else if(guser != null && guser.verifyPwd(pwd)){
						if(jrb4.isSelected()){//管理员按钮被选中
					//	if(s.equals("管理员")){
						JOptionPane.showMessageDialog(null, "登录成功");
						this.dispose();
						Guanliyuan g=new Guanliyuan();//跳转到管理员界面
					
						}
					else  JOptionPane.showMessageDialog(null, "对不起，你不是管理员用户");
			}
					else if(yuser != null && yuser.verifyPwd(pwd)){
						if(jrb5.isSelected()){//院长按钮被选中
						//if(s.equals("院长")){
						JOptionPane.showMessageDialog(null, "登录成功");
						this.dispose();
						YuanzhangYe y=new	YuanzhangYe(fieldAccount.getText());//跳转到院长界面
					
						}
					else  JOptionPane.showMessageDialog(null, "对不起，你不是院长用户");
			}
				
				if( e.getSource().equals(jb1))
		        {	
					fieldAccount.setText("账号或密码错误");
					
				}

}
		}
public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login2();
	}
}




package shixun;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class StartUp  extends JFrame  implements ActionListener{
	 private JLabel imagelabel=new JLabel();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new  StartUp();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
public  StartUp(){
	this.setTitle("联系人");
	this.setLocation(500, 150);
	this.setSize(700, 500);
	this.setLayout(null);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	JLabel l1=new JLabel("请假系统");
	l1.setBounds(250, 200, 200, 50);
	l1.setFont(new Font("简宋",Font.PLAIN,38));
	l1.setForeground(Color.white);
	this.add(l1);
	
	ImageIcon image=new ImageIcon("image/1.jpg");
     imagelabel = new JLabel(image);
     imagelabel.setBounds(0,0,700,500);
     this.add(imagelabel);
     this.setVisible(true);
     
     
    

    
     	  
    B b=new B();
    
    try{
 	  Thread.sleep(1800);
 	  b.start();
    }catch(InterruptedException e){
 	   e.printStackTrace();

	
	}
}

class B extends Thread{
	public void run(){
		 StartUp.this.dispose();
	//	new UserLogin1();	
		new Login2();
	}
}
}
	

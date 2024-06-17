package shixun;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class CounsellorSystem extends JFrame implements ActionListener{

	/**
	 *辅导员管理请假信息系统
	 */
	  JLabel imagelabel;;//背景图片
	JButton jb1=new JButton("审核请假信息");
	JButton jb2=new JButton("审核销假信息");
	JButton jb3=new JButton("学生请假记录");
	
	JButton jb4=new JButton("退出");
	String name1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CounsellorSystem CS=new CounsellorSystem(null);
	}
	
public CounsellorSystem(String name){
	name1=name;
	this.setTitle(name1+"辅导员管理请假信息系统");
	this.setLocation(550,200);
	this.setSize(700,500);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLayout(null);
	
	 
		ImageIcon image=new ImageIcon("image/3.jpg");
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
	jb1.setBackground(new Color(233,240,247));
	jb2.setBackground(new Color(233,240,247));
    jb3.setBackground(new Color(233,240,247));
    jb4.setBackground(new Color(233,240,247));


	jb1.setBounds(5, 0, 233, 50);
	jb2.setBounds(236, 0, 223, 50);
	jb3.setBounds(457, 0, 223, 50);
	jb4.setBounds(457, 400, 223, 50);
	jb1.addActionListener(this);	
	jb2.addActionListener(this);	
	jb3.addActionListener(this);
	jb4.addActionListener(this);
    this.add(jb1);
    this.add(jb2);
    this.add(jb3);
    this.add(jb4);
    this.add(imagelabel);
    this.setVisible(true);
}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  if(e.getSource().equals(jb4)){//退出事件
				this.dispose();
			}  
	
		if(e.getSource().equals(jb3)){//学生请假记录按钮事件
			CounsellorLookRecord clr=new CounsellorLookRecord(name1);
		}  
		if(e.getSource().equals(jb2)){//审核销假信息按钮事件
			JOptionPane.showMessageDialog(null, "对不起，该功能未开通");
		}  
		if(e.getSource().equals(jb1)){//审核请假信息按钮事件
			//JOptionPane.showMessageDialog(null, "你已处于当前界面");
			 CounsellorShenHeSystem cshs=new  CounsellorShenHeSystem(name1);
			this.dispose();
		}  
	
	}

}

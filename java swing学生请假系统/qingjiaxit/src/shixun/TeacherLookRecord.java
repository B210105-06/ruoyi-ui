package shixun;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.text.Caret;

import java.awt.Dimension;
import java.sql.*;
import java.util.Enumeration;

import com.mysql.jdbc.Connection;
public class TeacherLookRecord extends JFrame implements ActionListener{

	/**
	 * 教师查看学生请假信息系统模块
	 */
	JLabel imagelabel;;//背景图片
	JScrollPane scrollPane,scrollPane1;
	JButton jb1=new JButton("学生请假信息");
	JButton jb2=new JButton("修改密码");
	JButton jb3=new JButton("退出");
	JButton jb5=new JButton("查询");
	 JRadioButton jrb1=new JRadioButton("学号");
	 JRadioButton jrb2=new JRadioButton("专业");
	 JRadioButton jrb3=new JRadioButton("请假日期");
	 JRadioButton jrb4=new JRadioButton("全部");
	 ButtonGroup bg=new ButtonGroup();
	 
	 
	//JTextArea jt=new JTextArea();https://s.click.taobao.com/t?e=m%3D2%26s%3DpME6DhWJ0UscQipKwQzePCperVdZeJviK7Vc7tFgwiFRAdhuF14FMQMqTHK1cvurRitN3%2FurF3zqdWn68XGFlOmvLfATRoEi2xjF9AuMPhVx8uk1aChWOgBXgSuv7Sv7KtseCpInTy%2FkXkdea8kgYymBZ5ZWikN7RIhXpwzXCM5Pf2BYFhAHdCY1PMGA%2F%2FdiFveQ9Ld2joqwHLIflzoqbX6B%2F00oBp4ZPQUuEDH%2BG9RF6zF52nfI4w%3D%3D&union_lens=lensId%3APUB%401571398121%400b0af5b7_0ccc_16ddea079c5_04f0%4001
	JTextField jt=new JTextField();
	//JTextField jt1=new JTextField();
	JLabel jl=new JLabel("学号");
	JTextArea jtextarea=new JTextArea();
	public static final String DBDRVER ="org.gjt.mm.mysql.Driver";
	//定义MySQL数据库的连接地址
	//public static final String DBURL="jdbc:mysql://localhost:3306/shixun?characterEncoding=gbk";
	public static final String DBURL="jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8";
	//public static final String DBURL="jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8";
	//MySQL数据库的连接用户名
	public static final String DBUSER="root";
	//MySQL数据库的连接密码
	public static final String DBPASS="root";
	//public static final String DBPASS="aly66MYSQL!!!";
	String sql;
	String name1;
	DefaultTableModel model,model1;
	JTable table,table1;
	String[] biaotou = { "姓名","学号","专业","联系","开始日期","结束日期","请假事由","账号","请假状态"}; 
	Object [][]cellData={};
	String[] biaotou1 = { "姓名","学号","专业","联系","开始日期","结束日期","请假事由","账号","请假状态"}; 
	Object [][]cellData1={};
//	String[] columnNames={"姓名","学号","专业","联系","开始日期","结束日期","请假状态","请假事由"};//定义表格列名数
//	String[][] tableValues={{"陈锦贤","182017331","计算机","15119747306","2019-9-23-17:55","2019-9-23-19:14","通过","因为想呆在宿舍"},{"21","22","23","24","25","26","27","28"},{"","","","","","","",""},
//			{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
//			{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
//			{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""}};//定义表格数据数组
//	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeacherLookRecord TLR=new TeacherLookRecord(null);
	}

public TeacherLookRecord(String name){
    name1=name;
	this.setTitle(name1+"教师查看学生请假信息系统");
	this.setLocation(550,200);
	this.setSize(700,500);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLayout(null);
	
	ImageIcon image=new ImageIcon("image/6.jpg");
	imagelabel = new JLabel(image);
    imagelabel.setBounds(0,0,700,500);

	bg.add(jrb1);
	bg.add(jrb2);
	bg.add(jrb3);
	bg.add(jrb4);
	jrb1.setFont(new Font("简宋",Font.PLAIN,18));
	jrb2.setFont(new Font("简宋",Font.PLAIN,18));
	jrb3.setFont(new Font("简宋",Font.PLAIN,18));
	jrb4.setFont(new Font("简宋",Font.PLAIN,18));
	
	jrb1.setBounds(250,75,70,30);
	jrb2.setBounds(320,75,70,30);
	jrb3.setBounds(400,75,100,30);
	jrb4.setBounds(510,75,100,30);
	this.add(jrb1);
	this.add(jrb2);
	this.add(jrb3);
	this.add(jrb4);
	jrb1.addActionListener(this);	
	jrb2.addActionListener(this);	
	jrb3.addActionListener(this);	
	jrb4.addActionListener(this);	
//	JTable table=new JTable(tableValues,columnNames);//创建指定列名和数据的表格
//		JScrollPane scrollpane=new JScrollPane(table);//创建显示表格的滚动面板
//		//FitTableColumns(table);
//		table.setRowHeight(40);
//		table.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer()); 
		
		//JTableAUTO_RESIZE_ALL_COLUMNS;
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//JTable.AUTO_RESIZE_OFF
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	Connection conn=null;
//	DefaultTableModel model;
//	JTable table;
	try
	{
	Class.forName(DBDRVER);//加载驱动程序
	conn=(Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);//建立数据库连接
	Statement st=conn.createStatement();
	String sql="select * from user3";//假设要读的数据库表为user
	ResultSet results=st.executeQuery(sql);
//	String[] biaotou = { "姓名","学号","专业","联系","开始日期","结束日期","请假事由","请假状态"}; 
//	Object [][]cellData={};
	model=new DefaultTableModel(cellData,biaotou){ //表格用的数据模型
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	       return false;// 无条件返回 false，任何单元格都不让编辑。
	   }
	};
	table =new JTable(model);
	String []data=new String [9];
	       while (results.next()) { 
	         data[0] =results.getString(1);
	         data[1]=results.getString(2);
	       data[2]=results.getString(3);
	        data[3]=results.getString(4);
	         data[4]=results.getString(5);
	        data[5]=results.getString(6);
	        data[6]=results.getString(7);  
	        data[7]=results.getString(8); 
	        data[8]=results.getString(9); 
	           model.addRow(data);
	             //tEditable(false);    
	       }     
	      // table.setModel(model);
	       results.close();
	conn.close();
	//frame.getContentPane().setLayout(null);
	this.setLayout(null);
	table.setFillsViewportHeight(true);//填满容器高度
	table.setPreferredScrollableViewportSize(new Dimension(500, 700));
	 scrollPane = new JScrollPane(table); //存放表格的，表格必须放在里面
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);   //在所有的调整操作上成比例的调整所有的列
	scrollPane.setBounds(0, 0, 484, 461);
	table.setRowHeight(30);
	//FitTableColumns(table);    //宽度自适应方法
	table.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer()); 
	//}catch(Exception e){
	//}
	
	
	jb1.setOpaque(false);
	jb1.setFont(new Font("简宋",Font.PLAIN,18));
	jb2.setOpaque(false);
	jb2.setFont(new Font("简宋",Font.PLAIN,18));
	jb3.setOpaque(false);
	jb3.setFont(new Font("简宋",Font.PLAIN,18));
	jb5.setOpaque(false);
	jb5.setFont(new Font("简宋",Font.PLAIN,18));
	jb1.setBackground(new Color(233,240,247));
	jb2.setBackground(new Color(233,240,247));
    jb3.setBackground(new Color(233,240,247));
    jb5.setBackground(new Color(233,240,247));
    scrollPane.setBackground(new Color(233,240,247));
	jb1.setBounds(5, 0, 233, 50);
	jb2.setBounds(236, 0, 223, 50);
	jb3.setBounds(457, 0, 223, 50);
//	jb5.setBounds(5, 55, root, 25);
//	jl.setBounds(150, 55, root, 25);
//	jt.setBounds(220, 55, root, 25);
	jb5.setBounds(5, 55, 203, 25);
//	jl.setBounds(5, 90, 110, 25);
	jt.setBounds(8,90, 200, 45);
	
	//jt1.setBounds(350, 55, 323, 25);
//	jtextarea.setBounds(230,57,440,70);
	//scrollpane.setBounds(5, 95, 675, 330);
	
	//scrollPane.setBounds(5,95,675,330);
	scrollPane.setBounds(5,145,675,290);
	//jt.setBounds(30,80,620,300);
	//jt.setEditable(false);//设计文本框不能外部输入
	// jt.setFont(new Font("简宋",Font.PLAIN,18));
	

model1=new DefaultTableModel(cellData1,biaotou1){ //表格用的数据模型
		public boolean isCellEditable(int rowIndex, int columnIndex) {
		       return false;// 无条件返回 false，任何单元格都不让编辑。
		   }
		};
		table1 =new JTable(model1);
    table1.setFillsViewportHeight(true);//填满容器高度
			   	table1.setPreferredScrollableViewportSize(new Dimension(500, 700));
			   	scrollPane1 = new JScrollPane(table1); //存放表格的，表格必须放在里面
			   	table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);   //在所有的调整操作上成比例的调整所有的列
			  
			   	table1.setRowHeight(30);
			   	//FitTableColumns(table);    //宽度自适应方法
			   	table1.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer()); 
			 
			   	this.add(scrollPane1);
	
	
	
	
	
	
	
	jb1.addActionListener(this);	
	jb2.addActionListener(this);	
	jb3.addActionListener(this);	
	jb5.addActionListener(this);
    this.add(jb1);
    this.add(jb2);
    this.add(jb3);
    this.add(jb5);
   // this.add(jt);
    this.add(jl);
    this.add(jt);
   // this.add(jt1);
    this.add(jtextarea);
    //this.add(scrollpane);
    this.add(scrollPane);
    this.add(imagelabel);
    this.setVisible(true);
	}catch(Exception e){
		}
//    
//    FileReader fr=null;
//	//写入文件（输出流）
//	//FileWriter fw=null;
//	
//	try {
//		//创建fir对象
//		fr = new FileReader("d:\\student2.txt");
//		
//		
//		int n=0;//实际读取的字符数
//		//读入到内存
//		char c[]=new char[10024];
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

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	if(e.getSource().equals(jb3)){//退出按钮事件
	 this.dispose();
	}  
		if(e.getSource().equals(jb2)){//修改密码按钮事件
		//	JOptionPane.showMessageDialog(null, "对不起，该功能未开通");
			String s="老师";
			 ChangePassword cp=new ChangePassword(name1,s);
		}  
		if(e.getSource().equals(jb1)){//学生请假信息按钮事件
			JOptionPane.showMessageDialog(null, "你已处于当前界面");
		}  
		
		if(e.getSource().equals(jb5)){//查询按钮事件
			scrollPane.setBounds(0, 0, 0, 0);//关闭表格
			scrollPane1.setBounds(0, 0, 0, 0);//关闭表格
		 			Connection conn=null;
	//	model1.setRowCount(0);//清空表格数据
		 ((DefaultTableModel)table1.getModel()).getDataVector().clear();//清空表格数据	
		 ((DefaultTableModel)table.getModel()).fireTableDataChanged();//通知所有侦听器，表的所有表格数值可能已经更改 			
			try
			{
//			String[] biaotou = { "姓名","学号","专业","联系","开始日期","结束日期","请假事由","请假状态"}; 
//			Object [][]cellData={};
//		model1=new DefaultTableModel(cellData,biaotou){ //表格用的数据模型
//				public boolean isCellEditable(int rowIndex, int columnIndex) {
//				       return false;// 无条件返回 false，任何单元格都不让编辑。
//				   }
//				};
//				table1 =new JTable(model1);
				String []data=new String [9];
		
			Class.forName(DBDRVER);//加载驱动程序
			conn=(Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);//建立数据库连接
			Statement st=conn.createStatement();
			if(jrb1.isSelected()){//学号被选中
			 sql="select * from user3 where b='"+jt.getText()+"'";  //读取所填学号的数据表信息
			}
			if(jrb2.isSelected()){//专业按钮被选中
				 sql="select * from user3 where c='"+jt.getText()+"'";  //读取所填专业的数据表信息
				}
			if(jrb3.isSelected()){//请假日期按钮被选中
				 sql="select * from user3 where e='"+jt.getText()+"'";  //读取所填请假日期的数据表信息
				}
			if(jrb4.isSelected()){//全部按钮被选中
				 sql="select * from user3 ";  //读取该表的全部内容
				}
			//String sql="select * from user3 ";
			ResultSet results=st.executeQuery(sql);
			while (results.next()) { 
//		        String a =results.getString(1);
//		        String b =results.getString(2);
//		        String c =results.getString(3);
//		        String d =results.getString(4);
//		        String h =results.getString(5);
//		        String f =results.getString(6);
//		        String g =results.getString(7);
//		        String j =results.getString(8);
		        
		        data[0] =results.getString(1);
		         data[1]=results.getString(2);
		       data[2]=results.getString(3);
		        data[3]=results.getString(4);
		         data[4]=results.getString(5);
		        data[5]=results.getString(6);
		        data[6]=results.getString(7); 
		        data[7]=results.getString(8); 
		        data[8]=results.getString(9); 
		           model1.addRow(data);//读取的信息放进表格
		        
	//	       String  p=a+b+c+d+h+f+g+j;
		      //  if(jt.getText()==a){
//		        	//jt1.setText(p);
//		        jtextarea.setText("姓名"+a+"  "+"学号"+b+"  "+"专业"+c+"  "+"联系"+d+"\n"+"开始日期"+h+"  "+"结束日期"+f+"  "+"请假状态"+j+"\n"+"请假事由"+g);
//		        jtextarea.setFont(new Font("简宋",Font.PLAIN,15));
//		        jtextarea.setEditable(false);//设计文本框不能外部输入
//		        	System.out.println(p);
		        	
		      //  }
			}
			
			
			       results.close();
			       conn.close();
			     	scrollPane1.setBounds(5, 135, 675, 250);//显示表格
			     	System.out.println("0000");
//			       table.setFillsViewportHeight(true);//填满容器高度
//			   	table.setPreferredScrollableViewportSize(new Dimension(500, 700));
//			   	scrollPane1 = new JScrollPane(table); //存放表格的，表格必须放在里面
//			   	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);   //在所有的调整操作上成比例的调整所有的列
//			  
//			   	table.setRowHeight(30);
//			   	//FitTableColumns(table);    //宽度自适应方法
//			   	table.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer()); 
//			   	scrollPane1.setBounds(5, 135, 675, 250);
//			   	this.add(scrollPane1);
			   	
			   	
			}catch(Exception e1){
			}
			 //this.dispose();
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
}


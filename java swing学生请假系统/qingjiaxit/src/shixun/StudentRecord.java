package shixun;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Connection;

import java.sql.*;
import java.util.Enumeration;
import java.util.Vector;
//import sx.TableCellTextAreaRenderer;
public class StudentRecord extends JFrame implements ActionListener{

	/**
	 * 学生查询请假记录模块
	 */
	  JLabel imagelabel;;//背景图片
	JButton jb1=new JButton("学生申请请假");
	JButton jb2=new JButton("学生申请销假");
	JButton jb3=new JButton("查询请假记录");
	JButton jb4=new JButton("退出");
	//JTextArea jt=new JTextArea();
	//String[] columnNames={"姓名","学号","专业","联系","开始日期","结束日期","请假状态","请假事由"};//定义表格列名数
	//String[][] tableValues={{"陈锦贤","182017331","计算机","15119747306","2019-9-23-17:55","2019-9-23-19:14","通过","因为想呆在宿舍"},{"21","22","23","24","25","26","27","28"},{"","","","","","","",""},
	//		{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
	//		{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
	//		{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""}};//定义表格数据数组
	//
		//	JTable table=new JTable(tableValues,columnNames);//创建指定列名和数据的表格
	
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
  String name1;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentRecord SLR=new StudentRecord(null);
	}

public StudentRecord(String name){
	name1=name;
//	this.setTitle("学生请假系统");
//	this.setLocation(550,200);
//	this.setSize(700,500);
//	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//	this.setLayout(null);
	
	
	//JTable table=new JTable(tableValues,columnNames);//创建指定列名和数据的表格
	//	JScrollPane scrollpane=new JScrollPane(table);//创建显示表格的滚动面板
		//FitTableColumns(table);
	//	table.setRowHeight(40);
	//	table.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer()); 
		
		//JTableAUTO_RESIZE_ALL_COLUMNS;
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//JTable.AUTO_RESIZE_OFF
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	ImageIcon image=new ImageIcon("image/4.jpg");//设置背景图片
	imagelabel = new JLabel(image);
    imagelabel.setBounds(0,0,700,500);
    
	Connection conn=null;
	DefaultTableModel model;//表格模型
	JTable table;//表格
	try
	{
	Class.forName(DBDRVER);//加载驱动程序
	conn=(Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);//建立数据库连接
	Statement st=conn.createStatement();
	//String sql="select * from user3";//假设要读的数据库表为user
	String sql="select * from user3 where h='"+name1+"'";//读取当前登陆用户的请假信息
	//String sql="select * from user2 where c='"+result+"'";
	ResultSet results=st.executeQuery(sql);
	String[] biaotou = { "姓名","学号","专业","联系","开始日期","结束日期","请假事由","请假状态"}; 
	Object [][]cellData={};
	model=new DefaultTableModel(cellData,biaotou){ //表格用的数据模型
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	       return false;// 无条件返回 false，任何单元格都不让编辑。
	   }
	};
	table =new JTable(model);//
	String []data=new String [8];
	       while (results.next()) { 
	         data[0] =results.getString(1);
	         data[1]=results.getString(2);
	       data[2]=results.getString(3);
	        data[3]=results.getString(4);
	         data[4]=results.getString(5);
	        data[5]=results.getString(6);
	        data[6]=results.getString(7);  
	      //  data[7]=results.getString(8);  
	        data[7]=results.getString(9);  
	           model.addRow(data);//将读取的信息放进表格
	             //tEditable(false);    
	       }     
	      // table.setModel(model);
	       results.close();
	conn.close();
	//frame.getContentPane().setLayout(null);
	this.setLayout(null);
	table.setFillsViewportHeight(true);//填满容器高度
	table.setPreferredScrollableViewportSize(new Dimension(500, 700));
	JScrollPane scrollPane = new JScrollPane(table); //存放表格的，表格必须放在里面
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);   //在所有的调整操作上成比例的调整所有的列
	scrollPane.setBounds(0, 0, 484, 461);
	table.setRowHeight(30);//设置表格行高
	//FitTableColumns(table);    //宽度自适应方法
	table.setDefaultRenderer(Object.class, new TableCellTextAreaRenderer()); 
	//}catch(Exception e){
	//}
	
	
	
		
	
	//jt.setEditable(false);//设计文本框不能外部输入
	//jt.setForeground(Color.BLACK);
	//jt.setFont(new Font("简宋",Font.PLAIN,18));
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
	//jt.setBounds(30,80,620,300);
	//scrollpane.setBounds(5, 65, 675, 320);
	scrollPane.setBounds(30,80,620,300);
	jb1.addActionListener(this);	
	jb2.addActionListener(this);	
	jb3.addActionListener(this);
	jb4.addActionListener(this);
	
    this.add(jb1);
    this.add(jb2);
    this.add(jb3);
    this.add(jb4);
    this.add(scrollPane);
   // this.add(scrollpane);
    this.setTitle(name1+"学生请假系统");
	this.setLocation(550,200);
	this.setSize(700,500);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLayout(null);
	this.add(imagelabel);
    this.setVisible(true);
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
	

  }catch(Exception e){
  	}}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  if(e.getSource().equals(jb4)){//退出按钮事件
				this.dispose();
			}  
		
		if(e.getSource().equals(jb1)){//学生申请请假按钮事件
			StudentSystem a=new StudentSystem(name1);	
			this.dispose();
		}  
		if(e.getSource().equals(jb2)){//学生申请销假按钮事件
			JOptionPane.showMessageDialog(null, "对不起，该功能未开通");
		}  
		if(e.getSource().equals(jb3)){//查询请假记录按钮事件
			JOptionPane.showMessageDialog(null, "你已处于当前界面");
		}  
	
	}


	public static void FitTableColumns(JTable myTable) {////设置表格自动适应内容
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
	    }
	
	
	}}

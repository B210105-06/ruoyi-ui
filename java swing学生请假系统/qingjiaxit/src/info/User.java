package info;
/**
 * 
 */

/**
 * @author techlife
 * 
 */
public class User {
	// ID
	private long id = -1;
	// 用户名
	private String name = new String();
	// 密码
	private String pwd = new String();
	// 学号
	private String stuNum = new String();
	private String zhuangye = new String();
	public User(){
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getZhuangye() {
		return name;
	}
	public void setZhuangye(String zhuangye) {
		this.zhuangye= zhuangye;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public boolean verifyPwd(String pwd) {
		if (! this.pwd.equals(pwd)){
			return false; 
		}
		
		return true;
	}
	
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	
	public void show(){
		System.out.println("=== Use Information ===");
		System.out.println("*** ID     : \t" + id);
		System.out.println("*** Name   : \t" + name);
		System.out.println("*** stuNum : \t" + stuNum);
		System.out.println();
	}
}


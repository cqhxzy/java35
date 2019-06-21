package test1;

import java.util.Scanner;

public class Test2 {
	public final int SUCCESS = 1;  //成功
	public final int FAIL = 0;  //失败
	public final int ERROR = 2; //错误
	
	public Message login(String loginName,String loginPwd) {
		Message s = new Message();
		//通过数据库查询用户名或密码是否正确
		if (loginName.equals("admin") && loginPwd.equals("123")) {
			//登录成功
			s.setCode(SUCCESS);
			s.setMessage("登录成功");
		} else {
			//登录失败
			s.setCode(FAIL);
			s.setMessage("用户名或密码错误");
		}
		return s;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Test2 t2 = new Test2();
		
		System.out.println("请输入用户名：");
		String loginName = input.next();
		System.out.println("请输入密码：");
		String loginPwd = input.next();
		
		Message m = t2.login(loginName, loginPwd);
		
		System.out.println(m.getMessage());
	}

}

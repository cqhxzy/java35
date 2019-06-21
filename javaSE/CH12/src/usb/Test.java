package usb;

public class Test {

	public static void main(String[] args) {
		Fan f = new Fan();
		// f is a Iusb 的实现
		
		Light l = new Light();  // l is a Iusb的实现
		
		Udisk u = new Udisk();  //u is a Iusb的实现
		
		//父类类型  对象 = new 子类()
		Iusb f1 = new Fan();
		Iusb l1 = new Light();
		Iusb u1 = new Udisk();
		
		f1.service();
		l1.service();
		u1.service();
		
		Object obj = new Fan();
		
	}

}

package usb;

/**
 * U盘 必须实现usb接口的规范
 * @author Nick
 */
public class Udisk implements Iusb {

	@Override
	public void service() {
		System.out.println("U盘插在Usb后，可以传输数据了");
	}

}

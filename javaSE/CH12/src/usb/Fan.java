package usb;

/**
 * usb风扇，需要依赖usb接口
 * @author Nick
 */
public class Fan implements Iusb {

	@Override
	public void service() {
		System.out.println("usb风扇通电后，就开始出风了");
	}

}

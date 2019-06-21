package usb;

/**
 * usb小台灯
 * usb小台灯必须实现usb接口的规范
 * @author Nick
 */
public class Light implements Iusb {

	@Override
	public void service() {
		System.out.println("小台灯通过usb通电后，发光了");
	}

}

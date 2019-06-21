package usb;

/**
 * 模拟电脑的usb接口
 * @author Nick
 */
public interface Iusb {

	/**
	 * usb具有服务的能力，至于能做什么，usb不知道
	 */
	void service();
}

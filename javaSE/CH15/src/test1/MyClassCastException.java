package test1;

/**
 * 自定义的异常，代表类转换异常
 * @author Nick
 */
@SuppressWarnings("serial")
public class MyClassCastException extends Exception {

	public MyClassCastException() {
		super();
	}

	public MyClassCastException(String message) {
		super(message);
	}

}

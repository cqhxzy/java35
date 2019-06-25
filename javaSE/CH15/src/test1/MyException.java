package test1;

/**
 * 自定义的异常，编译异常
 * @author Nick
 */
public class MyException extends Exception{

	/**
	 * 生成的序列号，对象序列化时会有用
	 */
	private static final long serialVersionUID = -6489595089488568951L;

	public MyException() {
		super();
	}

	public MyException(String message) {
		super(message);
	}

	
}

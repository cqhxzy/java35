package three;

public class Book {

	private String bookName;
	
	private double bookPrice;
	
	/**
	 * 自定义方法 得到原价
	 * @return
	 */
	public double getOriginalPrice() {
		return bookPrice;
	}
	
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
	
	
}

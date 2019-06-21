package game.poker;

/**
 * 花色
 * @author Administrator
 *
 */
public enum Shape {
	/*
	 * 黑桃 > 红桃  > 梅花 > 方片
	 * */
	BLACK_HEART("♠"),
	RED_HEART("♥"),
	FLOWER("♣"),
	SQUARE("♦");
	
	private String value;
	private Shape(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public static Shape findShapeByValue(String value) {
		Shape[] values = Shape.values();
		for (int i = 0; i < values.length; i++) {
			if (values[i].getValue().equals(value)) {
				return values[i];
			}
		}
		return null;
	}
}

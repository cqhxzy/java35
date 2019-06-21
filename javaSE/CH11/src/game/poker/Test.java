package game.poker;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		BigKing d = new BigKing();
		SmallKing x = new SmallKing();
		
		//System.out.println(Shape.values().length);
		String[] shapes = {
				Shape.BLACK_HEART.getValue(),
				Shape.RED_HEART.getValue(),
				Shape.FLOWER.getValue(),
				Shape.SQUARE.getValue()
				};
		System.out.println(Arrays.toString(shapes));
	}

}

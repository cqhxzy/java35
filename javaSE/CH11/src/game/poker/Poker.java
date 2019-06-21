package game.poker;

/**
 * 牌
 * @author Administrator
 *
 */
public abstract class Poker implements Comparable<Poker>{
	//点数
	private String point;
	
	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public Poker(String point) {
		super();
		this.point = point;
	}
	
}

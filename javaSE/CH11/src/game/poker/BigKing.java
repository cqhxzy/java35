package game.poker;

/**
 * 大鬼
 * @author Administrator
 *
 */
public class BigKing extends Poker {
	private String type;//大鬼|小鬼
	public static final String BIG = "ZZZ"; //大鬼的点数

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigKing() {
		super(BIG);
		this.type = "大王";
	}

	@Override
	public int compareTo(Poker o) {
		return this.getPoint().compareTo(o.getPoint());
	}
	
}

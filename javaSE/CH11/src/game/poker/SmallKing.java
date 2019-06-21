package game.poker;

/**
 * 小王
 * @author Administrator
 *
 */
public class SmallKing extends Poker {

	public static final String SMALL = "YYY";//小鬼的点数
	private String type;
	public SmallKing() {
		super(SMALL);
		this.type = "小王";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int compareTo(Poker o) {
		return this.getPoint().compareTo(o.getPoint());
	}

}

package game.player;

import game.poker.Poker;

/**
 * 玩家
 * @author Administrator
 *
 */
public abstract class Player {
	private String nickName;
	
	//玩家的手牌
	private Poker[] hands;
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Poker[] getHands() {
		return hands;
	}

	public void setHands(Poker[] hands) {
		this.hands = hands;
	}

	public Player(String nickName) {
		super();
		this.nickName = nickName;
	}
	
}

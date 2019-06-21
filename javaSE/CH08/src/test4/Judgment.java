package test4;

/**
 * 裁判
 * @author Nick
 */
public class Judgment {

	/**
	 * 裁判的有参构造方法，裁判在初始化时，就需要指定参与游戏的玩家
	 * @param player
	 * @param computer
	 */
	public Judgment(Player player, Computer computer) {
		super();
		this.player = player;
		this.computer = computer;
	}

	private Player player;//对象，在此处充当的是玩家的角色
	
	private Computer computer;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	
	/**
	 * 玩家和电脑开始对战
	 * @return
	 */
	public String fight() {
		int player_solo = player.getSolo();//玩家出拳
		int pc_solo = computer.getSolo(); //电脑出拳
		//System.out.println("player:" + player_solo + ",pc:" + pc_solo);

		//输出玩家出拳信息
		String player_str_solo = showSolo(this.player.getSolo());
		System.out.println("你出拳：" + player_str_solo);
		
		//输出电脑出拳信息
		String pc_str_solo = this.computer.getName() + "出拳：";
		pc_str_solo += showSolo(pc_solo);
		System.out.println(pc_str_solo);
		
		
		String str = null;
		if (player_solo == pc_solo) {
			str = "平局";
		} else if (player_solo == 1 && pc_solo == 3 || player_solo == 2 && pc_solo == 1 || player_solo == 3 && pc_solo == 2) {//玩家胜
			str = player.getName() + "获胜";
		} else {
			str = computer.getName() + "获胜";
		}
		
		return str;
	}
	
	/**
	 * 打印出拳信息
	 * @param solo
	 * @return
	 */
	private String showSolo(int solo) {
		String str = null;
		if (solo == 1) {
			str = "剪刀";
		} else if (solo == 2) {
			str = "石头";
		} else if (solo == 3) {
			str = "布";
		}
		return str;
	}
}

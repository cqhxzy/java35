package game.poker;

/**
 * 普通牌
 * @author Administrator
 *
 */
public class NormalPoker extends Poker {
	//形状，用于描述花色 
	private String shape;
	
	

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	

	public NormalPoker(String shape, String point) {
		super(point);
		this.shape = shape;
	}

	@Override
	public int compareTo(Poker o) {
		/*
		 * compareTo()
		 * 如果对象1中的属性大于对象o2中的属性，  o1-o2  > 0
		 * 反之小于0
		 * 相同等于0
		 * 
		 * */
		if (this.getPoint().compareTo(o.getPoint()) == 0) {//如果牌的点数相同则根据花色排序
			String shape2 = this.getShape();  //本类图形的枚举
			Shape valueOf = Shape.findShapeByValue(shape2);//根据图形去枚举中查找图形对应的枚举类型
			
			
			NormalPoker normal_o = (NormalPoker)o;
			String shape3 = normal_o.getShape();
			Shape valueOf2 = Shape.findShapeByValue(shape3);
			
			return valueOf.compareTo(valueOf2); //根据花色的顺序排序
		}
		
		return this.getPoint().compareTo(o.getPoint()); //直接比点数
	}
	
}

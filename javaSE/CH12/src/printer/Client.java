package printer;

import printer.inkbox.BlackInkBox;
import printer.inkbox.ColorfulInkBox;
import printer.inkbox.InkBox;
import printer.paper.A4Paper;
import printer.paper.B5Paper;
import printer.paper.Paper;

public class Client {

	public static void main(String[] args) {
		
		Paper paper = new A4Paper(); //使用A4纸
		//Paper paper = new B5Paper(); //使用A4纸
		
		InkBox box = new BlackInkBox(); //使用黑色墨盒
		//InkBox box = new ColorfulInkBox(); //使用彩色墨盒
		
		HpPrinter hp = new HpPrinter(paper, box);
		
		hp.print("hello world");
	}

}

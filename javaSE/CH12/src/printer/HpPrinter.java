package printer;

import printer.inkbox.InkBox;
import printer.paper.Paper;

public class HpPrinter extends Printer {

	/**
	 * 使用打印机之前，必须安装纸张和墨盒
	 * @param paper
	 * @param inkBox
	 */
	public HpPrinter(Paper paper, InkBox inkBox) {
		super(paper, inkBox);
	}

	@Override
	public void print(String msg) {
		String size = super.getPaper().getSize(); //得到纸张
		String color = super.getInkBox().getColor(); //得到墨盒的颜色
		System.out.println("惠普打印机开始在" + size + "的尺寸上使用" + color + "的颜色打印了：" + msg);
	}

}

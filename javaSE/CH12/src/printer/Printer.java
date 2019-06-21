package printer;

import printer.inkbox.InkBox;
import printer.paper.Paper;

/**
 * 抽象的打印机类
 * @author Nick
 */
public abstract class Printer {

	//打印机需要安装纸张和墨盒
	private Paper paper; //所有纸的统称
	
	private InkBox inkBox; //所有墨盒的统称
	
	/**
	 * 打印机在使用前，必须安装纸张和墨盒
	 * @param paper
	 * @param inkBox
	 */
	public Printer(Paper paper,InkBox inkBox) {
		this.paper = paper;
		this.inkBox = inkBox;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public InkBox getInkBox() {
		return inkBox;
	}

	public void setInkBox(InkBox inkBox) {
		this.inkBox = inkBox;
	}
	
	/**
	 * 所有打印机都具备打印的能力
	 * @param msg
	 */
	public abstract void print(String msg);
}

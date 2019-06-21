package three;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(Integer.MAX_VALUE);
		 
		Book[]  bookArr=new Book[4];
		//第一本收
	    Book  book1=new Book();
	    book1.setBookName("JAVA基础");
	    book1.setBookPrice(50.8);	    
	    bookArr[0]=book1;
	    
	    //第2本书
	    PercentBook  book2=new PercentBook(); 
	    book2.setBookName("数据库基础");
	    book2.setBookPrice(80);
	    book2.setPercent(0.85);
	    bookArr[1]=book2;
	    
	    //第3本免费送
	    FreeBook  book3=new FreeBook();
	    book3.setBookName("中国地图");
	    book3.setBookPrice(30);
	    bookArr[2]=book3;
	    
	  //第4本收
	    Book  book4=new Book();
	    book4.setBookName("HTML基础");
	    book4.setBookPrice(40.8);	    
	    bookArr[3]=book4;
	    
	    //打印   instanceof
	    for(Book   b : bookArr) {
	    	
	    	//判断它是什么类型
	    	if(b instanceof FreeBook) {
	    		System.out.println("-------免费的书-------");	
	    		System.out.println("书名:"+b.getBookName());
	    		System.out.println("原价："+b.getOriginalPrice());
	    		
	    	}else if(b instanceof  PercentBook) {
	    		//向下转型
	    		PercentBook  pb=(PercentBook)b;
	    		double result=pb.getPercent()*10;	    		
	    		System.out.println("-------打("+result+")折的书-------");	
	    		System.out.println("书名:"+b.getBookName());
	    		
	    		//父类的价格代表原始
	    		System.out.println("原价:"+b.getOriginalPrice());	    		
	    		//子类价格更改过的价格
	    		System.out.println("折扣价格:"+pb.getBookPrice());  //子类
	    	}else {
	    		System.out.println("-------正常销售的书-------");	    
	    		System.out.println("书名:"+b.getBookName());
	    		System.out.println("价格："+b.getBookPrice());
	    	}
	    	
	    	 System.out.println();
	    	 
	    }

	}

}

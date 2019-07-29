package demo1;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void add() {
        Calc c = new Calc();
        int add = c.add(5, 5);

        /*通过Assert类中提供的方法来检测结果是否符合预期*/
        //断言结果相同
        assertEquals(10,add); //第一个参数：期望值，第二个参数：实际值
    }

    @Test
    public void mul() {
        Calc c = new Calc();
        int mul = c.mul(5, 5);
        //断言结果不相同
        assertNotEquals("两个数必须为不等的",25,mul);
    }

}
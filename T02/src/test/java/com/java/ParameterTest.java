package com.java;

import static org.junit.Assert.assertEquals; //静态导入

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//import com.jadyer.junit4.Calculator;

@RunWith(Parameterized.class)
public class ParameterTest {
    private final int expected;
    private final int input11;
    private final int input22;

    public ParameterTest(int expected, int input11, int input22){
        this.expected = expected;
        this.input11 = input11;
        this.input22 = input22;
    }

    @Parameters
    public static Collection prepareData(){
        //该二维数组的类型必须是Object类型的
        //该二维数组中的数据是为测试Calculator中的add()方法而准备的
        //该二维数组中的每一个元素中的数据都对应着构造方法ParameterTest()中的参数的位置
        //所以依据构造方法的参数位置判断，该二维数组中的第一个元素里面的第一个数据等于后两个数据的和
        //有关这种具体的使用规则，请参考JUnit4的API文档中的org.junit.runners.Parameterized类的说明
        Object[][] object = {{3,1,2}, {0,0,0}, {-4,-1,-3}, {6,-3,9}};
        return Arrays.asList(object);
    }

    @Test
    public void testAdd(){
        Calculator cal = new Calculator();
        assertEquals(expected, cal.add(input11, input22));
    }
}

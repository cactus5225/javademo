package algo;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by xufei on 2020/4/17.
 * 桶排序
 * 计数排序
 * 基数排序
 */
public class LinearSort {

    @Test
    public void bucketSort() {
        //给100万个用户订单金额排序
        //1.生成一百万个数据
        int[]  data = {1,5,2,7,9,10,23};
        bucket_sort(data);
        System.out.println(Arrays.toString(data));

    }

    public  void bucket_sort(int[] data){



    }


    //技术排序
    @Test
    public void countSort() {
        //所在省50万考生，总分数是900分，对考生成绩进行排序

    }

    @Test
    public void radixSort() {
        //有10万个手机号，对10万个手机号按照从小到大的顺序排序
    }

    /**
     * 思考题一：
     * 给一组字符串排序，小写字母在前，大写字母在后
     */
    @Test
    public void testOne() {

    }

    /**
     * 思考题二
     * 给一组字符串排序，小写字母在前，数字在中间，大写字母在后
     */
    @Test
    public void testTwo() {

    }

}

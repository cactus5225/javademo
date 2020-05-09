package algo;

import org.junit.Test;

/**
 * Created by xufei on 2020/4/20.
 */
public class BinarySearch {

    @Test
    public void bsearch() {
        int[] data = {1, 2, 3, 4, 5, 6, 7,7,7,7};
        int index = b_search(data, 7);
        System.out.println(index);

        int result = b_digui(data, 0, data.length - 1, 7);
        System.out.println(result);

        System.out.println(findFirst(data,7));

    }


    //循环写法
    public int b_search(int[] data, int num) {
        int low = 0;
        int high = data.length - 1;

        while (true) {
            int mid = (low + high) / 2;


            if (data[low] <= num && num <= data[mid]) {
                high = mid;
            } else if (data[mid] < num && num <= data[high]) {
                low = mid;
            }

            if (num == data[mid]) {
                return mid;
            }

        }

    }

    //递归写法
    public int b_digui(int[] data, int low, int high, int num) {
        int mid = (low + high) / 2;
        if (num == data[mid]) {
            return mid;
        }

        //因为算到最后两个值的时候，除以2总是会取最小值
        if (num == data[high]) {
            return high;
        }


        if (data[low] <= num && num <= data[mid]) {
            return b_digui(data, low, mid, num);
        } else if (data[mid] < num && num <= data[high]) {
            return b_digui(data, mid, high, num);
        }


        return -1;

    }

    /**
     * 查找第一个值等于给定元素的值
     */
    public int  findFirst(int[] data, int num){
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (data[mid] < num){
                low = mid +1;
            }else if (data[mid] > num){
                high  = mid-1;
            }else {
                if (mid == 0 || data[mid-1] != num){
                    return mid;
                }else {
                    high = mid -1;
                }

            }

        }

        return -1;
    }

    @Test
    public void testmid(){
        int low =0;
        int high =3;
        int mid =  low + ((high - low) >> 1);
        System.out.println(mid);
    }


    /**
     * 查找最后一个值等于给定元素的值
     */

    /**
     * 查找第一个大于等于给定元素的值
     */

    /**
     * 查找最后一个小于等于给定元素的值
     */
}

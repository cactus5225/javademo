package algo;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by xufei on 2020/4/10.
 * 排序算法
 * 内存使用，执行效率，稳定性
 * 从小到大的排序
 */
public class Sort {

    /**
     * 冒泡排序
     * <p>
     * 思路:
     * 相邻的两个数据比较，每一轮选出来最大值。
     * <p>
     * <p>
     * <p>
     * 原始数据 3-->4-->1-->5-->8--2-->9
     * 第一轮：3-->1-->4-->5-->2--8-->9
     * 第二轮:1-->3--4-->2-->5-->8-->9
     * 第三轮:1-->3--2-->4-->5-->8-->9
     * <p>
     * 优化:已经有序之后快速结束。标识位
     * <p>
     * 问题：1.数组越界，j的取值范围应该是data.length-1
     * 2.[1,1,1,2,2,2,9] 两个数交换有问题。。。
     */
    @Test
    public void bubbleSort() {
        int[] data = new int[]{13, 2, 43, 41, 15, 80, 9};
        //外层循环是控制冒泡排序冒出来几个数了
        boolean flag = false;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int tmp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

        System.out.println(Arrays.toString(data));
    }

    /**
     * 选择排序
     * 思路
     * 分已排序和未排序区间，从未排序的区间找到最小值插入到已排序的后面。
     * 问题:1下标越界的问题。
     * 2.xuanzeResult[15,15,15,15,15,0,0]
     * <p>
     * 找最小值
     * 优化的思路找到最小值的下标，然后和最小值互换位置
     */
    @Test
    public void selectSort() {
        int[] data = new int[]{13, 2, 43, 41, 15, 80, 9};
        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            for (int j = i; j < data.length; j++) {
                if (data[j] < min) {
                    int tmp = min;
                    min = data[j];
                    data[j] = tmp;
                }
            }
            data[i] = min;
        }

        System.out.println(Arrays.toString(data));
    }


    /**
     * 插入排序
     * 思路
     * <p>
     * 已排序区和未排序区
     * 排序区和未排序怎么区分
     * <p>
     * <p>
     * 将未排序区的数据插入已排序区，然后其他位置后移。
     * <p>
     * 1-->13-->2
     */
    @Test
    public void insertSort() {
        int[] data = new int[]{13, 2, 43, 41, 15, 80, 9};
        if (data.length <= 1) {
            System.out.println(Arrays.toString(data));
        }

        //走下面的逻辑则数组长度大于2
        //i循环为未排序区
        for (int i = 1; i < data.length; i++) {
            //要插入的数据
            int tmp = data[i];
            //j已排序区
            int j = i - 1;
            for (; j >= 0; ) {
                if (data[j] > tmp) {
                    data[j + 1] = data[j];
                    j--;
                } else {
                    break;
                }
            }
            data[j + 1] = tmp;
        }
        System.out.println(Arrays.toString(data));
    }

    /**
     * 希尔排序
     * 思路
     */
    @Test
    public void shellSort() {

    }


    /**
     * 递归思路
     * 1.一个问题可以分解为几个子问题
     * 2.分解之后的子问题除了数据的规模不用之外，思路完全一样。
     * 3.存在递归终止条件
     * <p>
     * <p>
     * 场景:
     * 假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问走这 n 个台阶有多少种走法？
     * 表达式：f(n) = f(n-1)+f(n-2)
     * 终止条件：f(1)=1 ,f(2)=2
     * <p>
     * 误区：人脑试图想清楚整个递归过程。
     * <p>
     * 警惕：
     * 堆栈溢出
     * 避免重复计算（用一个map记录中间结果）
     * <p>
     * 调试递归的方法
     * 1.打日志
     * 2.结合条件断点调试
     */
    @Test
    public void tesTtakeTheStairs() {
        int n = 5;
        System.out.println(takeTheStairs(n));
    }

    private int takeTheStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        return takeTheStairs(n - 1) + takeTheStairs(n - 2);
    }


    /**
     * 归并排序
     * <p>
     * 思路
     * 1.分成两组
     * 2.每组排序
     * 3.合并
     */
    @Test
    public void mergeSort() {
        int[] data = new int[]{13, 2, 4, 8};
        merge_sort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    //排序
    private void merge_sort(int[] data, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        merge_sort(data, p, q);
        merge_sort(data, q + 1, r);
        merge(data, p, q, r);
    }

    /**
     * merge,两个有序数组合并
     * 使用临时数组然后拷贝到原数组
     */
    private void merge(int[] data, int p, int q, int r) {
        int[] tmp = new int[data.length];
        int firstStart = p, nextStart = q + 1, k = p;

        while (firstStart <= q && nextStart <= r) {
            if (data[firstStart] <= data[nextStart]) {
                tmp[k++] = data[firstStart++];
            } else {
                tmp[k++] = data[nextStart++];
            }
        }
        while (firstStart <= q) {
            tmp[k++] = data[firstStart++];
        }

        while (nextStart <= r) {
            tmp[k++] = data[nextStart++];
        }

        for (int i = p; i <= r; i++) {
            data[i] = tmp[i];
        }
    }


    /**
     * 快速排序
     * 思路
     */
    @Test
    public void quickSort() {

    }


    /**
     * 随机生成数组
     *
     * @param length
     * @param max
     * @return
     */
    public int[] gennerateArray(int length, int max) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * max);
        }

        return array;
    }

    @Test
    public void test() {
        int[] data = new int[]{13, 2, 4, 8};
        int[] result = Arrays.copyOfRange(data, 0, 3);
        System.out.println(result.length);
        System.out.println(Arrays.toString(result));
    }


}

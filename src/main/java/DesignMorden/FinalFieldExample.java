package DesignMorden;

/**
 * Created by xufei on 2020/5/7.
 *仅当在使用 final 修饰属性的情况下，才可以保证在对象初始化完成之后，外部能够看到对象正确的属性值。
 *
 */
public class FinalFieldExample {
    final int x;
    int y;
    static FinalFieldExample f;

    public FinalFieldExample() {
        x = 3;
        y = 4;
    }

    static void writer() {
        f = new FinalFieldExample();
    }

    static void reader() {
        if (f != null) {
            int i = f.x;  // 程序一定能得到 3
            int j = f.y;  // 也许会看到 0
        }
    }


}

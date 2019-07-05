package cleancode;

import java.util.function.Function;

/**
 * Created by xufei on 2018/12/26.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        String name = "";
        String name1 = "12345";
        System.out.println(validInput(name, inputStr -> inputStr.isEmpty() ? "名字不能为空":inputStr));
        System.out.println(validInput(name1, inputStr -> inputStr.length() > 3 ? "名字过长":inputStr));

    }

    public static String validInput(String name,Function<String,String> function) {
        return function.apply(name);
    }


}

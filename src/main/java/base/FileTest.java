package base;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by xufei on 2020/5/13.
 */
public class FileTest {


    @Test
    public void read()  throws Exception{
        String localFilePath = "/Users/xufei/IDEproject/my/javademo/src/main/java/base/test.txt";
        java.nio.file.Path  path = Paths.get(localFilePath);
        byte[] data = Files.readAllBytes(path);
        String result = new String(data, "utf-8");

        System.out.println(result);

    }
}

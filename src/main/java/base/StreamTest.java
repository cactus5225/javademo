package base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "ddd");

        final Stream<Stream<Character>> streamStream
                = list.stream().map(TestStreamAPI::getCharacterByString);
        streamStream.forEach(System.out::println);


        Map map = new HashMap(2);

    }
}

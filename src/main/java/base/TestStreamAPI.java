package base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI {
    public static Stream<Character> getCharacterByString(String str) {

        List<Character> characterList = new ArrayList<>();

        for (Character character : str.toCharArray()) {
            characterList.add(character);
        }

        return characterList.stream();
    }
}

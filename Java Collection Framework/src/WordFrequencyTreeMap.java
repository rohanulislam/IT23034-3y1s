import java.util.TreeMap;

/*
 * This program stores words and their frequencies using TreeMap.
 * TreeMap keeps the words sorted alphabetically.
 */
public class WordFrequencyTreeMap {

    public static void main(String[] args) {
        String text = "java is easy and java is powerful";

        TreeMap<String, Integer> wordCount = new TreeMap<>();

        for (String word : text.split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies:");
        System.out.println(wordCount);
    }
}

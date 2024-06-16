package words;

import java.util.*;

//public class Words {
//    public static List<String> getUniqueWordsFromSentence(String sentence) {
        //throw new UnsupportedOperationException();
        public class Words {

    public static List<String> getUniqueWordsFromSentence(String sentence) {
        // Convert sentence to lower case
        sentence = sentence.toLowerCase();

        // Replace punctuation with spaces
        sentence = sentence.replaceAll("[^a-zA-Z\\s]", " ");

        // Split the sentence into words
        String[] words = sentence.split("\\s+");

        // Use a Set to store unique words
        Set<String> uniqueWordsSet = new LinkedHashSet<>(Arrays.asList(words));

        // Convert the Set back to a List
        List<String> uniqueWords = new ArrayList<>(uniqueWordsSet);

        return uniqueWords;
    }

    public static void main(String[] args) {
        Words words = new Words();
        List<String> uniqueWords = Words.getUniqueWordsFromSentence("A cat Sat on a mat; a Monkey sat on the Cat.");

        List<String> expectedResult = List.of("a", "cat", "sat", "on", "the", "mat", "monkey");

        assert uniqueWords.size() == 7 : "The size should be 7";
        for (String word : expectedResult) {
            assert uniqueWords.contains(word) : String.format("Word '%s' should be included", word);
        }

        System.out.println("All tests passed.");
    }

}






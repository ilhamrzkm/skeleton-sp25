import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> treeMap = new TreeMap<>();
        int i = 1;
        for (char ch = 'a'; ch <= 'z'; ch += 1) {
            treeMap.put(ch, i);
            i += 1;
        }
        return treeMap;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer, Integer> treeMap = new TreeMap<>();

        if (nums.isEmpty()) {
            return treeMap;
        } else {
            for (int n : nums) {
                treeMap.put(n, n * n);
            }
            return treeMap;
        }
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> treeMap = new TreeMap<>();

        for (String word : words) {
            if (treeMap.containsKey(word)) {
                treeMap.put(word, treeMap.get(word) + 1);
            } else {
                treeMap.put(word, 1);
            }
        }
        return treeMap;
    }
}

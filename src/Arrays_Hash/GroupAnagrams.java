package Arrays_Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap<signature, List<String>>
        HashMap<String, List<String>> groups = new HashMap<>();

        for(String s: strs){
            // create anagram signature by sorting the word
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            // lookup the map. Add the word to list. Create a new list if signature/key doesn't exist
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groups.values());

    }
}

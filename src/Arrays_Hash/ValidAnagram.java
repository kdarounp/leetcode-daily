package Arrays_Hash;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    //Hash Table Implementation
    public boolean isAnagramHashTableImp(String s, String t){
        if(s.length() != t.length()) return false;

        int[] count = new int[26];

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int c: count) if(c != 0) return false;

        return true;
    }

    //Hash Map Impl
    public boolean isAnagramHashMapImp(String s, String t){
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i) , 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i) , 0) + 1);

        }
        return countS.equals(countT);
    }

    public boolean isAnagramSortImp(String s, String t){
        if(s.length() != t.length()) return false;

        char[] sortS = s.toCharArray();
        char[] sortT = t.toCharArray();

        Arrays.sort(sortS);
        Arrays.sort(sortT);

        return Arrays.equals(sortS, sortT);
    }


}

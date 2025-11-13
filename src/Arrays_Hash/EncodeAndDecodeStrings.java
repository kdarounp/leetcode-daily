package Arrays_Hash;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s: strs){
            // append its length - append delimiter # - append the actual string
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#') j++;

            int len = Integer.parseInt(str.substring(i, j));
            j++; // skip #

            String word = str.substring(j, j + len);
            result.add(word);

            i = j + len;
        }

        return result;

    }
}


/*
High-Level Strategy:
Prefix each string with its length, followed by a special separator.


Low-Level Strategy:
Encoding:
1. Initialize a StringBuilder.
2. For each string s in strs:
    - Append its length.
    - Append a delimiter (e.g. #).
    - Append the actual string.
3. Return the combined result.

Decoding:
1. Initialize an empty list.
2. Start reading from index i = 0:
    - Read digits until you hit # → that gives you the length.
    - Convert that substring to an integer len.
    - Move past # and extract the next len characters → that’s one string.
    - Add it to the result list.
    - Move i to the start of the next encoded section.
* */

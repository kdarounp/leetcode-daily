public class LongestCommonPrefix {
    public String longestCommonPrefix(String... strs){
        if(strs == null || strs.length == 0) return "";

        // assume the first string is the prefix
        String prefix = strs[0];

        // compare prefix with each string in the array
        for (int i = 1; i < strs.length; i++){
            //while the current string does not start with the prefix
            //shorten the prefix
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}

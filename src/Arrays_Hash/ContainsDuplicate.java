package Arrays_Hash;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        for (int num: nums){
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}

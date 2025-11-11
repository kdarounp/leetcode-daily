import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        // map<value, index>
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            // calculate complement
            int complement = target - nums[i];

            // check if we have already seen the complement
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }

            //otherwise store the current value
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}

package Arrays_Hash;

public class ProductsOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];

        int prefix = 1;
        for(int i = 0; i < nums.length; i++){
            // use prefix for the current index
            result[i] = prefix;

            // calculate prefix for the next index using this index's value
            prefix = prefix * nums[i];
        }

        int postfix = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            // multiply prefixes by postfixes
            result[i] = result[i] * postfix;

            // calculate postfix for the next index using this index's value
            postfix = postfix * nums[i];

        }

        return result;
    }
}



/*
High-Level Strategy:
For each index i, the product of “everything except nums[i]” is:
(left side product) * (right side product)


Low-Level Strategy:

prefix = 1
for i from 0 to n-1:
    result[i] = prefix  --> // set this value to prefix, which is the product of everything before it
    prefix *= nums[i]   --> // update/calculate prefix for the next index using this index's value


postfix = 1
for i from n-1 down to 0:
    result[i] *= postfix  --> going into this loop result[] array starts as only the prefixes. we multiply each answer[i] by the postfix value so each answer[i] becomes prefix × postfix.
    postfix *= nums[i]    --> This prepares postfix for the next index to the left
 */

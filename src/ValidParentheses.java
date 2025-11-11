import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            //If opening brackets, push to stack
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                //If stack is empty, no brackets to match
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // Check if it matches
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // Valid only if no unmatched brackets remain. There could be opening char in there that we never saw a closing for
        return stack.isEmpty();


    }
}
/*
1. Create a stack.
2. Loop through each character c in the string s.
3. If c is an opening bracket → push it onto the stack.
4. If c is a closing bracket:
    - If the stack is empty, return false (nothing to match).
    - Pop the top of the stack → this is the bracket we expect to match.
    - Check if the popped bracket corresponds to the closing bracket.
        - If not → return false.

5. After processing all characters:
    - If the stack is empty, return true.
    - If the stack has leftover brackets → return fals


| Character | Action                     | Stack       |
| --------- | -------------------------- | ----------- |
| `(`       | push                       | `(`         |
| `[`       | push                       | `([`        |
| `]`       | matches with top `[` → pop | `(`         |
| `)`       | matches with top `(` → pop | ` ` (empty) |

* */
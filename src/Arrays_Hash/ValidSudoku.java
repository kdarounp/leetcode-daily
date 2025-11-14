package Arrays_Hash;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char ch = board[r][c];

                if(ch == '.') continue;

                // map char digit to index 0-8
                int d = ch - '1';

                // calculate box index
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If we've already seen this digit in the row, column, or box → invalid
                if(rows[r][d] || cols[c][d] || boxes[boxIndex][d]) return false;

                // mark digit as seen
                rows[r][d] = true;
                cols[c][d] = true;
                boxes[boxIndex][d] = true;
            }
        }
        return true;
    }
}



/*
High-level:
For each filled cell (r, c) with digit d:
- Check if d has already appeared in:
    - Row r
    - Column c
    - 3×3 box that (r, c) belongs to

If yes → board is invalid → return false.
If we finish scanning every cell without a conflict → return true.


Low-Level:
Three 2d boolean arrays to keep track of what we have seen
2 loops: outer for rows and inner for cols:
- get the character in the cell
- if the character is a '.' skip to the next iteration if not:
- map the char to a int between 0-8
- calculate box index
- check if we have seen the number before
- if we come out of both loops, return true.

*/

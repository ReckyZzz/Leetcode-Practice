package backtrack;

/**
 * 37. 解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 * */
public class Sudoku {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    // 返回值boolean做标记，找到结果立刻返回，不用再去搜索了
    boolean backtracking(char[][] board) {
        // 不需写终止条件
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 空格才进行处理
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(i, j, k, board)) {
                            board[i][j] = k;
                            boolean result = backtracking(board);
                            if (result == true) // 找到了数独的一个解，直接返回
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    // 尝试了9个数都不行，说明棋盘里没找到结果
                    return false;
                }
            }
        }
        // 选数一直都能选中，说明棋盘填满了
        return true;
    }

    private boolean isValid(int row, int col, char c, char[][] board) {
        // 判断第row行
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c)
                return false;
        }
        // 判断col列
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;
        }
        // 判断3*3
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == c)
                    return false;
            }
        }
        return true;
    }
}

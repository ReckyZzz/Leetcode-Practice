package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 *
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * */
public class NQueen {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtracking(chessboard, n, 0);
        return result;
    }

    // 第n次递归取第n行
    void backtracking(char[][] chessboard, int n, int row) {
        if (row >= n) {
            result.add(array2List(chessboard));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row, i, chessboard, n)) {
                chessboard[row][i] = 'Q';
                backtracking(chessboard, n, row + 1);
                // 回溯
                chessboard[row][i] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, char[][] chessboard, int n) {
        // 同一列有无Q
        for (int i = 0; i < n; i++) {
            if (chessboard[i][col] == 'Q')
                return false;
        }
        // 检查左上对角线，往上检查，不往下检查，因为是从上往下一行行遍历
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q')
                return false;
        }
        // 检查右上对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q')
                return false;
        }
        return true;
    }

    private List<String> array2List(char[][] chars) {
        List<String> list = new ArrayList<>();
        for (char[] c: chars) {
            list.add(String.valueOf(c));
        }
        return list;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        List<List<String>> lists = nQueen.solveNQueens(4);
        System.out.println(lists);
    }
}

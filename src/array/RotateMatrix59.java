package array;

/**
 * 数组部分第4题，59.螺旋矩阵II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * */
public class RotateMatrix59 {
    public int[][] generateMatrix(int n){
        int startX = 0, startY = 0;
        int offset = 1;
        int count = 1;
        int i, j;
        int loop = 0;
        int [][] nums = new int[n][n];
        //while循环控制转几圈
        while(loop < (n / 2)){
            loop++;
            //行不动，列动，从左上往右上
            for(j = startY; j < n - offset; j++){
                nums[startX][j] = count++;
            }
            //行动，列不动，从右上到右下
            for(i = startX;i < n - offset;i++){
                nums[i][j] = count++;
            }
            //行不动，列动，从右下往左下
            for(;j > startY; j--){
                nums[i][j] = count++;
            }
            //行动，列不动，从左下往左上
            for(;i > startX; i--){
                nums[i][j] = count++;
            }
            //一圈走完之后，起始位置加1
            // 往里走一圈，offset加1
            startX++;
            startY++;
            offset++;
        }

        if(n % 2 == 1){
            nums[startX][startY] = count;
        }
        return nums;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] res;
        RotateMatrix59 rotateMatrix = new RotateMatrix59();
        res = rotateMatrix.generateMatrix(n);
        for(int[] row:res){
            for(int i:row){
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}

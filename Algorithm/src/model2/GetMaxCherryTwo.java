/**
 * @ClassName: GetMaxCherryTwo
 * @Description:
 * @author: 千山
 * @date: 2023-03-28 15:22
 * @Blog: 暂无
 */

package model2;

import java.util.Arrays;

/**
 *
 * @ClassName: GetMaxCherryTwo
 * @Description:
 * @author: 千山
 * @date: 2023-03-28 15:22
 * @Blog: 暂无
 */
public class GetMaxCherryTwo {

    public static void main(String[] args) {
        int i = cherryPickup1(new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}});
        System.out.println(i);
    }

    class Solution {
        public int cherryPickup(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[][][] dp = new int[m][n][n];
            boolean[][][] valid = new boolean[m][n][n];
            dp[0][0][n - 1] = grid[0][0] + grid[0][n - 1];
            valid[0][0][n - 1] = true;

            for (int i = 1; i < m; ++i) {
                for (int j1 = 0; j1 < n; ++j1) {
                    for (int j2 = 0; j2 < n; ++j2) {
                        int t = grid[i][j1];
                        if (j1 != j2) {
                            t += grid[i][j2];
                        }
                        boolean ok = false;
                        for (int y1 = j1 - 1; y1 <= j1 + 1; ++y1) {
                            for (int y2 = j2 - 1; y2 <= j2 + 1; ++y2) {
                                if (y1 >= 0 && y1 < n && y2 >= 0 && y2 < n && valid[i - 1][y1][y2]) {
                                    dp[i][j1][j2] = Math.max(dp[i][j1][j2], dp[i - 1][y1][y2] + t);
                                    ok = true;
                                }
                            }
                        }
                        valid[i][j1][j2] = ok;
                    }
                }
            }
            int ans = 0;
            for (int j1 = 0; j1 < n; ++j1) {
                for (int j2 = 0; j2 < n; ++j2) {
                    ans = Math.max(ans, dp[m - 1][j1][j2]);
                }
            }
            return ans;
        }
    }



    public static int cherryPickup1(int[][] grid) {
            int m = grid.length, n = grid[0].length;

            // dp[x1][y1][x2][y2]表示机器人从(x1, y1)(x2, y2)出发到达底行的最大得分
            // 观察到x1 == x2 始终成立，降维——dp[x][y1][y1]
            int[][][] dp = new int[m][n][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    Arrays.fill(dp[i][j], Integer.MIN_VALUE);
                }
            }
            //起始位置
            dp[0][0][n - 1] = grid[0][0] + grid[0][n - 1];

            for(int x = 1; x < m; x++){
                for(int y1 = 0; y1 < n; y1++){
                    for(int y2 = n - 1; y2 >= y1; y2--){
                        //上+上
                        dp[x ][y1][y2] = dp[x - 1][y1][y2];
                        //左+左
                        if(y1 > 0)dp[x ][y1][y2]  = Math.max(dp[x][y1][y2], dp[x - 1][y1 - 1][y2 - 1]);
                        //右+右
                        if(y2 < n - 1)dp[x ][y1][y2]  = Math.max(dp[x][y1][y2], dp[x - 1][y1 + 1][y2 + 1]);
                        //左+右
                        if(y1 > 0 && y2 < n - 1)dp[x ][y1][y2]  = Math.max(dp[x][y1][y2], dp[x - 1][y1 - 1][y2 + 1]);
                        //右+左
                        if(y1 < n - 1 && y2 > 0)dp[x ][y1][y2]  = Math.max(dp[x][y1][y2], dp[x - 1][y1 + 1][y2 - 1]);

                        //上+左
                        if(y2 > 0)dp[x ][y1][y2]  = Math.max(dp[x][y1][y2], dp[x - 1][y1][y2 - 1]);

                        // 上+右
                        if(y2 < n - 1)dp[x ][y1][y2]  = Math.max(dp[x][y1][y2], dp[x - 1][y1][y2 + 1]);

                        //左+上
                        if(y1 > 0)dp[x ][y1][y2]  = Math.max(dp[x][y1][y2], dp[x - 1][y1 - 1][y2]);

                        //右+上
                        if(y1 < n - 1)dp[x ][y1][y2]  = Math.max(dp[x][y1][y2], dp[x - 1][y1 + 1][y2]);

                        //加上当前层的得分
                        if(y1 == y2)dp[x][y1][y2] += grid[x][y1];
                        else dp[x][y1][y2] +=  (grid[x][y1] + grid[x][y2]);
                    }
                }
            }
            //寻找最大值
            int res = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    res = Math.max(res, dp[m - 1][i][j]);
                }
            }
            return res;

        }

    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        dp[0][0][n-1] = grid[0][0] + grid[0][n-1];

        for (int k = 1; k < m ; k++) {
            for (int i1 = 0; i1 < n; i1++) {
                for (int i2 = n-1; i2 >=i1 ; i2--) {
                    //上上
                    int res = dp[k-1][i1][i2];
                    //左左
                    if (i1>0 ) res=Math.max(res,dp[k-1][i1-1][i2-1]);
                    //右右
                    if (i2 <n-1) res=Math.max(res,dp[k-1][i1+1][i2+1]);
                    //上左
                    if (i2>0) res=Math.max(res,dp[k-1][i1][i2-1]);
                    // 上右
                    if (i2<n-1) res=Math.max(res,dp[k-1][i1][i2+1]);
                    // 左 上
                    if (i1>0 )res=Math.max(res,dp[k-1][i1-1][i2]);
                    // 右上
                    if (i1<n-1)res=Math.max(res,dp[k-1][i1+1][i2]);
                    // 左右
                    if (i1>0 && i2<n-1)res=Math.max(res,dp[k-1][i1-1][i2+1]);
                    // 右 左
                    if (i1<n-1&& i2>0)res=Math.max(res,dp[k-1][i1+1][i2-1]);




                    dp[k][i1][i2] = res;
                    if (i1==i2){
                        dp[k][i1][i2] += grid[k][i1];
                    } else {
                        dp[k][i1][i2] += grid[k][i1] + grid[k][i2];
                    }

                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                 max  = Math.max(dp[m-1][i][j],max);
            }
        }
        return max;
    }
}

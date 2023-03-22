/**
 * @ClassName: DistanceAdd
 * @Description:
 * @author: 千山
 * @date: 2023-03-22 10:41
 * @Blog: 暂无
 */

package model1;

import java.util.Arrays;

/**
 *
 * @ClassName: 370区间加法
 * @Description:
 * @author: 千山
 * @date: 2023-03-22 10:41
 * @Blog: 暂无
 */
public class DistanceAdd {
    public static void main(String[] args) {
        //int[] ints = getModifiedArray(5, new int[][]{{1,3,2},{2,4,3},{0,2,-2}});
        int[] ints = getModifiedArray(5, new int[][]{{1,3,2}});
        System.out.println(Arrays.toString(ints));

        System.out.println(2&-2);
    }

    public static int[] addStartEnd(int length,int[][] updates){
        int[] ints = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int addNum = updates[i][2];
            for (; start <= end; start++) {
                ints[start] += addNum;
            }
        }
        return ints;
    }

    /**
     *  差分数组
     * @param length
     * @param updates
     * @return
     */
    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] d = new int[length];
        for (int[] e : updates) {
            int l = e[0], r = e[1], c = e[2];
            d[l] += c;
            if (r + 1 < length) {
                d[r + 1] -= c;
            }
        }
        for (int i = 1; i < length; ++i) {
            d[i] += d[i - 1];
        }
        return d;
    }
}

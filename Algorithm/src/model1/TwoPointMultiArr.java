/**
 * @ClassName: TwoPointMultiArr
 * @Description:
 * @author: 千山
 * @date: 2023-03-23 14:14
 * @Blog: 暂无
 */

package model1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: 713. 乘积小于 K 的子数组
 * @Description:
 * @author: 千山
 * @date: 2023-03-23 14:14
 * @Blog: 暂无
 */
public class TwoPointMultiArr {
    public static void main(String[] args) {
        int[] ints = new int[]{1,5,2,6};
        int[] int2 = new int[]{2,3,1,2,4,3};


        System.out.println(Math.log(9));
        System.out.println(numSubarrayProductLessThanK(ints, 100));


    }

    // 双指针模板
    public void test(int[]arr){
//        for (int i = 0,j=0; i <arr.length ; i++) {
//            while (j<i && check()){
//                j++;
//            }
//            //具体问题逻辑
//        }
    }


    /**
     * ans += r - l +1;是怎么得来的？
     *
     * 对于有n个元素的集合：
     *
     * 包含 1 个元素的子集有 n 个
     * 包含 2 个连续元素的子集有 n - 1 个
     * ...
     * 包含 n 个连续元素的子集有 1 个
     * 总共有 1 + 2 + 3 +... + n = （n+1）*n/2个连续元素的子集
     * 那么对于n-1个元素的集合：共有(n) * (n-1)/2个连续元素的子集。
     *
     * (n+1)n/2 - n(n-1)/2 = n/2 * (2)=n 对于n-1个元素的集合，增加第n个元素，则增加的连续元素子集数为n个。
     *
     * 对于a[l] ... a[r - 1] 的集合，增加第r个元素a[r]，则增加的连续元素子集数为 a[l] ... a[r] 范围内的元素总数即 r - l +1个。
     * @param nums
     * @param k
     * @return
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0){
            return 0;
        }
        int res = 0;
        for(int i = 0, j = 0, s =1;i<n;i++){
            s *= nums[i];
            while(j<=i && s >= k){
                s /= nums[j++];
            }
            res += i - j+1;
        }
        return res;
    }




}

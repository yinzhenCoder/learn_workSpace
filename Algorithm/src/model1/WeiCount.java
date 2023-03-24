/**
 * @ClassName: WeiCount
 * @Description:
 * @author: 千山
 * @date: 2023-03-23 16:30
 * @Blog: 暂无
 */

package model1;

/**
 *
 * @ClassName: 191. 位 1 的个数
 * @Description:
 * @author: 千山
 * @date: 2023-03-23 16:30
 * @Blog: 暂无
 */
public class WeiCount {

    public static void main(String[] args) {
        //hammingWeight1(11);
        Long l  = 1L;
        int i = 0;
        i = l.intValue();
        System.out.println(l.intValue());
    }

    public static int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            // 计算每个二进制数位为1的值
        /*1
        00000001
        2
        00000010
        4
        00000100
        8
        00001000

        */
            /*
            二进制位与用算，只有 1&1时结果是1，否则为0
             */
            System.out.println((1 << i));
            if ((n & (1 << i)) != 0) {
                // 12 & 5 可以得出4，两者都为1的才是1，为0的全是0,所以取决于两个数最小数中的1的个数。
                System.out.println("与的结果："+(n & (1 << i)));
                ret++;
            }
        }
        return ret;
    }


    public static int hammingWeight1(int n) {
        int ans = 0;
        while (n != 0) {
            n &= n - 1;
            ++ans;
        }
        return ans;
    }


}

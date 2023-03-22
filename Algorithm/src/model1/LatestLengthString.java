/**
 * @ClassName: LatestLengthString
 * @Description:
 * @author: 千山
 * @date: 2023-03-22 17:44
 * @Blog: 暂无
 */

package model1;

/**
 *
 * @ClassName: 3. 无重复字符的最长子串
 * @author: 千山
 * @date: 2023-03-22 17:44
 * @Blog: 暂无
 */
public class LatestLengthString {

    public static void main(String[] args) {
        System.out.println(getLength("pwwkew"));


    }

    public static int getLength(String s){
        int num = 1;
        int maxNum = 1;

        StringBuilder sb = new StringBuilder().append(s.charAt(0));
        for (int i = 1 ; i <s.length() ; i++) {
            char c = s.charAt(i);
            int i1 = sb.toString().indexOf(c);
            if (i1==0){
               sb.deleteCharAt(i1);
               sb.append(c);


            } else {
                sb.append(c);
                num ++;
                maxNum = num>maxNum?num:maxNum;
            }
        }
        return maxNum;
    }
}

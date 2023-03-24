/**
 * @ClassName: LatestLengthString
 * @Description:
 * @author: 千山
 * @date: 2023-03-22 17:44
 * @Blog: 暂无
 */

package model1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @ClassName: 3. 无重复字符的最长子串
 * @author: 千山
 * @date: 2023-03-22 17:44
 * @Blog: 暂无
 */

/**
 * 模式识别1.一旦涉及出现次数，需要用到散列表
 * 构造子串，散列表存下标
 * 模式识别2，涉及子串，考虑滑动窗口
 *
 */
public class LatestLengthString {

    public static void main(String[] args) {
        System.out.println(getLength("pwwkew"));
        System.out.println(lengthOfLongestSubstring1("abba"));


    }

    //暴力破解
    public static int getLength(String s) {
        int num = 1;
        int maxNum = 1;
        if (s.length() == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder().append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int i1 = sb.toString().indexOf(c);
            if (i1 >= 0) {
                maxNum = num > maxNum ? num : maxNum;
                for (int j = 0; j < sb.length(); ) {
                    sb.deleteCharAt(j);
                    if (sb.toString().indexOf(c) < 0) {
                        num = sb.length();
                        break;
                    }
                }
                sb.append(c);
                num++;
            } else {
                sb.append(c);
                num++;
                maxNum = num > maxNum ? num : maxNum;
            }
        }
        return maxNum;
    }

    //双指针 + 哈希表
    public static int lengthOfLongestString(String s) {
        Set<Character> ss = new HashSet<>();
        int i = 0, ans = 0;
        for (int j = 0; j < s.length(); ++j) {
            char c = s.charAt(j);
            while (ss.contains(c)) {
                //直接进行移除元素
                ss.remove(s.charAt(i++));
            }
            ss.add(c);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }


    // 滑动窗口 最大
    public static int lengthOfLongestSubstring1(String s) {
//            if (s.length()==0) return 0;
//            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//            int max = 0;
//            int left = 0;
//            for(int i = 0; i < s.length(); i ++){
//                if(map.containsKey(s.charAt(i))){
//                    left = Math.max(left,map.get(s.charAt(i)) + 1);
//                }
//                map.put(s.charAt(i),i);
//                max = Math.max(max,i-left+1);
//            }
//            return max;
//
//        }

        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        int maxNum = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                /**
                 * 要理解下面的代码首先要想明白获得最长字串的逻辑
                 * 这里一共存在两个变量：
                 *  - left：表示字串最左边字符的索引位置
                 *  - i：遍历的每个字符索引位置，我们全靠这个字符来完成这道题，i这个变量存在三种情况需要考虑
                 *      1） s.charAt(i)在[left, i)之间不存在重复字符
                 *          - 就把s.charAt(i)放到map中，最长长度同时也加一
                 *      2） s.charAt(i)在[left, i)之间存在重复字符
                 *          - 获得[left, i)范围内重复字符的下标h，让left = h + 1，此时新的字串开始匹配，新的长度变成了i - left + 1 = 1
                 *          - 更新map中重复字符的索引位置为i
                 *      3） s.charAt(i)在[0, left)之间存在重复字符
                 *          - 我们在发现重复字符后都要更新该字符在map中的索引位置，就是为了避免之前的重复元素对当前判断造成影响
                 *          - 但是譬如acbba这样一个字符：当遍历到第二个b时，可知h = map.get('b')，所以h=2，那么newLeft=h+1=3;
                 *              之后遍历到字符a，h = map.get('a')，发现此时h=0，newLeft=h+1=1；这种情况明显不合理，所以要求left=Math.max(left, newLeft)
                 *          - 更新map中重复字符的索引位置为i，最长长度同时也加一
                 *
                 */
                //需要是跳过该字符，所以要+1,但是因为没有移除前边的元素，为防止起始点回跳，添加最大值判断
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            maxNum = Math.max(maxNum, i - left + 1);
        }

        return maxNum;
    }



}
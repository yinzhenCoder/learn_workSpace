package model1; /**
 * @ClassName: model1.multiplication
 * @Description:
 * @author: 千山
 * @date: 2023-03-21 16:05
 * @Blog: 暂无
 */

/**
 *
 * @ClassName: model1.multiplication
 * @Description:
 * @author: 千山
 * @date: 2023-03-21 16:05
 * @Blog: 暂无
 */
public class multiplication {

    public static void main(String[] args) {
        /*System.out.println(addMethod("123", "456"));

        System.out.println(subMethod("1234554", "678"));

        int i = "5".compareTo("12333");
        System.out.println(i);*/

        //System.out.println(twoNumMultiplication("9133", "0"));
        System.out.println(multiply("1234", "567"));
    }

    //竖式先加优化
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        int[] res1 = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                //res1[res1.length-1] =  sum % 10;
                res[i + j] += sum / 10;
                //res[res1.length-2] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }




    //竖式相加
    public static String  twoNumMultiplication(String num1,String num2){

        String res = "0";
        for (int i = num1.length()-1; i>=0; i--) {
            int a = num1.charAt(i)  - '0';
            int x = 0;
            StringBuilder sb = new StringBuilder();

            for (int j = num1.length()-1; j>i ; j--) {
                sb.append(x);
            }
            for (int j = num2.length()-1; j >=0 || x >0  ; j--) {
               int  b = j <0 ?0:num2.charAt(j) - '0';
                x = a * b + x;
                sb.append(x%10);
                x = x/10;

            }
            res = addMethod(res,sb.reverse().toString());

        }
        return res;
    }

    public static String addMethod(String num1,String num2){
        int i = num1.length()-1,j = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k > 0 || i >=0 || j>= 0;) {
            int a = i <0 ? 0:num1.charAt(i--) -'0';
            int b = j <0? 0:num2.charAt(j--) - '0';

            k = a + b + k;
            sb.append(k%10);
            k = k/10;
        }

        return sb.reverse().toString();
    }


    public static String subMethod(String num1,String num2){
        int i = num1.length()-1,j = num2.length()-1;
        String a = num1,b=num2;
        boolean flag = false;
        //判断哪个数大，先根据长度，然后再根据每个字符串每个acsi码值来进行比较
        if (i<j || (i == j && num1.compareTo(num2) < 0 )){
            a = num2;
            b = num1;
            flag = true;
            i = j;
            j = i;
        }
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while ( i >= 0) {
            int x = i <0 ? 0:a.charAt(i--) -'0';
            int y = j <0? 0:b.charAt(j--) - '0';
            k = x-k -y ;
            sb.append((k+10)%10);
            k = k <0?1:0;
        }
        if (flag){
            sb.append("-");
        }
        return sb.reverse().toString();
    }



    class Solution {
        /**
         * 计算形式
         *    num1
         *  x num2
         *  ------
         *  result
         */
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            // 保存计算结果
            String res = "0";

            // num2 逐位与 num1 相乘
            for (int i = num2.length() - 1; i >= 0; i--) {
                int carry = 0;
                // 保存 num2 第i位数字与 num1 相乘的结果
                StringBuilder temp = new StringBuilder();
                // 补 0
                for (int j = 0; j < num2.length() - 1 - i; j++) {
                    temp.append(0);
                }
                int n2 = num2.charAt(i) - '0';

                // num2 的第 i 位数字 n2 与 num1 相乘
                for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                    int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                    int product = (n1 * n2 + carry) % 10;
                    temp.append(product);
                    carry = (n1 * n2 + carry) / 10;
                }
                // 将当前结果与新计算的结果求和作为新的结果
                res = addStrings(res, temp.reverse().toString());
            }
            return res;
        }

        /**
         * 对两个字符串数字进行相加，返回字符串形式的和
         */
        public String addStrings(String num1, String num2) {
            StringBuilder builder = new StringBuilder();
            int carry = 0;
            for (int i = num1.length() - 1, j = num2.length() - 1;
                 i >= 0 || j >= 0 || carry != 0;
                 i--, j--) {
                int x = i < 0 ? 0 : num1.charAt(i) - '0';
                int y = j < 0 ? 0 : num2.charAt(j) - '0';
                int sum = (x + y + carry) % 10;
                builder.append(sum);
                carry = (x + y + carry) / 10;
            }
            return builder.reverse().toString();
        }
    }

}

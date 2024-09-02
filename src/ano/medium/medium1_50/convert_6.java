package ano.medium.medium1_50;

public class convert_6 {

    //将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
    //
    //比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
    //
    //P   A   H   N
    //A P L S I I G
    //Y   I   R
    //之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"

    //思路
    //一: 直接用N行的StringBUi来存储按照计数器的顺序存储的Str, 然后最后拼接起来


    public String convert(String s, int numRows) {

        //短路:
        if (s.length() == 1) {
            return s;
        }
        if (numRows == 1) {
            return s;
        }

        //? 一: 普通N行String
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        //批量赋值
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (int p = 0; p < s.length(); p++) {
            stringBuilders[currentRow].append(s.charAt(p));
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }


        //Merge and print
        StringBuilder collect = new StringBuilder();
        for (StringBuilder b : stringBuilders) {
            collect.append(b);
        }
        return collect.toString();
    }

    public static void main(String[] args) {
        String s;
        int numRows;

        s = "PAYPALISHIRING";
        numRows = 3;
        System.out.println(new convert_6().convert(s, numRows));
        System.out.println();
        //PAHNAPLSIIGYIR
    }
}

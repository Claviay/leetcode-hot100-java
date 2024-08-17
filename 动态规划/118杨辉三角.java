import java.util.*;
class Solution {
    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        //定义一个临时存储上一行结果的集合
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            // 这里的temp其实是不断更新的
            temp = getRow(temp, i);
            result.add(temp);
        }
        return result;
    }

    //该方法通过上一行的数据计算出本行的数据
    public static ArrayList<Integer> getRow(List<Integer> list, int n) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                integers.add(1);
            } else {
                integers.add(list.get(i - 1) + list.get(i));
            }
        }
        return integers;
    }
}

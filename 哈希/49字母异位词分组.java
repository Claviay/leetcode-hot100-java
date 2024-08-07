import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
问题1：不能使用数组作为HashMap的键！
在Java中，数组的equals()方法没有被重写，它依然使用的是Object类中的equals()方法，
该方法比较的是引用而不是内容。因此，尽管两个数组的内容相同，但它们的引用不同，
使用数组作为HashMap的键会导致不可预期的行为。
解决这个问题的方法是将数组转换成一个唯一的字符串表示，
或者使用一个自定义对象并重写其equals()和hashCode()方法。
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();  // str转成和char[]
            java.util.Arrays.sort(chars);  // 排序
            String sorted = new String(chars); // 再把char[]转换回str

            // 如果本来key没有，则新建一个
            List<String> list = map.getOrDefault(sorted, new ArrayList<>());

            list.add(str);
            map.put(sorted, list); // 更新答案，更新这个str对应的答案集合
        }

        return new ArrayList<>(map.values());


        //这就是为什么下面答案中每一个list的list的里面只有一个str，
        // 因为每次key都是数组引用
        // 所以key每次都不一样了
        // key比较的是equals方法
//        HashMap<int[], List<String>> map = new HashMap<>();
//        for (String str : strs) {
//            int[] arr = new int[26];
//            for (char c : str.toCharArray()) {
//                arr[c - 'a']++;
//            }
//            List<String> list = new ArrayList<>();
//            list = map.getOrDefault(arr, new ArrayList<>());
//            list.add(str);
//            map.put(arr, list);
//
//        }
//
//        List<List<String>> ans = new ArrayList<>();
//        for (int[] arr : map.keySet()) {
//            List<String> list = map.get(arr);
//            ans.add(list);
//        }
//        return ans;


    }
}

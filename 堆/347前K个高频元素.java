import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));  // 反过来
//        list.sort(Map.Entry.comparingByValue());

        int flag = k;
        for(Map.Entry<Integer,Integer> entry:list){
            if (flag == 0) {
                break;
            }
            flag--;
            res.add(entry.getKey());
        }

        return res.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] arr = new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

class Solution {
    int getIndex(char x) {
        if (x >= 'A' && x <= 'Z') {
            return x - 'A';
        }

        return x - 'a' + 26;
    }

    public String minWindow(String s, String t) {
        int difference = 0;

        int[] arrS = new int[52]; // 存大小写字母各26字母
        int[] arrT = new int[52];

        for (int i = 0; i < t.length(); i++) {
            arrT[getIndex(t.charAt(i))]++;
            if (arrT[getIndex(t.charAt(i))] == 1) {
                difference++;
            }
        }

        String res = "";

        for (int left = 0, right = 0; right < s.length(); right++) {
            int rightIndex = getIndex(s.charAt(right));
            arrS[rightIndex]++;
            if (arrS[rightIndex] == arrT[rightIndex]) {
                difference--;
            }

            // 左边界移动
            while (left < right) {
                int leftIndex = getIndex(s.charAt(left));

                if (arrS[leftIndex] > arrT[leftIndex]) {
                    arrS[leftIndex]--;
                    left++;
                } else {
                    break;
                }
            }


            // res更新
            if (difference == 0 && ((right -left + 1 < res.length()) || res.length() == 0)) {
                res = s.substring(left, right + 1);
            }
        }

        return res;
    }
}

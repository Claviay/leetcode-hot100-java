import java.util.*;

class Solution {
    private final List<String> path = new ArrayList<>();
    private final List<List<String>> ans = new ArrayList<>();
    private String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0);
        return ans;
    }

    public void dfs(int i) {
        if (s.length() == i) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j)) {
                path.add(s.substring(i,j+1));
                dfs(j+1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}

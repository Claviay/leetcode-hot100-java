class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int lowest = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > lowest) {
                res = Math.max(res, prices[i] - lowest);
            }
            else {
                lowest = prices[i];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4})); //5
        System.out.println(new Solution().maxProfit(new int[]{7,6,4,3,1})); //0

    }
}

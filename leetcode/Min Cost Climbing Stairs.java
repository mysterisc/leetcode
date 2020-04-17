/*
Min Cost Climbing Stairs

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
cost will have a length in the range [2, 1000].
Every cost[i] will be an integer in the range [0, 999].

*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length, pre = 0, cur = 0;
        for(int i = 2; i < len + 1; i++) {
            int temp = cur;
            cur = Math.min(pre + cost[i-2], cur + cost[i-1]);
            pre = temp;
        }
        return cur;
    }
}
/*
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length, min_cost = 0;
         int[] dp = new int[len];
        if(len >= 0) dp[0] = 0;
        if(len >= 2) {
            dp[1] = Math.min(cost[0], cost[1]);
        }
        if(len >= 3 ) {
            dp[2] = Math.min(dp[1], dp[0] + dp[1]);
        }
        for(int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i-2] + Math.min(cost[i], cost[i-1]));
        }
        return dp[len-1];
    }
}*/
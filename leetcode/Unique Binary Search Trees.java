/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
*/

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        // 根据公式 1...n为结点组成的二叉搜索树的个数为G(n)
        // G(n) = f(1) + f(2) + ... + f(n)
        // f(i) 即 以i为根的二叉搜索树的个数
        // f(i) = G(i-1)*G(n-i)

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] + dp[i-j];
            }
        }
        return dp[n];
    }
}
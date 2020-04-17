/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
    
    List<String> res = new ArrayList<>();
    
    //动态规划
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for(int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for(int j = 0; j <= i-1; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i-j-1);
                for(String s1: str1) {
                    for(String s2: str2) {
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

    /*
    //Breadth First Search
    public List<String> generateParenthesis(int n) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, n, ""));
        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            if(curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.str);
            }
            if(curNode.left > 0) {
                queue.offer(new Node(curNode.left-1, curNode.right, curNode.str + "("));
            }
            // 剪枝
            if(curNode.right > 0 && curNode.right > curNode.left) {
            queue.offer(new Node(curNode.left, curNode.right-1, curNode.str + ")"));
            }
        }
        return res;
    }

    class Node {
        public int left;
        public int right;
        public String str;

        public Node(int left, int right, String str) {
            this.left = left;
            this.right = right;
            this.str = str;
        } 
    }*/

    /*
    // DFS
    public List<String> generateParenthesis(int n) {
        recurse(0, 0, n, "");
        return res;
    }

    public void recurse(int left, int right, int n, String str) {
        if(str.length() == n*2) {
            res.add(str);
            return;
        }
        if(left < n) {
            recurse(left+1, right, n, str + "(");
        }
        if(right < left) {
            recurse(left, right+1, n, str + ")");
        }
    }*/
}
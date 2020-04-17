/*
输入一个字符串，打印出该字符串中字符的所有排列。

 

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 

示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
 

限制：

1 <= s 的长度 <= 8
*/
class Solution {
    
    ArrayList<String> ans = new ArrayList<>();

    public String[] permutation(String str) {
        if(str.length() == 0 || str == null) return new String[0];
        boolean[] visited = new boolean[str.length()];
        reverse(str, "", visited);
        return new String[1];
    }
    public void reverse(String str, String s, boolean[] visited) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!visited[i] && !set.contains(c)) {
                visited[i] = true;
                set.add(c);
                reverse(str, s + c, visited);
                visited[i] = false;
            }
        }
        if(set.size() == 0) ans.add(s);
    }
}
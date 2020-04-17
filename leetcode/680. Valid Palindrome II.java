/*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

*/

class Solution {
    public boolean validPalindrome(String s) {
		
		//将字符串转换成数组操作可以减小时间消耗 cahr[] str = s.toCharArray()
		char[] str = s.toCharArray();
        int left = 0, right = str.length - 1;
        while(left < right) {
            if(str[left] != str[right]) {
               return secondValid(str, left + 1, right) || secondValid(str, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean secondValid(char[] str, int left, int right) {
        while(left < right) {
            if(str[left++] != str[right--]) {
                return false;
            }
        }
        return true;
    }
}
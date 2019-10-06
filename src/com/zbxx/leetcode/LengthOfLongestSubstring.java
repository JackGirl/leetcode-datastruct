package src.com.zbxx.leetcode;

import java.util.ArrayList;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dsadsadsa"));
	}

	public static int lengthOfLongestSubstring(String s) {
		char[] s1 = s.toCharArray();
		int l = s.length();
		boolean has = false;
		for (int i = 0; i < s1.length - 1; i++) {
			int index = s.substring(i + 1).indexOf(s1[i]);
			if (index == -1) {
				continue;
			} else {
				has = true;
				l = index - 1;
			}

		}
		return l;
	}

}

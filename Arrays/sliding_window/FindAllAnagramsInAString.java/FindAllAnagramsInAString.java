import java.util.*;
public class FindAllAnagramsInAString{

	//Given a string s and p. return a list of indexes of the starting points of all anagrams of p in s.

	public static void main(String[] args){

		System.out.println(findAllAnagramsInAString("cbaebabacd","abc"));

	}

	/*

		The algorithm idea here is to make char freq table and keep track of what kind of chars exist in p.
		Then we do a sliding window to figure out which substrings does the anagram exist in.

	*/

	public static List<Integer> findAllAnagramsInAString(String s, String p){

		List<Integer> results = new ArrayList<>();

		if(s.length() == 0)
			return results;

		int[] charFreq = new int[26];
		for(int i = 0; i < p.length();i++) // find all char freqs in p
			charFreq[p.charAt(i)-'a']++;

		int left = 0; // left of the window
		int right = 0; // right of the window
		int wordLength = p.length(); // keeps track of how many correct chars we have encountered.

		while(right < s.length()){

			if(charFreq[s.charAt(right++)-'a']-- >= 1) // we look up a char of s in the table. if the value >= 1 we decrement the table and word length
				wordLength--; // So if p is length 3 and we find one char in s that is the same as p we are one char closer to an anagram

			if(wordLength == 0) // if this is 0 this means we found an anagram
				results.add(left);

			if(right - left == p.length() && charFreq[s.charAt(left++)-'a']++ > -1) //window is getting to big. Increase left window, and add 1 to freq table at left pointer char.
				wordLength++;

		}

		return results;

	}

}
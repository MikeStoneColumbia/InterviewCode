import java.util.*;
public class Sliding_Window_Dynamic{

	/* 1. Find smallest subarray with sum >= targetSum

	   2. Find Longest substring length with K distinct chars

	*/

	public static int smallestSubarray(int targetSum, int[] arr){

		int currentWindowSum = 0; // keeps track of subarray sum
		int windowStart = 0; // starting index
		int minWindowSize = Integer.MAX_VALUE; // keeps track of window size
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){

			currentWindowSum += arr[windowEnd];

			while(currentWindowSum >= targetSum){

				minWindowSize = Math.min(minWindowSize, windowEnd-windowStart + 1);
				currentWindowSum -= arr[windowStart];
				windowStart++;

			}

		}		

		return minWindowSize;

	}

	public static int longestSubstringLength(int k, char[] chars){

		HashMap<Character,Integer> cache = new HashMap<>();

		int windowStart = 0;
		int largest = Integer.MIN_VALUE;
		int remove = 0;
		for(int windowEnd = 0; windowEnd < chars.length; windowEnd++){

			if(!cache.containsKey(chars[windowEnd])) // not in map then add
				cache.put(chars[windowEnd],1);

			else
				cache.put(chars[windowEnd], cache.get(chars[windowEnd])+1); // increment

			while(cache.size() > k){ // limit exceeded

				remove = cache.put(chars[windowStart], cache.get(chars[windowStart])-1); // remove begining

				if(remove == 1)
					cache.remove(chars[windowStart]); // last one remove from list
				++windowStart; // move starting window up

			}

			largest = Math.max(largest,windowEnd-windowStart+1); // see if new largest found +1 to account for one we removed earlier

		}

		return largest;

	}

	public static void main(String[] args){

		int[] input = new int[] {4,2,2,7,8,1,2,8,10};
		System.out.println(smallestSubarray(8,input));

		System.out.println(longestSubstringLength(2,new char[] {'a','a','a','h','h','i','b','c','c'}));

	}

}

// https://www.youtube.com/watch?v=MK-NZ4hN7rs
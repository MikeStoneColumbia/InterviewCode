import java.util.*;

public class IsPossibleDivide{

	/*

		given an array of integers and int k. Is it possible to divide the list into k parts?
		The nums in the list must be consecutive. Example [1,2,3,4,5,6], k = 2
		Ans => [1,2,3], [4,5,6].
		[1,2,3,4,5,7], k = 2

		[1,2,3], [4,5,7] => this is false since not conescutive.

	*/

	public static void main(String[] args){

		System.out.println(isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11}, 2));

	}

	/*

		Create a tree map that will keep track of all ints and their freqs.
		TreeMaps order items in ascending order so firstKey() always returns the smallest num.
		We get the smallest num and check to see if k-1 consecutive nums exist.
		If a consecutive num does not exist return false.

	*/

	public static  boolean isPossibleDivide(int[] nums, int k){

		if(nums.length == 0)
			return false;

		TreeMap<Integer,Integer> map = new TreeMap<>();

		for(int i : nums)
			map.put(i,map.getOrDefault(i,0)+1);

		while(!map.isEmpty()){

			int smallest = map.firstKey(); // get smallest key.
			map.put(smallest, map.getOrDefault(smallest,0)-1); // decrement freq by 1 since we are using it
			if(map.get(smallest) == 0) // if freq is 0 remove from Map.
				map.remove(smallest);

			for(int i = 1; i < k; i++){

				if(!map.containsKey(smallest+i)) // check to see if we have k-1 consecutive nums
					return false;

				map.put(smallest+i,map.getOrDefault(smallest+i,0)-1); // for every num we find decrement freq by 1.
				if(map.get(smallest+i) == 0) // if freq == 0 remove from list
					map.remove(smallest+i);

			}

		}

		return true;

	}

}
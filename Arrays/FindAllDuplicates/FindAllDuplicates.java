import java.util.*;

public class FindAllDuplicates{

	//Given an array of ints return any duplicates. The largest number in the list wont be bigger than the size of the list.
	//The most any number will appear in the list is twice.

	public static void main(String[] args){

		System.out.println(findAllDuplicates(new int[]{4,3,2,7,8,2,3,1}));

	}

	/*

		Go through the array of Nums. Translate the current number into an index and then check to see if that index
		is negative.

		If it is add the curr num to the list. At the end take the number at the index and make it negative.

		The idea is that if every number is truly unique, if you were to go to the index the number represents the number
		at that index should be posotive. It is only negative if we have visited it before.

	*/

	public static List<Integer> findAllDuplicates(int[] nums){

		List<Integer> results = new ArrayList<>();

		for(int num : nums){

			int posNum = Math.abs(num);

			if(nums[posNum-1] < 0)
				results.add(posNum);

			nums[posNum-1] *= -1;

		}

		return results;

	}

}
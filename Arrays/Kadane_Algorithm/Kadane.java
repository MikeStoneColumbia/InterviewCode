import java.util.*;

// Is very good for solving the largest sum in sub_array problem

public class Kadane{

	public static void main(String args[]){

		int[] test = {-2,1,-3,4,-1,2,1,-5,4};

		System.out.println(KadaneSolution(test));

	}

	public static int KadaneSolution(int [] nums){

		int max = nums[0];
		int curr = nums[0];

		for(int i = 1; i < nums.length; i++){

			curr = Math.max(nums[i], curr + nums[i]);
			max = Math.max(curr,max);

		}

		return max;

	}

}
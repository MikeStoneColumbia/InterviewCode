public class FindPivotIndex{

	public static void main(String[] args){

		System.out.println(findPivotIndex(new int[]{1,7,3,6,5,6,}));

	}

	public static int findPivotIndex(int[] nums){

		//The idea is to find the total sum of the array
		//Then starting from the left keep subtracting one num from the array until we get a match
		//Example [1,7,3,6,5,6] totalSum = 28
		
		int sum, leftSum;
		sum = leftSum = 0;

		for(int i = 0; i < nums.length; i++)
			sum += nums[i];

		for(int i = 0; i < nums.length; i++){

			if(i != 0)
				leftSum += nums[i-1];
			if(sum - leftSum - nums[i] ==  leftSum)
				return i;

		}

		return -1;


	}

	//https://www.youtube.com/watch?v=0PiH6Beqif8

}
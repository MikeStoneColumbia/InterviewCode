public class MySqrt{

	//given a number find the sqrt of it

	public static void main(String[] args){

		System.out.println(mySqrt(10));

	}

	/*

		Using binary search We check the middle of the number.
		If middle * middle is the same as the original then we return (2 * 2 == 4 or 3 * 3 == 9) for num = 4,9
		If middle * middle > num that means everything to the right of middle isnt the answer. IE ignore [middle,num]
		If middle * middle < num that means everything to the left of middle isnt the answer. IE ignore [0, middle]

		Ex if input is 16. Mid would initially be 8. 8 * 8 = 64 so we ignore [8,16].
		64 > 16 so right is now mid - 1. so the range we are looking in is now [0,7]
		mid is now 7/2 which is 3. 3 * 3 == 9 which is less than 16.
		left is now equal to mid + 1. so the range is now [4,7]
		4 * 4 is 16.

	*/

	public static int mySqrt(int num){ 

		int left = 0;
		int right = num;
		long mid;

		while(left <= right){

			mid = ((long)left + (long)right)/2;

			if(mid * mid == num)
				return (int)mid;

			if(mid * mid > num)
				right = (int)mid-1;

			if(mid * mid < num)
				left = (int)mid+1;

		}

		return right;

	}

}
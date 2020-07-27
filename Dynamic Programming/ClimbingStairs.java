public class ClimbingStairs{

	//Problems gives us n stairs that a person can climb. A person can climb the stairs one at a time, or 2 at a time
	//Figure out how many distinct ways to climb the stairs

	/*
		Algorithm idea is to break up this problem into smaller parts.
		Ask yourself, how many ways can we climb a flight of stairs with 0 steps?
		Then, how many ways can we climb a flight of stairs with one step?
		Now to figure out how many ways you can climb a flight of stairs with 2 steps.
		We add the results from the problems 1 and 2 steps ago.
		This simulates us taking into account going up one stair at a time, and 2 steps.

	*/

	public static void main(String[] args){

		System.out.println("Number of ways to go up 10 stairs is: " + climbingStairs(10) );

	}

	public static int climbingStairs(int n){

		int[] cache = new int[n+1]; // keep track of ways to climb stairs at n step
		cache[0] = 1; // Only one way to climb up a flight if stairs with no steps.

		if(n > 0) // only one way to climb up a set of stairs with 1 step.
			cache[1] = 1;

		for(int i = 2; i <= n; i++)
			cache[i] += cache[i-1] + cache[i-2]; // the ways to climb i steps is the ways to climb i-1 steps + ways to climb i-2 steps

		return cache[cache.length-1];

	}

}
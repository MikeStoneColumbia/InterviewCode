public class CoinChangeII{

	public static void main(String[] args){

		System.out.println(coinChangeII(20,new int[]{1,2,3,4,5}));

	}

	// coins are the diff type of coins one can use to return change
	// amount is how much we need to return using the coins
	// Note this algorithm works with the assumption that coins[] is sorted
	
	public static int coinChangeII(int amount, int[] coins){ 

		int[] cache = new int[amount+1]; // index represents amount, and the cache[i] holds # of ways to get that amount with the avilable coins

		cache[0] = 1;

		for(int c: coins) // for each avilable coin
			for(int i = c; i <= amount; i++) // figure out how many ways we can get needed amount using that coin
				cache[i] += cache[i-c];

		return cache[cache.length-1];

		// really helps to draw this out in a list. Just keep in mind index i is the amount, and cache[i] is the num of ways to get that amount using the coins

	}

}
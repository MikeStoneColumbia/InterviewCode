import java.util.*;

public class DailyTemperatures{

	public static void main(String[] args){

		int[] test = dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
		System.out.println(Arrays.toString(test));

	}

	private static int[] dailyTemperatures(int [] T){

		int[] results = new int[T.length];
		Deque<Integer> stack = new ArrayDeque<>();

		for(int i = 0; i <T.length; i++){

			while(!stack.isEmpty() && T[i] > T[stack.peek()]){

				results[stack.peek()] = i - stack.pop();

			}

			stack.push(i);

		}	

		return results;

	}

}

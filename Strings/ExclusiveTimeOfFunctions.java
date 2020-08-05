import java.util.*;

public class ExclusiveTimeOfFunctions{

	/*

		Given a List/array of strings. Each string represents either the start or end of a CPU cycle.
		n represens the number of tasks that will eventually run on the CPU. 
		Find how long each tasks spends on the CPU.
		Every start process will eventually end.
		You will also have no more than n processes.

	*/

	public static void main(String[] args){

		System.out.println(exclusiveTimeOfFunctions(2,new String[] {"0:start:0","1:start:2","1:end:5","0:end:6"}));

	}

	/*

		Have a stack that keeps track of the id and val of a process.
		When we "start" we push the process onto a stack
		When we "end" we pop it off the stack and calc how long it spent.
		If stack isnt empty, we adjust the time to reflect that task 1 was interrupted by task 2.
		task 2 ended then task 1 ended.

		Example from above:

		we see process 0 start at time 0
		stack -> [[0,0]]

		We see precess 1 start at time 2
		stack -> [[0,0],[1,2]]

		process 1 ends
		stack -> [0,0]
		time is 5 - 2 + 1 for process 1. (inclusive of time 2)
		since task 0 was interrupted for 4 seconds we account for that
		so as of rn process 0 has run for -4 secounds

		process 0 ends at time 6.
		6 - 0 + 1 = 7
		-4 + 7 = 3

	*/

	public static int[] exclusiveTimeOfFunctions(int n, String[] logs){


		Stack<Pair<Integer,Integer>> stack = new Stack<>();
		int[] results = new int[n];

		for(String s: logs){

			String[] pieces = s.split(":"); // --> [id,state,time]
			int id = Integer.parseInt(pieces[0]);
			int val = Integer.parseInt(pieces[2]);

			if(pieces[1].equals("start")){

				Pair<Integer,Integer> p = new Pair(id,val); // push id and time into stack
				stack.push(p);

			}else{

				int finalVal = val - stack.pop().getValue() + 1; // calculate runtime

				results[Integer.parseInt(pieces[0])] += finalVal; // add runtime to result list

				if(!stack.isEmpty())
					results[stack.peek().getKey()] -= finalVal; // if there is another item on stack adjust time

			}

		}

		return results;


	}


}
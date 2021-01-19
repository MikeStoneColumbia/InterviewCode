import java.util.*;

/*

	Given a string and a int limit create a string such that the adjacent repeating character are less than k.
	String = tool, k = 2
	result -> tl

	Algorithm:

	Use a Pair obj that holds 2 vals. a char and the chars freq.
	Build a stack of Pairs. Everytime you encounter a new letter build a new Pair and add to stack
	If new letter not encountered retrieve the head of the stack and increment freq by 1
	if freq == k remove that pair
	Finally pop from the stack and build the new string using char and freq vals.

*/

public class RemoveAllAdjDups2{

	public static void main(String[] args){

		System.out.println(removeDuplicates("pbbcggttciiippooaais",2));

	}

	public static String removeDuplicates(String s, int k){

		Stack<Pair> filter = new Stack<>(); // Custom pair class takes char for val and int for freq.
		StringBuilder results = new StringBuilder();

		filter.add(new Pair(s.charAt(0),1)); // add the first letter
		Pair p;

		for(int i = 1; i < s.length(); i++){

			if(filter.isEmpty()){ // if stack is empty then insert regardless
				filter.push(new Pair(s.charAt(i),1));
				continue;
			}

			p = filter.peek(); // get the last modified/inserted pair

			if(p.val == s.charAt(i)){ // if current == to previous

				p.freq++; // increment freq and check condition
				if(p.freq == k)
					filter.pop();

			}else
				filter.push(new Pair(s.charAt(i),1)); // new letter encountered so add


		}

		while(!filter.isEmpty()){ // remove everything from stack and build a new string

			p = filter.pop();

			for(int i = 0; i < p.freq; i++) // use the freq to figure out how many dups u need per char
				results.insert(0,p.val);

		}

		return results.toString(); // return the resulting string

	}

}
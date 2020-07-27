import java.util.*;
public class DecodeString{

	public static void main(String[] args){

		System.out.println(decodeString("3[a2[c]]"));

	}

	public static String decodeString(String s){

		Stack<StringBuilder> stack = new Stack<>();
		Stack<Integer> times = new Stack<>();
		stack.push(new StringBuilder());
		int repeats = 0;

		for(int i = 0; i < s.length(); i++){

			char c = s.charAt(i);

			if(Character.isDigit(c))
				repeats = repeats * 10 + ((c -'0'));

			else if(c == '['){

				stack.push(new StringBuilder());
				times.push(repeats);
				repeats = 0;

			}else if(c == ']'){

				String sub = stack.pop().toString();
				StringBuilder sb = stack.peek();
				int length = times.pop();

				for(int x = 0; x < length; x++)
					stack.peek().append(sub);

			}else{
				stack.peek().append(c);
			}

		}

			return stack.pop().toString();

	}

}
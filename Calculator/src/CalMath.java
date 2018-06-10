import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CalMath {
	private static int priority(String s) {
		return s.equals("+") || s.equals("-") ? 1 : s.equals("¡Ñ") || s.equals("¡Ò") ? 2 : 0;
	}

	static Queue<String> toPostfix(String infix) {
		StringBuffer element = new StringBuffer();
		Stack<String> temp = new Stack<String>();
		Queue<String> post = new LinkedList<String>();
		for (char c : infix.toCharArray()) {
			if(c>'9' && c<'0' && c!='.' && element.length()!=0){
				post.add(element.toString());
				element = new StringBuffer();	//²MªÅ
			}
			if (c == '(') {
				temp.push(c+"");
			} else if ("+-*/".indexOf(c) != -1) {
				while (!temp.isEmpty() && priority(temp.peek()) >= priority(c+"")) {
					post.add(temp.pop());
				}
				temp.push(c+"");
			} else if (c == ')') {
				while (!temp.peek().equals("(")) {
					post.add(temp.pop());
				}
				temp.pop();
			} else {
				element.append(c);
			}
		}
		if(element.length()!=0)
			post.add(element.toString());
		return post;
	}
	
	
	

}

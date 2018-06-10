import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CalMath {
	private static int priority(String s) {
		return s.equals("+") || s.equals("-") ? 1 : s.equals("กั") || s.equals("กา") ? 2 : 0;
	}

	static Queue<String> toPostfix(String infix) {
		StringBuffer element = new StringBuffer();
		Stack<String> temp = new Stack<String>();
		Queue<String> post = new LinkedList<String>();
		for (char c : infix.toCharArray()) {
			if(!isDigit(c+"") && element.length()!=0){
				System.out.println("c="+c);
				post.add(element.toString());
				element = new StringBuffer();	//ฒMชล
			}
			if (c == '(') {
				temp.push(c+"");
			} else if ("+-กักา".indexOf(c) != -1) {
				while (!temp.isEmpty() && priority(temp.peek()) >= priority(c+"")) {
					
					post.add(temp.pop());
				}
				//System.out.println(c);
				temp.push(c+"");
				//System.out.println(temp);
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
		while(temp.size()!=0)
			post.add(temp.pop());
		System.out.println(post);
		return post;
	}
	
	static String calAns(Queue<String> post) {
		Stack<String> calArray = new Stack<String>();
		MathContext mc = new MathContext(17);
		BigDecimal a,b;
		for(String ele:post) {
			if(isDigit(ele)) {
				calArray.push(ele);
			}
			else {
				b = new BigDecimal(calArray.pop());
				//System.out.println("a="+a);
				a = new BigDecimal(calArray.pop());
				switch(ele) {
					case "+":
						calArray.push(a.add(b).toString());
						break;
					case "-":
						calArray.push(a.subtract(b).toString());
						break;
					case "กั":
						calArray.push(a.multiply(b).toString());
						break;
					case "กา":
						calArray.push(a.divide(b,mc).toString());
						break;
					default:
						break;
				}
			}
		}
		return calArray.pop();
	}
	
	static boolean isDigit(String s) {
		return s.charAt(0)<='9' && s.charAt(0)>='0' || s.charAt(0)=='.';
	}

}

/*
-  14253506
-  Şeref Batın Eryılmaz
*/
import java.util.Stack;
public class Odev1 {
    public static ExpressionTree postfixToExpressionTree(String girdi){
        Stack<BTNode> stack = new Stack();
        ExpressionTree ET = new ExpressionTree();
        String items[] = new String[girdi.length()];
        items = girdi.split(" ");
        for (int i = 0; i <items.length; i++) {
            if (Character.isDigit(items[i].charAt(0))) {
                stack.push(new BTNode(items[i], null, null));
            } else {
                BTNode d1 = null;
                BTNode d2 = null;
                if (!stack.isEmpty())
                    d1 = stack.pop();
                if (!stack.isEmpty())
                    d2 = stack.pop();
                BTNode node = new BTNode(items[i], d2, d1);
                stack.push(node);
            }
        }
        if (!stack.isEmpty())
            ET.root = stack.pop();
        return ET;
    }

   public static int process(char operator,int x,int y){
		switch (operator) {
			case '+':
				return x + y;
			case '-':
				return x - y;
			case '/':
			    if(y != 0)
				    return x / y;
				else
					return 1;
			case '*':
				return x * y;
			default:
				return 0;
		}
	}
	public static int evaluate(BTNode b){
	  if (b == null)
			return 0;
		int x = 0;
		int y = 0;
		if(b.left ==null && b.right == null)
		return Integer.parseInt((String) b.value);
		 x =evaluate(b.left);
		 y =evaluate(b.right);
		return process(((String)b.value).charAt(0),x,y);
	}
  public static int evaluateExpressionTree(ExpressionTree agac) {
    return evaluate(agac.getRoot());
    }
}

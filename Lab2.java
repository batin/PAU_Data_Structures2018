import java.util.*;

public class Islemler {

    public static <T> Stack<T> tersCevir(Stack<T> s){
    Stack<T> stack;
    stack = (Stack<T>)s.clone();
    Stack<T> stack1 = new Stack<T>();
    while(!stack.isEmpty())
      stack1.push(stack.pop());
    return stack1;
    }

    /**
     * İki yığıtın eşit olup olmadığını kontrol eder
     * @param s1 Birinci yığıt
     * @param s2 İkinci yığıt
     * @return İki yığıtın eşit olma durumunu döndürür
     */
    public static <T> boolean esit(Stack<T> s1, Stack<T> s2)
    {
    Stack<T> stack1;
    stack1 = (Stack<T>)s1.clone();
    Stack<T> stack2;
    stack2 = (Stack<T>)s2.clone();
    while(!stack1.isEmpty())
        if(stack1.pop() !=stack2.pop())
           return false;
    return true;
    }

    /**
     * Postfix ifadeyi değerlendirir. İşlemler tamsayılar üzerinde gerçekleşir. "7 5 /" işleminin sonucu 1'dir.
     * @param girdi Girdi ifadesi
     * @return İfadenin sonucu
     */
    public static int postfixDegerlendir(String girdi) {
      Stack<Integer> stack = new Stack<>();
        String items[] = new String[girdi.length()];
        items = girdi.split(" ");
        for (int i = 0; i < items.length; i++) {

            if (!Character.isDigit(items[i].charAt(0))) {
                if (items[i].charAt(0) == '/') {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second / first);
                } else if (items[i].charAt(0) == '*') {
                    stack.push(stack.pop() * stack.pop());
                } else if (items[i].charAt(0) == '+') {
                    stack.push(stack.pop() + stack.pop());
                } else {
                    stack.push(-stack.pop() + stack.pop());
                }
            } else {
                stack.push(Integer.parseInt(items[i]));
            }
        }

        return stack.pop();
    }

 private static int getPriority(String symbol) {
        int priority = 0;

        if (symbol.equals("+") || symbol.equals("-")) {
            priority = 0;
        } else if (symbol.equals("*") || symbol.equals("/")) {
            priority = 1;
        } else {
            priority = -1;
        }

        return priority;
    }
    /**
     * Infix ifadeyi postfix'e dönüştürür.
     * @param girdi Infix girdi metni
     * @return Dönüştürülmüş postfix ifade
     */
    public static String infixToPostfix(String girdi){
     Stack<String> opstack=new Stack<>();
        Map<String, Integer> precedence=new HashMap<>();
        precedence.put("+",2);
        precedence.put("-",2);
        precedence.put("*",3);
        precedence.put("/",3);
        precedence.put("(",1);
        precedence.put(")",1);
        String[] gm=splitToTokens(girdi);
        String postfix="";
        for (String s:gm){
            if (Character.isDigit(s.charAt(0)))
                postfix+=s+" ";
            else if(s.equals("("))
                opstack.push(s);
            else if(s.equals(")")) {
                String o=opstack.pop();
                while(!o.equals("(")) {
                    postfix+=o+" ";
                    o=opstack.pop();
                }
            }
            else {
                while (!opstack.isEmpty() && precedence.get(opstack.peek())>precedence.get(s)) {
                    postfix+=opstack.pop()+" ";
                }
                opstack.push(s);
            }
        }
        while (!opstack.isEmpty())
            postfix+=opstack.pop()+" ";
        postfix=postfix.substring(0,postfix.length()-1);
        return postfix;
    }

    /**
     * Infix ifadeyi sembollerine ayıran metod
     * @param girdi Infix ifade
     * @return Sembol dizisi
     */
    private static String[] splitToTokens(String girdi)
    {
        StringTokenizer t=new StringTokenizer(girdi, "+-*/^() ",true);
        List<String> tokenList=new ArrayList<>();
        while (t.hasMoreTokens()){
            String s=t.nextToken().trim();
            if(!s.equals(""))
                tokenList.add(s);
        }
        String [] tl=new String[tokenList.size()];
        tokenList.toArray(tl);
        return tl;
    }
}

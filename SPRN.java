import java.util.Stack;

public class SPRN {

        //pseudorandom numbers array
        static int[] random = {1804289383, 846930886, 1681692777, 1714636915,
                1957747793, 424238335, 719885386, 1649760492, 596516649,
                1189641421, 1025202362, 1350490027, 783368690, 1102520059,
                2044897763, 1967513926, 1365180540, 1540383426, 304089172,
                1303455736, 35005211, 521595368, 1804289383};

        //count for pseudorandom numbers
        static int count = 0;

        //create stack for integers
        public static Stack<Integer> stack = new Stack<>(); 

        //methods for operators & include unique behaviours
        //MAX & MIN VALUES for integers 
        //Stack underflow & overflow
        //Divide by zero
        public static void add() {
            if (stack.size() > 1) { // Perform procedure if the required values are in the stack, otherwise print 'stack underflow'
                int n1 = stack.pop();
                int n2 = stack.pop();
                if ((double) n2 + (double) n1 > Integer.MAX_VALUE) { //If the result is greater than data type integer value, print max value, or print min value if less than minimum
                    stack.push(Integer.MAX_VALUE);                  
                } else if ((double) n2 + (double) n1 < Integer.MIN_VALUE) {
                    stack.push(Integer.MIN_VALUE);
                } else {
                    stack.push(n1 + n2);
                }
            } else {
                System.out.println("Stack underflow.");
            }
        }

        public static void subtract() {
            if (stack.size() > 1) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                if ((double) n2 - (double) n1 < Integer.MIN_VALUE) {
                    stack.push(Integer.MIN_VALUE);
                } else if ((double) n2 - (double) n1 > Integer.MAX_VALUE) {
                    stack.push(Integer.MAX_VALUE);
                } else {
                    stack.push(n2 - n1);
                }
            } else {
                System.out.println("Stack underflow.");
            }
        }

        public static void divide() {
            if (stack.size() < 2) {
                System.out.println("Stack underflow.");
            } else {
                int n1 = stack.pop();
                int n2 = stack.pop();
                if (n1 == 0) {
                    System.out.println("Divide by 0."); // print divide by zero flag, if attempts to divide by zero
                } else {
                    int result = n2 / n1;
                    stack.push(result);
                }
            }
        }

        public static void multiply() {
            if (stack.size() > 1) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                if ((double) n2 * (double) n1 > Integer.MAX_VALUE) { 
                    stack.push(Integer.MAX_VALUE);
                } else if ((double) n2 * (double) n1 < Integer.MIN_VALUE) {
                    stack.push(Integer.MIN_VALUE);
                } else {
                    stack.push(n2 * n1);
                }
            } else {
                System.out.println("Stack underflow."); 
            }
        }

        public static void getPower() {
            if (stack.size() > 1) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                if (Math.pow(n1, n2) > Integer.MAX_VALUE) { 
                    stack.push(Integer.MAX_VALUE);
                } else if (Math.pow(n1, n2) < Integer.MIN_VALUE) {
                    stack.push(Integer.MIN_VALUE);
                } else {
                    stack.push((int) Math.pow(n1, n2));
                }
            } else {
                System.out.println("Stack underflow.");
            }
        }

        public static void getRemainder() {
            if (stack.size() > 1) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                int result = n2 % n1;
                stack.push(result);
            } else {
                System.out.println("Stack underflow.");
            }
        }

        public static void printStack() {
            for (Integer integer : stack) {
                System.out.println(integer);
            }
        }

        public static void generatePseudoRandomNumber() {
            if (count > random.length - 1) {  //pushes the value in the array to the stack
                count = 23;
                System.out.println("Stack overflow.");
            } else {
                stack.push(random[count]);
                count++;
            }
        }

        public static void getAnswer() {
            {
                System.out.println(stack.peek());
            }
        }

  //String input

        public void evaluateInput(String s) {

          //try catch for exceptions
            try {

              //switch with operator methods 
                switch (s) {
                    case "+" -> add();
                    case "-" -> subtract();
                    case "/" -> divide();
                    case "*" -> multiply();
                    case "^" -> getPower();
                    case "%" -> getRemainder();
                    case "=" -> getAnswer();
                    case "d" -> printStack();
                    case "r" -> generatePseudoRandomNumber();
                    default -> {
                        long m = Long.parseLong(s);  //long data type used for input, convert to int
                        if (m > Integer.MAX_VALUE) {
                            stack.push(Integer.MAX_VALUE);
                        } else if (m < Integer.MIN_VALUE) {
                            stack.push(Integer.MIN_VALUE);
                        } else {
                        stack.push((int)m);                
                        }                            
                    }
                }

            } catch (Exception e) {

              //prints specific input character error 
                for (int i = 0; i < s.length(); i++) {
                    System.out.print("Unrecognised operator or operand ");
                    System.out.print("\"");
                    System.out.print(s.charAt(i));
                    System.out.print("\"");
                    System.out.println();
                }

            }

        }
    }


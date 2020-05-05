import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String s = scn.nextLine();
		String[] arr;
		String operator;
		
		if(s.contains("+")) {
			arr = s.split("\\+");
			operator = "+";
		}
		else {
			arr = s.split("-");
			operator = "-";
		}
		Calculate cal = new Calculate(arr, operator);

		try {
			if(operator.equals("+")){
				cal.sumZero();
			}
			else {
				cal.subtractZero();
			}
			cal.range();
			System.out.println(cal.c);
			
		}catch(AddZeroException e) {
			System.out.println("AddZeroException");
		}catch(SubtractZeroException e) {
			System.out.println("SubtractZeroException");
		}catch(OutOfRangeException e) {
			System.out.println("OutOfRangeException");
		}		
	}
}

class Calculate{
	int a, b, c;
	public Calculate(String[] arr, String op) {
		a = Integer.parseInt(arr[0]);
		b = Integer.parseInt(arr[1]);
		if(op.equals("+")) {
			c = a+b;
		}
		else {
			c = a-b;
		}
	}

	public void sumZero() throws AddZeroException{
		if(a==0 || b==0) {
			throw new AddZeroException();
		}
	}
	public void subtractZero() throws SubtractZeroException{
		if(a==0 || b==0) {
			throw new SubtractZeroException();
		}
	}
	public void range() throws OutOfRangeException{
		if(a>1000 || a<0 || b>1000 || b<0 || c>1000 || c<0) {
			throw new OutOfRangeException();
		}
	}
}

class OutOfRangeException extends Exception {
}

class AddZeroException extends Exception {
}

class SubtractZeroException extends Exception {	
}
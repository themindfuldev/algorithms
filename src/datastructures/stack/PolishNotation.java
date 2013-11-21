package datastructures.stack;


public class PolishNotation {
	
	static int MAX_CAPACITY = 99999999;

	enum Operator {
		ADDITION('+', 1), 
		SUBTRACTION('-', 1), 
		MULTIPLICATION('*', 2), 
		DIVISION('/', 2), 
		EXPONENTIAL('$', 3);

		char symbol;
		int priority;

		Operator(char symbol, int priority) {
			this.symbol = symbol;
			this.priority = priority;
		}
	}
	
	public String convertInfixToPrefix(String infixExpression) {
		LinkedStack<Character> stack = new LinkedStack<>();
		StringBuilder result = new StringBuilder();

		for (int i = infixExpression.length() - 1; i >= 0; i--) {
			char symbol = infixExpression.charAt(i);
			
			if (symbol == ')') {
				stack.push(symbol);
			}
			else if (symbol == '(') {
				Character currentSymbol = stack.pop();
				
				while (currentSymbol != ')') {
					result.append(currentSymbol);
					currentSymbol = stack.pop();
				}
			}
			else {
				Operator thisOperator = getOperator(symbol);
				if (thisOperator != null) {
					int thisPriority = thisOperator.priority;
					int currentPriority = 0;
					Character currentSymbol = stack.peek();
					if (currentSymbol != null) {
						Operator currentOperator = getOperator(currentSymbol);
						if (currentOperator != null) {
							currentPriority = currentOperator.priority;
						}
					}
					
					if (thisPriority >= currentPriority) {
						stack.push(symbol);
					}
					else {
						while (thisPriority < currentPriority && stack.size() > 0) {
							currentSymbol = stack.pop();
							result.append(currentSymbol);
							currentPriority = getOperator(currentSymbol).priority;
						}
						stack.push(symbol);
					}
				}
				else {
					result.append(symbol);
				}
			}
		}
		
		while (stack.size() > 0) {
			result.append(stack.pop());
		}

		return result.reverse().toString();
	}
	
	private Operator getOperator(char symbol) {
		for (Operator operator: Operator.values()) {
			if (operator.symbol == symbol) {
				return operator;
			}
		}
		
		return null;
	}
}

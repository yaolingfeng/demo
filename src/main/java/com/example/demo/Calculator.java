package com.example.demo;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("除数不能为零");
		}
		return a / b;
	}

	public double power(double base, double exponent) {
		if (exponent == 0) {
			return 1.0;
		}
		return Math.pow(base, exponent);
	}

	public double sqrt(double value) {
		if (value < 0) {
			throw new IllegalArgumentException("Cannot compute sqrt of negative number");
		}
		return Math.sqrt(value);
	}

	public double mod(double dividend, double divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("Divisor cannot be zero for modulo");
		}
		return dividend % divisor;
	}

	public long factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n must be non-negative for factorial");
		}
		if (n > 20) {
			throw new ArithmeticException("Factorial result overflow");
		}
		long result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	public double percentage(double total, double percent) {
		return total * percent / 100;
	}

}

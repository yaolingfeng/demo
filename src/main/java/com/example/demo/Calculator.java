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



	// --- Financial methods (Issue #5) ---

	public double pmt(double rate, int nper, double pv, double fv, boolean due) {
		if (nper <= 0) {
			throw new IllegalArgumentException("nper must be positive");
		}
		if (rate == 0) {
			return -(pv + fv) / nper;
		}
		double factor = Math.pow(1 + rate, nper);
		double pmt = -rate * (fv + factor * pv) / (factor - 1);
		if (due) {
			pmt /= (1 + rate);
		}
		return pmt;
	}

	public double fv(double rate, int nper, double pmt, double pv, boolean due) {
		if (nper <= 0) {
			throw new IllegalArgumentException("nper must be positive");
		}
		if (rate == 0) {
			return -(pv + pmt * nper);
		}
		double factor = Math.pow(1 + rate, nper);
		if (due) {
			return -(pv * factor + pmt * (1 + rate) * (factor - 1) / rate);
		}
		return -(pv * factor + pmt * (factor - 1) / rate);
	}

	public double npv(double rate, double... cashflows) {
		if (cashflows.length == 0) {
			throw new IllegalArgumentException("cashflows must not be empty");
		}
		double result = 0;
		for (int i = 0; i < cashflows.length; i++) {
			result += cashflows[i] / Math.pow(1 + rate, i + 1);
		}
		return result;
	}

	public double sln(double cost, double salvage, int life) {
		if (life <= 0) {
			throw new IllegalArgumentException("life must be positive");
		}
		return (cost - salvage) / life;
	}

	public double compoundInterest(double principal, double rate, int periods) {
		if (periods < 0) {
			throw new IllegalArgumentException("periods must be non-negative");
		}
		return principal * Math.pow(1 + rate, periods);
	}

}

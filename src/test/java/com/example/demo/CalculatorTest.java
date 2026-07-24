package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

	private final Calculator calculator = new Calculator();

	// --- Existing tests (add, subtract, multiply, divide) ---

	@Test
	void addReturnsSum() {
		assertEquals(5, calculator.add(2, 3));
	}

	@Test
	void subtractReturnsDifference() {
		assertEquals(12, calculator.subtract(5, 3));
	}

	@Test
	void multiplyReturnsProduct() {
		assertEquals(12, calculator.multiply(4, 3));
	}

	@Test
	void divideReturnsQuotient() {
		assertEquals(5, calculator.divide(10, 2));
	}

	@Test
	void divideByZeroThrowsException() {
		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class, () -> calculator.divide(10, 0));
		assertEquals("除数不能为零", exception.getMessage());
	}

	// --- Power tests ---

	@Test
	void powerReturnsCorredResult() {
		assertEquals(8.0, calculator.power(2, 3));
	}

	@Test
	void powerExponentZeroReturnsOne() {
		assertEquals(1.0, calculator.power(5, 0));
	}

	@Test
	void powerNegativeExponentReturnsReciprocal() {
		assertEquals(0.25, calculator.power(2, -2));
	}

	@Test
	void powerBaseZeroPositiveExponent() {
		assertEquals(0.0, calculator.power(0, 3));
	}

	@Test
	void powerBaseOneAnyExponent() {
		assertEquals(1.0, calculator.power(1, 100));
	}

	// --- Sqrt tests ---

	@Test
	void sqrtReturnsCorrectResult() {
		assertEquals(3.0, calculator.sqrt(9));
	}

	@Test
	void sqrtZeroReturnsZero() {
		assertEquals(0.0, calculator.sqrt(0));
	}

	@Test
	void sqrtOneReturnsOne() {
		assertEquals(1.0, calculator.sqrt(1));
	}

	@Test
	void sqrtNegativeThrowsException() {
		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class, () -> calculator.sqrt(-1));
		assertEquals("Cannot compute sqrt of negative number", exception.getMessage());
	}

	@Test
	void sqrtSmallValue() {
		assertEquals(0.5, calculator.sqrt(0.25));
	}

	// --- Mod tests ---

	@Test
	void modReturnsCorrectResult() {
		assertEquals(1.0, calculator.mod(10, 3));
	}

	@Test
	void modWithDoubleValues() {
		assertEquals(1.5, calculator.mod(5.5, 2));
	}

	@Test
	void modDividendZeroReturnsZero() {
		assertEquals(0.0, calculator.mod(0, 3));
	}

	@Test
	void modDivisorZeroThrowsException() {
		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class, () -> calculator.mod(10, 0));
		assertEquals("Divisor cannot be zero for modulo", exception.getMessage());
	}

	@Test
	void modSmallerThanDivisor() {
		assertEquals(2.0, calculator.mod(2, 5));
	}

	// --- Factorial tests ---

	@Test
	void factorialReturnsCorrectResult() {
		assertEquals(120, calculator.factorial(5));
	}

	@Test
	void factorialZeroReturnsOne() {
		assertEquals(1, calculator.factorial(0));
	}

	@Test
	void factorialOneReturnsOne() {
		assertEquals(1, calculator.factorial(1));
	}

	@Test
	void factorialTwentyReturnsMax() {
		assertEquals(2432902008176640000L, calculator.factorial(20));
	}

	@Test
	void factorialNegativeThrowsException() {
		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class, () -> calculator.factorial(-1));
		assertEquals("n must be non-negative for factorial", exception.getMessage());
	}

	@Test
	void factorialOverflowThrowsException() {
		ArithmeticException exception = assertThrows(
				ArithmeticException.class, () -> calculator.factorial(21));
		assertEquals("Factorial result overflow", exception.getMessage());
	}

	// --- Percentage tests ---

	@Test
	void percentageReturnsCorrectResult() {
		assertEquals(30.0, calculator.percentage(200, 15));
	}

	@Test
	void percentageFiftyPercent() {
		assertEquals(50.0, calculator.percentage(100, 50));
	}

	@Test
	void percentageZeroPercent() {
		assertEquals(0.0, calculator.percentage(200, 0));
	}

	@Test
	void percentageOneHundredPercent() {
		assertEquals(100.0, calculator.percentage(100, 100));
	}

	@Test
	void percentageTotalZero() {
		assertEquals(0.0, calculator.percentage(0, 50));
	}

}

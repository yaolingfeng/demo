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
		assertEquals(2, calculator.subtract(5, 3));
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



	// --- Financial methods tests (Issue #5) ---
	// PMT tests

	@Test
	void pmtNormalCase() {
		assertEquals(-5368.22, calculator.pmt(0.05 / 12, 360, 1000000, 0, false), 1e-2);
	}

	@Test
	void pmtRateZero() {
		assertEquals(-833.33, calculator.pmt(0, 12, 10000, 0, false), 1e-2);
	}

	@Test
	void pmtDueTrue() {
		assertEquals(-5345.94, calculator.pmt(0.05 / 12, 360, 1000000, 0, true), 1e-2);
	}

	@Test
	void pmtWithFv() {
		assertEquals(-977.29, calculator.pmt(0.05 / 12, 12, 0, 12000, false), 1e-2);
	}

	@Test
	void pmtNegativeNperThrows() {
		assertThrows(IllegalArgumentException.class,
				() -> calculator.pmt(0.05, -1, 10000, 0, false));
	}

	// FV tests

	@Test
	void fvNormalCase() {
		assertEquals(610.51, calculator.fv(0.1, 5, -100, 0, false), 1e-2);
	}

	@Test
	void fvRateZero() {
		assertEquals(-1000.0, calculator.fv(0, 5, 200, 0, false), 1e-2);
	}

	@Test
	void fvDueTrue() {
		assertEquals(671.56, calculator.fv(0.1, 5, -100, 0, true), 1e-2);
	}

	@Test
	void fvWithPv() {
		assertEquals(3831.53, calculator.fv(0.1, 5, -100, -2000, false), 1e-2);
	}

	@Test
	void fvNegativeNperThrows() {
		assertThrows(IllegalArgumentException.class,
				() -> calculator.fv(0.05, -1, -100, 1000, false));
	}

	// NPV tests

	@Test
	void npvNormalCase() {
		assertEquals(1188.44, calculator.npv(0.1, -10000, 3000, 4200, 6800), 1e-2);
	}

	@Test
	void npvSecondCase() {
		assertEquals(42.52, calculator.npv(0.05, -500, 200, 200, 200), 1e-2);
	}

	@Test
	void npvEmptyCashflowsThrows() {
		assertThrows(IllegalArgumentException.class,
				() -> calculator.npv(0.1));
	}

	@Test
	void npvSingleCashflow() {
		assertEquals(-909.09, calculator.npv(0.1, -1000), 1e-2);
	}

	// SLN tests

	@Test
	void slnNormalCase() {
		assertEquals(2250.0, calculator.sln(30000, 7500, 10), 1e-2);
	}

	@Test
	void slnSecondCase() {
		assertEquals(180.0, calculator.sln(1000, 100, 5), 1e-2);
	}

	@Test
	void slnZeroLifeThrows() {
		assertThrows(IllegalArgumentException.class,
				() -> calculator.sln(1000, 100, 0));
	}

	// compoundInterest tests

	@Test
	void compoundInterestNormalCase() {
		assertEquals(1157.625, calculator.compoundInterest(1000, 0.05, 3), 1e-10);
	}

	@Test
	void compoundInterestZeroPeriods() {
		assertEquals(1000.0, calculator.compoundInterest(1000, 0.05, 0), 1e-10);
	}

	@Test
	void compoundInterestZeroRate() {
		assertEquals(1000.0, calculator.compoundInterest(1000, 0, 5), 1e-10);
	}

	@Test
	void compoundInterestNegativePeriodsThrows() {
		assertThrows(IllegalArgumentException.class,
				() -> calculator.compoundInterest(1000, 0.05, -1));
	}

}

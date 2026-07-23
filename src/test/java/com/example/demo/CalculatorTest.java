package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

	private final Calculator calculator = new Calculator();

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

}

package com.example.SpringDemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringDemoApplicationTests {
	Calculator calculator = new Calculator();

	@Test
	void itShouldAddNumbers() {
		int number1 = 20;
		int number2 = 30;

		int result = calculator.add(number1, number2);
		int expected = 50;

		assertThat(result).isEqualTo(expected);
	}

	class Calculator {
		int add(int a, int b) {
			return a + b;
		}
	}
}

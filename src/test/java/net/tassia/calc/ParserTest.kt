package net.tassia.calc

import kotlin.test.Test

class ParserTest {

	private fun testExpression(expression: String, result: Double) {
		val parsed = Environment().parse(expression)
		val actual = parsed.evaluateDouble()
		if (result != actual) {
			throw AssertionError("Expression failed: '$expression'. Expected result: $result; actual result: $actual")
		}
	}

	@Test
	fun testExpressions() {
		testExpression("add(2, 2)", 4.0)
		testExpression("add(2,2)", 4.0)
		testExpression("add(2 ,2)", 4.0)
		testExpression("	 add 	(	 2  		 ,  	2	 )  ", 4.0)
	}

}

class ExceptionTest extends GroovyTestCase {
  def divide(int a, int b) {
    return a / b
  }

  void testDivide() {
    try {
      divide(2, 0)
      fail "Expected ArithmeticException ..."
    } catch(ArithmeticException ex) {
      assertTrue true // Success
    }
  }

  void shouldFail { divide(2, 0) }
}
def factorial(int factorialFor) {
  def tailFactorial
  tailFactorial = { int number, BigInteger theFactorial = 1 ->
    number == 1 ? theFactorial :
      tailFactorial.trampoline(number - 1, number * theFactorial)
  }.trampoline()
  tailFactorial(factorialFor)
}
println "factorial of 5 is ${factorial(5)}"
println "Number of bits in the result is ${factorial(5000).bitCount()}"

println 'He said, "That is Groovy"'

str = 'A string'
println str.getClass().name

value = 25
println 'The value is ${value}'

str = 'hello'
println str[2]
try {
  str[2] = '!'
} catch(Exception ex) {
  println ex
}

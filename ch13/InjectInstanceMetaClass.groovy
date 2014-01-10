class Person {
  def paly() { println 'playing...' }
}
def jack = new Person()
def paul = new Person()

jack.metaClass.sing = { ->
  'oh baby baby...'
}
println jack.sing()

try {
  paul.sing()
} catch(ex) {
  println ex
}

jack.metaClass = null
try {
  jack.paly()
  jack.sing()
} catch(ex) {
  println ex
}

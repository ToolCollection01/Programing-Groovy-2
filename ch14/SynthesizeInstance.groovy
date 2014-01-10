class Person {}

def emc = new ExpandoMetaClass(Person)
emc.methodMissing = { String name, args ->
  "I'm Jack of all trades... I can $name"
}
emc.initialize()

def jack = new Person()
def paul = new Person()

jack.metaClass = emc

println jack.sing()
println jack.dance()
println jack.juggle()

try {
  paul.sing()
} catch(ex) {
  println ex
}

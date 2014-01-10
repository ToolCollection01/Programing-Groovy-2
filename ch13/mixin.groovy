class Friend {
  def listen() {
    "$name is listening as a friend"
  }
}


@Mixin(Friend)
class Person {
  String firstName
  String lastName
  String getName() { "$firstName $lastName" }
}

john = new Person(firstName: "John", lastName: "Smith")
println john.listen()




class Dog {
  String name
}

Dog.mixin Friend

buddy = new Dog(name: "Buddy")
println buddy.listen()




class Cat {
  String name
}

try {
  rude = new Cat(name:"Rude")
  rude.listen()
} catch(ex) {
  println ex.message
}




socks = new Cat(name: "Socks")
socks.metaClass.mixin Friend
println socks.listen()

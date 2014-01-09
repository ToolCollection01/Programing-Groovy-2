Integer.metaClass.invokeMethod = { String name, args ->
  System.out.println("Call to $name intercepted on $delegate... ")

  def validMethod = Integer.metaClass.getMetaMethod(name, args)
  if (validMethod == null) {
    Integer.metaClass.invokeMissingMethod(delegate, name, args)
  } else {
    System.out.println("running pre-filter... ")
    result = validMethod.invoke(delegate, args) // Remove this for around-advice

    System.out.println("running post-filter... ")
    result
  }
}

println 5.floatValue()
println 5.intValue()
try {
  println 5.empty()
} catch(Exception ex) {
  println ex
}

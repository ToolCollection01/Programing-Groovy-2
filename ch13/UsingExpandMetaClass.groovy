Integer.metaClass.'static'.isEven = { val -> val % 2 == 0 }

println "Is 2 even? " + Integer.isEven(2)
println "Is 3 even? " + Integer.isEven(3)



Integer.metaClass.constructor << { Calendar calendar ->
  new Integer(calendar.get(Calendar.DAY_OF_YEAR))
}

println new Integer(Calendar.instance)



Integer.metaClass.constructor = { int val ->
  println "Intercepting constructor call"
  constructor = Integer.class.getConstructor(Integer.TYPE)
  constructor.newInstance(val)
}

println new Integer(4)
println new Integer(Calendar.instance)

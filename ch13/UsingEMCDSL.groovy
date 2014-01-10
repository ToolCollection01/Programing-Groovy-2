Integer.metaClass {
  daysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, delegate)
    today.time
  }

  getDaysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, delegate)
    today.time
  }

  'static' {
    isEven = { val -> val % 2 == 0 }
  }

  constructor = { Calendar calendar ->
    new Integer(calendar.get(Calendar.DAY_OF_YEAR))
  }

  constuctor = { int val ->
    println "Intercepting constructor call"
    constructor = Integer.class.getConstructor(Integer.TYPE)
    constructor.newInstance(val)
  }
}

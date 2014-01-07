def tellFortune(closure) {
  closure new Date("09/20/2012"), "Your day is filled with ceremony"
}
tellFortune() { date, fortune ->
  println "Fortune for ${date} is '${fortune}'"
}

tellFortune() { Date date, fortune ->
  println "Fortune for ${date} is '${fortune}'"
}

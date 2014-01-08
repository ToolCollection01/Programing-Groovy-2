what = new StringBuilder('fence')
text = "The cow jumped over the $what"
println text

what.replace(0, 5, "moon")
println text


price = 684.71
company = 'Google'
quote = "Today $company stock closed at $price"
println quote

stocks = [Apple : 663.01, Microsoft : 30.95]

stocks.each { key, value ->
  company = key
  price = value
  println quote
}


companyClosure = { it.write(company) }
priceClosure = { it.write("$price") }
quote = "Today ${companyClosure} stock closed at ${priceClosure}"
stocks.each { key, value ->
  company = key
  price = value
  println quote
}



companyClosure = {-> company}
priceClosure = {-> price }
quote = "Today ${companyClosure} stock closed at ${priceClosure}"
stocks.each { key, value ->
  company = key
  price = value
  println quote
}


quote = "Today ${-> company } stock closed at ${-> price }"
stocks.each { key, value ->
  company = key
  price = value
  println quote
}

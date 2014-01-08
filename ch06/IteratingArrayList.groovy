lst = [1, 3, 4, 1, 8, 9, 2, 6]
lst.each { println it }


total = 0
lst.each { total += it }
println "Total is $total"


doubled = []
lst.each { doubled << it * 2 }
println doubled


println lst.collect { it * 2 }

lst = ['Programming', 'In', 'Groovy']

count = 0
lst.each { count += it.size() }
println count

println lst.collect { it.size() }.sum()


println lst.inject(0) { carryOver, element -> carryOver + element.size() }


println lst.join(' ')


lst[0] = ['Be', 'Productive']
println lst

lst = lst.flatten()
println lst

println lst - ['Productive', 'In']


println lst.size()
println lst*.size()


def words(a, b, c, d) {
  println "$a $b $c $d"
}

words(*lst)

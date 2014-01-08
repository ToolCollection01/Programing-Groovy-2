lst = [1, 3, 4, 1, 8, 9, 2, 6]
println lst
println lst.getClass().name

println lst[0]
println lst[lst.size() - 1]

println lst[-1]
println lst[-2]

println lst[2..5]
println lst[-6..-3]


subLst = lst[2..5]
println subLst.dump()
subLst[0] = 55
println "After  subLst[0]=55 lst = $lst"

String[] command = ['groovy', '-e', '"print \'Groovy\'"']
println "Calling ${command.join(' ')}"
println command.execute().text

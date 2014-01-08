languages = new XmlSlurper().parse(
  'computerAndNaturalLanguages.xml').declareNamespace(human: 'Natural')

print "Languages: "
println languages.language.collect { it.@name }.join(', ')

print "Natural languages: "
println languages.'human:language'.collect { it.@name }.join(', ')

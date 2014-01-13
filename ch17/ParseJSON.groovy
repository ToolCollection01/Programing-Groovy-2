def sluper = new groovy.json.JsonSlurper()
def person = sluper.parse(new FileReader('person.json'))

println "$person.first $person.last is interested in ${person.sigs.join(', ')}"

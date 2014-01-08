document = groovy.xml.DOMBuilder.parse(new FileReader('languages.xml'))

rootElement = document.documentElement

use(groovy.xml.dom.DOMCategory) {
  println "Languages and authors"
  languages = rootElement.language

  languages.each { language ->
    println "${language.'@name'} authored by ${language.author[0].text()}"
  }

  def languagesByAuthor = { authorName ->
    languages.findAll { it.author[0].text() == authorName }.collect {
      it.'@name' }.join(', ')
  }

  println "Languages by Wirth:" + languagesByAuthor('Wirth')
}

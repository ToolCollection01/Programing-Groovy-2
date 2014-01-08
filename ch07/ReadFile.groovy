println new File('thoreau.txt').text

new File('thoreau.txt').eachLine { line ->
  println line
}

println new File('thoreau.txt').filterLine { it =~ /life/ }

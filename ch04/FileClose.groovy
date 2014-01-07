writer = new FileWriter('output.txt')
writer.write('!')
// forget to call writer.close()
writer.close()


new FileWriter('output.txt').withWriter { writer ->
  writer.write('a')
} // no need to close()

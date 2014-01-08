process = "wc".execute()

process.out.withWriter {
  // Send input to process
  it << "Let the World know...\n"
  it << "Groovy Rocks!\n"
}

// Read output from process
println process.in.text
// or
//println process.text

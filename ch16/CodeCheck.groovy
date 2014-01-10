@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class CodeCheck implements ASTTransformation {
  void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
    sourceUnit.ast.classes.each { classNode ->
      classNode.visitContents(new OurClassVisitor(sourceUnit))
    }
  }
}



class OurClassVisitor implements GroovyClassVisitor {
  SourceUnit sourceUnit
  OurClassVisitor(theSourceUnit) { sourceUnit = theSourceUnit }
  private void reportError(message, lineNumber, columnNumber) {
    sourceUnit.addError(new SyntaxException(message, lineNumber, columnNumber))
  }

  void visitMethod(MethodNode node) {
    if(node.name.size() == 1)
      reportError "Make method name descriptive, avoid single letter names",
        node.lineNumber, node.columnNumber

    node.parameters.each { parameter ->
      if (parameter.name.size() == 1)
	reportError "Single letter parameters are morally wrong!",
	parameter.lineNumber, parameter.columnNumber
    }
  }

  void visitClass(ClassNode node) {}
  void visitConstructor(ConstructorNode node) {}
  void visitField(FieldNode node) {}
  void visitProperty(PropertyNode node) {}
}

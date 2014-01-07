import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode

@TypeChecked
class Sample {
  //static type checking in effect here
  def method1() {
  }

  @TypeChecked(TypeCheckingMode.SKIP)
  def method2(String str) {
    str.shout()
  }
}

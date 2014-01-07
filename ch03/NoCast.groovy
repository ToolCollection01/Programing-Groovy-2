@groovy.transform.TypeChecked
def use(Object instance) {
  if(instance instanceof String)
    println instance.length() //No need to cast
  else
    println instance
}
use('hello')
use(4)

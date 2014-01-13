def bldr = new RobotBuilder()

def robot = bldr.robot('iRobot') {
  forward(dist: 20)
  left(rotation: 90)
  forward(speed: 10, duration: 5)
}

robot.do()



class RobotBuilder extends FactoryBuilderSupport {
  {
    registerFactory('robot', new RobotFactory())

    registerFactory('forward', new ForwardMoveFactory())

    registerFactory('left', new LeftTurnFactory())
  };
}



class Robot {
  String name
  def movements = []
  
  void go() {
    println "Robot $name operationg..."
    movements.each { movement -> println movement }
  }
}

class ForwardMove {
  def dist
  String toString() { "move distance... $dist"}
}

class LeftTurn {
  def rotation
  String toString() { "turn left... $rotation degrees" }
}




// Except of AbstractFactory.java - part of Groovy
/*
public abstract class AbstractFactory implements Factory
{
  public boolean isLeaf() { return false; }

  public boolean onHandleNodeAttributes(FactoryBuilderSupport builder,
					Object node, Map attributes) { return true; }

  public void onNodeCompleted(FactoryBuilderSupport builder,
			      Object parent, Object child) { }

  public void setParent(FactoryBuilderSupport builder,
			Object parent, Object child) { }
  
  public void setChild(FactoryBuilderSupport builder,
		       Object parent, Object child) { }
}
*/





class RobotFactory extends AbstractFactory {
  def newInstance(FactoryBuilderSupport builder, name, value, Map attributes) {
    new Robot(name: value)
  }

  void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
    parent.movements << child
  }
}

class ForwardMoveFactory extends AbstractFactory {
  boolean isLeaf() { true }

  def newInstance(FactoryBuilderSupport builder, name, value, Map attributes) {
    new ForwardMove()
  }

  boolean onHandleNodeAttributes(FactoryBuilderSupport builder,
				 Object node, Map attributes) {
    if (attributes.speed && attributes.duration) {
      node.dist = attributes.speed * attributes.duration
      attributes.remove('speed')
      attributes.remove('duration')
    }

    true
  }
}

class LeftTurnFactory extends AbstractFactory {
  boolean isLeaf() { true }

  def newInstance(FactoryBuilderSupport builder, name, value, Map attributes) {
    new LeftTurn()
  }
}




def robotBldr = new RobotBuilder()
robotBldr.robot('bRobot') {
  forward(dist: 20) { }
}

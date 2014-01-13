class CarTest extends GroovyTestCase
{
  def car
  void setUp()
  {
    car = new com.agiledeveloper.Car()
  }
  void testInitialize()
  {
    assertEquals 0, car.miles
  }
  void testDrive()
  {
    car.drive(10)
    assertEquals 10, car.miles
  }
  void testDriveNegativeInput()
  {
    car.drive(-10)
    assertEquals 0, car.miles
  }
}

//Java code
System.out.println("Received: " +
		   instance.passToClosure(2, new Object() {
			   public String call(int value) {
			       return "You called from Groovy with value " + value;
			   }
		       }));

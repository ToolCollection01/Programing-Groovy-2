//Java code
public Object clone() {
    try {
	Car cloned = (Car) super.clone();
	cloned.engine = (Engine) engine.clone();
	return cloned;
    } catch(CloneNotSupportedException ex) {
	return null;  // Will not happen, but we need to please the compiler
    }

// Java code
package com.agiledeveloper;

public class Car
{
    private int miles;
    public int getMiles() { return miles; }
    public void drive(int dist)
    {
	miles += dist;
    }
}

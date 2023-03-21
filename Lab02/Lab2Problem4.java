//----------------------------------------------------------------------------------------------------------------------
//  Lab2Problem4.java                Author: Brian Salchert
//
//  Driver class for MovingAverage.java.
//----------------------------------------------------------------------------------------------------------------------

public class Lab2Problem4 {
    public static void main (String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);

        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
        System.out.println(movingAverage.next(432));
    }
}

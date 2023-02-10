//----------------------------------------------------------------------------------------------------------------------
//  MovingAverage.java                Author: Brian Salchert
//
//  Class for calculating the moving average of a set of integers given a window size. The window size determines how
//  many integers are incorporated into the average from the input stream at a time.
//----------------------------------------------------------------------------------------------------------------------

public class MovingAverage {
    private MyCircularQueue window;
    private int count;

    /**
     * Initializes the window for the moving average with a given size.
     * @param size size of the window
     */
    public MovingAverage(int size) {
        window = new MyCircularQueue(size);
        count = 0;
    }

    /**
     * Returns the moving average of the values in the window after adding the next value to the window
     * @param val value to add to the window
     * @return the average of the values in the window
     */
    public double next(int val) {
        int sum = 0;
        int temp;

        // Check if the queue already has three values and remove the first if necessary
        if (window.isFull()) {
            window.deQueue();
            count--;
        }

        // Add the next value into the queue
        window.enQueue(val);
        count++;

        // Obtain the sum of the values in the window
        for (int i = 0; i < count; i++) {
            // Add the first element in the window to the sum
            sum += window.front();

            // Move the first element to the back of the queue
            temp = window.front();
            window.deQueue();
            window.enQueue(temp);
        }

        // Return the average of the values in the window
        return ((double) sum / count);
    }
}

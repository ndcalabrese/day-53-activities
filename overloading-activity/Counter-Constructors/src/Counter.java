public class Counter {
    // Declare private variables.
    private int counter;

    // Class constructors
    public Counter(int startValue) {
        this.counter = startValue;
    }

    public Counter() {
        this.counter = 0;
    }

    public int value() {
        return this.counter;
    }

    public void increase() {
        this.counter += 1;
    }

    public void increase(int increaseBy) {
        if (increaseBy > 0) {
            this.counter += increaseBy;
        }
    }

    public void decrease() {
        this.counter -= 1;
    }

    public void decrease(int decreaseBy) {
        if (decreaseBy > 0) {
            this.counter -= decreaseBy;
        }
    }

}

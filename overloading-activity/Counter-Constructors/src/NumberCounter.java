import java.util.concurrent.TimeUnit;

public class NumberCounter {

    public static void main(String[] args) throws InterruptedException {

        // Start first counter at zero
        Counter counter1 = new Counter();
        System.out.println("First counter initialized with value: " + counter1.value());

        counter1.increase();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("First counter increased by 1. Value is now: " + counter1.value());

        counter1.decrease();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("First counter decreased by 1. Value is now: " + counter1.value());

        TimeUnit.SECONDS.sleep(2);

        // Start second counter at a specific value
        Counter counter2 = new Counter(121);
        System.out.println("\nSecond counter initialized with value: " + counter2.value());

        counter2.increase(15);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Second counter increased by 15. Value is now: " + counter2.value());

        counter2.decrease(56);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Second counter decreased by 56. Value is now: " + counter2.value());

        counter2.increase(-25);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Attempted to increase second counter by -25. Value is still: " + counter2.value());

        counter2.decrease(-200);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Attempted to decrease second counter by -200. Value is still: " + counter2.value());

    }

}

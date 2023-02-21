public class waitNotifyTest {
    public static void main(String[] args) {
    message msg = new message("process it");
    waiter waiter = new waiter(msg);
    new Thread(waiter,"waiter").start();
    waiter waiter1 = new waiter(msg);
    new Thread(waiter1, "waiter1").start();
    notifier notifier = new notifier(msg);
    new Thread(notifier, "notifier").start();
    System.out.println("Se han comenzado los hilos");
    }
    }
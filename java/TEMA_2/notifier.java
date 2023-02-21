public class notifier implements Runnable {
    private message msg;
    public notifier(message msg) {
    this.msg = msg;
    }
    @Override
    public void run() {
    String name = Thread.currentThread().getName();
    System.out.println("Se ha empezado "+name);
    try {
    Thread.sleep(1000);
    synchronized (msg) {
    msg.setMsg("Se ha notificado a "+name);
    //msg.notify();
    msg.notifyAll();
    }
    } catch (InterruptedException e) {
    e.printStackTrace();
    }
    }
    }
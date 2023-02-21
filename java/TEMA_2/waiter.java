public class waiter implements Runnable{
private message msg;
public waiter(message m){
this.msg=m;
}
@Override
public void run() {
String name = Thread.currentThread().getName();
synchronized (msg) {
try{
System.out.println(name+" está esperando a su ejecución en el tiempo "+System.currentTimeMillis());
msg.wait();
}catch(InterruptedException e){
e.printStackTrace();
}
System.out.println(name+" El hilo fue notificado en el tiempo:"+System.currentTimeMillis());
//process the message now
System.out.println(name+" se ha procesado: "+msg.getMsg());
}
}
}
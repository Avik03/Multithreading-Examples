package MonitorLockEample;

public class MonitorLockExample {

    public synchronized void task1(){
        try {
            System.out.println("Inside Task1");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void task2(){
        System.out.println("Task2 but before synchronized");
        synchronized (this){
            System.out.println("Task2 inside synchronized");
        }
    }

    public void task3(){
        System.out.println("Task3");
    }
}

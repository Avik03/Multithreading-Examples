import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadCreation3 {

    public static final int MAX_PASSWORD = 9999;
    public static void main(String[] args) {
        Random random = new Random();

        Valult valult = new Valult(random.nextInt(MAX_PASSWORD));

        List<Thread> threadList = new ArrayList<>();
        threadList.add(new AscendingHackerThread(valult));
        threadList.add(new DescendingHackerThread(valult));
        threadList.add(new PoiliceThread());

        for(Thread thread: threadList){
            thread.start();
        }
    }

    public static class Valult{
        private int password;

        public Valult(int password){
            this.password = password;
        }

        public boolean isCorrectPassword(int guess){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return this.password == guess;
        }
    }

    public static abstract class HackerThread extends Thread{
        protected Valult valult;

        public HackerThread(Valult valult){
            this.valult = valult;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start(){
            System.out.println("Starting thread : " + this.getName());
            super.start();
        }
    }

    public static class AscendingHackerThread extends HackerThread{

        public AscendingHackerThread(Valult valult) {
            super(valult);
        }

        @Override
        public void run(){
            for (int guess = 0; guess < MAX_PASSWORD ; guess++){
                if(valult.isCorrectPassword(guess)){
                    System.out.println(this.getName() + "guesses the password" + guess);
                    System.exit(0);
                }
            }
        }
    }

    public static class DescendingHackerThread extends HackerThread{

        public DescendingHackerThread(Valult valult) {
            super(valult);
        }

        @Override
        public void run(){
            for (int guess = MAX_PASSWORD; guess >= 0 ; guess--){
                if(valult.isCorrectPassword(guess)){
                    System.out.println(this.getName() + "guesses the password" + guess);
                    System.exit(0);
                }
            }
        }
    }

    public static class PoiliceThread extends Thread{

        public PoiliceThread(){
            this.setName(this.getClass().getSimpleName());
        }

        @Override
        public void run(){
            for(int i = 10; i > 0; i--){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i);
            }
            System.out.println("Game Over For Hackers");
            System.exit(0);
        }
    }
}

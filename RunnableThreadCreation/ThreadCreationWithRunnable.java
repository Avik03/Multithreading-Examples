package RunnableThreadCreation;

import RunnableThreadCreation.MultithreadingLearning;

public class ThreadCreationWithRunnable {
    public static void main(String[] args) {
        MultithreadingLearning multithreadingLearning = new MultithreadingLearning();
        Thread thread = new Thread(multithreadingLearning);
        thread.start();
    }

}


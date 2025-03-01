package AtomicIntegerExample;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource {
    AtomicInteger counter = new AtomicInteger(0);

    public void increment(){
        for(int i =0; i<200; i++){
            counter.incrementAndGet();
        }
    }

    public void increment2(){
        for(int i =0; i<200; i++){
            counter.incrementAndGet();
        }
    }

    public AtomicInteger get(){
        return counter;
    }


}

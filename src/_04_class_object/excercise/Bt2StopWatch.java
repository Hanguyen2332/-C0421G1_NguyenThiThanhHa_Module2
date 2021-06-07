package _04_class_object.excercise;

import java.sql.Time;
import java.time.LocalTime;

public class Bt2StopWatch {
    private long startTime;
    private long endTime ;  //LocalTime.now();

    //khai báo Constructor:
    public Bt2StopWatch() {
        this.startTime = System.currentTimeMillis();
    }
    public long start() {
        return this.startTime = System.currentTimeMillis();
    }
    public long stop() {
        return this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
       return this.endTime-this.startTime;
    }
        public static void main(String[] args) {
            Bt2StopWatch stopWatch = new Bt2StopWatch();
            System.out.println("Start time = " + stopWatch.start());
            for (int i = 0; i<=100;i++) {
                System.out.println(i);
            }
            System.out.println("Stop time = " + stopWatch.stop());
            System.out.printf("Elapsed Time = %d milliseconds ", stopWatch.getElapsedTime());
    }
}

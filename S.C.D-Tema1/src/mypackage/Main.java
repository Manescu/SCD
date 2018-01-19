package mypackage;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static boolean status = false;
    public static final int START_INTERVAL = 10000000;
    public static final int NUMBER_OF_THREADS = 99;
    public static final int INCREMENT_VALUE = 101010;

    public static void main(String[] args) throws InterruptedException {

        List<Thread> listThreads = new ArrayList<>();
        Thread myThread;
        int pointStart;
        int pointStop;

        for(int i=0; i<NUMBER_OF_THREADS; i++){
            pointStart = START_INTERVAL+(i)*INCREMENT_VALUE;
            pointStop = START_INTERVAL+(i+1)*INCREMENT_VALUE;
            myThread = new Thread(new MyThread(pointStart, pointStop));
            myThread.start();
            listThreads.add(myThread);
        }

        try {
            for(int i=0; i<listThreads.size(); i++) {
                listThreads.get(i).join();
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}


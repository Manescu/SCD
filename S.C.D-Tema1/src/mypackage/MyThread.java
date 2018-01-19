package mypackage;

import org.apache.commons.codec.digest.DigestUtils;


public class MyThread  implements Runnable {

    private int start;
    private int stop;

    MyThread(){}

    MyThread(int start, int stop){
        this.start = start;
        this.stop = stop;
    }

    @Override
    public void run() {

       for(int i=start; i<stop && !Main.status; i++){
           String s = String.valueOf(i);
           String sha256hex = DigestUtils.sha256Hex(s);

           if(sha256hex.equalsIgnoreCase("F8D6500AFF42C270845230ADB8F5EE42C367AE86F7190EBC0FF12524930D15C8")){
               System.out.println("Nume thread: " + Thread.currentThread().getName());
               System.out.println("Parola cautata corespunde numarului: " + i);
               Main.status = true;
           }
       }
    }
}

package ro.pub.cs.systems.eim.colocviu1_2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;
import java.util.Random;

// ProcessingThread.java
public class ProcessingThread extends Thread {

    private Context context = null;
    private boolean isRunning = true;

    private Random random = new Random();

    private Integer sum;


    public ProcessingThread(Context context, int sum) {
        this.context = context;
      this.sum = sum;
    }

    @Override
    public void run() {
        Log.d("MY_TAG", "Thread has started!");
        while (isRunning) {
            sleep2s();
            sendMessage();

        }
        Log.d("MY_TAG", "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.putExtra("EXTRA_MSG",
                new Date(System.currentTimeMillis()) + " " + sum);
        context.sendBroadcast(intent);
    }

    private void sleep2s() {
        try { Thread.sleep(2000); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void stopThread() { isRunning = false; }
}


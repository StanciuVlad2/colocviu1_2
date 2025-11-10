package ro.pub.cs.systems.eim.colocviu1_2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class Colocviu1_2Service extends Service {

    private ProcessingThread processingThread = null;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int sum  = intent.getIntExtra("EXTRA_MSG", -1);
        processingThread = new ProcessingThread(this, sum);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        processingThread.stopThread();
        super.onDestroy();
    }
}

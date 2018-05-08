package com.wow.app.random.workers;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.wow.app.random.adapters.MainAdapter;
import com.wow.app.random.utilities.Constants;

public class Consumer extends Activity {

    public Consumer(final List<String> dataArray, final MainAdapter mainAdapter) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Adding a row into RecyclerView
                removeRow(dataArray, mainAdapter);
            }
        }, 0, Constants.CONSUMER_SECONDS);
    }

    public void removeRow(final List<String> dataArray, final MainAdapter mainAdapter) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (dataArray.size() > 0) {
                    dataArray.remove(dataArray.size() - 1);
                    mainAdapter.notifyDataSetChanged();
                    return;
                }
                Log.d(Constants.TAG, "No row is remainig to remove");
            }
        });
    }

}

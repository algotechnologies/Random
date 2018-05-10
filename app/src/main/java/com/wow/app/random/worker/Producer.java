package com.wow.app.random.worker;

import android.app.Activity;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.wow.app.random.adapter.MainAdapter;
import com.wow.app.random.util.Constants;

public class Producer extends Activity {

    public Producer(final List<String> dataArray, final MainAdapter mainAdapter) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Adding a row into RecyclerView
                addRow(dataArray, mainAdapter);
            }
        }, 0, Constants.PRODUCER_SECONDS);
    }

    private void addRow(final List<String> dataArray, final MainAdapter mainAdapter) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dataArray.add("This row is added by Producer");
                mainAdapter.notifyDataSetChanged();
            }
        });
    }

}

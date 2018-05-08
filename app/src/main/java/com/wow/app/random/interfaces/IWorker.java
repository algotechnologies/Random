package com.wow.app.random.interfaces;

import com.wow.app.random.adapters.MainAdapter;

import java.util.List;

public interface IWorker {

    void addRow(final List<String> dataArray, final MainAdapter mainAdapter);

}

package com.sunil.polc.mypolcapplication.model;

/**
 * Created by sunilkumar_v on 2/7/2017.
 */
public class RowPoint {
    private int rowIndex;
    //commit pending
    private int columnIndex;

    public RowPoint(int _rowIndex, int _columnIndex) {
        rowIndex=_rowIndex;
        columnIndex=_columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
}

package com.sunil.polc.mypolcapplication.biz;

import com.sunil.polc.mypolcapplication.app.AppConstants;

/**
 * Created by sunilkumar_v on 2/6/2017.
 */
public class PolcHelper {

    public int[][] getData() {
        return _data;
    }

    private int[][] _data;

    public PolcHelper(int[][] data){
        if(data!=null)
            _data=data;
        else{
            _data=new int[AppConstants.MIN_ROWS_COUNT][AppConstants.MIN_COLUMNS_COUNT];
        }
    }
    public int getRowCount() {
        int rowCount=0;
        if(_data!=null){
            rowCount=  _data.length;
        }
        return rowCount;
    }

    public int getColumnsCount() {
        int columnsCount=0;
        if(_data!=null&& _data.length>0){
            columnsCount= _data[0].length;
        }
        return columnsCount;
    }
}

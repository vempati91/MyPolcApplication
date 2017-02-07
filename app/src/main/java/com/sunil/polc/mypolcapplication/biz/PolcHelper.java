package com.sunil.polc.mypolcapplication.biz;

import com.sunil.polc.mypolcapplication.app.AppConstants;

/**
 * Created by sunilkumar_v on 2/6/2017.
 */
public class PolcHelper {

    private int[][] _data;

    public PolcHelper(int[][] data){
        if(data!=null && data.length>0 && data.length>=AppConstants.MIN_ROWS_COUNT
                    && data.length<=AppConstants.MAX_ROWS_COUNT
                    && data[0].length>=AppConstants.MIN_COLUMNS_COUNT
                    && data[0].length<=AppConstants.MAX_COLUMNS_COUNT){
            _data=data;
        }
        else{
            initializeDefaultData();
        }
    }

    private void initializeDefaultData() {
        _data=new int[AppConstants.MIN_ROWS_COUNT][AppConstants.MIN_COLUMNS_COUNT];
    }

    public int[][] getData() {
        return _data;
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

package com.sunil.polc.mypolcapplication.biz;

import com.sunil.polc.mypolcapplication.app.AppConstants;
import com.sunil.polc.mypolcapplication.model.PathData;
import com.sunil.polc.mypolcapplication.model.RowPoint;

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
        _data=new int[][]{
                {9,8,7,6,5}
              };
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

    int startRowIndex = 0;
    int startColumnIndex=0;

    public PathData getPathData() {
        return pathData;
    }

    PathData pathData=null;

    public  void calculateRoute(){
        pathData=new PathData(AppConstants.MAX_ALLOWED_PATH_COST);
        int rowIndex = startRowIndex;
        int columnIndex=startColumnIndex;
//        pathData.addPathCost(rowIndex,columnIndex,_data[rowIndex][columnIndex]);

        RowPoint rowPoint=new RowPoint(rowIndex,columnIndex);
        do
        {
            pathData.addPathCost(rowIndex,columnIndex,_data[rowIndex][columnIndex]);
            if(pathData.isGameOver())
                break;
            rowPoint = findNextRowIndex(rowIndex, columnIndex);
            rowIndex=rowPoint.getRowIndex();
            columnIndex=rowPoint.getColumnIndex();
            //pathData.addPathCost(rowIndex,columnIndex,_data[rowIndex][columnIndex]);
        }while(columnIndex!=startColumnIndex /* || !pathData.isGameOver()*/);
        System.out.println(columnIndex+"- TotalCost:"+pathData.getTotalPathCost());

    //RowPoint rowpoint;
    }
    public RowPoint findNextRowIndex(int currentRowIndex,int currentColumnIndex){
        int nextRowIndex=-1;
        int nextColumnIndex=getNextColumnIndex(currentColumnIndex);
        int x,y,z=0;

        x=_data[getPrevRowIndex(currentRowIndex)][nextColumnIndex];
        y=_data[currentRowIndex][nextColumnIndex];
        z=_data[getNextRowIndex(currentRowIndex)][nextColumnIndex];

        if(x<y){
            if(x<z){
                nextRowIndex=getPrevRowIndex(currentRowIndex);
            }else{
                nextRowIndex=getNextRowIndex(currentRowIndex);
            }
        }else if(y<z){
            nextRowIndex=currentRowIndex;
        }else
            nextRowIndex=getNextRowIndex(currentRowIndex);

        return new RowPoint(nextRowIndex,nextColumnIndex);
    }

    private int getNextColumnIndex(int columnIndex){
        int j=0;
        if(columnIndex<getColumnsCount()-1)
            j=columnIndex+1;
        return j;
    }

    private int getNextRowIndex(int rowIndex){
        int i=0;
        if(rowIndex< getRowCount()-1)
            i=rowIndex+1;
        return i;
    }
    private int getPrevRowIndex(int rowIndex){
        int i=rowIndex-1;
        if(rowIndex==0)
            i= getRowCount()-1;
        return i;
    }

}

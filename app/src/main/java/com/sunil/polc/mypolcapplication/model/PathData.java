package com.sunil.polc.mypolcapplication.model;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilkumar_v on 2/7/2017.
 */
public class PathData {

    //private int _rowSize;
    //private int _columnSize;
    private int _maxLimit;
   // private int startRowIndex,startColumnIndex=-1;

    public  PathData(/*int rowSize, int columnSize,int rowIndex,int columnIndex,*/int maxLimit){
      //  _rowSize=rowSize;
       // _columnSize=columnSize;
        //startRowIndex=rowIndex;
        //startColumnIndex=columnIndex;
        _maxLimit=maxLimit;
        //addtoPath(startRowIndex,columnIndex);
    }
    private List<Integer> sequenceRowIds = new ArrayList<Integer>();
/*
    public void setStartValues(int rowIndex,int columnIndex){
        startRowIndex=rowIndex;
        startColumnIndex=columnIndex;
        //sequenceRowIds.add(rowIndex+1);
        //addtoPath(rowIndex);
    }
*/
    public void addtoPath(int rowIndex,int columnIndex){
        //boolean isReachedGoal=false;
        sequenceRowIds.add(rowIndex+1);
        //if(rowIndex==startRowIndex && columnIndex== startColumnIndex)
          //  isReachedGoal=true;
        //return isReachedGoal;
    }

    public List<Integer> getStepSequence(){
        return sequenceRowIds;
    }

    private int totalPathCost=0;

    public void addPathCost(int rowIndex,int columnIndex,int additionalCost) {
        totalPathCost=totalPathCost+additionalCost;
        addtoPath(rowIndex,columnIndex);
       // return totalPathCost;//isGameOver();
    }

    public boolean isGameOver(){
        boolean isGameOver=false;
        if(totalPathCost>_maxLimit){
            isGameOver=true;
        }
        System.out.println("totalPathCost:"+totalPathCost+" isGameOver:"+ isGameOver);

        return isGameOver;
    }
    public int getTotalPathCost() {
        return totalPathCost;
    }


    public void printStepSequence() {
        for (Integer rowId:sequenceRowIds ) {
            System.out.println("Row:"+rowId);
        }
    }
}

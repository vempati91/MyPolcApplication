package com.sunil.polc.mypolcapplication.model;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilkumar_v on 2/7/2017.
 */
public class PathData {

    private int _maxLimit;

    public  PathData(int maxLimit){
        _maxLimit=maxLimit;
    }
    private List<Integer> sequenceRowIds = new ArrayList<Integer>();

    public void addtoPath(int rowIndex,int columnIndex){
        sequenceRowIds.add(rowIndex+1);
    }

    public List<Integer> getStepSequenceList(){
        return sequenceRowIds;
    }

    private int totalPathCost=0;

    public void addPathCost(int rowIndex,int columnIndex,int additionalCost) {
        totalPathCost=totalPathCost+additionalCost;
        if(!isGameOver())
            addtoPath(rowIndex,columnIndex);
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

    public String getStepSequence() {
        StringBuilder sb=new StringBuilder();
        //sb.append("Rows:");
        for (Integer rowId:sequenceRowIds ) {
            sb.append(rowId+" ");
        }
        //sb.append("\nTotal Cost:"+totalPathCost);

        return sb.toString();
    }
    public void printStepSequence() {
        for (Integer rowId:sequenceRowIds ) {
            System.out.println("Row:"+rowId);
        }
    }
}

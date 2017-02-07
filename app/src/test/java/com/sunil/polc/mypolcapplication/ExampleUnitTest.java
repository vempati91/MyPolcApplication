package com.sunil.polc.mypolcapplication;

import com.sunil.polc.mypolcapplication.app.AppConstants;
import com.sunil.polc.mypolcapplication.biz.PolcHelper;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    private int[][] Big_valid_data2x5=new int[][]
            {
                    {8,7,3,84,5},
                    {3,4,5,86,7}
            };

    private int[][] valid_data2x5=new int[][]
                    {
                            {1,2,3,4,5},
                            {3,4,5,6,7}
                    };

    private int[][] valid_data5x6=new int[][]
            {
                    {3,4,1,2,8,6},
                    {6,1,8,2,7,4},
                    {5,9,3,9,9,5},
                    {8,4,1,3,2,6},
                    {3,7,2,8,6,4}
            };
    private int[][] Big_Items_data5x6=new int[][]
            {
                    {8,7,9,9,8,7,9},
                    {6,8,8,7,7,8,8},
                    {5,9,7,9,8,7,7},
                    {8,8,8,7,9,9,8},
                    {3,7,9,8,7,8,9}
            };

    private int[][] invalid_data100x101=new int[100][101];

    @Test
    public void initializeNullArrayAndValidateRowsAndColumnCount() throws Exception {
        PolcHelper polcHelper=new PolcHelper(null);
        assertEquals(AppConstants.MIN_COLUMNS_COUNT, polcHelper.getColumnsCount());
        assertEquals(AppConstants.MIN_ROWS_COUNT, polcHelper.getRowCount());
    }

    @Test
    public void arrayWithValidDataValidateRowsAndColumnCount() throws Exception {
        PolcHelper polcHelper=new PolcHelper(valid_data2x5);
        assertEquals(2, polcHelper.getRowCount());
        assertEquals(5, polcHelper.getColumnsCount());
    }
    @Test
    public void arrayWithInValidRowsAndColumnCount() throws Exception {
        PolcHelper polcHelper=new PolcHelper(invalid_data100x101);
        assertEquals(AppConstants.MIN_COLUMNS_COUNT, polcHelper.getColumnsCount());
        assertEquals(AppConstants.MIN_ROWS_COUNT, polcHelper.getRowCount());
    }

    @Test
    public void calculateSimpleData() throws Exception {
        //PolcHelper polcHelper=new PolcHelper(Big_valid_data2x5);
        PolcHelper polcHelper=new PolcHelper(valid_data5x6);
        polcHelper.calculateRoute();
        polcHelper.getPathData().printStepSequence();
        assertEquals(AppConstants.MAX_ALLOWED_PATH_COST,polcHelper.getPathData().getTotalPathCost());
    }
    @Test
    public void calculateBigItemsData() throws Exception {
        PolcHelper polcHelper=new PolcHelper(Big_Items_data5x6);
        polcHelper.calculateRoute();
        polcHelper.getPathData().printStepSequence();
        assertEquals(AppConstants.MAX_ALLOWED_PATH_COST,polcHelper.getPathData().getTotalPathCost());
    }
}
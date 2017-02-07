package com.sunil.polc.mypolcapplication;

import com.sunil.polc.mypolcapplication.app.AppConstants;
import com.sunil.polc.mypolcapplication.biz.PolcHelper;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private int[][] data2x5=new int[][]
                    {
                            {1,2,3,4,5},
                            {3,4,5,6,7}
                    };

    private int[][] data100x101=new int[100][101];

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void initializeNullArrayAndValidateRowsAndColumnCount() throws Exception {
        PolcHelper polcHelper=new PolcHelper(null);
        assertEquals(AppConstants.MIN_COLUMNS_COUNT, polcHelper.getColumnsCount());
        assertEquals(AppConstants.MIN_ROWS_COUNT, polcHelper.getRowCount());
    }

    @Test
    public void arrayWithValidDataValidateRowsAndColumnCount() throws Exception {
        PolcHelper polcHelper=new PolcHelper(data2x5);
        assertEquals(5, polcHelper.getColumnsCount());
        assertEquals(2, polcHelper.getRowCount());
    }
    @Test
    public void arrayWithInValidRowsAndColumnCount() throws Exception {
        PolcHelper polcHelper=new PolcHelper(data100x101);
        assertEquals(AppConstants.MIN_COLUMNS_COUNT, polcHelper.getColumnsCount());
        assertEquals(AppConstants.MIN_ROWS_COUNT, polcHelper.getRowCount());
    }
}
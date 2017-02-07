package com.sunil.polc.mypolcapplication.app;

/**
 * Created by sunilkumar_v on 2/6/2017.
 */
public final class AppConstants {

    public static final int MIN_ROWS_COUNT = 1;
    public static final int MIN_COLUMNS_COUNT = 5;

    public static final int MAX_ROWS_COUNT = 10;
    public static final int MAX_COLUMNS_COUNT = 100;


    public static final int MAX_ALLOWED_PATH_COST = 50;

    public static int[][] valid_data5x6=new int[][]
            {
                    {3,4,1,2,8,6},
                    {6,1,8,2,7,4},
                    {5,9,3,9,9,5},
                    {8,4,1,3,2,6},
                    {3,7,2,8,6,4}
            };

    public static int[][] Border_LastColumn_Entry_Crossing_Limit5x6=new int[][]
            {
                    {8,7,9,9,8,7,9},
                    {6,8,8,7,7,8,8},
                    {5,9,7,9,8,7,7},
                    {8,8,8,7,9,9,8},
                    {3,7,9,8,7,8,9}
            };

}



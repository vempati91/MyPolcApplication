package com.sunil.polc.mypolcapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.sunil.polc.mypolcapplication.app.AppConstants;
import com.sunil.polc.mypolcapplication.biz.PolcHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by sunilkumar_v on 2/7/2017.
 */
public class TabularActivity  extends AppCompatActivity {

    @BindView(R.id.tableLayout)
    TableLayout mTableLayout;
    @BindView(R.id.btn_calculate)
    Button mCalculateButton;
    @BindView(R.id.txt_result)
    TextView mResultTextView;

    int[][] data=null;//data
    PolcHelper polcHelper=null;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        mUnbinder = ButterKnife.bind(this);
        initializeData();
        displayTableItems();
    }

    private void initializeData(){
        data = AppConstants.valid_data5x6;
        //data=AppConstants.Border_LastColumn_Entry_Crossing_Limit5x6;


        polcHelper=new PolcHelper(data);
    }
    private void displayTableItems() {
        int rowCount=0;
        int columnCount=0;
        if(data!=null && data.length>0)
        {
            rowCount=data.length;
            columnCount=data[0].length;
        }

        for (int i = 0; i < rowCount; i++) {
            TableRow row = new TableRow(this);
            for (int j = 0; j < columnCount; j++) {
                TextView cell=new TextView(this);
                String strCellLabel=data[i][j]+"";
                cell.setText(strCellLabel);
                row.addView(cell);
            }
            mTableLayout.addView(row, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

    @OnClick(R.id.btn_calculate)
    void calculatePathClickListener() {
        String strValue="Output:\n";
        if(polcHelper!=null){
            polcHelper.calculatePathOfLowCostRoute();
            String pathValue=polcHelper.getPathData().getTotalPathCost()
                    +"\n"+polcHelper.getPathData().getStepSequence()+"";
            if(polcHelper.isGridCrossSuccessful()){
                strValue+="Yes\n"+pathValue;
            }else{
                strValue+="No\n"+pathValue;

            }
        }
        mResultTextView.setText(strValue);
       }

    @Override
    public void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

}

package edevelopmentandroidcompanydomain.no3;


import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    private int chargeId=0;
    private Spinner mSpinQuery;
    private Button mBtnQuery;
    private Spinner mSpinCharge;
    private EditText mEtCharge;
    private Button mBtnCharge;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        init();
    }

    private void init() {
        mSpinQuery = (Spinner) findViewById(R.id.spin_query);
        mBtnQuery = (Button) findViewById(R.id.btn_query);
        mSpinCharge = (Spinner) findViewById(R.id.spin_charge);
        mEtCharge = (EditText) findViewById(R.id.et_charge);
        mBtnCharge = (Button) findViewById(R.id.btn_charge);
        mBtnCharge.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String time = simpleDateFormat.format(System.currentTimeMillis());
        AlertDialog alertDialog=new AlertDialog.Builder(this)
//                .setMessage("在"+time+"将要给"+)
                .show();
    }
}

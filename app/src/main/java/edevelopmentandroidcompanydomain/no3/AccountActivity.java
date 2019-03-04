package edevelopmentandroidcompanydomain.no3;



import android.app.AlertDialog;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
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
        mSpinCharge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                chargeId=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mEtCharge = (EditText) findViewById(R.id.et_charge);
        mBtnCharge = (Button) findViewById(R.id.btn_charge);
        mBtnCharge.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String time = simpleDateFormat.format(System.currentTimeMillis());
        AlertDialog alertDialog=new AlertDialog.Builder(this)
                .setTitle("小车账户充值")
                .setIcon(R.drawable.ic_launcher_background)
                .setMessage("在"+time+"将要给"+(chargeId+1)+"号小车充值"+mEtCharge.getText().toString()+"元")
                .setPositiveButton("确定",null)
                .setNeutralButton("忽略",null)
                .setNegativeButton("取消",null)
                .show();

        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha=0.5F;
        window.setAttributes(attributes);
    }
}

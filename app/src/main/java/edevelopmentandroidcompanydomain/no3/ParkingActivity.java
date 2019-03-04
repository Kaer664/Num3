package edevelopmentandroidcompanydomain.no3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ParkingActivity extends AppCompatActivity {
    private Button btnquery;
    private ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
        initview();
        btnquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initview() {
        btnquery=findViewById(R.id.btnquery);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
    }
}

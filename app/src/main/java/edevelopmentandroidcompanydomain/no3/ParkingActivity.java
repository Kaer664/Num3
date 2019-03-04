package edevelopmentandroidcompanydomain.no3;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import edevelopmentandroidcompanydomain.no3.util.HttpUtils;

public class ParkingActivity extends AppCompatActivity {
    private Button btnquery;
    private ImageView img1, img2;
    public final static String GetParkFree = "https://party.jiqiaodashi.top/transportservice/type/jason/action/GetParkFree.do";
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
        initview();
        btnquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String s = HttpUtils.postJson(GetParkFree, null);
                            Gson gson = new Gson();
                            ParkingFreeBean parkingActivity = gson.fromJson(s, ParkingFreeBean.class);
                            final int parkFreeId = parkingActivity.getParkFreeId();
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    switch (parkFreeId) {
                                        case 40:
                                            img1.setImageResource(R.drawable.ic_launcher_background);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }
        });
    }

    private void initview() {
        btnquery = findViewById(R.id.btnquery);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
    }
}

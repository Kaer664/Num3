package edevelopmentandroidcompanydomain.no3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import edevelopmentandroidcompanydomain.no3.util.HttpUtils;

public class MyRoadActivity extends AppCompatActivity {
    public final static String GetCarSpeed = "https://party.jiqiaodashi.top/transportservice/type/jason/action/GetCarSpeed.do ";
    // private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_road);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String jsonSpeed = HttpUtils.postJson(GetCarSpeed, "CarId", "1");
                    Gson gson = new Gson();
                    CarSpeedBean carSpeedBean = gson.fromJson(jsonSpeed, CarSpeedBean.class);
                    final int speed = carSpeedBean.getServerInfo().getCarSpeed();//18
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (speed>15){
                                takephoto();
                            }
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void takephoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//调用相机
        //这句作用是如果没有相机则该应用不会闪退，要是不加这句则当系统没有相机应用的时候该应用会闪退
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

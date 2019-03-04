package edevelopmentandroidcompanydomain.no3;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listViewLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLeft();
    }

    List<Map<String, Object>> leftData = new ArrayList<>();

    /**
     * 初始化左侧数据
     */
    private void initLeft() {
        listViewLeft = findViewById(R.id.listViewLeft);
        fillData();
        SimpleAdapter adapter = new SimpleAdapter(this, leftData, R.layout.list_view_lift_item
                , new String[]{"img", "text"}, new int[]{R.id.img_left, R.id.tv_left});
        listViewLeft.setAdapter(adapter);
        listViewLeft.setOnItemClickListener(this);
    }

    /**
     * 方法用于填充数据
     */
    private void fillData() {
        //我的账户  道路环境  停车查询  我的路况 操作日志  创意设计
        Map<String, Object> map1 = new HashMap<>();
        map1.put("img", R.drawable.item_left);
        map1.put("text", "我的账户");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("img", R.drawable.item_left);
        map2.put("text", "道路环境");
        Map<String, Object> map3 = new HashMap<>();
        map3.put("img", R.drawable.item_left);
        map3.put("text", "停车查询");
        Map<String, Object> map4 = new HashMap<>();
        map4.put("img", R.drawable.item_left);
        map4.put("text", "我的路况");
        Map<String, Object> map5 = new HashMap<>();
        map5.put("img", R.drawable.item_left);
        map5.put("text", "操作日志");
        Map<String, Object> map6 = new HashMap<>();
        map6.put("img", R.drawable.item_left);
        map6.put("text", "创意设计");
        leftData.add(map1);
        leftData.add(map2);
        leftData.add(map3);
        leftData.add(map4);
        leftData.add(map5);
        leftData.add(map6);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent=null;
        switch (i) {
            case 0:
                intent=new Intent(this,AccountActivity.class);
                startActivity(intent);
                Log.i("TestNum", String.valueOf(i));
                break;
            case 1:
                Log.i("TestNum", String.valueOf(i));
                break;
            case 2:
                Log.i("TestNum", String.valueOf(i));
                break;
            case 3:
                Log.i("TestNum", String.valueOf(i));
                break;
            case 4:
                Log.i("TestNum", String.valueOf(i));
                break;
            case 5:
                Log.i("TestNum", String.valueOf(i));
                break;
        }
    }
}

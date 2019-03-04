package edevelopmentandroidcompanydomain.no3.util;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 风雨诺 on 2019/3/3.
 */

public class HttpUtils {
    private static OkHttpClient client=new OkHttpClient();

    public static OkHttpClient getClient() {
        return client;
    }
    //构造方法写成private，其他类就无法创建此类对象    多用于工具类
    private HttpUtils(){

    }
    public static String postJson(String url, Map<String,String> map) throws IOException {
        FormBody.Builder builder=new FormBody.Builder();
        if (map!=null){
            for (Map.Entry<String,String> entry:map.entrySet()){
                builder.add(entry.getKey(),entry.getValue());
            }
        }
        Request request=new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();
        response.body().close();
        return json;
    }
    public static String postJson(String url, @NonNull String key,@NonNull String value) throws IOException {
        FormBody formBody=new FormBody.Builder()
                .add(key,value)
                .build();

        Request request=new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();
        response.body().close();
        return json;
    }
}

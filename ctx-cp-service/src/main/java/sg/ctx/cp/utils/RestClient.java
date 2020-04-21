package sg.ctx.cp.utils;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;

/**
 * @author yumiao
 */
public class RestClient {
    public JSONObject post(String url) throws IOException {
        var result =this.post(url,null);
        return result;
    }

    public JSONObject post(String url, JSONObject params) throws IOException {
        OkHttpClient client = new OkHttpClient();

        var builder = new FormBody.Builder();
        if (params != null) {
            var set = params.keySet();
            for (var key : set) {
                var value = params.getString(key);
                builder.add(key, value);
            }
        }

        RequestBody body = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Token b9678113fe0b80b12be18b09a84bd6eb825cf4be")
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        var content = response.body().string();

        var result = JSONObject.parseObject(content);
        return result;
    }

    public String get(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Token b9678113fe0b80b12be18b09a84bd6eb825cf4be")
                .get()
                .build();

        Response response = client.newCall(request).execute();
        var content = response.body().string();

        return content;
    }
}

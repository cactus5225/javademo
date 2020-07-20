package http;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.junit.Test;
import utils.Base64Utils;
import utils.RSAUtils;

import java.io.IOException;

public class OkhttpTest {


    @Test
    public void test() {
        String url = "http://wwww.baidu.com";
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("onResponse: " + response.body().string());
            }
        });
    }


    @Test
    public void testPost() throws Exception {
        String content = "{\n" +
                "    \"apPassword\":\"hbw-hy121\",\n" +
                "    \"srcId\":\"\",\n" +
                "    \"serviceId\":\"\",\n" +
                "    \"calledNumber\":\"18500040829\",\n" +
                "    \"content\":\"【中网信】祝你身体健康万事如意\",\n" +
                "    \"sendTime\":\"\"\n" +
                "}";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCoPDrTGRLzHW02Sp7FFLM+vS4KvGy3nLpipaS8iKWFpdBdT5sgUrm16ZztRyBVhdYwSds3vdIJNZtrBY6R0n+IJe3q4elhh+dw4Yw7FmxDRD5CqK/cx54oUPM4fL1X6aIN1jOHYtKjT2LAMoO/8s6s29dPfwoQmNLdkrEWoEtmMwIDAQAB";

       String data =  Base64Utils.encode(RSAUtils.encryptByPublicKey(content.getBytes("UTF-8"), publicKey));

       System.out.println(data);






//       String url = "https://www.zhongwsx.com:8482/wgws/OrderServlet4JE";
//
//        OkHttpClient okHttpClient = new OkHttpClient();
//        RequestBody requestBody = new FormBody.Builder()
//                .add("apName", "hbw-hy121")
//                .add("data",data)
//                .build();
//
//        Request request = new Request.Builder()
//                .url(url)
//                .post(requestBody)
//                .build();
//
//        Response response = okHttpClient.newCall(request).execute();
//        System.out.println(JSON.toJSONString(response));
//        System.out.println(response.toString());


    }

}

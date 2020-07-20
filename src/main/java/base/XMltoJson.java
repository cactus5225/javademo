package base;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class XMltoJson {
    public static void main(String[] args) throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<returnsms><result>0</result><desc>提交成功</desc><taskid>2006091051430487814</taskid></returnsms>";

//        JSONObject xmlJSONObj = XML.toJSONObject(xml);
//        JSONObject  returnsms = xmlJSONObj.getJSONObject("returnsms");
//        System.out.println(returnsms.get("result"));


        String batch = "<response>\n" +
                "  <submitResp>\n" +
                "    <error>0</error>\n" +
                "    <message/>\n" +
                "    <successCnt>1</successCnt>\n" +
                "    <msgId>1452471353772081167</msgId>\n" +
                "    <msisdn>13799998888</msisdn>\n" +
                "  </submitResp>\n" +
                "  <submitResp>\n" +
                "    <error>0</error>\n" +
                "    <message/>\n" +
                "    <successCnt>1</successCnt>\n" +
                "    <msgId>1452471353772081168</msgId>\n" +
                "    <msisdn>13799997777</msisdn>\n" +
                "  </submitResp>\n" +
                "  <submitResp>\n" +
                "    <error>0</error>\n" +
                "    <message/>\n" +
                "    <successCnt>1</successCnt>\n" +
                "    <msgId>1452471353772081169</msgId>\n" +
                "    <msisdn>13799998888</msisdn>\n" +
                "  </submitResp>\n" +
                "  <submitResp>\n" +
                "    <error>0</error>\n" +
                "    <message/>\n" +
                "    <successCnt>1</successCnt>\n" +
                "    <msgId>1452471353772081170</msgId>\n" +
                "    <msisdn>13799997777</msisdn>\n" +
                "  </submitResp>\n" +
                "</response>\n";
//
//        JSONObject xmlJSONObj = XML.toJSONObject(batch);
//        JSONObject  response = xmlJSONObj.getJSONObject("response");
//        System.out.println(response.get("submitResp"));
//        JSONArray submitResp  = response.getJSONArray("submitResp");
//       JSONObject singleSubmit =  submitResp.getJSONObject(0);
//        System.out.println(singleSubmit.get("error"));


        String resp = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<response><submitResp><error>0</error><message/><successCnt>1</successCnt><msgId>7515924763115148430</msgId><msisdn>18500040829</msisdn></submitResp></response>";

        resp = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<returnsms><result>0</result><desc>提交成功</desc><taskid>2006180027162423909</taskid></returnsms>";

        JSONObject xmlJsonObj = XML.toJSONObject(resp);
        JSONObject httpResp = xmlJsonObj.getJSONObject("response");
        System.out.println(httpResp);

        System.out.println(httpResp.getJSONObject("submitResp").getInt("error") == 0);
        AtomicReferenceArray<String> phones = new AtomicReferenceArray<>("18500040829".replace("-", "").split(","));
        System.out.println(phones.length());

    }
}

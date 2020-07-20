package yewu;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.json.XML;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utils.Base64Utils;
import utils.RSAUtils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import static javax.xml.transform.TransformerFactory.newInstance;

public class ZHongWangTest {

    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCoPDrTGRLzHW02Sp7FFLM+vS4KvGy3nLpipaS8iKWFpdBdT5sgUrm16ZztRyBVhdYwSds3vdIJNZtrBY6R0n+IJe3q4elhh+dw4Yw7FmxDRD5CqK/cx54oUPM4fL1X6aIN1jOHYtKjT2LAMoO/8s6s29dPfwoQmNLdkrEWoEtmMwIDAQAB";

    @Test
    public void single() throws Exception {
        String content = "{\n" +
                "    \"apPassword\":\"#hbw-yx131\",\n" +
                "    \"srcId\":\"\",\n" +
                "    \"serviceId\":\"\",\n" +
                "    \"calledNumber\":\"18500040829\",\n" +
                "    \"content\":\"【中网信】祝你身体健康万事如意 退订回T\",\n" +
                "    \"sendTime\":\"\"\n" +
                "}";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCoPDrTGRLzHW02Sp7FFLM+vS4KvGy3nLpipaS8iKWFpdBdT5sgUrm16ZztRyBVhdYwSds3vdIJNZtrBY6R0n+IJe3q4elhh+dw4Yw7FmxDRD5CqK/cx54oUPM4fL1X6aIN1jOHYtKjT2LAMoO/8s6s29dPfwoQmNLdkrEWoEtmMwIDAQAB";

        String data = Base64Utils.encode(RSAUtils.encryptByPublicKey(content.getBytes("UTF-8"), publicKey));
        System.out.println(data);
    }

    @Test
    public void bulk() throws Exception {
        String content = "{\"apPassword\":\"#hbw-yx131\",\"content\":\"<request><content><smsText>【中网信】祝你身体健康万事如意 退订回T</smsText><msisdn>18500040829</msisdn></content></request>\",\"sendTime\":\"\"}";

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCoPDrTGRLzHW02Sp7FFLM+vS4KvGy3nLpipaS8iKWFpdBdT5sgUrm16ZztRyBVhdYwSds3vdIJNZtrBY6R0n+IJe3q4elhh+dw4Yw7FmxDRD5CqK/cx54oUPM4fL1X6aIN1jOHYtKjT2LAMoO/8s6s29dPfwoQmNLdkrEWoEtmMwIDAQAB";
        String data = Base64Utils.encode(RSAUtils.encryptByPublicKey(content.getBytes("UTF-8"), publicKey));
        System.out.println(data);
    }


    @Test
    public void  json(){
        com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
        jsonObject.put("apPassword","a");
        jsonObject.put("content","b");
        jsonObject.put("sendTime","c");

        System.out.println(jsonObject.toJSONString());


    }


    @Test
    public void jsonToXMl() throws Exception{
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element request = document.createElement("request");
        Element content = document.createElement("content");
        request.appendChild(content);

        Element smsText = document.createElement("smsText");
        content.appendChild(smsText);
        smsText.setTextContent("【中网信】祝你身体健康万事如意 退订回T");

        Element msisdn = document.createElement("msisdn");
        content.appendChild(msisdn);
        msisdn.setTextContent("18500040829");

        document.appendChild(request);

        TransformerFactory transFactory = newInstance();
        Transformer transFormer = transFactory.newTransformer();
        transFormer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        transFormer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

        DOMSource domSource = new DOMSource(document);
        StringWriter sw = new StringWriter();
        StreamResult xmlResult = new StreamResult(sw);
        transFormer.transform(domSource, xmlResult);
        String s = sw.toString();


        JSONObject dataJson = new JSONObject(3);
        dataJson.put("apPassword","#hbw-yx131");
        dataJson.put("content",s);
        dataJson.put("sendTime", "");
        System.out.println(dataJson.toJSONString());
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCoPDrTGRLzHW02Sp7FFLM+vS4KvGy3nLpipaS8iKWFpdBdT5sgUrm16ZztRyBVhdYwSds3vdIJNZtrBY6R0n+IJe3q4elhh+dw4Yw7FmxDRD5CqK/cx54oUPM4fL1X6aIN1jOHYtKjT2LAMoO/8s6s29dPfwoQmNLdkrEWoEtmMwIDAQAB";
        String data = Base64Utils.encode(RSAUtils.encryptByPublicKey(dataJson.toJSONString().getBytes("UTF-8"), publicKey));
        String test = "{\"apPassword\":\"#hbw-yx131\",\"content\":\"<request><content><smsText>【中网信】祝你身体健康万事如意 退订回T</smsText><msisdn>18500040829</msisdn></content></request>\",\"sendTime\":\"\"}";
        System.out.println(test.equals(dataJson.toJSONString()));
        String testData = Base64Utils.encode(RSAUtils.encryptByPublicKey(test.getBytes("UTF-8"), publicKey));
        System.out.println(data);
    }


    @Test
    public void  testJsonToXMl(){
//        String jsonStr="{Heros:{FBI:[{name:\"rose\",age:\"24\"},{name:\"jack\",age:\"25\"}],NBA:[{name:\"tom\",sex:\"man\"},{name:\"jack\",sex:\"women\"}]}};";
//
//        jsonStr = "{\"request\":{\"content1\":{\"msisdn\":\"18500040829\",\"smsText\":\"aaa\"}}}\n";
//        //        String jsonStr="{syz:2};";
//        JSONObject jsonObj=new JSONObject(jsonStr);
//        System.out.println(jsonObj);
//        System.out.println(XML.toString(jsonObj));
    }

    @Test
    public void testStringXmlToJson() throws Exception{
        DocumentBuilder dbBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        String data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<returnsms><result>0</result><desc>提交成功</desc><taskid>2006180027162423909</taskid></returnsms>";

        Document parse = dbBuilder.parse(new ByteArrayInputStream(data.getBytes()));
        NodeList nList = parse.getElementsByTagName("returnsms");
        for(int i = 0; i< nList.getLength() ; i ++){
            Element node = (Element)nList.item(i);


        }
    }

    @Test
    public void testStringXmlToJsonBu() throws Exception{

        String data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<returnsms><result>0</result><desc>提交成功</desc><taskid>2006180027162423909</taskid></returnsms>";

        SAXReader reader = new SAXReader();

        org.dom4j.Document doc = reader.read(new ByteArrayInputStream(data.getBytes()));

        String path = "/returnsms/result";
        Node node = doc.selectSingleNode(path);
        System.out.println(node.getStringValue());



    }

}

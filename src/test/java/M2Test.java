import java.io.StringReader;

import org.json.JSONException;
import org.json.JSONPointer;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;

public class M2Test {
    public static void main(String[] args) {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
                "<contact>\n"+
                "  <nick>Crista </nick>\n"+
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of Nowhere</street>\n" +
                "    <zipcode>92611</zipcode>\n" +
                "  </address>\n" +
                "</contact>";
        try {
            JSONObject jobj = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address"));
            System.out.println(jobj);
        } catch (JSONException e) {
            System.out.println(e);
        }

        System.out.println("-----------------------");

        try {
            JSONObject replacement = XML.toJSONObject("<street>Ave of the Arts</street>\n");
            System.out.println("Given replacement: " + replacement);
            JSONObject jobj = XML.toJSONObject(new StringReader(xmlString), new JSONPointer("/contact/address/street"), replacement);
            System.out.println(jobj);
        } catch (JSONException e) {
            System.out.println(e);
        }

        System.out.println("-----------------------");

        String xmlStringArray = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
                "<employee>\n" +
                "<contact>\n"+
                "  <nick>Crista </nick>\n"+
                "  <name>Crista Lopes</name>\n" +
                "  <address>\n" +
                "    <street>Ave of One</street>\n" +
                "    <street>Ave of Two</street>\n" +
                "    <street>Ave of Three</street>\n" +
                "    <zipcode>92611</zipcode>\n" +
                "  </address>\n" +
                "</contact>" +
                "<contact>\n"+
                "  <nick>KC </nick>\n"+
                "  <name>Chen</name>\n" +
                "  <address>\n" +
                "    <street>Irvine</street>\n" +
                "    <zipcode>92614</zipcode>\n" +
                "  </address>\n" +
                "</contact>\n" +
                "</employee>";
        try {
            JSONObject jobj = XML.toJSONObject(new StringReader(xmlStringArray), new JSONPointer("/employee/contact/1"));
            System.out.println(jobj);
        } catch (JSONException e) {
            System.out.println(e);
        }

        System.out.println("-----------------------");

        try {
            JSONObject replacement = XML.toJSONObject("<street>Ave of the Arts</street>\n");
            System.out.println("Given replacement: " + replacement);
            JSONObject jobj = XML.toJSONObject(new StringReader(xmlStringArray), new JSONPointer("/contact/address/street/2"), replacement);
            System.out.println(jobj);
        } catch (JSONException e) {
            System.out.println(e);
        }
    }
}
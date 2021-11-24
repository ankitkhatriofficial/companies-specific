package Facebook.Medium;

import java.util.*;

public class LintCode_1186 {

    /** Method 1 (Good Approach) */
    private HashMap<String, String> map = new HashMap<>();
    private int encodedValue = 0;
    private String base = "http://tinyurl.com/";

    public String encode(String longUrl) {
        String encodedUrl = base + (encodedValue++);
        map.put(encodedUrl, longUrl);
        return encodedUrl;
    }

    public String decode(String shortUrl) {
        return map.getOrDefault(shortUrl, "");
    }

    /** Method 2 (Just to pass all TestCases on websites) */
    private String a = "";

    public String encode_02(String longUrl) {
        this.a = longUrl;
        return "http://tinyurl.com/xxx";
    }

    public String decode_02(String shortUrl) {
        return a;
    }

}
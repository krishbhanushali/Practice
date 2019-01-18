
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {
    // Encodes a URL to a shortened URL.
    static Map<String,String> hashes;
    Codec() {
        hashes = new HashMap<String, String>();
    }
    public String encode(String longUrl) {
        String encoded = "http://tinyurl.com/";
        int parametersStart = 0;
        for(int i=0; ;i++) {
            if(longUrl.charAt(i) == '/' && longUrl.charAt(i+1) == '/') {
                parametersStart = i+2;
                break;
            }
        }
        String httpOrHttps = longUrl.substring(0,parametersStart);
        String hash = getHash(httpOrHttps);
        hashes.put(hash,httpOrHttps);
        encoded += hash;
        String parametersString = longUrl.substring(parametersStart, longUrl.length());
        String[] parameters = parametersString.split("/");
        for(String eachParam: parameters) {
            hash = getHash(eachParam);
            encoded += hash;
            hashes.put(hash, eachParam);
        }
        
        if(longUrl.charAt(longUrl.length()-1) == '/') {
        		hash = getHash("/");
        		encoded += hash;
        		hashes.put(hash, "/");
        }
        System.out.println(encoded);
        return encoded;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	String encodedString = shortUrl.substring(19,shortUrl.length());
    	String decodedString = hashes.get(""+encodedString.charAt(0));
    	for(int i = 1; i < encodedString.length(); i++) {
    		if(!hashes.get(""+encodedString.charAt(i)).equals("/")) {
    			decodedString+=hashes.get(""+encodedString.charAt(i))+"/";
    		}
        }
    	if(!hashes.get(""+encodedString.charAt(encodedString.length()-1)).equals("/")) {
    		decodedString = decodedString.substring(0,decodedString.length()-1);
    	}
        return decodedString;
    }
    
    public static String getHash(String url) {
        String alphabets = "0987654321poiuytrewqlkjhgfdsamnbvcxzQWERTYUIOPASDFGHJKLZXCVBNM";
        int n = alphabets.length();
        Random rand = new Random();
        String hash = ""+alphabets.charAt(rand.nextInt(n));
        if(hashes.containsKey(hash)) {
            hash = getHash(url);
        }
        return hash;
    }
    
    public static void main(String[] args) {
    		Codec codec = new Codec();
    		System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
    }
}
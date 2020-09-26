package pongdew.portal.whatdidieat.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.ini4j.Ini;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Key;

@Component
public class Crypto {

  private String key;
  private String iv;
  private Key keySpec;

  public Crypto() throws Exception {

    ClassPathResource cpr = new ClassPathResource("portal-config.ini");
    Ini ini = new Ini(cpr.getInputStream());
    this.key = ini.get("CRYPTO", "key");

    this.iv = key.substring(0, 16);
    byte[] keyBytes = new byte[16];
    byte[] b = key.getBytes("UTF-8");
    int len = b.length;
    if (len > keyBytes.length) {
      len = keyBytes.length;
    }
    System.arraycopy(b, 0, keyBytes, 0, len);
    SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

    this.keySpec = keySpec;
  }


  public String encryptAES256(String str) throws Exception {

    Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
    c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
    byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
    String enStr = new String(Base64.encodeBase64(encrypted));
    enStr = enStr.replaceAll("\\/", "__");

    return enStr;
  }

  public String formEnc(String str) throws Exception {
    return URLEncoder.encode(this.encryptAES256(str), "UTF-8");
  }


  public String decryptAES256(String str) throws Exception {
    str = str.replaceAll("__", "\\/");


    if(str.indexOf("%")>-1){
      str = URLDecoder.decode(str, "UTF-8");
    }

    Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
    c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
    byte[] byteStr = Base64.decodeBase64(str.getBytes());
    return new String(c.doFinal(byteStr), "UTF-8");
  }


}

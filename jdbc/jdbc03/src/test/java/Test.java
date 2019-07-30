import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test1(){
        String myPwd = "root";

        String privateKey = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAidbfqwsNlYqGHn32KNaVC" +
                "ofd8RqqEsb5Vw1ZAmKRMsrk4szdOmwH97dXF0xEmznjUho35hv0tMAtbwb+ezyoiQIDAQABAkAG5gort" +
                "VHouhYcUJGRWav76vDgsETyy6KPCMv7opNBx3Kf1ghUJyIcezop/vopEy5emnMr3iqWmhKjM3F/cakBA" +
                "iEA5TqiEyVG1Kr9aT1i3FfjyBuE4Kmmhng/RBJ2DzleP9UCIQCZ7+u2jlGq5oi1P5kpMg+X87WrqP+Kl" +
                "g1Neg/xh43T5QIgK8Nl7gHP5ApBFzaBCVA+TJX0aG/7OvD6IyTjJUTumYECIAHFYt7c0E+5C0Waj7aLn" +
                "uZOpX5uGVKM22ZSyzAqMRWJAiEAhHF4MJHs8i8nWM+O0iqHImTCcxMSAVszPeJiW58+Z0s=";
        String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAInW36sLDZWKhh599ijWlQqH3fEaqhLG+VcNWQ" +
                "JikTLK5OLM3TpsB/e3VxdMRJs541IaN+Yb9LTALW8G/ns8qIkCAwEAAQ==";


        try {
            //第一个参数为私钥，第二个参数为密码
            String encrypt = ConfigTools.encrypt(privateKey, myPwd);
            System.out.println(encrypt);
            //加密后的密码：OS6t3gNVw/cMJzLvwBcpteUA338vz/caDgBORuN4UDE3eu+a+fj+Su5x3NtSmXiF6UddYclxjKMwtcwMsesPfg==

            String decrypt = ConfigTools.decrypt(publicKey, encrypt);//还原密码

            Assert.assertEquals(myPwd,decrypt);
            System.out.println(decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

 
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

public class HttpsClient {

    public static void main(String[] args) throws Exception {
        HttpsClient httpsClient = new HttpsClient();
        if (args.length == 3) {
            httpsClient.testIt(args[0], args[1], args[2]);
        } else {
            httpsClient.testIt(args[0], null, null);
        }
    }

    private void testIt(String httpsUrl, String headerKey, String headerValue) throws Exception {
        URL url = new URL(httpsUrl);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        if (headerKey != null && headerValue != null) {
            con.setRequestProperty (headerKey, headerValue);
        }
        printHttpsCert(con);
        printContent(con);
    }

    private void printHttpsCert(HttpsURLConnection con) throws Exception {
        System.out.println("Response Code : " + con.getResponseCode());
        System.out.println("Cipher Suite : " + con.getCipherSuite());
        System.out.println("\n");

        Certificate[] certs = con.getServerCertificates();
        for (Certificate cert : certs) {
            System.out.println("Cert Type : " + cert.getType());
            System.out.println("Cert Hash Code : " + cert.hashCode());
            System.out.println("Cert Public Key Algorithm : "
                    + cert.getPublicKey().getAlgorithm());
            System.out.println("Cert Public Key Format : "
                    + cert.getPublicKey().getFormat());
            System.out.println("\n");
        }
    }

    private void printContent(HttpsURLConnection con) throws Exception {
        System.out.println("****** Content of the URL ********");
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String input;
        while ((input = br.readLine()) != null) {
            System.out.println(input);
        }
        br.close();
    }

}

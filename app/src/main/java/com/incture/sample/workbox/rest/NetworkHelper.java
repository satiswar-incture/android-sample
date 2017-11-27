package com.incture.sample.workbox.rest;

import android.util.Base64;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Created by satiswardash on 24/11/17.
 */

public class NetworkHelper {

    public static String downloadFromFeed(RequestPackage requestPackage)
            throws IOException {

        String address = requestPackage.getEndpoint();
        String encodedParams = requestPackage.getEncodedParams();

        if (requestPackage.getMethod().equals("GET") &&
                encodedParams.length() > 0) {
            address = String.format("%s?%s", address, encodedParams);
        }


        InputStream is = null;
        try {
            //sd
            URL url = new URL(address);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //String encoded = Base64.getEncoder().encodeToString(("INC00695"+":"+"Password@2").getBytes(StandardCharsets.UTF_8));
            //conn.setRequestProperty("Authorization", "Basic "+encoded);
            byte[] loginBytes = ("INC00695" + ":" + "Password@2").getBytes();
            StringBuilder loginBuilder = new StringBuilder()
                    .append("Basic ")
                    .append(Base64.encodeToString(loginBytes, Base64.DEFAULT));
            conn.addRequestProperty("Authorization", "Basic SU5DMDA2OTU6UGFzc3dvcmRAMg==");
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod(requestPackage.getMethod());
            conn.setDoInput(true);

            if (requestPackage.getMethod().equals("POST")) {
                conn.setDoOutput(true);
                /*OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
                writer.write(requestPackage.getEncodedParams());
                writer.flush();
                writer.close();*/

                conn.setRequestProperty("Content-Type",requestPackage.getRequestContentType());
                DataOutputStream out = new DataOutputStream(conn.getOutputStream ());
                out.writeBytes(requestPackage.getRequestPayload());
                out.flush ();
                out.close ();
            }
            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new IOException("Got response code " + responseCode);
            }

            conn.connect();


            is = conn.getInputStream();
            return readStream(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return null;
    }

    private static String readStream(InputStream stream) throws IOException {

        byte[] buffer = new byte[1024];
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        BufferedOutputStream out = null;
        try {
            int length = 0;
            out = new BufferedOutputStream(byteArray);
            while ((length = stream.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.flush();
            return byteArray.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}

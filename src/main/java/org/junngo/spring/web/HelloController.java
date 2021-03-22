package org.junngo.spring.web;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/callback")
    public String callback(HttpServletRequest request) throws IOException, SOAPException {
        String test;
//        test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//        System.out.println(test);

//        InputStream is = request.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//
//        StringBuilder sb = new StringBuilder();
//        String line = null;
//        try
//        {
//            while ((line = reader.readLine()) != null)
//            {
//                sb.append(line + "\n");
//            }
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                is.close();
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(sb.toString());
        MessageFactory messageFactory = MessageFactory.newInstance();
        InputStream inStream = request.getInputStream();
        SOAPMessage soapMessage = messageFactory.createMessage(new MimeHeaders(), inStream);
//        PrintWriter writer = response.getWriter();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        soapMessage.writeTo(out);
        String strMsg = new String(out.toByteArray());
        System.out.println(strMsg);
        System.out.println("========================");
//        writer.println(strMsg);

        return "hello";

    }
}

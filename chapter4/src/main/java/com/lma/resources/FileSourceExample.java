package com.lma.resources;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileSourceExample {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Project\\Java\\IDEA\\Spring4\\chapter4\\src\\main\\resources\\1.txt";

        WritableResource resource1 = new PathResource(filePath);

        Resource resource2 = new ClassPathResource("1.txt");

        OutputStream stream1 = resource1.getOutputStream();
        stream1.write("欢迎光临".getBytes());
        stream1.close();

        InputStream inputStream1 = resource1.getInputStream();
        InputStream inputStream2 = resource2.getInputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i;
        while ((i = inputStream1.read()) != -1) {
            baos.write(i);
        }

        System.out.println(baos.toString());
        System.out.println(resource1.getFilename());
        System.out.println(resource2.getFilename());
    }

}

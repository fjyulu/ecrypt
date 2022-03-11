package org.vin.encrypt;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Explore {


    static String source;
    static String dest;


    @BeforeClass
    public static void setup() {
        source = "/Users/fjyulu/Documents/_202112082248046597f.gif";
        dest = "/Users/fjyulu/Desktop/check/ret.gif";
    }




    @Test
    public void byteCopyt() throws IOException {

        FileInputStream reader = new FileInputStream(source);

        FileOutputStream writer = new FileOutputStream(dest);

        byte[] b = new byte[1024];

        while ((reader.read(b)) != -1) {
            for (int i = 0; i < b.length; i++) {
                byte value = b[i];
//                System.out.println(value);
//                System.out.println(Byte.toUnsignedInt(value));
//                System.out.println("----------------------------------------------------------------");

               if (value < 0) {
                   value += 256;
               }
               writer.write(value);
            }
        }
        reader.close();
        writer.close();

    }


    @Test
    public void isPicHasUppercase() throws IOException {


        FileInputStream file = new FileInputStream(source);

        BufferedWriter writer = Files.newBufferedWriter(Paths.get("/Users/Desktop/check/ret.gif"),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE_NEW);

        byte[] b = new byte[1024];


        BufferedReader reader = Files.newBufferedReader(Paths.get(source));


//        while ((file.read(b)) != -1) {
//            for (int i = 0; i < b.length; i++) {
//                System.out.println(b[i]);
//                System.out.println(Byte.toUnsignedInt(b[i]));
//                System.out.println("----------------------------------------------------------------");
//                writer.wri
//            }
//
//        }


    }

}

package org.vin.encrypt;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DictExplore {

    @Test
    public void run() throws IOException {

        List<String> collect = Stream.of("a", "b", "c").distinct().collect(Collectors.toList());

        byte[] bytes = Files.readAllBytes(Paths.get("/Users/fjyulu/Documents/_202112082248046597f.gif"));


        Map<Byte, Integer> map = new HashMap<>(2 << 16);

        for (int i = 0; i < bytes.length; i++) {

            Byte key = bytes[i];


            map.compute(key, (k, v) -> {

                if (v == null) {
                    v = 1;
                }
                return v + 1;
            });
        }

        System.out.println(map);

        Set<Byte> characters = map.keySet();
        Optional<Byte> max = characters.stream().max((a, b) -> a - b);

        Byte character = max.get();


        List<byte[]> bytes1 = Arrays.asList(bytes);





    }
}

package org.vin.encrypt.generator;

import org.apache.commons.cli.ParseException;
import org.vin.encrypt.GenerateMappingParamBean;
import org.vin.encrypt.bean.DictMapper;
import org.vin.encrypt.util.CommandLineUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;

public class DictGenerator {

    private static final ArrayList<Character> DICT_MAPPING = null;


    private static Collector<Integer, LinkedList<DictMapper<Integer, Integer>>, LinkedList<DictMapper<Integer, Integer>>> getCollector() {

        final BiConsumer<LinkedList<DictMapper<Integer, Integer>>, Integer> consumer = (result, element) -> {

            DictMapper<Integer, Integer> pop = result.poll();

            if (Objects.nonNull(pop)) {

                if (pop.t == Integer.MIN_VALUE) {
                    pop.t = element;
                    result.push(pop);

                } else if (pop.u == Integer.MIN_VALUE) {
                    pop.u = element;
                    result.push(pop);

                } else {
                    result.push(pop);
                    result.push(new DictMapper<>(element, Integer.MIN_VALUE));
                }
            } else {
                result.push(new DictMapper<>(element, Integer.MIN_VALUE));
            }
        };

        final BinaryOperator<LinkedList<DictMapper<Integer, Integer>>> operator = (r1, r2) -> {

            while (!r2.isEmpty()) {
                r1.addLast(r2.getLast());
            }
            return r1;
        };

        return Collector.of(
                LinkedList::new,
                consumer,
                operator
        );

    }


    private static LinkedList<DictMapper<Integer, Integer>> getMappingDict(int limit) {

        limit = limit << 2;
        limit = limit >> 2;

        return new Random().ints(0, 256)
                .limit(limit)
                .boxed()
                .collect(getCollector());

    }

    private static void writeToLocal(String path, int[] ints) throws IOException {

        BufferedWriter writer = Files.newBufferedWriter(Paths.get(path), StandardOpenOption.TRUNCATE_EXISTING);

        for (int i = 0; i < ints.length; i++) {
            int value = ints[i];

            writer.write(i + "," + value);
            writer.newLine();

        }
        writer.close();
    }

    private static int[] disruptMapping(LinkedList<DictMapper<Integer, Integer>> list) {

        int[] ints = new int[256];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }

        while (!list.isEmpty() && !Thread.currentThread().isInterrupted()) {

            Optional.ofNullable(list.poll())
                    .map(t -> {
                        exchange(ints, t.t, t.u);
                        return 1;
                    })
                    .get();
        }
        return ints;
    }

    private static void exchange(int[] ints, int from, int to) {
//        if (from < 0 || from >= (len = ints.length) || to < 0 || to > len) {
//            throw new IllegalArgumentException("out of bun")
//        }
        int tmp = ints[from];
        ints[from] = ints[to];
        ints[to] = ints[from];
    }

//    -l 1 -i /Users/fjyulu/Documents/_202112082248046597f.gif -o /Users/fjyulu/Desktop/check/dd -h

    public static void main(String[] args) throws ParseException, IOException {

        GenerateMappingParamBean bean = CommandLineUtils.getArgumentsFromCommandLineForGenerator(args);

        LinkedList<DictMapper<Integer, Integer>> dict = getMappingDict(bean.getLevel());

        int[] dictionary = disruptMapping(dict);

        writeToLocal(bean.getOutput(), dictionary);

    }

}

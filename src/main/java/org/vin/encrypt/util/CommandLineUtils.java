package org.vin.encrypt.util;

import org.apache.commons.cli.*;
import org.vin.encrypt.GenerateMappingParamBean;

import java.util.Optional;

import static org.vin.encrypt.common.Constant.*;

public class CommandLineUtils {

    private static Options getGenerateOptions() {

        Options options = new Options();
        options.addOption(OUTPUT_OPTION.build()).addOption(LEVEL_OPTION.build());
        return options;
    }


    private static Options getEncryptOptions() {

        Options options = new Options();

        options.addOption(LEVEL_OPTION.build());
        options.addOption(INPUT_OPTION.build());
        options.addOption(OUTPUT_OPTION.build());
        options.addOption(CONFIG_OPTION.build());
        options.addOption(HELP_OPTION.build());

        return options;
    }

    public static CommandLine parseMainWork(String[] args) throws ParseException {


        final CommandLineParser parser = new DefaultParser();

        final HelpFormatter hf = new HelpFormatter();
        hf.setWidth(110);

        CommandLine cmd = parser.parse(getEncryptOptions(), args, true);

        if (cmd.hasOption('h') || cmd.hasOption("help")) {
            hf.printHelp("encrypt", getEncryptOptions(), true);
            System.exit(-1);
        }

        return cmd;
    }


    public static GenerateMappingParamBean getArgumentsFromCommandLineForGenerator(String[] args) throws ParseException {

        CommandLine parse = new DefaultParser().parse(getGenerateOptions(), args, true);

        return GenerateMappingParamBean.build()
                .setLevel(
                        Optional.ofNullable(parse.getOptionValue(LEVEL_OPTION.build()))
                                .map(Integer::parseInt)
                                .orElse(100)
                )
                .setOutput(Optional.ofNullable(parse.getOptionValue(OUTPUT_OPTION.build()))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .orElseThrow(() -> new IllegalArgumentException("Output path must exists"))
                )
                .build();
    }
}





















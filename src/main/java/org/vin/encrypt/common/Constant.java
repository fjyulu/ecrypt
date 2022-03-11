package org.vin.encrypt.common;

import org.apache.commons.cli.Option;

public class Constant {


    public static final String LEVEL_SHORT = "l";
    public static final String LEVEL = "level";
    public static final String INPUT_SHORT = "i";
    public static final String INPUT = "input";
    public static final String OUTPUT_SHORT = "o";
    public static final String OUTPUT = "output";

    public static final String CONFIG_SHORT = "c";
    public static final String CONFIG = "config";
    public static final String HELP_SHORT = "h";
    public static final String HELP = "help";


    public static final Option.Builder LEVEL_OPTION = Option.builder(LEVEL_SHORT)
            .hasArg()
            .longOpt(LEVEL)
            .required()
            .desc("random level for mapping dictionary");

    public static final Option.Builder OUTPUT_OPTION = Option.builder(OUTPUT_SHORT)
            .hasArg()
            .longOpt(OUTPUT)
            .required()
            .desc("location for saving the mapping dictionary");

    public static final Option.Builder HELP_OPTION = Option.builder(HELP_SHORT)
            .hasArg(false)
            .longOpt(HELP)
            .required(false)
            .desc("Print the help information");

    public static final Option.Builder INPUT_OPTION = Option.builder(INPUT_SHORT)
            .hasArg()
            .longOpt(INPUT)
            .required()
            .desc("The input file that need to encrypt need the absolute path");

    public static final Option.Builder CONFIG_OPTION = Option.builder(CONFIG_SHORT)
            .hasArg()
            .longOpt(CONFIG)
            .required()
            .desc("The output file name where to save the encrypt file to");

}

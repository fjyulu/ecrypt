package org.vin.encrypt.bean;

public class EncryptParamBean {


    private String input;

    private String output;

    private String config;

    private String level;

    public EncryptParamBean(String input, String output, String config, String level) {
        this.input = input;
        this.output = output;
        this.config = config;
        this.level = level;
    }

    public EncryptParamBean() {
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public static Builder builder() {

        return new Builder();
    }


    public static final class Builder {


        private String input;

        private String output;

        private String config;

        private String level;

        public EncryptParamBean build() {

            return new EncryptParamBean(this.input, this.output, this.config, this.level);
        }


        public Builder setInput(String input) {
            this.input = input;
            return this;
        }

        public Builder setOutput(String output) {
            this.output = output;
            return this;
        }

        public Builder setConfig(String config) {
            this.config = config;
            return this;
        }

        public Builder setLevel(String level) {
            this.level = level;
            return this;
        }
    }
}

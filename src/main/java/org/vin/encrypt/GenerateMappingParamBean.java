package org.vin.encrypt;

public class GenerateMappingParamBean {


    private int level;

    private String output;

    public GenerateMappingParamBean() {
    }

    public GenerateMappingParamBean(int level, String output) {
        this.level = level;
        this.output = output;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public static Builder build() {
        return new Builder();
    }


    public static class Builder {

        private int level;

        private String output;


        public GenerateMappingParamBean build() {
            return new GenerateMappingParamBean(this.level, this.output);
        }

        public Builder setLevel(int level) {
            this.level = level;
            return this;
        }

        public Builder setOutput(String output) {
            this.output = output;
            return this;
        }
    }
}

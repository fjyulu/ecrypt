package org.vin.encrypt.bean;

import java.util.Random;

public class Article {

    private int value;

    public Article(int value) {
        this.value = value;
    }



    public int getWordCount() {
        return this.value;
    }
}

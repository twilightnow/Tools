package com.tools.japaneselearning.controller;


public class Kana {
    private String hiragana;
    private String katakana;
    private String romaji;

    public Kana(String hiragana, String katakana, String romaji) {
        this.hiragana = hiragana;
        this.katakana = katakana;
        this.romaji = romaji;
    }

    // Getters
    public String getHiragana() {
        return hiragana;
    }

    public String getKatakana() {
        return katakana;
    }

    public String getRomaji() {
        return romaji;
    }

    // Setters - 如果您需要更改属性值，可以添加 Setters
    // ...
}
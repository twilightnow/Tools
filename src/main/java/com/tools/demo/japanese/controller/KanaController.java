package com.tools.demo.japanese.controller;


public class KanaController {
    private String hiragana;
    private String katakana;
    private String romaji;

    public KanaController(String hiragana, String katakana, String romaji) {
        this.hiragana = hiragana;
        this.katakana = katakana;
        this.romaji = romaji;
    }
    // 暂未用到本文件
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
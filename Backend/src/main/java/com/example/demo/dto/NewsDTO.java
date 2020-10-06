package com.example.demo.dto;

import com.sun.istack.NotNull;

import java.time.LocalDate;

public class NewsDTO {

    @NotNull
    private String caption;

    @NotNull
    private  String text;

    private LocalDate date;

    @NotNull
    private Integer userId;

    public NewsDTO(String caption, String text, LocalDate date, Integer userId) {
        this.caption = caption;
        this.text = text;
        this.date = date;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

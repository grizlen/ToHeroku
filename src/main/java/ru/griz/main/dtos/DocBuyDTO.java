package ru.griz.main.dtos;

import ru.griz.main.entities.BuyItem;

import java.util.ArrayList;
import java.util.List;

public class DocBuyDTO {
    private Long id;
    private String date;
    private List<BuyItem> items = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public List<BuyItem> getItems() {
        return items;
    }

    public void setItems(List<BuyItem> items) {
        this.items = items;
    }
}

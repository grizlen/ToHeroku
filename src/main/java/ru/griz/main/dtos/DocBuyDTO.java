package ru.griz.main.dtos;

import ru.griz.main.entities.BuyItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocBuyDTO {
    private Long id;
    private Date date;
    private List<BuyItem> items = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public List<BuyItem> getItems() {
        return items;
    }

    public void setItems(List<BuyItem> items) {
        this.items = items;
    }
}

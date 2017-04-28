package com.russellmeili.caasera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Group_heading {

    private String name;
    private ArrayList<Child_row> productList = new ArrayList<Child_row>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Child_row> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Child_row> productList) {
        this.productList = productList;
    }
}

package com.ovais.tshirtsproject.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.ovais.tshirtsproject.utils.Constants.TABLE_NAME;

//entity
@Entity(tableName = TABLE_NAME)
//model class
public class Shirt {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private int id;

    @ColumnInfo(name = "available")
    @SerializedName("available")
    @Expose
    private String available;

    @ColumnInfo(name = "description")
    @SerializedName("description")
    @Expose
    private String description;

    @ColumnInfo(name = "pName")
    @SerializedName("pName")
    @Expose
    private String pName;

    @ColumnInfo(name = "picture")
    @SerializedName("picture")
    @Expose
    private String picture;

    @ColumnInfo(name = "price")
    @SerializedName("price")
    @Expose
    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}


package com.ovais.tshirtsproject.utils;


import static com.ovais.tshirtsproject.utils.Constants.TABLE_NAME;

public class Queries {
    //select all from table query
    public static final String selectAllData = "SELECT * FROM " + TABLE_NAME;
    //delete from table query
    public static final String deleteAllData = "DELETE FROM " + TABLE_NAME;
}

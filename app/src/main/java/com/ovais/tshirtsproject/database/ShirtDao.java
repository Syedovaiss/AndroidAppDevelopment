package com.ovais.tshirtsproject.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ovais.tshirtsproject.model.Shirt;

import java.util.List;

import static com.ovais.tshirtsproject.utils.Queries.deleteAllData;
import static com.ovais.tshirtsproject.utils.Queries.selectAllData;

// method that access database
@Dao
public interface ShirtDao {

    //Insert method--- on conflict pe replace kardega item
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertData(List<Shirt> shirts);

    //select all data
    @Query(selectAllData)
    LiveData<List<Shirt>> selectAllShirt();

    //deleting all data
    @Query(deleteAllData)
    void deleteShirts();

}

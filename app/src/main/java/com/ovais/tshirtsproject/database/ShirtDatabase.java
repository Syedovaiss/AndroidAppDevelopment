package com.ovais.tshirtsproject.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ovais.tshirtsproject.model.Shirt;

import static com.ovais.tshirtsproject.utils.Constants.DATABASE_NAME;

@Database(entities = {Shirt.class}, version = 1, exportSchema = false)
public abstract class ShirtDatabase extends RoomDatabase {


    public abstract ShirtDao shirtDao();

    private static volatile ShirtDatabase INSTANCE;

    //creating an instance
    //best practice is to make it singleton
    public static ShirtDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (ShirtDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                            , ShirtDatabase.class
                            , DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

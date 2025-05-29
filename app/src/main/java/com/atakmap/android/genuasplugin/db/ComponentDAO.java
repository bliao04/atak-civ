package com.atakmap.android.genuasplugin.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ComponentDAO {
    @Insert
    void insert(ComponentEntity component);

    @Update
    void update(ComponentEntity component);

    @Delete
    void delete(ComponentEntity componentEntity);

    @Query("SELECT * FROM components")
    LiveData<List<ComponentEntity>> getComponentList();
}

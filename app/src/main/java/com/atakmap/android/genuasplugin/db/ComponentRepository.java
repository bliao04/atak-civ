package com.atakmap.android.genuasplugin.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ComponentRepository {
    private final ComponentDAO dao;
    private final LiveData<List<ComponentEntity>> allComps;

    public ComponentRepository(Application application) {
        ComponentDatabase db = ComponentDatabase.getDatabase(application);
        dao = db.Dao();
        allComps = dao.getComponentList();
    }

    public void insert(ComponentEntity component) {
        ComponentDatabase.databaseWriteExecutor.execute(()-> {
            dao.insert(component);
        });
    }

    public void update(ComponentEntity component) {
        ComponentDatabase.databaseWriteExecutor.execute(() -> {
            dao.update(component);
        });
    }

    public void delete(ComponentEntity component) {
        ComponentDatabase.databaseWriteExecutor.execute(()-> {
            dao.delete(component);
        });
    }

    LiveData<List<ComponentEntity>> getAllComps() {
        return allComps;
    }
}

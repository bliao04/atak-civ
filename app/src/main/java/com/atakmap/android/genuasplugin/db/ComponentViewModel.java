package com.atakmap.android.genuasplugin.db;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ComponentViewModel extends AndroidViewModel {
    private final ComponentRepository repo;
    private final LiveData<List<ComponentEntity>> allComps;

    public ComponentViewModel(@NonNull Application application) {
        super(application);
        repo = new ComponentRepository(application);
        allComps = repo.getAllComps();
    }

    public LiveData<List<ComponentEntity>> getAllComps() { return allComps; }

    public void insert(ComponentEntity component) {
        repo.insert(component);
    }

    public void update(ComponentEntity component) {
        repo.update(component);
    }

    public void delete(ComponentEntity component) {
        repo.delete(component);
    }
}

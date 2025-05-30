
package com.atakmap.android.genuasplugin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atak.plugins.impl.PluginLayoutInflater;
import com.atakmap.android.genuasplugin.adapters.Component;
import com.atakmap.android.genuasplugin.adapters.ComponentAdapter;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.genuasplugin.plugin.R;
import com.atakmap.android.dropdown.DropDown.OnStateListener;

import com.atakmap.coremap.log.Log;

import java.util.ArrayList;
import java.util.List;

public class DropDownReceiver extends com.atakmap.android.dropdown.DropDownReceiver implements OnStateListener {

    public static final String TAG = DropDownReceiver.class.getSimpleName();
    public static final String SHOW_PLUGIN = "com.atakmap.android.genuasplugin.SHOW_PLUGIN";

    private final View mainView;
    private final Context pluginContext;

    /**************************** CONSTRUCTOR *****************************/

    public DropDownReceiver(MapView mapView, final Context context) {
        super(mapView);
        this.pluginContext = context;
        mainView = PluginLayoutInflater.inflate(context, R.layout.main_layout, null);

        RecyclerView cList = mainView.findViewById(R.id.compLIST);
        List<Component> componentList = new ArrayList<>();
        componentList.add(new Component("T3st", "Test", 0.0, 0.0));
        cList.setLayoutManager(new LinearLayoutManager(getMapView().getContext()));
        ComponentAdapter cadapter = new ComponentAdapter(componentList);
        cList.setAdapter(cadapter);

        Button addCompBTN = mainView.findViewById(R.id.addComponentBTN);
        addCompBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Add component clicked");
                Intent intent = new Intent();
                intent.setAction(AddComponentDropDown.SHOW_AC_WINDOW);
                AtakBroadcast.getInstance().sendBroadcast(intent);
                //getMapView().getContext().startActivity(intent);
            }
        });
    }

    /**************************** PUBLIC METHODS *****************************/

    @Override
    public void disposeImpl() {
    }

    /**************************** INHERITED METHODS *****************************/

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (action == null)
            return;

        if (action.equals(SHOW_PLUGIN)) {

            Log.d(TAG, "showing plugin drop down");
            showDropDown(mainView, HALF_WIDTH, FULL_HEIGHT, FULL_WIDTH,
                    HALF_HEIGHT, false, this);
        }
    }

    @Override
    public void onDropDownSelectionRemoved() {
    }

    @Override
    public void onDropDownVisible(boolean v) {
    }

    @Override
    public void onDropDownSizeChanged(double width, double height) {
    }

    @Override
    public void onDropDownClose() {
    }

}

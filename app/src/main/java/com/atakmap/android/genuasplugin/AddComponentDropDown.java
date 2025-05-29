package com.atakmap.android.genuasplugin;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.atak.plugins.impl.PluginLayoutInflater;
import com.atakmap.android.dropdown.DropDown.OnStateListener;
import com.atakmap.android.genuasplugin.plugin.R;
import com.atakmap.android.maps.MapView;
import com.atakmap.coremap.log.Log;

public class AddComponentDropDown extends com.atakmap.android.dropdown.DropDownReceiver implements OnStateListener {
    public static final String TAG = AddComponentDropDown.class.getSimpleName();
    public static final String SHOW_AC_WINDOW = "com.atakmap.android.genuasplugin.SHOW_AC_WINDOW";

    private final View acView;
    private final Context pluginContext;

    public AddComponentDropDown(MapView mapView, final Context context) {
        super(mapView);
        pluginContext = context;
        acView = PluginLayoutInflater.inflate(pluginContext, R.layout.ac_layout , null);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Reached receive");
        final String action = intent.getAction();

        if (action == null)
            return;

        if (action.equals(SHOW_AC_WINDOW)) {
            Log.d(TAG, "showing plugin drop down");
            showDropDown(acView, HALF_WIDTH, FULL_HEIGHT, FULL_WIDTH,
                    HALF_HEIGHT, false, this);
        }
    }

    @Override
    public void onDropDownSelectionRemoved() {}

    @Override
    public void onDropDownVisible(boolean v) {}

    @Override
    public void onDropDownSizeChanged(double width, double height) {}

    @Override
    public void onDropDownClose() {}

    @Override
    public void disposeImpl() {}
}


package com.atakmap.android.genuasplugin;

import android.content.Context;
import android.content.Intent;
import com.atakmap.android.ipc.AtakBroadcast.DocumentedIntentFilter;

import com.atakmap.android.maps.MapView;
import com.atakmap.android.dropdown.DropDownMapComponent;

import com.atakmap.coremap.log.Log;
import com.atakmap.android.genuasplugin.plugin.R;

public class MapComponent extends DropDownMapComponent {

    private static final String TAG = "PluginTemplateMapComponent";

    private Context pluginContext;

    private DropDownReceiver ddr;

    private AddComponentDropDown acdd;

    public void onCreate(final Context context, Intent intent, final MapView view) {

        context.setTheme(R.style.ATAKPluginTheme);
        super.onCreate(context, intent, view);
        pluginContext = context;

        ddr = new DropDownReceiver(view, context);
        Log.d(TAG, "registering the plugin filter for main window");
        DocumentedIntentFilter ddFilter = new DocumentedIntentFilter();
        ddFilter.addAction(DropDownReceiver.SHOW_PLUGIN);
        registerDropDownReceiver(ddr, ddFilter);

        acdd = new AddComponentDropDown(view, context);
        Log.d(TAG, "registering the plugin filter for add window");
        DocumentedIntentFilter acddFilter = new DocumentedIntentFilter();
        acddFilter.addAction(AddComponentDropDown.SHOW_AC_WINDOW);
        registerDropDownReceiver(acdd, acddFilter);

    }

    @Override
    protected void onDestroyImpl(Context context, MapView view) {
        super.onDestroyImpl(context, view);
    }

}

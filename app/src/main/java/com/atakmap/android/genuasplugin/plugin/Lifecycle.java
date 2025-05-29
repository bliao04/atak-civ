
package com.atakmap.android.genuasplugin.plugin;


import com.atak.plugins.impl.AbstractPluginLifecycle;
import com.atakmap.android.genuasplugin.MapComponent;
import android.content.Context;


/**
 * Please note:
 *     Support for versions prior to 4.5.1 can make use of a copy of AbstractPluginLifeCycle shipped with
 *     the plugin.
 */
public class Lifecycle extends AbstractPluginLifecycle {

    private final static String TAG = "PluginTemplateLifecycle";

    public Lifecycle(Context ctx) {
        super(ctx, new MapComponent());
        PluginNativeLoader.init(ctx);
    }

}

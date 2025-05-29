
package com.atakmap.android.genuasplugin.plugin;

import com.atak.plugins.impl.AbstractPluginTool;
import com.atakmap.android.genuasplugin.DropDownReceiver;

import android.content.Context;

/**
 * Please note:
 *     Support for versions prior to 4.5.1 can make use of a copy of AbstractPluginTool shipped with
 *     the plugin.
 */
public class GenUASTool extends AbstractPluginTool {

    private final Context context;

    public GenUASTool(Context context) {
        super(context,
                context.getString(R.string.app_name),
                context.getString(R.string.app_name),
                context.getResources().getDrawable(R.drawable.ic_launcher),
                DropDownReceiver.SHOW_PLUGIN);
        this.context = context;
    }

    public String getDesc() {
        return context.getString(R.string.app_desc);
    }

}

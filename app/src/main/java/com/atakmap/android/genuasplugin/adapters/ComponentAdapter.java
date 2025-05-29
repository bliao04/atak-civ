package com.atakmap.android.genuasplugin.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atakmap.android.genuasplugin.plugin.R;

import java.util.List;

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.ComponentViewHolder> {

    private List<Component> componentList;

    public ComponentAdapter(List<Component> componentList) {
        this.componentList = componentList;
    }

    @NonNull
    @Override
    public ComponentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.component_card, parent, false);
        return new ComponentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComponentViewHolder holder, int position) {
        Component component = componentList.get(position);

        holder.callSign.setText(component.getCallSign());
        holder.type.setText(component.getType());
        holder.longitude.setText(String.valueOf(component.getLongitude()));
        holder.latitude.setText(String.valueOf(component.getLatitude()));
    }

    @Override
    public int getItemCount() {
        return componentList.size();
    }

    static class ComponentViewHolder extends RecyclerView.ViewHolder {
        TextView callSign, type, longitude, latitude;

        public ComponentViewHolder(@NonNull View compView) {
            super(compView);
            callSign = compView.findViewById(R.id.callSign);
            type = compView.findViewById(R.id.type);
            longitude = compView.findViewById(R.id.longitude);
            latitude = compView.findViewById(R.id.latitude);
        }
    }
}

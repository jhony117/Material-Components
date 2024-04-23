package com.example.mdcomponents.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mdcomponents.R;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.OnClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComponentAdapter extends RecyclerView.Adapter<Component.ViewHolder>{



    private List<Component> mComponents;
    private OnClickListener mListener;

    public ComponentAdapter(List<Component> mComponents, OnClickListener mListener) {
        this.mComponents = mComponents;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_component, parent,
                false);
        return new ViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull Component.ViewHolder holder, int position) {
        Component component = mComponents.get(position);

        holder.setClickListener(mListener, component);

        holder.tvName.setText(component.getName());
        holder.imgPhoto.setImageResource(component.getPhotoRes());

    }

    @Override
    public int getItemCount() {
        return mComponents.size();
    }

    public void add(Component component){
        if (!mComponents.contains(component)){
            mComponents.add(component);
            notifyItemInserted(mComponents.size() - 1);
        }
    }

    class VirewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imgPhoto)
        AppCompatImageView imgPhoto;
        @BindView(R.id.tvName)
        TextView txName;

        View view;


        public VirewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind
        }

        void setClickListener(OnClickListener listener, Component component){
            view.setOnClickListener(view1 -> listener.onClick(component));
        }
    }

    }


package maufdh.dev.gradetracking.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import maufdh.dev.gradetracking.Application.MyApplication;
import maufdh.dev.gradetracking.R;

public class Afotos extends RecyclerView.Adapter<Afotos.ViewHolder> {
    List<Integer> sources;
    int layout;
    OnItemLongClickListener longClickListener;
    itemClickListener itemClickListener;
    Context context;
    public Afotos(List<Integer> sources, int layout, OnItemLongClickListener longClickListener, Afotos.itemClickListener itemClickListener) {
        this.sources = sources;
        this.layout = layout;
        this.longClickListener = longClickListener;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh= new ViewHolder(v);
        context=parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(sources.get(position),longClickListener);
        holder.bindClick(sources.get(position),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return sources.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        CheckBox check;
        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.cardfotos_img);
            check=(CheckBox)itemView.findViewById(R.id.cardfotos_check);
        }
        public void bind(final int source, final OnItemLongClickListener longClickListener){
            Picasso.with(context).load(source).into(image);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    longClickListener.onItemLongClick(source,getAdapterPosition());
                    return false;
                }
            });

        }
        public void bindClick(final int source, final itemClickListener itemClickListener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int s=source;
                    if(MyApplication.flagToDrawable){
                        if(check.isChecked()){
                            check.setChecked(false);
                            s=R.drawable.lit1;
                            check.setVisibility(View.INVISIBLE);
                            MyApplication.flagToDrawable=false;
                        }
                    }else{
                        if(!check.isChecked()){
                            check.setChecked(true);
                            check.setVisibility(View.VISIBLE);
                            MyApplication.flagToDrawable=true;}
                    }
                    itemClickListener.OnItemClick(s,getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemLongClickListener{
        void onItemLongClick(int source,int position);
    }
    public interface  itemClickListener{
        void OnItemClick(int source,int position);
    }
}

package maufdh.dev.gradetracking.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;
import maufdh.dev.gradetracking.Models.MMateria;
import maufdh.dev.gradetracking.R;
import maufdh.dev.gradetracking.Utilities.UtilsMethods;

public class AMaterias extends RecyclerView.Adapter<AMaterias.ViewHolder> {
    List<MMateria> materias;
    private int layout;
    OnItemClickListener itemClickListener;
    Context context;

    public AMaterias(List<MMateria> materias, int layout, OnItemClickListener itemClickListener) {
        this.materias = materias;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh=new ViewHolder(v);
        context=parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(materias.get(position),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return materias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView tvName;
        public Button btn;

        public ViewHolder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.imgv_cardMaterias);
            tvName=(TextView)itemView.findViewById(R.id.tvname_cardMaterias);
            btn=(Button)itemView.findViewById(R.id.btnver_cardMaterias);
        }
        public void bind(final MMateria materia,final OnItemClickListener listener){
            tvName.setText(materia.getName());
            UtilsMethods.setCardImage(img,materia.getIdportada(),context);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Click ver :D", Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(materia,getAdapterPosition());
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(MMateria materia, int position);
    }
}

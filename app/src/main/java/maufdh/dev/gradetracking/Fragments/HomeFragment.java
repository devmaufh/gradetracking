package maufdh.dev.gradetracking.Fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import maufdh.dev.gradetracking.Adapters.AMaterias;
import maufdh.dev.gradetracking.Models.MMateria;
import maufdh.dev.gradetracking.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    Realm realm;
    public RecyclerView rv;
    public RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    private RealmResults<MMateria> materias;
    private FloatingActionButton btnAdd;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_home, container, false);
        bindUI(v);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewMat();
            }
        });
        return v;
    }
    private void bindUI(View view){
        realm=Realm.getDefaultInstance();
        materias=realm.where(MMateria.class).findAll();
        rv=(RecyclerView) view.findViewById(R.id.home_rv);
        btnAdd=(FloatingActionButton)view.findViewById(R.id.home_fab);
        setMateriasOnRecycler(view);
    }
    private void setMateriasOnRecycler(final View v){
        mLayoutManager= new LinearLayoutManager(v.getContext());
        mAdapter= new AMaterias(materias, R.layout.cardview_maetrias, new AMaterias.OnItemClickListener() {
            @Override
            public void onItemClick(MMateria materia, int position) {
                Toast.makeText(v.getContext(), "ID: "+materia.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(mAdapter);

    }

    private void createNewMat(){
        realm.beginTransaction();
        MMateria materia= new MMateria("Matemáticas aplicadas","Jorge Lopez","Cuarto",10,10,10,10,10);
        realm.copyToRealm(materia);
        realm.commitTransaction();
        refreshRecycler();
    }
    private void refreshRecycler(){
        materias=realm.where(MMateria.class).findAll();
        mAdapter.notifyDataSetChanged();

    }
}

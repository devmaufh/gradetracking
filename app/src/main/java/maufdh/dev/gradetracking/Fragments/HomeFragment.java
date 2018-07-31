package maufdh.dev.gradetracking.Fragments;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import maufdh.dev.gradetracking.Activities.AddM;
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
                startActivity(new Intent(getContext(), AddM.class));
            }
        });
        return v;
    }
    private void bindUI(View view){
        realm=Realm.getDefaultInstance();
        asyncRealmData();
        rv=(RecyclerView) view.findViewById(R.id.home_rv);
        btnAdd=(FloatingActionButton)view.findViewById(R.id.home_fab);
        setMateriasOnRecycler(view);
    }
    private void setMateriasOnRecycler(final View v){
        mLayoutManager= new LinearLayoutManager(v.getContext());
        mAdapter= new AMaterias(materias, R.layout.cardview_maetrias, new AMaterias.OnItemClickListener() {
            @Override
            public void onItemClick(MMateria materia, int position) {
                deleteById(materia.getId());
            }
        });
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(mAdapter);

    }
    int counter=0;
    private void createNewMat(){
        realm.beginTransaction();
        MMateria materia= new MMateria("Matemáticas aplicadas"+(++counter),"Jorge Lopez","Cuarto",10,10,10,10,10);
        realm.copyToRealm(materia);
        realm.commitTransaction();
        refreshRecycler();
    }
    private void refreshRecycler(){
        asyncRealmData();
        mAdapter.notifyDataSetChanged();
        mLayoutManager.scrollToPosition(0);
    }
    private void asyncRealmData() {
        realm.executeTransaction(new Realm.Transaction() {

            @Override
            public void execute(Realm realm) {
                materias = realm.where(MMateria.class).sort("id").findAll();
            }
        });
    }
    private void deleteById(final int id){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //RealmResults<MMateria> rows=realm.where(MMateria.class).equalTo("id",id).findAll();
                //rows.deleteAllFromRealm();
                realm.where(MMateria.class).equalTo("id",id).findAll().deleteAllFromRealm();
            }
        });
        refreshRecycler();
    }
}

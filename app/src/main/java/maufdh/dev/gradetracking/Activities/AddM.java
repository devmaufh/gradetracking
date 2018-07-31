package maufdh.dev.gradetracking.Activities;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.realm.Realm;
import maufdh.dev.gradetracking.Adapters.Afotos;
import maufdh.dev.gradetracking.Application.MyApplication;
import maufdh.dev.gradetracking.R;

public class AddM extends AppCompatActivity {
    Realm realm;
    private RecyclerView rv;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_m);
        bindUI();
    }
    private void bindUI(){
        realm=Realm.getDefaultInstance();
        rv=(RecyclerView)findViewById(R.id.addm_rv);
        setSourceOnRecycler();
    }
    private void setSourceOnRecycler(){
        mLayoutManager= new GridLayoutManager(this,3);
        Log.w("test sources()", "Input      :"+Arrays.toString(sources().toArray()));
        mAdapter= new Afotos(sources(), R.layout.card_fotos, new Afotos.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(int source, int position) {

            }

        }, new Afotos.itemClickListener() {
            @Override
            public void OnItemClick(int source, int position) {
            }
        });
        rv.setHasFixedSize(true);
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.flagToDrawable=false;
    }

    private List<Integer> sources(){
        return new ArrayList<Integer>(){{
            add(R.drawable.chemistry1);
            add(R.drawable.chemistry2);
            add(R.drawable.chemistry3);
            add(R.drawable.d1);
            add(R.drawable.i1);
            add(R.drawable.lit1);
            add(R.drawable.math1);
            add(R.drawable.math2);
            add(R.drawable.math3);
            add(R.drawable.p1);
            add(R.drawable.p2);
            add(R.drawable.p3);
            add(R.drawable.physical1);
            add(R.drawable.physical2);
        }};
    }
}

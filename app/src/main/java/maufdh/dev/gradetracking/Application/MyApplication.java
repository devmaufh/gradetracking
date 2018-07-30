package maufdh.dev.gradetracking.Application;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import maufdh.dev.gradetracking.Models.MDetails;
import maufdh.dev.gradetracking.Models.MMateria;

public class MyApplication extends Application {
    public static AtomicInteger idDetail= new AtomicInteger();
    public static AtomicInteger idMateria= new AtomicInteger();

    @Override
    public void onCreate() {
        setUpRealmConfig();
        super.onCreate();
        Realm realm= Realm.getDefaultInstance();
        idDetail=getIdByTable(realm,MDetails.class);
        idMateria=getIdByTable(realm,MMateria.class);
        Log.w(" -   -   -IDENTIFICADOR", "id: "+idMateria);

        realm.close();
    }
    private void setUpRealmConfig(){
        Realm.init(getApplicationContext());
        RealmConfiguration configuration= new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass){
        RealmResults<T> results=realm.where(anyClass).findAll();
        return (results.size()>0)?new AtomicInteger(results.max("id").intValue()): new AtomicInteger();
    }
}

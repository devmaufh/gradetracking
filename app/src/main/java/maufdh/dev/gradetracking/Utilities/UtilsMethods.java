package maufdh.dev.gradetracking.Utilities;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import maufdh.dev.gradetracking.R;

public class UtilsMethods {
    public static void setCardImage(ImageView v, int id, Context c){
        switch (id){
            case 1:
                Picasso.with(c).load(R.drawable.chemistry1).into(v);
                break;
            case 2:
                Picasso.with(c).load(R.drawable.chemistry2).into(v);
                break;
            case 3:
                Picasso.with(c).load(R.drawable.chemistry3).into(v);
                break;
            case 4:
                Picasso.with(c).load(R.drawable.d1).into(v);
                break;
            case 5:
                Picasso.with(c).load(R.drawable.i1).into(v);
                break;
            case 6:
                Picasso.with(c).load(R.drawable.lit1).into(v);
                break;
            case 7:
                Picasso.with(c).load(R.drawable.math1).into(v);
                break;
            case 8:
                Picasso.with(c).load(R.drawable.math2).into(v);
                break;
            case 9:
                Picasso.with(c).load(R.drawable.math3).into(v);
                break;
            case 10:
                Picasso.with(c).load(R.drawable.p1).into(v);
                break;
            case 11:
                Picasso.with(c).load(R.drawable.p2).into(v);
                break;
            case 12:
                Picasso.with(c).load(R.drawable.p3).into(v);
                break;
            case 13:
                Picasso.with(c).load(R.drawable.physical1).into(v);
                break;
            case 14:
                Picasso.with(c).load(R.drawable.physical2).into(v);
                break;
             default:
                 Picasso.with(c).load(R.drawable.p1).into(v);

        }
    }
}

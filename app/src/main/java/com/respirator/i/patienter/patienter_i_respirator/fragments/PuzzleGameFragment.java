package com.respirator.i.patienter.patienter_i_respirator.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;

import com.respirator.i.patienter.patienter_i_respirator.R;

import java.util.ArrayList;


import com.respirator.i.patienter.patienter_i_respirator.R;

import java.util.ArrayList;

/*
 * A simple {@link Fragment} subclass.
 */


public class PuzzleGameFragment extends Fragment implements View.OnClickListener {

    private final int[] billeder = {R.drawable.image_part_001, R.drawable.image_part_002, R.drawable.image_part_003, R.drawable.image_part_004,
    R.drawable.image_part_005, R.drawable.image_part_006, R.drawable.image_part_007, R.drawable.image_part_008, R.drawable.image_part_009};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.puzzle_game_fragment, container, false);
       // b1 = (Button) f


    }

    @Override
    public void onClick(View view) {

    }

    class Billede {
        RectF rectF = new RectF();
        String tekst;

        Billede(String string, int x, int y) {
            tekst = string;
            rectF = new RectF(x + 2, y + 2, x + 38, y + 38);
        }
    }

    class BraetspilView extends View {
        PointF finger = new PointF();
        ArrayList<Billede> billeder = new ArrayList<>();
        Billede valgtBrik = null;
        Paint tekstStregtype = new Paint();
        Paint brikStregtype = new Paint();
        Paint brikStregtypeValgt;
        Billede b1, b2, b3, b4, b5, b6, b7, b8, b9;

        public BraetspilView(Context context) {
            super(context);
        }

        public void Puzzlespilbræt(Context context) {
            tekstStregtype.setColor(Color.WHITE);
            tekstStregtype.setTextSize(24);
            tekstStregtype.setAntiAlias(true);
            brikStregtype.setColor(Color.BLACK);
            brikStregtype.setStyle(Paint.Style.FILL);
            brikStregtype.setAntiAlias(true);
            brikStregtype.setStrokeWidth(2);
            brikStregtypeValgt = new Paint(brikStregtype);
            brikStregtypeValgt.setStyle(Paint.Style.STROKE);
            brikStregtypeValgt.setColor(Color.BLUE);
        }}}

/*
            billeder.add(new Billede(R.drawable.image_part_001, 30, 30));
            billeder.add(new Billede(R.drawable.image_part_002, 80, 80));
            billeder.add(new Billede(R.drawable.image_part_003, 140, 40));
            billeder.add(new Billede(R.drawable.image_part_004, 130, 90));
            billeder.add(new Billede(R.drawable.image_part_005, 160, 130));
            billeder.add(new Billede(R.drawable.image_part_006, 17, 120));
            billeder.add(new Billede(R.drawable.image_part_007, 170, 190));
            billeder.add(new Billede(R.drawable.image_part_008, 170, 130));
            billeder.add(new Billede(R.drawable., 170, 130));

            Billede forklaring = new Billede("Få billederne til at passe sammen :)", 40, 280);
            forklaring.rectF.right += 280;
            billeder.add(forklaring);


        }
    }}
    */
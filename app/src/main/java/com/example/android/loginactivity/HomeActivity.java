package com.example.android.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    ImageView left, right, middle;
    List<Integer> cards;
    Button newgame;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setTitle("");

        left = (ImageView) findViewById(R.id.LeftI);
        right = (ImageView) findViewById(R.id.rightI);
        middle = (ImageView) findViewById(R.id.middleI);
        newgame = (Button) findViewById(R.id.new_game);


        cards = new ArrayList<>();
        cards.add(107);
        cards.add(307);
        cards.add(407);


        Collections.shuffle(cards);

        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(cards);

                left.setImageResource(R.drawable.back_play);
                right.setImageResource(R.drawable.back_play);
                middle.setImageResource(R.drawable.back_play);

                Animation anim_left = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left);
                Animation anim_middle = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.middle);
                Animation anim_right = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right);

                left.startAnimation(anim_left);
                middle.startAnimation(anim_middle);
                right.startAnimation(anim_right);
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assignImage();
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assignImage();

            }
        });

        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assignImage();

            }
        });

    }



    public void assignImage() {

        //left card
        if (cards.get(0) == 107) {
            left.setImageResource(R.drawable.diamonds_king);
        } else if (cards.get(0) == 307) {
            left.setImageResource(R.drawable.spades10);
        } else if (cards.get(0) == 407) {
            left.setImageResource(R.drawable.spades5);
        }


        //Middle card
        if (cards.get(1) == 107) {
            middle.setImageResource(R.drawable.diamonds_king);
        } else if (cards.get(1) == 307) {
            middle.setImageResource(R.drawable.spades10);
        } else if (cards.get(1) == 407) {
            middle.setImageResource(R.drawable.spades5);
        }

        //right card
        if (cards.get(2) == 107) {
            right.setImageResource(R.drawable.diamonds_king);
        } else if (cards.get(2) == 307) {
            right.setImageResource(R.drawable.spades10);
        } else if (cards.get(2) == 407) {
            right.setImageResource(R.drawable.spades5);
        }
    }




}

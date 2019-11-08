package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int correct_counter = 0;

    public static int Roll_the_dice() {
        Random r = new Random();
        int number = r.nextInt(7-1)+1;
        return number;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on_button_click(View view) {
        TextView tv = this.findViewById(R.id.textView);
        TextView et = this.findViewById(R.id.editText);
        TextView tv4 = this.findViewById(R.id.textView4);


        Random r = new Random();
        int number = r.nextInt(7-1)+1;//  maximum number is 6
        tv.setText(Integer.toString(number));
        String value = et.getText().toString();
        int Fnum = Integer.parseInt(value);

        if (number == Fnum) {

            tv.setText(String.valueOf(number) + " " + "Congrats !");
            tv4.setText(String.valueOf(correct_counter));
            correct_counter++;


        }
    }
    public void on_click_icebreaker(View view) {
        int Roll = Roll_the_dice();

        TextView tv = this.findViewById(R.id.textView5);
        List<String> Questions = new ArrayList<>();// Questions arraylist

        Questions.add("If you could go anywhere in the world, where would you go?"); //1
        Questions.add("If you were stranded on a desert island, what three things would you want to take with you?"); //2
        Questions.add("If you could eat only one food for the rest of your life, what would that be?"); //3
        Questions.add("If you won a million dollars, what is the first thing you would buy?"); //4
        Questions.add("If you could spaned the day with one fictional character, who would it be?"); //5
        Questions.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?"); //6

        if (Roll == 1) // Question 1
            tv.setText(Questions.get(0));

        if (Roll == 2) // Question 2
            tv.setText(Questions.get(1));

        if (Roll == 3) // Question 3
            tv.setText(Questions.get(2));

        if (Roll == 4) // Question 4
            tv.setText(Questions.get(3));

        if (Roll == 5) // Question 5
            tv.setText(Questions.get(4));

        if (Roll == 6) // Question 6
            tv.setText(Questions.get(5));



    }

    }



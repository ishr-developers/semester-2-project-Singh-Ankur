package com.android.example.tic_tac_toe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int playerTurn = 0;
    boolean[] isBoxChecked = new boolean[9];


    //TODO: Lets work on the logic of this method.
    public boolean Win() { //TODO: Need to rename method to reflect what it does.
    
    if(isBoxChecked[0]&&isBoxChecked[1]&&isBoxChecked[2]){
        return true;
    }
    return false;
}
// This method does all the actions needed in the box; checking if the box is clicked,
// making the box unusable, setting the counter token and changing the player turn.
    public void useBox(int id, int boxNumber){
        if (!isBoxChecked[boxNumber]) {
            isBoxChecked[boxNumber] = true;
            TextView boxView = findViewById(id);
            if (playerTurn == 0) {
                boxView.setText("X");
                playerTurn = 1;
            } else {
                boxView.setText("O");
                playerTurn = 0;
            }
        }
        if (Win()) {
            Toast.makeText(getApplicationContext(),"You Won",Toast.LENGTH_SHORT).show();
        }
    }

//This method links itself to a box whenver it is clicked
    public void onBoxClicked(View view) {
        int clickedViewId = view.getId();
        switch (clickedViewId) {
            case R.id.box1: {
              useBox(clickedViewId, 0);
                //TODO: Check for winners.
                break;
            }

            case R.id.box2: {
                useBox(clickedViewId,1);
                //TODO: Check For winners
                break;
            }

            case R.id.box3: {
                useBox(clickedViewId,2);
                //TODO: Check For winners
                break;
            }

            case R.id.box4: {
                useBox(clickedViewId,3);
                //TODO: Check For winners
                break;
            }

            case R.id.box5: {
                useBox(clickedViewId,4);
                //TODO: Check For winners
                break;
            }

            case R.id.box6: {
                useBox(clickedViewId,5);
                //TODO: Check For winners
                break;
            }

            case R.id.box7: {
               useBox(clickedViewId,6);
                //TODO: Check For winners
                break;
            }

            case R.id.box8: {
                useBox(clickedViewId,7);
                //TODO: Check For winners
                break;
            }

            case R.id.box9: {
                useBox(clickedViewId,8);
                //TODO: Check For winners
                break;
            }
        }
    }
}




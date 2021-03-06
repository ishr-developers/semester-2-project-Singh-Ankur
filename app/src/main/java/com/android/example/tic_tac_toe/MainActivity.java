package com.android.example.tic_tac_toe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int playerTurn = 0;
    boolean[] isBoxChecked = new boolean[9];
    String[] tokenXPLace = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void endGame() {
        isBoxChecked[0] = true;
        isBoxChecked[1] = true;
        isBoxChecked[2] = true;
        isBoxChecked[3] = true;
        isBoxChecked[4] = true;
        isBoxChecked[5] = true;
        isBoxChecked[6] = true;
        isBoxChecked[7] = true;
        isBoxChecked[8] = true;
    }

    public boolean xWin() {
        if (tokenXPLace[0] == "x" && tokenXPLace[1] == "x" && tokenXPLace[2] == "x") {
            return true;
        } else if (tokenXPLace[3] == "x" && tokenXPLace[4] == "x" && tokenXPLace[5] == "x") {
            return true;
        } else if (tokenXPLace[6] == "x" && tokenXPLace[7] == "x" && tokenXPLace[8] == "x") {
            return true;
        } else if (tokenXPLace[0] == "x" && tokenXPLace[3] == "x" && tokenXPLace[6] == "x") {
            return true;
        } else if (tokenXPLace[2] == "x" && tokenXPLace[4] == "x" && tokenXPLace[7] == "x") {
            return true;
        } else if (tokenXPLace[2] == "x" && tokenXPLace[5] == "x" && tokenXPLace[8] == "x") {
            return true;
        } else if (tokenXPLace[0] == "x" && tokenXPLace[4] == "x" && tokenXPLace[8] == "x") {
            return true;
        } else if (tokenXPLace[2] == "x" && tokenXPLace[4] == "x" && tokenXPLace[6] == "x") {
            return true;
        } else
        return false;
    }
    public boolean oWin() {
        if (tokenXPLace[0] == "o" && tokenXPLace[1] == "o" && tokenXPLace[2] == "o") {
            return true;
        } else if (tokenXPLace[3] == "o" && tokenXPLace[4] == "o" && tokenXPLace[5] == "o") {
            return true;
        } else if (tokenXPLace[6] == "o" && tokenXPLace[7] == "o" && tokenXPLace[8] == "o") {
            return true;
        } else if (tokenXPLace[0] == "o" && tokenXPLace[3] == "o" && tokenXPLace[6] == "o") {
            return true;
        } else if (tokenXPLace[2] == "o" && tokenXPLace[5] == "o" && tokenXPLace[7] == "o") {
            return true;
        } else if (tokenXPLace[3] == "o" && tokenXPLace[6] == "o" && tokenXPLace[8] == "o") {
            return true;
        } else if (tokenXPLace[0] == "o" && tokenXPLace[4] == "o" && tokenXPLace[8] == "o") {
            return true;
        } else if (tokenXPLace[2] == "o" && tokenXPLace[4] == "o" && tokenXPLace[6] == "o") {
            return true;
        } else
            return false;
    }


// This method does all the actions needed in the box; checking if the box is clicked,
// making the box unusable, setting the counter token and changing the player turn.
    public void useBox ( int id, int boxNumber){
            if (!isBoxChecked[boxNumber]) {
                isBoxChecked[boxNumber] = true;
                TextView boxView = findViewById(id);
                if (playerTurn == 0) {
                    boxView.setText("X");
                    tokenXPLace[boxNumber] = "x";
                    playerTurn = 1;
                } else {
                    boxView.setText("O");
                    tokenXPLace[boxNumber] = "o";
                    playerTurn = 0;
                }
            }
            if (xWin()) {
                Toast.makeText(getApplicationContext(), "Player 1 Won", Toast.LENGTH_SHORT).show();
                endGame();
                } else if (oWin()) {
                Toast.makeText(getApplicationContext(), "Player 2 Won", Toast.LENGTH_SHORT).show();
                endGame();
            } else if () {
            }
        }

//This method links itself to a box whenever it is clicked
        public void onBoxClicked (View view){
            int clickedViewId = view.getId();
            switch (clickedViewId) {
                case R.id.box1: {
                    useBox(clickedViewId, 0);
                    break;
                }

                case R.id.box2: {
                    useBox(clickedViewId, 1);
                    break;
                }

                case R.id.box3: {
                    useBox(clickedViewId, 2);
                    break;
                }

                case R.id.box4: {
                    useBox(clickedViewId, 3);
                    break;
                }

                case R.id.box5: {
                    useBox(clickedViewId, 4);
                    break;
                }

                case R.id.box6: {
                    useBox(clickedViewId, 5);
                    break;
                }

                case R.id.box7: {
                    useBox(clickedViewId, 6);
                    break;
                }

                case R.id.box8: {
                    useBox(clickedViewId, 7);
                    //TODO: Check For winners
                    break;
                }

                case R.id.box9: {
                    useBox(clickedViewId, 8);
                    //TODO: Check For winners
                    break;
                }
            }
        }
    }




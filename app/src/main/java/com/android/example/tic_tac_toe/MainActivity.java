package com.android.example.tic_tac_toe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int playerTurn = 0;
    boolean[] isBoxChecked = new boolean[9];
    String[] tokenPLace = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void endgame() {
        int i;
        for(i = 0;i < 9; i++) {
            isBoxChecked[i] = true;
        }
    }
    public boolean xWin() {
        if (tokenPLace[0] == "x" && tokenPLace[1] == "x" && tokenPLace[2] == "x") {
            return true;
        } else if (tokenPLace[3] == "x" && tokenPLace[4] == "x" && tokenPLace[5] == "x") {
            return true;
        } else if (tokenPLace[6] == "x" && tokenPLace[7] == "x" && tokenPLace[8] == "x") {
            return true;
        } else if (tokenPLace[0] == "x" && tokenPLace[3] == "x" && tokenPLace[6] == "x") {
            return true;
        } else if (tokenPLace[1] == "x" && tokenPLace[4] == "x" && tokenPLace[7] == "x") {
            return true;
        } else if (tokenPLace[2] == "x" && tokenPLace[5] == "x" && tokenPLace[8] == "x") {
            return true;
        } else if (tokenPLace[0] == "x" && tokenPLace[4] == "x" && tokenPLace[8] == "x") {
            return true;
        } else if (tokenPLace[2] == "x" && tokenPLace[4] == "x" && tokenPLace[6] == "x") {
            return true;
        } else
        return false;
    }

    public boolean oWin() {
        if (tokenPLace[0] == "o" && tokenPLace[1] == "o" && tokenPLace[2] == "o") {
            return true;
        } else if (tokenPLace[3] == "o" && tokenPLace[4] == "o" && tokenPLace[5] == "o") {
            return true;
        } else if (tokenPLace[6] == "o" && tokenPLace[7] == "o" && tokenPLace[8] == "o") {
            return true;
        } else if (tokenPLace[0] == "o" && tokenPLace[3] == "o" && tokenPLace[6] == "o") {
            return true;
        } else if (tokenPLace[1] == "o" && tokenPLace[4] == "o" && tokenPLace[7] == "o") {
            return true;
        } else if (tokenPLace[2] == "o" && tokenPLace[5] == "o" && tokenPLace[8] == "o") {
            return true;
        } else if (tokenPLace[0] == "o" && tokenPLace[4] == "o" && tokenPLace[8] == "o") {
            return true;
        } else if (tokenPLace[2] == "o" && tokenPLace[4] == "o" && tokenPLace[6] == "o") {
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
                    tokenPLace[boxNumber] = "x";
                    playerTurn = 1;
                } else {
                    boxView.setText("O");
                    tokenPLace[boxNumber] = "o";
                    playerTurn = 0;
                }
            }
            if (xWin()) {
                Toast.makeText(getApplicationContext(), "Player 1 Won", Toast.LENGTH_SHORT).show();
                endgame();
            }
            else if (oWin()) {
                Toast.makeText(getApplicationContext(), "Player 2 Won", Toast.LENGTH_SHORT).show();
                endgame();
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
                    break;
                }

                case R.id.box9: {
                    useBox(clickedViewId, 8);
                    break;
                }
            }
        }

    }



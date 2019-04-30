package com.android.example.tic_tac_toe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int playerTurn = 0;
    boolean[] isBoxChecked = new boolean[9];
    int[] tokenPLace = new int[9];
    int xWins = 0;
    int oWins = 0;

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
    public boolean checkDraw() {
        for(boolean b : isBoxChecked)
            if(!b) return false;
        return true;
    }
    public void resetScore(View view) {
        clearBoxes(view);
        xWins = -1;
        oWins = -1;
        changeP1();
        changeP2();
    }
    public void clearBoxes(View view) {
        int i;
        for(i = 0;i < 9;i++) {
            isBoxChecked[i] = false;
            tokenPLace[i] = 0;
            playerTurn = 0;
                TextView boxView = findViewById(R.id.box1);
                TextView boxView2 = findViewById(R.id.box2);
                TextView boxView3 = findViewById(R.id.box3);
                TextView boxView4 = findViewById(R.id.box4);
                TextView boxView5 = findViewById(R.id.box5);
                TextView boxView6 = findViewById(R.id.box6);
                TextView boxView7 = findViewById(R.id.box7);
                TextView boxView8 = findViewById(R.id.box8);
                TextView boxView9 = findViewById(R.id.box9);
                boxView.setText("");
                boxView2.setText("");
                boxView3.setText("");
                boxView4.setText("");
                boxView5.setText("");
                boxView6.setText("");
                boxView7.setText("");
                boxView8.setText("");
                boxView9.setText("");
        }
    }
    public boolean xWinCheck() {
        if (tokenPLace[0] + tokenPLace[1] + tokenPLace[2] == 12) {
            return true;
        } else if (tokenPLace[3] + tokenPLace[4] + tokenPLace[5] == 12) {
            return true;
        } else if (tokenPLace[6] + tokenPLace[7] + tokenPLace[8] == 12) {
            return true;
        } else if (tokenPLace[0] + tokenPLace[3] + tokenPLace[6] == 12) {
            return true;
        } else if (tokenPLace[1] + tokenPLace[4] + tokenPLace[7] == 12) {
            return true;
        } else if (tokenPLace[2] + tokenPLace[5] + tokenPLace[8] == 12) {
            return true;
        } else if (tokenPLace[0] + tokenPLace[4] + tokenPLace[8] == 12) {
            return true;
        } else if (tokenPLace[2] + tokenPLace[4] + tokenPLace[6] == 12) {
            return true;
        } else
        return false;
    }

    public boolean oWinCheck() {
        if (tokenPLace[0] + tokenPLace[1] + tokenPLace[2] == 9) {
            return true;
        } else if (tokenPLace[3] + tokenPLace[4] +  tokenPLace[5] == 9) {
            return true;
        } else if (tokenPLace[6] +  tokenPLace[7] + tokenPLace[8] == 9) {
            return true;
        } else if (tokenPLace[0] + tokenPLace[3] + tokenPLace[6] == 9) {
            return true;
        } else if (tokenPLace[1] + tokenPLace[4] +  tokenPLace[7] == 9) {
            return true;
        } else if (tokenPLace[2] + tokenPLace[5] + tokenPLace[8] == 9) {
            return true;
        } else if (tokenPLace[0] + tokenPLace[4] + tokenPLace[8] == 9) {
            return true;
        } else if (tokenPLace[2] + tokenPLace[4] + tokenPLace[6] == 9) {
            return true;
        } else
            return false;
    }

    public void changeP1() {
        xWins++;
        TextView p1Score = findViewById(R.id.player1Score);
        p1Score.setText(Integer.toString(xWins));
    }

    public void changeP2() {
        oWins++;
        TextView p2Score = findViewById(R.id.player2Score);
        p2Score.setText(Integer.toString(oWins));
    }
    // This method does all the actions needed in the box; checking if the box is clicked,
// making the box unusable, setting the counter token and changing the player turn.
        public void useBox ( int id, int boxNumber){
            if (!isBoxChecked[boxNumber]) {
                isBoxChecked[boxNumber] = true;
                TextView boxView = findViewById(id);
                if (playerTurn == 0) {
                    boxView.setText("X");
                    tokenPLace[boxNumber] = 4;
                    playerTurn = 1;
                } else {
                    boxView.setText("O");
                    tokenPLace[boxNumber] = 3;
                    playerTurn = 0;
                }
            }
            if (xWinCheck()) {
                changeP1();
                Toast.makeText(getApplicationContext(), "Player 1 Won", Toast.LENGTH_SHORT).show();
                endgame();
            }
            else if (oWinCheck()) {
                changeP2();
                Toast.makeText(getApplicationContext(), "Player 2 Won", Toast.LENGTH_SHORT).show();
                endgame();
            }
            else if(checkDraw()) {
                Toast.makeText(getApplicationContext(), "Cat's Game", Toast.LENGTH_SHORT).show();
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



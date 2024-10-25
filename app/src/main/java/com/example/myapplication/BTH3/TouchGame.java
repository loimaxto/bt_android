package com.example.myapplication.BTH3;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Random;

public class TouchGame extends Activity implements View.OnTouchListener {
    private FrameLayout layout;
    private TextView scoreTextView;
    private int totalScore = 0;
    private int currentScore = 0;
    private ArrayList<CycleView> cycles = new ArrayList<>();
    private CountDownTimer timer;
    private FrameLayout gamePlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w6touchgame);

        layout = findViewById(R.id.layout);
        scoreTextView = findViewById(R.id.score_text);

        // Get screen size
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        startGame(size);
    }


    private void startGame(Point size) {
        currentScore = 0;
        scoreTextView.setText("Score: " + currentScore);

        // Start timer
        timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Create new cycles every second
                createCycle(size);
            }

            @Override
            public void onFinish() {
                // End game
                endGame();
            }
        }.start();

        // Create initial cycles
//        createCycle(size);
//        createCycle(size);
//        createCycle(size);
    }

    private void createCycle(Point size) {
        Random random = new Random();
        int x = random.nextInt(size.x - 100) + 50;
        int y = random.nextInt(size.y - 100) + 50;

        CycleView cycle = new CycleView(this);
        cycle.setX(x);
        cycle.setY(y);
        cycle.setOnTouchListener(this);
        layout.addView(cycle);
        cycles.add(cycle);
    }

    private void endGame() {
        // Remove all cycles
        for (CycleView cycle : cycles) {
            layout.removeView(cycle);
        }
        cycles.clear();

        // Add current score to total score
        totalScore += currentScore;

        // Show final score and start new game
        scoreTextView.setText("Game Over! Your score: " + totalScore);
//        startGame();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            for (CycleView cycle : cycles) {
                if (v == cycle) {
                    // Remove cycle and increase score
                    layout.removeView(cycle);
                    cycles.remove(cycle);
                    currentScore++;
                    scoreTextView.setText("Score: " + currentScore);
                    break;
                }
            }
        }
        return true;
    }
}

class CycleView extends View {
    private int radius = 50;

    public CycleView(TouchGame context) {
        super(context);
        setBackgroundColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centerX = getWidth() ;
        int centerY = getHeight() ;
        canvas.drawCircle(centerX, centerY, radius, new Paint());
    }
}
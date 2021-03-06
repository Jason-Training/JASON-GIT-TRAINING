package com.example.jason.opps_concept.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jason.opps_concept.R;

import java.util.Random;

public class RunnableInterface extends AppCompatActivity {

    private ProgressBar progressBar_1, progressBar_2, progressBar_3;
    private CustomizeRunable customizeRunable_1, customizeRunable_2, customizeRunable_3;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.runable);
        progressBar_1 = (ProgressBar) findViewById(R.id.progressBar_thread_1);
        progressBar_2 = (ProgressBar) findViewById(R.id.progressBar_thread_2);
        progressBar_3 = (ProgressBar) findViewById(R.id.progressBar_thread_3);

        customizeRunable_1 = new CustomizeRunable(progressBar_1, random.nextInt(5));
        customizeRunable_2 = new CustomizeRunable(progressBar_2, random.nextInt(5));
        customizeRunable_3 = new CustomizeRunable(progressBar_3, random.nextInt(5));
    }

    public void onclickStart(View view){
            customizeRunable_1.start();
            customizeRunable_2.start();
            customizeRunable_3.start();
    }

    public class CustomizeRunable implements Runnable{

        private ProgressBar progressBar;
        private int increase;
        private Thread mThread;

        public CustomizeRunable(ProgressBar progressBar, int increase) {
            this.progressBar = progressBar;
            this.increase = increase;
        }

        @Override
        public void run() {
            for (int i = 0; i < 105; i += increase){
                progressBar.setProgress(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void start(){
            if (mThread == null){
                mThread = new Thread(this);
                mThread.start();
            } else mThread.start();
        }
    }
}

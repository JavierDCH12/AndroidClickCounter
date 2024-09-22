package com.example.clickcounter;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.clickcounter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    public static int contador;
    private CountDownTimer countDownTimer;
    private boolean isTimerRunning = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        contador=0;



        //BOTON CLICK
        binding.BotonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTimerRunning){
                    contador++;
                    binding.ContadorNumerico.setText(String.valueOf(contador));
                }
            }
        });


        //BOTON RESET
        binding.ButonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador=0;
                binding.ContadorNumerico.setText(String.valueOf(contador));
            }
        });
    }


    //CountDown

    private void startCountdown(){

        countDownTimer = new CountDownTimer(20000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                binding.CountDown.setText(String.valueOf(millisUntilFinished/1000));
                isTimerRunning=true;
            }

            @Override
            public void onFinish() {
                isTimerRunning=false;
                binding.CountDown.setText(String.valueOf("FIN"));
                binding.BotonClick.setEnabled(false);
            }
        }.start();

    }


    private void restart(){
        if(countDownTimer!=null){
            countDownTimer.cancel();

        }
        binding.BotonClick.setEnabled(true);
        startCountdown();
    }











}
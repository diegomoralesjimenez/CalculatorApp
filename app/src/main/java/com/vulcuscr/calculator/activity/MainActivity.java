package com.vulcuscr.calculator.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.distribute.Distribute;
import com.vulcuscr.calculator.BuildConfig;
import com.vulcuscr.calculator.R;
import com.vulcuscr.calculator.controller.CalculatorController;
import com.vulcuscr.calculator.util.AppCenterDistributeListener;


public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonEqual, buttonSum, buttonRes, buttonDiv, buttonMul, buttonCE;
    int num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    int res;
    TextView textRes1, textRes2, textRes3, textSimp;
    String text;

    CalculatorController object = CalculatorController.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!BuildConfig.APPCENTER_APP_SECRET.equals("")) {
            Log.v(this.getClass().getSimpleName(), "AppCenter Powered");
            Distribute.setListener(new AppCenterDistributeListener());

            // Use APPCENTER_APP_SECRET environment variable if it exists
            AppCenter.start(getApplication(), BuildConfig.APPCENTER_APP_SECRET,
                    Analytics.class, Crashes.class, Distribute.class);
            Distribute.setEnabled(true);
            Distribute.checkForUpdate();
        }
        if (BuildConfig.DEBUG) {
            AppCenter.setLogLevel(Log.VERBOSE);
        }

        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button4 = findViewById(R.id.btn4);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonEqual = findViewById(R.id.btnEqual);
        buttonSum = findViewById(R.id.btnAdd);
        buttonRes = findViewById(R.id.btnRest);
        buttonDiv = findViewById(R.id.btnDiv);
        buttonMul = findViewById(R.id.btnMul);
        buttonCE = findViewById(R.id.buttonCE);
        textSimp = findViewById(R.id.textSim);
        textRes1 = findViewById(R.id.textResult);
        textRes2 = findViewById(R.id.textView2);
        textRes3 = findViewById(R.id.textView3);

        button0.setOnClickListener(v -> {
           text = button0.getText().toString();
           num0 = Integer.parseInt(text);
           object.addCal(num0);
           if(!object.seeOp()) {
               textRes1.setText(object.primBuff());
           }
           else {
               textRes2.setText(object.secBuff());
           }
        });

        button1.setOnClickListener(v -> {
            text = button1.getText().toString();
            num1 = Integer.parseInt(text);
            object.addCal(num1);
            if(!object.seeOp()) {
                textRes1.setText(object.primBuff());
            }
            else {
                textRes2.setText(object.secBuff());
            }
        });

        button2.setOnClickListener(v -> {
            text = button2.getText().toString();
            num2 = Integer.parseInt(text);
            object.addCal(num2);
            if(!object.seeOp()) {
                textRes1.setText(object.primBuff());
            }
            else {
                textRes2.setText(object.secBuff());
            }
        });

        button3.setOnClickListener(v -> {
            text = button3.getText().toString();
            num3 = Integer.parseInt(text);
            object.addCal(num3);
            if(!object.seeOp()) {
                textRes1.setText(object.primBuff());
            }
            else {
                textRes2.setText(object.secBuff());
            }
        });

        button4.setOnClickListener(v -> {
            text = button4.getText().toString();
            num4 = Integer.parseInt(text);
            object.addCal(num4);
            if(!object.seeOp()) {
                textRes1.setText(object.primBuff());
            }
            else {
                textRes2.setText(object.secBuff());
            }
        });

        button5.setOnClickListener(v -> {
            text = button5.getText().toString();
            num5 = Integer.parseInt(text);
            object.addCal(num5);
            if(!object.seeOp()) {
                textRes1.setText(object.primBuff());
            }
            else {
                textRes2.setText(object.secBuff());
            }
        });

        button6.setOnClickListener(v -> {
            text = button6.getText().toString();
            num6 = Integer.parseInt(text);
            object.addCal(num6);
            if(!object.seeOp()) {
                textRes1.setText(object.primBuff());
            }
            else {
                textRes2.setText(object.secBuff());
            }
        });

        button7.setOnClickListener(v -> {
            text = button7.getText().toString();
            num7 = Integer.parseInt(text);
            object.addCal(num7);
            if(!object.seeOp()) {
                textRes1.setText(object.primBuff());
            }
            else {
                textRes2.setText(object.secBuff());
            }
        });

        button8.setOnClickListener(v -> {
            text = button8.getText().toString();
            num8 = Integer.parseInt(text);
            object.addCal(num8);
            if(!object.seeOp()) {
                textRes1.setText(object.primBuff());
            }
            else {
                textRes2.setText(object.secBuff());
            }
        });

        button9.setOnClickListener(v -> {
            text = button9.getText().toString();
            num9 = Integer.parseInt(text);
            object.addCal(num9);
            if(!object.seeOp()) {
                textRes1.setText(object.primBuff());
            }
            else {
                textRes2.setText(object.secBuff());
            }
        });

        buttonCE.setOnClickListener(v -> {
            object.clearBuff();
            object.useMode(-1);
            textRes1.setText(object.primBuff());
            textRes2.setText(object.secBuff());
            textRes3.setText("");
            textSimp.setText("");
        });

        buttonSum.setOnClickListener(v -> {
            object.useMode(0);
            textSimp.setText("+");
        });

        buttonRes.setOnClickListener(v -> {
            object.useMode(1);
            textSimp.setText("-");
        });

        buttonMul.setOnClickListener(v -> {
            object.useMode(2);
            textSimp.setText("*");

        });

        buttonDiv.setOnClickListener(v -> {
            object.useMode(3);
            textSimp.setText("/");
            });

        buttonEqual.setOnClickListener(v -> {
            if(object.getMode() == 0) {
                res = object.sum(object.primVal(), object.secVal());
                textRes3.setText(String.valueOf(res));
            }

            if(object.getMode() == 1) {
                res = object.rest(object.primVal(), object.secVal());
                textRes3.setText(String.valueOf(res));
            }

            if(object.getMode() == 2) {
                res = object.mul(object.primVal(), object.secVal());
                textRes3.setText(String.valueOf(res));
            }

            if(object.getMode() == 3) {
                res = object.div(object.primVal(), object.secVal());
                textRes3.setText(String.valueOf(res));
            }

        });
    }




}
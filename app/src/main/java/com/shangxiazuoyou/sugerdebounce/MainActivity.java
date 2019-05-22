package com.shangxiazuoyou.sugerdebounce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import library.shangxiazuoyou.sugerdebounce.Debounce;
import library.shangxiazuoyou.sugerdebounce.DebounceObserver;
import library.shangxiazuoyou.sugerdebounce.TextViewAfterTextChangeEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView test = findViewById(R.id.test);

        Debounce.onAfterTextChangedAction(test, 300, new DebounceObserver<TextViewAfterTextChangeEvent>() {
            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onSuccess(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {
                Log.i("打印：", textViewAfterTextChangeEvent.editable().toString());
            }
        });
    }
}

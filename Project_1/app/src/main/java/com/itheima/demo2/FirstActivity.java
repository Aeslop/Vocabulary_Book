package com.itheima.demo2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.itheima.demo2.database.DBOpenHelper;
import com.itheima.demo2.fragments.FragmentInput;
import com.itheima.demo2.fragments.FragmentRecite;
import com.itheima.demo2.fragments.FragmentSelf;

public class FirstActivity extends AppCompatActivity {
    TextView name;
    Button button_input,button_recite,button_self;
    FragmentInput fragmentInput;
    FragmentRecite fragmentRecite;
    FragmentSelf fragmentSelf;
    DBOpenHelper dbOpenHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist);
        button_input = (Button) findViewById(R.id.frist_btn_input);
        button_recite = (Button) findViewById(R.id.frist_btn_recite);
        button_self = (Button) findViewById(R.id.frist_btn_self);

        name = (TextView) findViewById(R.id.name);

        fragmentInput = new FragmentInput();
        fragmentRecite = new FragmentRecite();
        fragmentSelf = new FragmentSelf();

        dbOpenHelper = new DBOpenHelper(FirstActivity.this,"tb_dict",null,1);

        //获取ID
        Bundle buddle = getIntent().getExtras();
        name.setText(buddle.getString("name"));

        button_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.first_fl,fragmentInput).commitAllowingStateLoss();
            }
        });

        button_recite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.first_fl,fragmentRecite).commitAllowingStateLoss();
            }
        });

        button_self.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.first_fl,fragmentSelf).commitAllowingStateLoss();
            }
        });

        getFragmentManager().beginTransaction().add(R.id.first_fl,fragmentInput).commitNowAllowingStateLoss();
    }
}

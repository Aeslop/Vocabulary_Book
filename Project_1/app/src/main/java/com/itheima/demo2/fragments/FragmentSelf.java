package com.itheima.demo2.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.itheima.demo2.Explain;
import com.itheima.demo2.R;
import com.itheima.demo2.WordsBase;

public class FragmentSelf extends Fragment {
    TextView textView_wordsbase,textView_explain;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_self,null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView_wordsbase = view.findViewById(R.id.self_tv_words);
        textView_explain = view.findViewById(R.id.self_tv_explain);
        textView_wordsbase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WordsBase.class);
                startActivity(intent);
            }
        });
        textView_explain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Explain.class);
                startActivity(intent);
            }
        });
    }
}



















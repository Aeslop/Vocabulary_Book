package com.itheima.demo2.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.itheima.demo2.R;
import com.itheima.demo2.database.DBOpenHelper;
import com.itheima.demo2.util.ToastUtil;

public class FragmentInput extends Fragment {
    Button button;
    EditText editText_word,editText_translate;
    DBOpenHelper dbOpenHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input,null);
        dbOpenHelper = new DBOpenHelper(getActivity(),"tb_dict",null,1);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText_word = view.findViewById(R.id.input_et_words);
        editText_translate = view.findViewById(R.id.input_et_translate);
        button = view.findViewById(R.id.input_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = editText_word.getText().toString();
                String translate = editText_translate.getText().toString();
                if(word.endsWith("ion")){
                    translate = "n. "+editText_translate.getText().toString();
                }else if(word.endsWith("ness")){
                    translate = "n. "+editText_translate.getText().toString();
                }else if(word.endsWith("ment")){
                    translate = "n. "+editText_translate.getText().toString();
                }else if(word.endsWith("ty")){
                    translate = "n. "+editText_translate.getText().toString();
                }else if(word.endsWith("acy")){
                    translate = "n. "+editText_translate.getText().toString();
                }else if(word.endsWith("ance")){
                    translate = "n. "+editText_translate.getText().toString();
                }else if(word.endsWith("ence")){
                    translate = "n. "+editText_translate.getText().toString();
                }else if(word.endsWith("ice")){
                    translate = "n. "+editText_translate.getText().toString();
                }else if(translate.endsWith("的")){
                    translate = "adj. "+editText_translate.getText().toString();
                }else if (translate.endsWith("地")){
                    translate = "adv. "+editText_translate.getText().toString();
                }else{
                    translate = editText_translate.getText().toString();
                }
                if (word.isEmpty() || editText_translate.getText().toString().isEmpty()){
                    ToastUtil.showMsg(getActivity(),"请输入数据");
                }else{
                    dbOpenHelper.writeData(dbOpenHelper.getReadableDatabase(),word,translate);
                    ToastUtil.showMsg(getActivity(),"录入成功");
                    editText_translate.setText("");
                    editText_word.setText("");
                    editText_word.requestFocus();
                }
            }
        });
    }
}

package com.example.iread.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iread.R;
import com.example.iread.auth.HomeActivity;
import com.example.iread.options.SettingActivity;

public class NewsPageFragment extends Fragment {

    public static NewsPageFragment newInstance() {
        return (new NewsPageFragment());
    }


    public  interface  OnQuizClickListener{
        void OnStart1Click(View view);
        void OnStart2Click(View view);
        void OnStart3Click(View view);
        void OnStart4Click(View view);
        void OnStart5Click(View view);
        void OnLire1Click(View view);
        void OnLire2Click(View view);
        void OnLire3Click(View view);
        void OnLire4Click(View view);
        void OnLire5Click(View view);
    }
    private NewsPageFragment.OnQuizClickListener addCalback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_news_page, container, false);
        result.findViewById(R.id.defi_1).findViewById(R.id.defi_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCalback.OnStart1Click(v);
            }
        });











        return result;
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.createCallbackToParentActivity();
    }

    private void createCallbackToParentActivity(){
        try{
            addCalback = (NewsPageFragment.OnQuizClickListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");        }
    }
}
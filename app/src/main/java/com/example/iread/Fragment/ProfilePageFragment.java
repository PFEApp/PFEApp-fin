package com.example.iread.Fragment;


import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.iread.MainActivity;
import com.example.iread.R;
import com.example.iread.auth.HomeActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.BreakIterator;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilePageFragment extends Fragment {



    public static ProfilePageFragment newInstance() {
        return (new ProfilePageFragment());
    }
//gestion des call bac

    public interface OnAddClicklistener{
        void onAddClick(View view);
    }
    private OnAddClicklistener addCalback;

    ///
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.fragment_profile_page, container, false);
        FloatingActionButton floatingActionButton = (FloatingActionButton)result.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCalback.onAddClick(v);
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
            addCalback = (OnAddClicklistener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");        }
    }


}

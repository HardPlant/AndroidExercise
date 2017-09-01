package com.kiiren.fragment2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by 120897 on 2017-08-28.
 */


public class ViewerFragment extends Fragment {
    ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_image, container, false);

        imageView = (ImageView) rootView.findViewById(R.id.imageView);

        return rootView;
    }
    public void setImage(int index){
        if (index == 0){
            imageView.setImageResource(R.drawable.ic_launcher_background);
        } else {
            imageView.setImageResource(R.drawable.ic_launcher_background);
        }
    }
}

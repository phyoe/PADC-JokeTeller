package xyz.phyoekhant.harthapadaythar.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import xyz.phyoekhant.harthapadaythar.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class Joke1Fragment extends Fragment {


    public Joke1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke1, container, false);

        return view;
    }
}

package com.example.respro2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link review1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class review1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View view;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public review1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment review1.
     */
    // TODO: Rename and change types and number of parameters
    public static review1 newInstance(String param1, String param2) {
        review1 fragment = new review1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_review1, container, false);
        // Array of strings...
        ArrayList<String> mobileArray = new ArrayList<String>();
        //ArrayList<ListviewContactItem> listContact = GetlistContact();
        EditText ed = (EditText) rootView.findViewById(R.id.editTextTextPersonName);
        Button b = (Button) rootView.findViewById(R.id.button2);
        ListView lv = (ListView) rootView.findViewById(R.id.listView1);
        ListAdapter adapter = new ArrayAdapter<String>(getContext(), R.layout.fragment_review1,R.id.textView2, mobileArray);
        lv.setAdapter(adapter);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // this line adds the data of your EditText and puts in your array
                mobileArray.add(ed.getText().toString());
                //lv.addElement(ed.getText().toString());
                lv.setAdapter(adapter);
                // next thing you have to do is check if your adapter has changed

            }
        });
        return rootView;
    }

}
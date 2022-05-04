package com.example.respro2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link review2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class review2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public review2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment review2.
     */
    // TODO: Rename and change types and number of parameters
    public static review2 newInstance(String param1, String param2) {
        review2 fragment = new review2();
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
        View rootView = inflater.inflate(R.layout.fragment_review2, container, false);
        // Array of strings...
        String[] mobileArray = {"Review 1","Review 2","Review 3","Review 4",
                "Review 5","Review 6","Review 7","Review 8"};
        //ArrayList<ListviewContactItem> listContact = GetlistContact();
        ListAdapter adapter = new ArrayAdapter<String>(getContext(), R.layout.fragment_review2,R.id.textView3, mobileArray);
        ListView lv = (ListView)rootView.findViewById(R.id.listView2);
        lv.setAdapter(adapter);

        return rootView;
    }
}
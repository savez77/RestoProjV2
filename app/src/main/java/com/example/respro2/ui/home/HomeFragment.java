package com.example.respro2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.respro2.R;
import com.example.respro2.RestAdapter;
import com.example.respro2.RestarauntModel;
import com.example.respro2.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView courseRV;
    // Arraylist for storing data
    private ArrayList<RestarauntModel> RestarauntModelArrayList;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        courseRV = (RecyclerView) root.findViewById(R.id.idRVCourse);

        // here we have created new array list and added data to it.
        RestarauntModelArrayList = new ArrayList<>();
        RestarauntModelArrayList.add(new RestarauntModel("Restaurant 1", 4, R.drawable.ic_baseline_fastfood_24));
        RestarauntModelArrayList.add(new RestarauntModel("Restaurant 2", 3, R.drawable.ic_baseline_fastfood_24));
        RestarauntModelArrayList.add(new RestarauntModel("Restaurant 3", 4, R.drawable.ic_baseline_fastfood_24));
        RestarauntModelArrayList.add(new RestarauntModel("Restaurant 4", 3, R.drawable.ic_baseline_fastfood_24));
        RestarauntModelArrayList.add(new RestarauntModel("Restaurant 5", 3, R.drawable.ic_baseline_fastfood_24));
        RestarauntModelArrayList.add(new RestarauntModel("Restaurant 6", 4, R.drawable.ic_baseline_fastfood_24));
        RestarauntModelArrayList.add(new RestarauntModel("Restaurant 7", 5, R.drawable.ic_baseline_fastfood_24));

        RestAdapter restAdapter = new RestAdapter(this, RestarauntModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(restAdapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
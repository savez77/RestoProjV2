package com.example.respro2.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.respro2.R;
import com.example.respro2.databinding.FragmentNotificationsBinding;
import com.example.respro2.loginactiv;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;

public class NotificationsFragment extends Fragment {



    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

   // MaterialButton signoutbtn;

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
       // gsc = GoogleSignIn.getClient(this,gso);

        MaterialButton signoutbtn = root.findViewById(R.id.sign_outbtn);


        signoutbtn.setOnClickListener(v -> signOut());





        return root;
    }

    void signOut(){
        gsc.signOut().addOnCompleteListener(task -> {
            getActivity().finish();
    //        startActivity(new Intent(NotificationsFragment.this, loginactiv.class));
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
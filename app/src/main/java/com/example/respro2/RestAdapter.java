package com.example.respro2;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.respro2.ui.home.HomeFragment;

import java.util.ArrayList;

public class RestAdapter extends RecyclerView.Adapter<RestAdapter.Viewholder> {
    public static final String EXTRA_MESSAGE = "myString";
    public static final String EXTRA_MESSAGE1 = "myString";
    private HomeFragment context;
    private ArrayList<RestarauntModel> RestarauntModelArrayList;

    // Constructor
    public RestAdapter(HomeFragment context, ArrayList<RestarauntModel> RestarauntModelArrayList) {
        this.context = context;
        this.RestarauntModelArrayList = RestarauntModelArrayList;
    }

    @NonNull

    public RestAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new Viewholder(view);
    }


    public void onBindViewHolder(@NonNull RestAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        RestarauntModel model = RestarauntModelArrayList.get(position);
        holder.courseNameTV.setText(model.getrest_name());
        holder.courseRatingTV.setText("" + model.getCourse_rating());
        holder.courseIV.setImageResource(model.getCourse_image());
    }

    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return RestarauntModelArrayList.size();
    }

    // View holder class for initializing of 
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView courseIV;
        private TextView courseNameTV, courseRatingTV;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            courseIV = itemView.findViewById(R.id.idIVCourseImage);
            courseNameTV = (TextView) itemView.findViewById(R.id.idTVCourseName);
            courseRatingTV = itemView.findViewById(R.id.idTVCourseRating);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(),rest_menu.class);

                    String message = courseNameTV.getText().toString();
                    intent.putExtra(EXTRA_MESSAGE, message);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}

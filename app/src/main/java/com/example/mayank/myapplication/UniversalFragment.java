package com.example.mayank.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/*
*
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UniversalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UniversalFragment#newInstance} factory method to
 * create an instance of this fragment.
*/
public class UniversalFragment extends Fragment {

    private String day;

    private TextView first;
    private TextView second;
    private TextView third;
    private TextView fourth;
    private TextView fifth;
    private TextView sixth;




    public UniversalFragment() {
        // Required empty public constructor
        day="NULL";
    }

    public UniversalFragment(String day) {
        this.day = day;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment, container, false);

        first = (TextView)view.findViewById(R.id.first);
        second = (TextView)view.findViewById(R.id.second);
        third = (TextView)view.findViewById(R.id.third);
        fourth = (TextView)view.findViewById(R.id.fourth);
        fifth = (TextView)view.findViewById(R.id.fifth);
        sixth = (TextView)view.findViewById(R.id.sixth);

        fill(day);

        return view;
    }

    private void fill(String title){

        if(title.equals("MONDAY")){
            first.setText(TimeTable.Monday[0]);
            second.setText(TimeTable.Monday[1]);
            third.setText(TimeTable.Monday[2]);
            fourth.setText(TimeTable.Monday[3]);
            fifth.setText(TimeTable.Monday[4]);
            sixth.setText(TimeTable.Monday[5]);
        }

        if(title.equals("TUESDAY")){
            first.setText(TimeTable.Tuesday[0]);
            second.setText(TimeTable.Tuesday[1]);
            third.setText(TimeTable.Tuesday[2]);
            fourth.setText(TimeTable.Tuesday[3]);
            fifth.setText(TimeTable.Tuesday[4]);
            sixth.setText(TimeTable.Tuesday[5]);
        }

        if(title.equals("WEDNESDAY")){
            first.setText(TimeTable.Wednesday[0]);
            second.setText(TimeTable.Wednesday[1]);
            third.setText(TimeTable.Wednesday[2]);
            fourth.setText(TimeTable.Wednesday[3]);
            fifth.setText(TimeTable.Wednesday[4]);
            sixth.setText(TimeTable.Wednesday[5]);
        }

        if(title.equals("THURSDAY")){
            first.setText(TimeTable.Thursday[0]);
            second.setText(TimeTable.Thursday[1]);
            third.setText(TimeTable.Thursday[2]);
            fourth.setText(TimeTable.Thursday[3]);
            fifth.setText(TimeTable.Thursday[4]);
            sixth.setText(TimeTable.Thursday[5]);
        }

        if(title.equals("FRIDAY")){
            first.setText(TimeTable.Friday[0]);
            second.setText(TimeTable.Friday[1]);
            third.setText(TimeTable.Friday[2]);
            fourth.setText(TimeTable.Friday[3]);
            fifth.setText(TimeTable.Friday[4]);
            sixth.setText(TimeTable.Friday[5]);
        }

        if(title.equals("SATURDAY")){
            first.setText(TimeTable.Saturday[0]);
            second.setText(TimeTable.Saturday[1]);
            third.setText(TimeTable.Saturday[2]);
            fourth.setText(TimeTable.Saturday[3]);
            fifth.setText(TimeTable.Saturday[4]);
            sixth.setText(TimeTable.Saturday[5]);
        }


    }




}

package com.example.electionapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electionapp.ElectionAdapter;
import com.example.electionapp.MainActivity;
import com.example.electionapp.R;

public class HomeFragment extends Fragment {
    Button btnUpdate, btnGraduate, btnLogout;
    TextView tvUniv,tvDept,tvName,tvNumber,tvGrade;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        btnUpdate=root.findViewById(R.id.btnUpdate);
        btnGraduate=root.findViewById(R.id.btnGraduate);
        btnLogout=root.findViewById(R.id.btnLogout);

        tvUniv=root.findViewById(R.id.tvUniv);
        tvDept=root.findViewById(R.id.tvDept);
        tvName=root.findViewById(R.id.tvName);
        tvNumber=root.findViewById(R.id.tvNumber);
        tvGrade=root.findViewById(R.id.tvGrade);

        Bundle bundle=getArguments();
        String member_id=bundle.getString("member_id");
        String univ_name=bundle.getString("univ_name");
        String dept_name=bundle.getString("dept_name");
        String member_name=bundle.getString("member_name");
        String member_number=bundle.getString("member_number");
        String member_grade=bundle.getString("member_grade");

        tvUniv.setText(univ_name);
        tvDept.setText(dept_name);
        tvName.setText(member_name);
        tvNumber.setText(member_number);
        tvGrade.setText(member_grade);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent=new Intent(getContext(),MainActivity.class);
                startActivity(mainIntent);
            }
        });

        return root;
    }

}
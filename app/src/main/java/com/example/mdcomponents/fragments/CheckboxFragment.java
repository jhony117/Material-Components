package com.example.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentCheckBoxBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CheckboxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CheckboxFragment extends Fragment {


    FragmentCheckBoxBinding binding;


    public static final String TAG = "Checkbox";
    private static Component mInstance;
    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_checkboxes);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CheckboxFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheckBoxFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CheckboxFragment newInstance(String param1, String param2) {
        CheckboxFragment fragment = new CheckboxFragment();
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

        binding = FragmentCheckBoxBinding.inflate(inflater, container, false);

        return binding.getRoot();


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


       /* TriStateCheckbox triStateCheckbox = binding.cbEnableIndeterminate;
        triStateCheckbox.setState(TriStateCheckbox.State.INDETERMINATE);*/


        binding.cbEnable.setOnClickListener(v -> {
            String status = binding.cbEnable.isChecked() ? "Activo" : "Iactivo";
            Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();

           //Requiere libreria
            // binding.cbEnableIndeterminate.setIndeterminate(binding.cbEnable.isChecked());
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }
}
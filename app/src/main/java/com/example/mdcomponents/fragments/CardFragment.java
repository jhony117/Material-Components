package com.example.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentCardBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardFragment extends Fragment {


    FragmentCardBinding binding;
    public static final String TAG = "Card";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardFragment newInstance(String param1, String param2) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    private static Component mInstance;
    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_cards_template);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
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

        binding = FragmentCardBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RequestOptions options = new RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();

        Glide.with(this)
                .load("https://th.bing.com/th/id/R.36f16f57ae735d87247c6dec403a48e2?rik=%2bqz0TxjX3Ds5jQ&pid=ImgRaw&r=0")
                .into(binding.imgCardLarge);

        binding.chipFirst.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "First Chip", Toast.LENGTH_SHORT).show();
        });

        binding.chipSecond.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if(isChecked){
                Toast.makeText(getActivity(), "Checked", Toast.LENGTH_SHORT).show();
            }
        });

        binding.chipThird.setOnCloseIconClickListener(v -> binding.chipThird.setVisibility(View.GONE));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
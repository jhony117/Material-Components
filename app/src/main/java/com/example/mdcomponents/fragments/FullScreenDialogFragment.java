package com.example.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentFullScreenDialogBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FullScreenDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FullScreenDialogFragment extends DialogFragment {

    public static  final String TAG = "FullScreenDialogFragment";

    FragmentFullScreenDialogBinding binding;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FullScreenDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FullScreenDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FullScreenDialogFragment newInstance(String param1, String param2) {
        FullScreenDialogFragment fragment = new FullScreenDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFullScreenDialogBinding.inflate(inflater, container, false);
        return  binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.toolbar.setNavigationIcon(R.drawable.ic_close);
        binding.toolbar.setNavigationOnClickListener(v -> dismiss());
        binding.toolbar.setTitle(R.string.dialog_full_screen);

        binding.btnSave.setOnClickListener(v ->
                Toast.makeText(getActivity(), R.string.message_action_success, Toast.LENGTH_SHORT).show());
        dismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}

package com.example.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentDialogBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlertDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlertDialogFragment extends Fragment {

FragmentDialogBinding binding;

    public static final String TAG = "Dialog";
    private static Component mInstance;
    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_dialog_mobile_alert);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AlertDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlertDialogFragment newInstance(String param1, String param2) {
        AlertDialogFragment fragment = new AlertDialogFragment();
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
        // Inflate the layout for this fragment with view binding
        binding = FragmentDialogBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnDialogInfo.setOnClickListener(v -> {
            new MaterialAlertDialogBuilder(getActivity())
                    .setTitle(R.string.card_message_demo_small)
                    .setPositiveButton(R.string.dialog_ok, null)
                    .show();
        });
        binding.btnDialogChooser.setOnClickListener(v -> {
            final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.select_dialog_item);
            adapter.add("Opcion 1");
            adapter.add("Opcion 2");
            adapter.add("Opcion 3");

            new MaterialAlertDialogBuilder(getActivity())
                    .setTitle(R.string.dialog_chooser)
                    .setAdapter(adapter, (dialog, which) -> //porque i se expresa automaticamnete como which ?
                            Toast.makeText(getActivity(), adapter.getItem(which), Toast.LENGTH_SHORT).show())
                    .show();
        });
        binding.btnDialogConfirm.setOnClickListener(v -> {
        //    new MaterialAlertDialogBuilder(getActivity())
            new MaterialAlertDialogBuilder(getActivity(), com.google.android.material.R.style.Theme_AppCompat_Light_Dialog)
                    .setTitle(R.string.dialog_confirm_title)
                    .setMessage(R.string.card_message_demo_small)
                    .setPositiveButton(R.string.dialog_confirm, (dialog, which) ->
                            Toast.makeText(getActivity(), R.string.message_action_success, Toast.LENGTH_SHORT).show())
                    .setNegativeButton(R.string.dialog_cancel, null)
                    .show();
        });
        binding.btnDialogFullscreen.setOnClickListener(v -> {
            FullScreenDialogFragment dialogFragment = new FullScreenDialogFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            dialogFragment.show(transaction, FullScreenDialogFragment.TAG);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
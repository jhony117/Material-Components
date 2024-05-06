package com.example.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentPickerBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PickerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickerFragment extends Fragment {


    FragmentPickerBinding binding;


    public static final String TAG = "Picker";
    private static Component mInstance;
    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_picker);
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

    public PickerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickerFragment newInstance(String param1, String param2) {
        PickerFragment fragment = new PickerFragment();
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
     binding = FragmentPickerBinding.inflate(inflater, container, false);
     return binding.getRoot();
        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText(R.string.picker_title);
        builder.setSelection(System.currentTimeMillis());

        binding.btnDialog.setOnClickListener(v ->  {
            builder.setTheme(com.google.android.material.R.style.Widget_Material3_MaterialCalendar);

        });   //revisa los errores por usar getParentFragmentManager() y no geFragmentManager()
        binding.btnFullscreen.setOnClickListener(v -> {
 //            builder.setTheme(com.google.android.material.R.style.Widget_Material3_MaterialCalendar_Fullscreen);
            builder.setTheme(R.style.FullScreenPicker);

        });

        MaterialDatePicker<?> picker = builder.build();
        picker.addOnPositiveButtonClickListener(selection -> {
//            Snackbar.make(binding.containerMain, R.string.message_action_success, Snackbar.LENGTH_LONG).show();
            Snackbar.make(binding.containerMain, picker.getHeaderText(), Snackbar.LENGTH_LONG).show();

        });
        picker.addOnNegativeButtonClickListener(dialog ->
                Snackbar.make(binding.containerMain, R.string.dialog_negative, Snackbar.LENGTH_LONG).show()
     );
        picker.addOnCancelListener(dialogInterface ->
                Snackbar.make(binding.containerMain, R.string.dialog_cancel, Snackbar.LENGTH_LONG).show()
        );
        picker.show(getParentFragmentManager(), picker.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

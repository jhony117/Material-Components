package com.example.mdcomponents;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mdcomponents.adapters.ComponentAdapter;
import com.example.mdcomponents.databinding.ActivityMainBinding;
import com.example.mdcomponents.fragments.AlertDialogFragment;
import com.example.mdcomponents.fragments.ButtonFragment;
import com.example.mdcomponents.fragments.BottomNavigationBarFragment;
import com.example.mdcomponents.fragments.CardFragment;
import com.example.mdcomponents.fragments.CheckboxFragment;
import com.example.mdcomponents.fragments.FloatingActionButtonFragment;
import com.example.mdcomponents.fragments.MenuFragment;
import com.example.mdcomponents.fragments.SnackBarFragment;
import com.example.mdcomponents.fragments.TextFieldFragment;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;
import com.example.mdcomponents.utils.OnClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private ActivityMainBinding binding;

    private ComponentAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);


        setContentView(binding.getRoot());

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        confingAdapter();
        confingRecyvlerView();
    }

    private void confingAdapter() {
        mAdapter = new ComponentAdapter(new ArrayList<>(), this);
    }

    private void confingRecyvlerView() {
        binding.recyclerView.setAdapter(mAdapter);
        mAdapter.add(ButtonFragment.getmInstance());
        mAdapter.add(BottomNavigationBarFragment.getmInstance());
        mAdapter.add(SnackBarFragment.getmInstance());
        mAdapter.add(TextFieldFragment.getmInstance());
        mAdapter.add(FloatingActionButtonFragment.getmInstance());
        mAdapter.add(CheckboxFragment.getmInstance());
        mAdapter.add(CardFragment.getmInstance());
        mAdapter.add(MenuFragment.getmInstance());
        mAdapter.add(AlertDialogFragment.getmInstance());
        mAdapter.reverse();
    }



//OnClickListener
    @Override
    public void onClick(Component component) {
      Intent intent;
       if(component.getType() == Constants.SCROLL){
           intent = new Intent(this, ScrollActivity.class);
       } else { // STATIC
           intent = new Intent(this, StaticActivity.class);
       }
       intent.putExtra(Constants.ARG_NAME, component.getName());
       startActivity(intent);
    }
}
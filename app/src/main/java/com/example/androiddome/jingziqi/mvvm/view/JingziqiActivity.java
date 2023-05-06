package com.example.androiddome.jingziqi.mvvm.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.androiddome.R;
import com.example.androiddome.databinding.JingziqiMvvmBinding;
import com.example.androiddome.jingziqi.mvvm.viewmodel.JingziqiViewModel;
import androidx.databinding.DataBindingUtil;

public class JingziqiActivity extends AppCompatActivity {
    JingziqiViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JingziqiMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.jingziqi_mvvm);
        viewModel = new ViewModelProvider(this,new  ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(JingziqiViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_jingziqi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_reset:
                viewModel.onResetSelected();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
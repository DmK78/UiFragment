package ru.job4j.uifragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;
    private Fragment firstFragment;
    private Fragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager(); // получить FragmentManager
        firstFragment = fm.findFragmentById(R.id.fragment_container);
        if (firstFragment == null) {
            firstFragment = new FirstFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, firstFragment) // добавить фрагмент в контейнер
                    .commit();
        }
    }

    public class HostFragmentsActivity extends AppCompatActivity implements FirstFragment.OnNextButtonClickListener {
        @Override
        public void onNextButtonClicked(String message) {
            Bundle bundle = new Bundle();
            bundle.putString("message", message);
            if (secondFragment == null) {
                secondFragment = new SecondFragment();
            }
            secondFragment.setArguments(bundle);
            fm.beginTransaction()
                    .replace(R.id.fragment_container, secondFragment)
                    .addToBackStack(null)
                    .commit();

        }

    }



}


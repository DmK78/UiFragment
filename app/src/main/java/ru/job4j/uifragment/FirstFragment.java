package ru.job4j.uifragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FirstFragment extends Fragment {
    private Button nextFragment;
    private OnNextButtonClickListener callback;

    public interface OnNextButtonClickListener {
        void onNextButtonClicked(String message);

    }
    public void onClick(View view) {
        callback.onNextButtonClicked("Next button clicked");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        nextFragment = view.findViewById(R.id.next_fragment);
        nextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//todo
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
           callback = (OnNextButtonClickListener) context; // назначаем активити при присоединении фрагмента к активити

    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null; // обнуляем ссылку при отсоединении фрагмента от активити
    }



}

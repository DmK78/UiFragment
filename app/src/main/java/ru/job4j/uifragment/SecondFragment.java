package ru.job4j.uifragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SecondFragment extends Fragment {
    private Button buttonBack;
    TextView textViewMsg;
    private OnBackButtonClickListener callback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        buttonBack = view.findViewById(R.id.back);
        textViewMsg = view.findViewById(R.id.messageFromFirst);
        if (getArguments() != null) {
            String message = getArguments().getString("message");
            textViewMsg.setText(message);
        }
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onBackButtonClicked("Hello from Second fragment");
            }
        });
        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (OnBackButtonClickListener) context; // назначаем активити при присоединении фрагмента к активити
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null; // обнуляем ссылку при отсоединении фрагмента от активити
    }

    public interface OnBackButtonClickListener {
        void onBackButtonClicked(String message);
    }
}

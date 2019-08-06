package ru.job4j.uifragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstFragment extends Fragment {
    private Button buttonNextFragment;
    private OnNextButtonClickListener callback;
    TextView textViewMsg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        buttonNextFragment = view.findViewById(R.id.next_fragment);
        textViewMsg = view.findViewById(R.id.messageFromSecond);
        if (getArguments() != null) {
            String message = getArguments().getString("message");
            textViewMsg.setText(message);
        }
        buttonNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback. onNextButtonClicked("Greetings from first fragment");
            }
        });
        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (OnNextButtonClickListener) context; // назначаем активити при присоединении фрагмента к активити
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null; // обнуляем ссылку при отсоединении фрагмента от активити
    }
    public interface OnNextButtonClickListener {
        void onNextButtonClicked(String message);
    }
}


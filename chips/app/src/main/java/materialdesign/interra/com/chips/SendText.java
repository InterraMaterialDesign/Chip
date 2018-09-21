package materialdesign.interra.com.chips;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.button.MaterialButton;
import android.support.design.chip.Chip;
import android.support.design.chip.ChipGroup;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;


public class SendText extends BottomSheetDialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private boolean checkJoe = true;
    private boolean checkJane = true;

    public SendText() {
        // Required empty public constructor
    }

    public static SendText newInstance(String param1, String param2) {
        SendText fragment = new SendText();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_text, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Chip joe = new Chip(view.getContext());
        joe.setText(R.string.joe_doe);
        joe.setChipIconResource(R.drawable.boy);
        joe.setCloseIconVisible(true);

        final Chip jane = new Chip(view.getContext());
        jane.setText(R.string.jane_doe);
        jane.setChipIconResource(R.drawable.girl1);
        jane.setCloseIconVisible(true);

        final ChipGroup chipGroup = view.findViewById(R.id.chipGroup);
        final AutoCompleteTextView editText = view.findViewById(R.id.editText);

        final ArrayList<String> person = new ArrayList<>();
        person.add("Jane Doe");
        person.add("Janr Doe");



        final ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, person);
        editText.setAdapter(adapter);

        editText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (checkJoe && "Jane Doe".equals(parent.getItemAtPosition(position))) {
                    chipGroup.addView(jane);
                    checkJoe = false;

                } else if(checkJane && "Janr Doe".equals(parent.getItemAtPosition(position))){
                    chipGroup.addView(joe);
                    checkJane = false;
                }
                editText.setText("");
            }
        });
        

        joe.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chipGroup.removeView(joe);
                checkJoe = true;
            }
        });

        jane.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chipGroup.removeView(jane);
                checkJane = true;
            }
        });

        MaterialButton sendButton = view.findViewById(R.id.materialSendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStop();
            }
        });
    }
}

/*
        editText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
* */
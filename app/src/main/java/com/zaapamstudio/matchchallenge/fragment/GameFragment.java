package com.zaapamstudio.matchchallenge.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zaapamstudio.matchchallenge.activity.GameActivity;
import com.zaapamstudio.matchchallenge.utils.CountDownTimerPausable;
import com.zaapamstudio.matchchallenge.R;
import com.zaapamstudio.matchchallenge.view.NumberButton;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GameFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final int DEFAULT_NUMBER = -9999;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private NumberButton btnNumber1;
    private NumberButton btnNumber2;
    private NumberButton btnNumber3;
    private NumberButton btnNumber4;
    private NumberButton btnPlus;
    private NumberButton btnMinus;
    private NumberButton btnMultiply;
    private NumberButton btnDivine;
    private NumberButton btnInput1;
    private NumberButton btnInput2;
    private NumberButton btnInputOperator;

    private ImageButton btnPause;

    private TextView tvTimer;
    private int timeCounter = 0;
    private int[] slots;
    private NumberButton[] numberActive;
    private boolean  operatorActive;

    private CountDownTimerPausable timer;
    private Random random;


    private IFragmentInteractListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameFragment newInstance() {
        GameFragment fragment = new GameFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public GameFragment() {
        // Required empty public constructor
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
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        initInstance(rootView);
        return rootView;
    }

    private void initInstance(View rootView) {
        random = new Random();
        slots = new int[]{0, 0, 0, 0};
        numberActive = new NumberButton[2];
        operatorActive = false;

        btnNumber1 = (NumberButton) rootView.findViewById(R.id.btnNumber1);
        btnNumber2 = (NumberButton) rootView.findViewById(R.id.btnNumber2);
        btnNumber3 = (NumberButton) rootView.findViewById(R.id.btnNumber3);
        btnNumber4 = (NumberButton) rootView.findViewById(R.id.btnNumber4);
        btnPlus = (NumberButton) rootView.findViewById(R.id.btnPlus);
        btnMinus = (NumberButton) rootView.findViewById(R.id.btnMinus);
        btnMultiply = (NumberButton) rootView.findViewById(R.id.btnMultiply);
        btnDivine = (NumberButton) rootView.findViewById(R.id.btnDevine);
        btnInput1 = (NumberButton) rootView.findViewById(R.id.btnInput1);
        btnInput2 = (NumberButton) rootView.findViewById(R.id.btnInput2);
        btnInputOperator = (NumberButton) rootView.findViewById(R.id.btnInputOperator);
        tvTimer = (TextView) rootView.findViewById(R.id.tvTimer);
        btnPause = (ImageButton) rootView.findViewById(R.id.btnPause);

        btnPlus.setText(NumberButton.CHAR_PLUS);
        btnMinus.setText(NumberButton.CHAR_MINUS);
        btnMultiply.setText(NumberButton.CHAR_MULTIPLY);
        btnDivine.setText(NumberButton.CHAR_DEVINE);
        btnNumber1.setNumber(getRandomNumber());
        btnNumber2.setNumber(getRandomNumber());
        btnNumber3.setNumber(getRandomNumber());
        btnNumber4.setNumber(getRandomNumber());
        slots[0] = btnNumber1.getNumber();
        slots[1] = btnNumber2.getNumber();
        slots[2] = btnNumber3.getNumber();
        slots[3] = btnNumber4.getNumber();

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });

        btnNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInputNumber(btnNumber1);
            }
        });

        btnNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInputNumber(btnNumber2);
            }
        });

        btnNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInputNumber(btnNumber3);
            }
        });

        btnNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInputNumber(btnNumber4);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInputOperator(btnPlus);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInputOperator(btnMinus);
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInputOperator(btnMultiply);
            }
        });

        btnDivine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setInputOperator(btnDivine);
            }
        });

        start();
    }

    private int getRandomNumber() {
        return random.nextInt(8) + 1;
    }

    private void setInputNumber(NumberButton number) {
        if (btnInput1.isEnable() == false) {
            btnInput1.setNumber(number.getNumber());
            btnInput1.setEnable(true);
            numberActive[0] = number;
        } else {
            btnInput2.setNumber(number.getNumber());
            btnInput2.setEnable(true);
            numberActive[1] = number;
        }
    }

    private void setInputOperator(NumberButton operator) {
        btnInputOperator.setText(operator.getText());
        operatorActive = true;
    }

    private void start() {
        Log.e("Test", "Start");
        timer = new CountDownTimerPausable(1000 * 9999, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeCounter++;
                Log.e("Test", "Counter : " + timeCounter);
                int sec = (int)(timeCounter % 60);
                int min = (int)(timeCounter / 60);
                tvTimer.setText(String.format("%02d:%02d", min, sec));
            }

            @Override
            public void onFinish() {
                Log.e("Test", "Finish");
            }
        };
        timer.start();
    }

    private void pause() {
        timer.pause();

        mListener.OnFragmentInteract(GameActivity.STATE_PAUSE);
    }

    public void resume() {
        timer.start();
    }

    private void reset() {

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            //mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (IFragmentInteractListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}

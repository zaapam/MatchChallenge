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
import android.widget.TextView;

import com.zaapamstudio.matchchallenge.utils.CountDownTimerPausable;
import com.zaapamstudio.matchchallenge.R;
import com.zaapamstudio.matchchallenge.view.NumberButton;

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
    private TextView tvTimer;
    private int timeCounter = 0;

    private CountDownTimerPausable timer;


    private OnFragmentInteractionListener mListener;

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
        btnNumber1 = (NumberButton) rootView.findViewById(R.id.btnNumber1);
        btnNumber2 = (NumberButton) rootView.findViewById(R.id.btnNumber2);
        btnNumber3 = (NumberButton) rootView.findViewById(R.id.btnNumber3);
        btnNumber4 = (NumberButton) rootView.findViewById(R.id.btnNumber4);
        btnPlus = (NumberButton) rootView.findViewById(R.id.btnPlus);
        btnMinus = (NumberButton) rootView.findViewById(R.id.btnMinus);
        btnMultiply = (NumberButton) rootView.findViewById(R.id.btnMultiply);
        btnDivine = (NumberButton) rootView.findViewById(R.id.btnDevine);
        tvTimer = (TextView) rootView.findViewById(R.id.tvTimer);

        btnPlus.setText("+");
        btnMinus.setText("-");
        btnMultiply.setText("*");
        btnDivine.setText("/");
        btnNumber1.setText("3");
        btnNumber2.setText("13");
        btnNumber3.setText("123");
        btnNumber4.setText("1783");

        start();
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            //mListener = (OnFragmentInteractionListener) activity;
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

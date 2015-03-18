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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.zaapamstudio.matchchallenge.R;
import com.zaapamstudio.matchchallenge.activity.GameActivity;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.zaapamstudio.matchchallenge.fragment.GameStartFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link com.zaapamstudio.matchchallenge.fragment.GameStartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameStartFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageView imgNumber;
    private int counter = 5;
    private Animation animation;

    private IFragmentInteractListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameStartFragment newInstance() {
        GameStartFragment fragment = new GameStartFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public GameStartFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_game_start, container, false);
        initInstance(rootView);
        return rootView;
    }

    private void initInstance(View rootView) {
        imgNumber = (ImageView) rootView.findViewById(R.id.imgNumber);
        imgNumber.setTag(0);

        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_in);
        //animation.setRepeatCount(2);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                switch ((int)imgNumber.getTag()) {
                    case 0:
                        imgNumber.setTag(R.drawable.number_3);
                        break;
                    case R.drawable.number_3:
                        //imgNumber.startAnimation(animation);
                        imgNumber.setImageResource(R.drawable.number_2);
                        imgNumber.setTag(R.drawable.number_2);
                        break;
                    case R.drawable.number_2:
                        imgNumber.setImageResource(R.drawable.number_1);
                        imgNumber.setTag(R.drawable.number_1);
                        //imgNumber.startAnimation(animation);
                        break;
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //counter--;

                //Log.e("MC", "Prestart counter : " + counter);

                if ((int)imgNumber.getTag() == R.drawable.number_1) {
                    imgNumber.clearAnimation();
                    mListener.OnFragmentInteract(GameActivity.STATE_START_END);
                } else {
                    imgNumber.clearAnimation();
                    imgNumber.startAnimation(animation);
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imgNumber.startAnimation(animation);
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

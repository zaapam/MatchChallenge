package com.zaapamstudio.matchchallenge.activity;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.zaapamstudio.matchchallenge.R;
import com.zaapamstudio.matchchallenge.fragment.GameFragment;
import com.zaapamstudio.matchchallenge.fragment.GamePauseFragment;
import com.zaapamstudio.matchchallenge.fragment.IFragmentInteractListener;

public class GameActivity extends ActionBarActivity implements IFragmentInteractListener {

    public static final String STATE_PAUSE = "pause";
    public static final String STATE_PLAY = "play";
    public static final String STATE_RESUME = "resume";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                                       .add(R.id.container, GameFragment.newInstance(), "GameFragment")
                                       .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnFragmentInteract(String text) {
        switch (text) {
            case STATE_PAUSE:
                getSupportFragmentManager().beginTransaction()
                                           .add(R.id.container, GamePauseFragment.newInstance(), "GamePauseFragment")
                                           .commit();
                break;
            case STATE_RESUME:
                getSupportFragmentManager().beginTransaction()
                                           .remove(getSupportFragmentManager().findFragmentByTag("GamePauseFragment"))
                                           .commit();
                ((GameFragment)getSupportFragmentManager().findFragmentByTag("GameFragment")).resume();
                break;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_game, container, false);
            return rootView;
        }
    }
}

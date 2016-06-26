package xyz.phyoekhant.harthapadaythar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import xyz.phyoekhant.harthapadaythar.R;
import xyz.phyoekhant.harthapadaythar.fragments.JokeFragment;
import xyz.phyoekhant.harthapadaythar.utils.JokeTellerConstants;

public class MainActivity extends AppCompatActivity {

    private FrameLayout flContainer;
    private Button btnPreviousJoke;
    private Button btnNextJoke;

    private int jokeIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        flContainer = (FrameLayout) findViewById(R.id.fl_container);

        if (savedInstanceState == null) {
            jokeIndex++;
            JokeFragment fragment = JokeFragment.newInstance(jokeIndex);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();

        }
        btnNextJoke = (Button) findViewById(R.id.btn_next_joke);
        btnNextJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jokeIndex++;
                if (jokeIndex < JokeTellerConstants.TOTAL_JOKES) {
                    JokeFragment fragment = JokeFragment.newInstance(jokeIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();

                } else {
                    jokeIndex = JokeTellerConstants.TOTAL_JOKES - 1;
                    Toast.makeText(getApplicationContext(), R.string.msg_no_more_joke, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnPreviousJoke = (Button) findViewById(R.id.btn_previous_joke);
        btnPreviousJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jokeIndex--;
                if (jokeIndex >= 0) {
                    JokeFragment fragment = JokeFragment.newInstance(jokeIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();
                } else {
                    jokeIndex = 0;
                    Toast.makeText(getApplicationContext(), R.string.msg_no_more_joke, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}

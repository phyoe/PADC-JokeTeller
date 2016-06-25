package xyz.phyoekhant.harthapadaythar.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import xyz.phyoekhant.harthapadaythar.HarthaPadaytharApp;
import xyz.phyoekhant.harthapadaythar.R;
import xyz.phyoekhant.harthapadaythar.fragments.Joke1Fragment;
import xyz.phyoekhant.harthapadaythar.fragments.Joke2Fragment;
import xyz.phyoekhant.harthapadaythar.fragments.Joke3Fragment;

public class MainActivity extends AppCompatActivity {

    private static String current = "joke1";
    private static String MESSAGE = "ဟာသမ\u103Bားမရ\u103Eိတော့ပ\u102B။";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button btnPrevious = (Button) findViewById(R.id.btn_previous);
        final Button btnNext = (Button) findViewById(R.id.btn_next);

        if (findViewById(R.id.fl_container) != null) {
            Joke1Fragment fragment = new Joke1Fragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }

        String current_current = MainActivity.current;
        if (current_current == "joke1") {
            btnPrevious.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }else{
            btnPrevious.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
        if (current_current == "joke3") {
            btnNext.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }else{
            btnNext.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String current_current = MainActivity.current;

                btnNext.setBackgroundColor(getResources().getColor(R.color.colorAccent));

                /**
                 *
                 * Current is Joke1.
                 * Set color gray because it cannot be previous.
                 * Still in Joke1
                 *
                 */
                if (current_current == "joke1") {

                    btnPrevious.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                    Joke1Fragment fragment = new Joke1Fragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();

                    Toast.makeText(getApplicationContext(), MainActivity.MESSAGE, Toast.LENGTH_SHORT).show();
                }
                /**
                 *
                 * Current is Joke2.
                 * Set color accent because it can be previous.
                 * Previous to Joke1
                 * Reset color gray because Joke1 cannot be previous.
                 *
                 */
                else if (current_current == "joke2") {

                    MainActivity.current = "joke1";

                    Joke1Fragment fragment = new Joke1Fragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();

                    btnPrevious.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                }
                /**
                 *
                 * Current is Joke3.
                 * Set color accent because it can be previous.
                 * Previous to Joke2
                 *
                 */
                else if (current_current == "joke3") {

                    MainActivity.current = "joke2";

                    Joke2Fragment fragment = new Joke2Fragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();

                    btnPrevious.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                }

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String current_current = MainActivity.current;

                btnPrevious.setBackgroundColor(getResources().getColor(R.color.colorAccent));

                /**
                 *
                 * Current is Joke1.
                 * Set color accent because it can be next.
                 * Next to Joke2
                 *
                 */
                if (current_current == "joke1") {
                    btnNext.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    MainActivity.current = "joke2";
                    Joke2Fragment fragment = new Joke2Fragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();

                }
                /**
                 *
                 * Current is Joke2.
                 * Set color accent because it can be next.
                 * Next to Joke3
                 * Reset color gray because Joke3 cannot be next.
                 *
                 */
                else if (current_current == "joke2") {
                    MainActivity.current = "joke3";
                    Joke3Fragment fragment = new Joke3Fragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();
                    btnNext.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                }
                /**
                 *
                 * Current is Joke3.
                 * Set color gray because it cannot be next.
                 * Still in Joke3
                 *
                 */
                else if (current_current == "joke3") {
                    btnNext.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                    Joke3Fragment fragment = new Joke3Fragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();

                    Toast.makeText(getApplicationContext(), MainActivity.MESSAGE, Toast.LENGTH_SHORT).show();
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

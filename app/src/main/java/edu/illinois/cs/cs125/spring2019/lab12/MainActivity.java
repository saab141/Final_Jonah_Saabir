package edu.illinois.cs.cs125.spring2019.lab12;

import android.drm.DrmStore;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Main class for our UI design lab.
 */
public final class MainActivity extends AppCompatActivity {
    /**
     * Default logging tag for messages from the main activity.
     */
    private static final String TAG = "Final Project";

    /**
     * Request queue for our API requests.
     */
    private char operator;
    private TextView output;
    private EditText first;
    private EditText second;
    /**
     * Run when this activity comes to the foreground.
     *
     * @param savedInstanceState unused
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        TextView ans = findViewById(R.id.answer);

        final MediaPlayer calcsound = MediaPlayer.create(this, R.raw.media);
        final MediaPlayer beeps = MediaPlayer.create(this, R.raw.beep2);




        final Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                calcsound.start();
                Log.d(TAG, "solve!");
                double hold = solution();
                String[] arr = new String[1];
                String answerAsString = Double.toString(hold);
                arr[0] = answerAsString;
                ans.setText(arr[0]);

            }
        });
        final Button plus = findViewById(R.id.Plus);
        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                beeps.start();
                Log.d(TAG, "plus!");
                operator = '+';
            }
        });

        final Button minus = findViewById(R.id.Minus);
        minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                beeps.start();
                Log.d(TAG, "minus!");
                operator = '-';
            }
        });
        final Button divide = findViewById(R.id.Div);
        divide.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                beeps.start();
                Log.d(TAG, "divide!");
                operator = '/';
            }
        });
        final Button mult = findViewById(R.id.Mult);
        mult.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                beeps.start();
                Log.d(TAG, "multiply!");
                operator = '*';
            }
        });
        final Button sqrt = findViewById(R.id.sqrt);
        sqrt.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                beeps.start();
                Log.d(TAG, "root!");
                operator = '√';
            }
        });
        final Button log = findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                beeps.start();
                Log.d(TAG, "log!");
                operator = 'l';
            }
        });
    }
    /**
     * Run when this activity is no longer visible.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    public double solution() {
        if (operator == 'l') {
            return Math.log(Integer.parseInt(first.getText().toString()));
        }
        if (operator == '√') {
            return Math.sqrt(Integer.parseInt(first.getText().toString()));
        }
        if (operator == '+') {
            return Integer.parseInt(first.getText().toString())
                    + Integer.parseInt(second.getText().toString());
        } else if (operator == '-') {
            return Integer.parseInt(first.getText().toString())
                    - Integer.parseInt(second.getText().toString());
        } else if (operator == '*') {
            return Integer.parseInt(first.getText().toString())
                    * Integer.parseInt(second.getText().toString());
        } else if (operator == '/') {
            double one = (double) Integer.parseInt(first.getText().toString());
            double two = (double) Integer.parseInt(second.getText().toString());
            return one / two;

        } else {
            return 0.0;
        }
    }
}
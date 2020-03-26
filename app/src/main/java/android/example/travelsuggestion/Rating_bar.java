package android.example.travelsuggestion;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Rating;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.internal.service.Common;
import com.stepstone.apprating.AppRatingDialog;
import com.stepstone.apprating.listener.RatingDialogListener;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class Rating_bar extends AppCompatActivity implements RatingDialogListener {

    // create objects
    TextView rateCount, showRating;
    EditText review;
    Button submit;
    RatingBar ratingBar;
    float rateValue; String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        // initialise the objects
        rateCount = findViewById(R.id.rateCount);
        ratingBar = findViewById(R.id.ratingBar);
        review = findViewById(R.id.review);
        submit = findViewById(R.id.submitBtn);
        showRating = findViewById(R.id.showRating);

        // assign OnClickListener to submit button
        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                // call showRating method when submit button is clicked
                showRatingDialog();

            }


            private void showRatingDialog() {
                new AppRatingDialog.Builder()
                        .setPositiveButtonText("Submit")
                        .setNegativeButtonText("Cancel")
                        .setNoteDescriptions(Arrays.asList("Bad","Ok","Good","Very Good", "Excellent"))
                        .setDefaultRating(1)
                        .setTitle("Rate our App!")
                        .setDescription("We appreciate your feedback!")
                        .setTitleTextColor(R.color.colorPrimary)
                        .setDescriptionTextColor(R.color.colorPrimary)
                        .setHint("Please write your comment here..")
                        .setHintTextColor(R.color.colorAccent)
                        .setCommentTextColor(android.R.color.white)
                        .setCommentBackgroundColor(R.color.colorPrimaryDark)
                        .setWindowAnimation(R.style.RatingDialogFadeAnim)
                        .create(Rating_bar.this)
                        .show();
            }
        });



    };

    @Override
    public void onNegativeButtonClicked() {

        Toast.makeText(getApplicationContext(),"Cancelled",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onPositiveButtonClicked(int rating, @NotNull String comments) {
        //Get Rating and upload to server

        new PostDataTask().execute("http://172.31.82.136:3000/Rating/" + rating + "/" + comments );
        Toast.makeText(getApplicationContext(),"Thank you for giving us your feedback!",Toast.LENGTH_SHORT).show();
    }



}
class PostDataTask extends AsyncTask<String, Void, String> {


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            return postData(params[0]);
        } catch (IOException ex) {
            return "Network error !";
        } catch (JSONException ex) {
            return "Data Invalid !";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        //mResult.setText(result);
    }

    private String postData(String urlPath) throws IOException, JSONException {

        StringBuilder result = new StringBuilder();
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;

        try {
            JSONObject dataToSend = new JSONObject();
            dataToSend.put("email", "value1");
            dataToSend.put("name", "value2");
            dataToSend.put("active", true);

            URL url = new URL(urlPath);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            OutputStream outputStream = urlConnection.getOutputStream();
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(dataToSend.toString());
            bufferedWriter.flush();

            InputStream inputStream = urlConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append("\n");
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }

        return result.toString();
    }
}



package android.example.travelsuggestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONParse extends AppCompatActivity {

    private TextView txtResult;
    private Button btnParse;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonparse);

        txtResult = findViewById(R.id.textResult);
        btnParse = findViewById(R.id.button_parse);

    }



    public void Test(View view) {
        //make GET request when button is pressed
        new GetDataTask().execute("http://172.31.82.136:3000/Countries/1");

    }

    class GetDataTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            try {
                return getData(params[0]);
            } catch (IOException | JSONException ex) {
                return "Network error !";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                JSONArray json = new JSONArray(result);

                for(int i = 0; i < result.length(); i++){
                    JSONObject e = json.getJSONObject(i);

                    int id = e.getInt("ID");
                    String country = e.getString("Country");
                    String keyword1 = e.getString("Keyword1");
                    String keyword2 = e.getString("Keyword2");
                    String keyword3 = e.getString("Keyword3");
                    String attractions = e.getString("Attractions");
                    String summary = e.getString("Summary");
                    String weather = e.getString("weather");

                    txtResult.setText("ID: " + String.valueOf(id) + "\n Name: " + country + " \n Keywords: " + keyword1 + ", " + keyword2 + ", " + keyword3 + "\n" + "Summary: " + summary + "\n" + "Attractions: " + attractions + "\n\n\n");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }


        private String getData(String urlPath) throws IOException, JSONException {
            StringBuilder result = new StringBuilder();
            BufferedReader bufferedReader = null;


            try {
                URL url = new URL(urlPath);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setReadTimeout(10000);
                urlConnection.setConnectTimeout(10000);
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.connect();

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
            }


            return result.toString();


        }

    }
}

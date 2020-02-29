package android.example.travelsuggestion;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import androidx.annotation.RequiresApi;


public class afterselection extends selection {
    private TextView mResult;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterselection);
        mResult = findViewById(R.id.Results);


        // System.out.println(keywords);
      //  System.out.println(test);

        String keyword1 =  keywords.get(0);
        String keyword2 = keywords.get(1);
       // String keyword3 = keywords.get(2);
      // System.out.println(keyword1);
       // System.out.println(keyword2);
       // System.out.println(keyword3);

        new afterselection.GetDataTask().execute("http://172.31.82.136:3000/Search/" + keyword1 + "/" + keyword2);

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
            mResult.setText(result);
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

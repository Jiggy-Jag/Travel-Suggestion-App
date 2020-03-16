package android.example.travelsuggestion;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.RequiresApi;

import static android.example.travelsuggestion.SelectionButtons.keywords;
import static android.example.travelsuggestion.SelectionButtons.selected_shopping;
import static android.example.travelsuggestion.SelectionButtons.selected_culture;
import static android.example.travelsuggestion.SelectionButtons.selected_sightseeing;
import static android.example.travelsuggestion.SelectionButtons.selected_Wildlife;
import static android.example.travelsuggestion.SelectionButtons.selected_Beaches;
import static android.example.travelsuggestion.SelectionButtons.selected_Scenic_views;
import static android.example.travelsuggestion.SelectionButtons.selected_Island;
import static android.example.travelsuggestion.SelectionButtons.selected_Romantic;
import static android.example.travelsuggestion.SelectionButtons.selected_Adventures;


public class afterselection extends selection {
    private TextView title,txt_summary,txt_attractions;
    static private Random rand;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterselection);
        title = findViewById(R.id.name);
        txt_summary = findViewById(R.id.txt_summary);
        txt_attractions = findViewById(R.id.txt_attractions);

        String keyword1 = keywords.get(0);

        if (keywords.size() == 2 ){
            String keyword2 = keywords.get(1);
            new afterselection.GetDataTask().execute("http://172.31.82.136:3000/Search/" + keyword1 + "/" + keyword2);
        }
else {
            new afterselection.GetDataTask().execute("http://172.31.82.136:3000/Search/" + keyword1 + "/" );
        }


    }




    @Override
    public void onBackPressed() {

        //Reset values of previous
        super.onBackPressed();
        keywords.clear();
        selected_shopping.setBackgroundColor(Color.parseColor("#CACFD2"));
        selected_culture.setBackgroundColor(Color.parseColor("#CACFD2"));
        selected_sightseeing.setBackgroundColor(Color.parseColor("#CACFD2"));
        selected_Wildlife.setBackgroundColor(Color.parseColor("#CACFD2"));
        selected_Beaches.setBackgroundColor(Color.parseColor("#CACFD2"));
        selected_Scenic_views.setBackgroundColor(Color.parseColor("#CACFD2"));
        selected_Island.setBackgroundColor(Color.parseColor("#CACFD2"));
        selected_Romantic.setBackgroundColor(Color.parseColor("#CACFD2"));
        selected_Adventures.setBackgroundColor(Color.parseColor("#CACFD2"));

    }

    public int RandomNumber(int aa, int bb)
    {
        int a = Math.min(aa,bb);
        int b = Math.max(aa,bb);
        if (rand == null)
        {
            rand = new Random();
            rand.setSeed(System.nanoTime());
        }
        int d = b - a + 1;
        int x = rand.nextInt(d) + a;
        return(x);
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


            ArrayList<Integer> idList = new ArrayList<Integer>();//store all the ID's of the countries
            try {
                JSONArray json = new JSONArray(result);
                int random = RandomNumber(1,json.length());
                JSONObject e = json.getJSONObject(random);
                int id = e.getInt("ID");
                String country = e.getString("Country");
                String attractions = e.getString("Attractions");
                String summary = e.getString("Summary");

                title.setText(country);
                txt_summary.setText(summary);
                txt_attractions.setText(attractions);


//                for(int i = 0; i < result.length(); i++){
//                    JSONObject e = json.getJSONObject(i);
//                    idList.add(e.getInt("ID"));
//                    int id = e.getInt("ID");
//                    String weather = e.getString("weather");
//
//                    mResult.append("ID: " + String.valueOf(id) + "\n Name: " + country + " \n Keywords: " + keyword1 + ", " + keyword2 + ", " + keyword3 + "\n" + "Summary: " + summary + "\n" + "Attractions: " + attractions + "\n\n\n");
//                }



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

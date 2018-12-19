package com.example.phakjira.namjai;

//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.Toast;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
//
//import com.google.gson.Gson;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//public class FindOthers extends AppCompatActivity {
//
//    public static final String URL =
//            "http://blog.teamtreehouse.com/api/get_recent_summary/";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        new SimpleTask().execute(URL);
//    }
//
//    private class SimpleTask extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected void onPreExecute() {
//            // Create Show ProgressBar
//        }
//
//        protected String doInBackground(String... urls)   {
//            String result = "";
//            try {
//
//                HttpGet httpGet = new HttpGet(urls[0]);
//                HttpClient client = new DefaultHttpClient();
//
//                HttpResponse response = client.execute(httpGet);
//
//                int statusCode = response.getStatusLine().getStatusCode();
//
//                if (statusCode == 200) {
//                    InputStream inputStream = response.getEntity().getContent();
//                    BufferedReader reader = new BufferedReader
//                            (new InputStreamReader(inputStream));
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        result += line;
//                    }
//                }
//
//            } catch (ClientProtocolException e) {
//
//            } catch (IOException e) {
//
//            }
//            return result;
//        }
//
//        protected void onPostExecute(String jsonString)  {
//            // Dismiss ProgressBar
//            showData(jsonString);
//        }
//    }
//
//    private void showData(String jsonString) {
//        Toast.makeText(this, jsonString, Toast.LENGTH_LONG).show();
//    }
//}

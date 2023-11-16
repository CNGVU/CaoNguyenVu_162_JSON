package com.example.caonguyenvu_162_json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    private ArrayList<Comment> listComment;
    private CommentAdapter commentAdapter;
    private ListView listview_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listComment = new ArrayList<>();
        listview_item = findViewById(R.id.listview_item);

        commentAdapter = new CommentAdapter(MainActivity.this, R.layout.layout_custom_listview, listComment);
        listview_item.setAdapter(commentAdapter);
        new ReadJSON().execute("https://jsonplaceholder.typicode.com/comments");
    }

    private class ReadJSON extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    content.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }catch (IOException e){

            }

            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONArray array = new JSONArray(s);

                for (int i = 0; i< array.length();i++){
                    JSONObject jsonObject = array.getJSONObject(i);
                    String postId = jsonObject.getString("postId");
                    String id = jsonObject.getString("id");
                    String name = jsonObject.getString("name");
                    String email = jsonObject.getString("email");
                    String content = jsonObject.getString("body");

                    Comment comment = new Comment( postId,  id, "Name: "+ name,"Email: "+   email, content);
                    listComment.add(comment);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            commentAdapter.notifyDataSetChanged();
        }
    }
}
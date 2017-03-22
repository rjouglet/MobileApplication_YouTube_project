package fr.esilv.s8.youtube_project;

/**
 * Created by Rem on 19/03/2017.
 */

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * This is the task that will ask YouTube for a list of videos
  */
public class GetYouTubeUserVideosTask implements Runnable {
        public static final String LIBRARY = "Library";
        private final Handler replyTo;
        private final String username;

        public GetYouTubeUserVideosTask(Handler replyTo, String username) {
        this.replyTo = replyTo;
        this.username = username;
    }

    @Override
    public void run() {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpUriRequest request = new HttpGet("https://gdata.youtube.com/feeds/api/videos?author="+username+"&v=2&alt=jsonc");
            HttpResponse response = client.execute(request);
            String jsonString = StreamUtils.convertToString(response.getEntity().getContent());
            JSONObject json = new JSONObject(jsonString);


            JSONArray jsonArray = json.getJSONObject("data").getJSONArray("items");

            // Create a list to store are videos in
            List<Video> videos = new ArrayList<Video>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String title = jsonObject.getString("title");
                String url;
                try {
                    url = jsonObject.getJSONObject("player").getString("mobile");
                } catch (JSONException ignore) {
                    url = jsonObject.getJSONObject("player").getString("default");
                }

                String thumbUrl = jsonObject.getJSONObject("thumbnail").getString("sqDefault");

                videos.add(new Video(title, url, thumbUrl));
            }

            Library lib = new Library(username, videos);
            Bundle data = new Bundle();
            data.putSerializable(LIBRARY, lib);

            Message msg = Message.obtain();
            msg.setData(data);
            replyTo.sendMessage(msg);


        } catch (IOException | JSONException e) {
            }
    }
}
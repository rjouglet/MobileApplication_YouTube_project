package fr.esilv.s8.youtube_project;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class MainActivity extends Activity {
    private VideoListView listView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (VideoListView) findViewById(R.id.videosListView);
    }

    public void getUserYouTubeFeed(View v){
        new GetYouTubeUserVideosTask(responseHandler, "blundellp").run();
    }


    Handler responseHandler = new Handler() {
        public void handleMessage(Message msg) {
            populateListWithVideos(msg);
        };
    };


    private void populateListWithVideos(Message msg) {
        Library lib = (Library) msg.getData().get(GetYouTubeUserVideosTask.LIBRARY);
        listView.setVideos(lib.getVideos());
    }

    @Override
    protected void onStop() {
       responseHandler = null;
        super.onStop();
    }
}
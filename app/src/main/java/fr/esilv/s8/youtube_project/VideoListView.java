package fr.esilv.s8.youtube_project;

/**
 * Created by Rem on 19/03/2017.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;


public class VideoListView extends ListView {

    public VideoListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public VideoListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VideoListView(Context context) {
        super(context);
    }

    public void setVideos(List<Video> videos){
        VideoAdapter adapter = new VideoAdapter(getContext(), videos);
        setAdapter(adapter);
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
    }
}

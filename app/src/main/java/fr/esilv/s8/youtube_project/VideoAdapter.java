package fr.esilv.s8.youtube_project;

/**
 * Created by Rem on 19/03/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * This adapter is used to show our Video objects in a ListView
 */
public class VideoAdapter extends BaseAdapter {
    List<Video> videos;
    private LayoutInflater mInflater;


    public VideoAdapter(Context context, List<Video> videos) {
        this.videos = videos;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return videos.size();
    }

    @Override
    public Object getItem(int position) {
        return videos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
           convertView = mInflater.inflate(R.layout.list_item_user_video, null);
        }

        UrlImageView thumb = (UrlImageView) convertView.findViewById(R.id.userVideoThumbImageView);

        TextView title = (TextView) convertView.findViewById(R.id.userVideoTitleTextView);
        Video video = videos.get(position);
        thumb.setImageDrawable(video.getThumbUrl());
        title.setText(video.getTitle());

        return convertView;
    }
}

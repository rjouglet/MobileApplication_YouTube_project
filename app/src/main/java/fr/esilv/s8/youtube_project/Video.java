package fr.esilv.s8.youtube_project;

/**
 * Created by Rem on 19/03/2017.
 */

import java.io.Serializable;


public class Video implements Serializable {
    // The title of the video
    private String title;
    // A link to the video on youtube
    private String url;
    // A link to a still image of the youtube video
    private String thumbUrl;

    public Video(String title, String url, String thumbUrl) {
        super();
        this.title = title;
        this.url = url;
        this.thumbUrl = thumbUrl;
    }

    public String getTitle(){
        return title;
    }

    public String getUrl() {
        return url;
    }


    public String getThumbUrl() {
        return thumbUrl;
    }
}

package fr.esilv.s8.youtube_project;

/**
 * Created by Rem on 19/03/2017.
 */

import java.io.Serializable;
import java.util.List;

/**
 * This is the 'library' for all the videos
 */
public class Library implements Serializable{
    private String user;
    private List<Video> videos;

    public Library(String user, List<Video> videos) {
        this.user = user;
        this.videos = videos;
    }


    public String getUser() {
        return user;
    }


    public List<Video> getVideos() {
        return videos;
    }
}
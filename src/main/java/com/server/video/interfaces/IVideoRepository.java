package com.server.video.interfaces;

import com.server.video.model.Video;

import java.util.List;
import java.util.Optional;

public interface IVideoRepository {

    public  List<Video> getVideos();

    public Video saveVideo(Video video);

    public void deleteVideo(long id);

    public Video updateVideo(Video video);

    public Optional<Video> getVideoById(Long id);

}

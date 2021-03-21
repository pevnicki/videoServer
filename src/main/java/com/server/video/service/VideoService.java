package com.server.video.service;

import com.server.video.interfaces.IVideoRepository;
import com.server.video.model.Video;
import com.server.video.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService implements IVideoRepository {


    private VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> getVideos() {
        return (List<Video>) videoRepository.findAll();
    }

    @Override
    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public void deleteVideo(long id) {
        videoRepository.deleteById(id);
    }

    @Override
    public Video updateVideo(Video video) {
        Optional<Video> optionalVideo = getVideoById(video.getId());
        Video storedVideo = optionalVideo.get();
        storedVideo.setSeen(video.isSeen());
        return videoRepository.save(storedVideo);
    }

    @Override
    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }
}

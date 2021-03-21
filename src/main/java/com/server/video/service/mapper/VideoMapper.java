package com.server.video.service.mapper;

import com.server.video.model.Video;
import com.server.video.service.dto.VideoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VideoMapper {

    public List<VideoDTO> videoToVideoDTOs(List<Video> videos) {
        return videos.stream()
                .filter(Objects::nonNull)
                .map(this::videoToVideoDTO)
                .collect(Collectors.toList());
    }

    public VideoDTO videoToVideoDTO(Video user) {
        return new VideoDTO(user);
    }

    public List<Video> videoDTOsToVideos(List<VideoDTO> userDTOs) {
        return userDTOs.stream()
                .filter(Objects::nonNull)
                .map(this::videoDTOToVideo)
                .collect(Collectors.toList());
    }

    public Video videoDTOToVideo(VideoDTO userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            Video video = new Video();
            video.setId(userDTO.getId());
            video.setName(userDTO.getName());
            video.setImdb_link(userDTO.getImdb_link());
            video.setSeen(userDTO.isSeen());
            video.setCreatedAt(userDTO.getCreatedAt());
            video.setUpdatedAt(userDTO.getUpdatedAt());
            return video;
        }
    }
}

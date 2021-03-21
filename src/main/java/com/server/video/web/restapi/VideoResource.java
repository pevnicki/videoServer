package com.server.video.web.restapi;

import com.server.video.interfaces.IVideoRepository;
import com.server.video.model.Video;
import com.server.video.service.dto.VideoDTO;
import com.server.video.service.mapper.VideoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(maxAge = 36000)
@RestController()
@RequestMapping(value = "/api/v1/video")
public class VideoResource {

    private IVideoRepository videoService;
    private VideoMapper mapper;

    public VideoResource(IVideoRepository videoService, VideoMapper mapper) {
        this.videoService = videoService;
        this.mapper = mapper;
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody VideoDTO videoDTO) {
        System.out.println(videoDTO);
        Video video = mapper.videoDTOToVideo(videoDTO);
        video = this.videoService.saveVideo(video);
        return new ResponseEntity<Object>(mapper.videoToVideoDTO(video),HttpStatus.OK) ;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVideo(@PathVariable("id") Long id) {
        System.out.println(id);
        videoService.deleteVideo(id);
    }

    @GetMapping()
    public ResponseEntity<?> getVideos() {
        List<VideoDTO> videos = mapper.videoToVideoDTOs(videoService.getVideos());
        return new ResponseEntity<Object>(videos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVideo(@PathVariable("id") Long id, @RequestBody VideoDTO videoDTO) {
        System.out.println(videoDTO);
        videoDTO.setId(id);
        Video video = mapper.videoDTOToVideo(videoDTO);
        videoDTO = mapper.videoToVideoDTO(videoService.updateVideo(video));
        return new ResponseEntity<Object>(videoDTO,HttpStatus.OK);
    }


}

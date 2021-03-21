package com.server.video.service.dto;

import com.server.video.model.Video;

import javax.validation.constraints.Size;
import java.util.Date;

public class VideoDTO {


    private long id;

    @Size(max = 50, min = 5)
    private String name;

    @Size(max = 256)
    private String imdb_link;

    private boolean seen = false;

    private String createdAt;
    private String updatedAt;

    public VideoDTO(Video video){
        this.id = video.getId();
        this.name = video.getName();
        this.imdb_link = video.getImdb_link();
        this.seen = video.isSeen();
        this.createdAt = video.getCreatedAt();
        this.updatedAt = video.getUpdatedAt();
    }

    public VideoDTO() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImdb_link() {
        return imdb_link;
    }

    public void setImdb_link(String imdb_link) {
        this.imdb_link = imdb_link;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imdb_link='" + imdb_link + '\'' +
                ", seen=" + seen +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

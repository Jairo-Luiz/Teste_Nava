package com.example.api.domain.dto;

import java.time.LocalDateTime;

public class MetaDTO {

    private Integer totalRecords;
    private Integer totalPages;
    private LocalDateTime requestDataTime;

    public MetaDTO() {
        this.requestDataTime = LocalDateTime.now();
    }

    public MetaDTO(Integer totalRecords, Integer totalPages, LocalDateTime requestDataTime) {
        this.totalRecords = totalRecords;
        this.totalPages = totalPages;
        this.requestDataTime = requestDataTime;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public LocalDateTime getRequestDataTime() {
        return requestDataTime;
    }

    public void setRequestDataTime(LocalDateTime requestDataTime) {
        this.requestDataTime = requestDataTime;
    }
}
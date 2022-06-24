package com.example.api.domain.dto;

import java.util.List;

public class ResponseListDTO<T> {

    private List<T> data;
    private LinkDTO links;
    private MetaDTO meta;

    public ResponseListDTO() {
    }

    public ResponseListDTO(List<T> data, LinkDTO links, MetaDTO meta) {
        this.data = data;
        this.links = links;
        this.meta = meta;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public LinkDTO getLinks() {
        return links;
    }

    public void setLinks(LinkDTO links) {
        this.links = links;
    }

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }
}
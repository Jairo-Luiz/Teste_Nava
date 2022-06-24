package com.example.api.domain.dto;

public class ResponseDTO<T> {

    private T data;
    private LinkDTO links;
    private MetaDTO meta;

    public ResponseDTO() {
    }

    public ResponseDTO(T data, LinkDTO links, MetaDTO meta) {
        this.data = data;
        this.links = links;
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
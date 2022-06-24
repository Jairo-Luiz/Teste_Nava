package com.example.api.assembler;

import com.example.api.domain.Customer;
import com.example.api.domain.dto.*;
import com.example.api.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CustomerAssembly<D> {

    @Autowired
    private MapperUtil mapperUtil;

    public ResponseDTO<D> toResponseModel(D dto){
        ResponseDTO response = new ResponseDTO();
        response.setData(dto);
        response.setLinks(null);
        response.setMeta(null);
        return response;
    }
    public ResponseListDTO<List<D>> toCollectionModel(Page<Customer> dto){
        ResponseListDTO response = new ResponseListDTO();
        response.setData(mapperUtil.mapList(dto.getContent(), CustomerResponseDTO.class));
        response.setLinks(getLinks(dto.getSize(), dto.getTotalPages(), dto.getNumber()));
        response.setMeta(calculateMeta( dto.getSize(), dto.getTotalPages()));
        return response;
    }

    private LinkDTO getLinks(int size, int pages, int currentPage){

        return new LinkDTO("http://localhost:8080/customers?page="+(currentPage + 1)+"&size=" + size,
                "http://localhost:8080/customers?page="+1+"&size=" + size,
                currentPage <= 0 ? null : "http://localhost:8080/customers?page="+ (currentPage) +"&size=" + size,
                currentPage >= (pages -1) ? null : "http://localhost:8080/customers?page="+ (currentPage + 2) +"&size=" + size,
                "http://localhost:8080/customers?page="+ pages +"&size=" + size);
    }

    private MetaDTO calculateMeta(int size, int page){
        return new MetaDTO(size, page, LocalDateTime.now());
    }
}
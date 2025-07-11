package com.gabriel.springrestspecialist.api.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductPhotoRequest {
    private MultipartFile file;
    private String description;
}

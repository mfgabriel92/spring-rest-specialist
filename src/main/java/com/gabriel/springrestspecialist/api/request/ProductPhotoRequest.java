package com.gabriel.springrestspecialist.api.request;

import com.gabriel.springrestspecialist.core.validation.FileContentType;
import com.gabriel.springrestspecialist.core.validation.FileSize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@Getter
@Setter
public class ProductPhotoRequest {
    @NotNull
    @FileSize("500KB")
    @FileContentType(allowed = { IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
    private MultipartFile file;
    private String description;
}

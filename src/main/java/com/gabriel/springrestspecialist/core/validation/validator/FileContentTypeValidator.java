package com.gabriel.springrestspecialist.core.validation.validator;

import com.gabriel.springrestspecialist.core.validation.FileContentType;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class FileContentTypeValidator implements ConstraintValidator<FileContentType, MultipartFile> {
    private List<String> allowedTypes;

    @Override
    public void initialize(FileContentType constraintAnnotation) {
        allowedTypes = Arrays.asList(constraintAnnotation.allowed());
    }

    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        return value == null || allowedTypes.contains(value.getContentType());
    }
}

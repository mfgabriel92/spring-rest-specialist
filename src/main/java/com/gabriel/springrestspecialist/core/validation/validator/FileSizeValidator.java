package com.gabriel.springrestspecialist.core.validation.validator;

import com.gabriel.springrestspecialist.core.validation.FileSize;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FileSizeValidator implements ConstraintValidator<FileSize, MultipartFile> {
    private DataSize size;

    @Override
    public void initialize(FileSize constraintAnnotation) {
        size = DataSize.parse(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        return value == null || value.getSize() <= size.toBytes();

    }
}

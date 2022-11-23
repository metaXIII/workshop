package com.metaxiii.fr.feigntransfert.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metaxiii.fr.feigntransfert.dto.ErrorDto;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class RetreiveMessageErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        final ErrorDto errorDto;
        try (InputStream bodyIs = response.body()
                .asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            errorDto = mapper.readValue(bodyIs, ErrorDto.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        try {
            throw new Exception(errorDto.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

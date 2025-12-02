package com.example.demo.service.impl;

import com.example.demo.dto.VtoRequest;
import com.example.demo.service.VtoService;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

@Service
public class VtoServiceImpl implements VtoService {

    private final RestClient restClient;

    public VtoServiceImpl() {
        this.restClient = RestClient.builder()
                .baseUrl("https://thenewblack.ai/api/1.1/wf")
                .build();
    }

    @Override
    public String generateVto(VtoRequest request) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("email", request.getEmail());
        formData.add("password", request.getPassword());
        formData.add("model_photo", request.getModelPhoto());
        formData.add("clothing_photo", request.getClothingPhoto());
        formData.add("ratio", request.getRatio());
        formData.add("prompt", "A realistic photo");

        return restClient.post()
                .uri("/vto_stream")
                .contentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA)
                .body(formData)
                .retrieve()
                .body(String.class);
    }
}

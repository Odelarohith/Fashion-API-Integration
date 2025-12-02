package com.example.demo;

import com.example.demo.dto.VtoRequest;
import com.example.demo.service.VtoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vto")
public class VtoController {

    private final VtoService vtoService;

    public VtoController(VtoService vtoService) {
        this.vtoService = vtoService;
    }

    @PostMapping
    public String generateVto(@RequestBody VtoRequest request) {
        return vtoService.generateVto(request);
    }
}

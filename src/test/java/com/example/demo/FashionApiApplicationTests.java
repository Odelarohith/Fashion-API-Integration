package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FashionApiApplicationTests {

	@Autowired
	private MockMvc mvc;

	@org.springframework.boot.test.mock.mockito.MockBean
	private com.example.demo.service.VtoService vtoService;

	@Test
	void generateVto() throws Exception {
		com.example.demo.dto.VtoRequest request = new com.example.demo.dto.VtoRequest();
		request.setEmail("test@test.com");
		request.setPassword("password");
		request.setModelPhoto("http://example.com/model.jpg");
		request.setClothingPhoto("http://example.com/clothing.jpg");
		request.setRatio("auto");

		org.mockito.Mockito
				.when(vtoService.generateVto(org.mockito.ArgumentMatchers.any(com.example.demo.dto.VtoRequest.class)))
				.thenReturn("http://example.com/result.png");

		mvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post("/api/vto")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(
						"{\"email\":\"test@test.com\",\"password\":\"password\",\"modelPhoto\":\"http://example.com/model.jpg\",\"clothingPhoto\":\"http://example.com/clothing.jpg\",\"ratio\":\"auto\"}"))
				.andExpect(status().isOk())
				.andExpect(content().string("http://example.com/result.png"));
	}

}

package com.motivationalq.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.motivationalq.dto.ProductRequest;
import com.motivationalq.dto.ProductResponse;
import com.motivationalq.model.Product;
import com.motivationalq.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class ProductController {

	@Autowired
	private final ProductService productService;

	@PostMapping("/createproduct")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductRequest productRequest) {
		productService.createProduct(productRequest);
	}

	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<ProductResponse> updateProduct(@PathVariable("id") String id,
			@RequestBody ProductRequest productRequest) {

		Optional<Product> product = productService.findProductById(id);

		if (product.isPresent()) {
			productService.createProduct(productRequest);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") String id) {
		try {
			productService.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findallproducs")
	public List<ProductResponse> getAllProducts() {
		return productService.getAllProducts();
	}
}

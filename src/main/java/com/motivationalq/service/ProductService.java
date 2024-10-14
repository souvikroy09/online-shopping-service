package com.motivationalq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motivationalq.dto.ProductRequest;
import com.motivationalq.dto.ProductResponse;
import com.motivationalq.model.Product;
import com.motivationalq.repository.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

	@Autowired
	private final ProductRepository productRepository;
	
	public void createProduct(ProductRequest productRequest)
	{
		Product product = Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();
		
		this.productRepository.save(product);
		log.info("Product {} saved successfully",product.getId());
	}
	
	
	public List<ProductResponse> getAllProducts() {

		List<Product> productList = this.productRepository.findAll() ;
		return productList.stream().map(this:: mapToProductResponse).toList();

	}


	private ProductResponse mapToProductResponse(Product product) 
	{ 
		return   ProductResponse.builder() 
				.id(product.getId()) 
				.name(product.getName())
				.description(product.getDescription()) 
				.price(product.getPrice()) 
				.build();

	}

	public Optional<Product> findProductById(String id) {
		
		return productRepository.findById(id);
	}
	
	public void deleteProduct(String id) {
		
		 productRepository.deleteById(id);
	}


}

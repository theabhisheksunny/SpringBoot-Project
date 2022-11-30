package com.springbootproject.productservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springbootproject.productservice.dto.ProductRequest;
import com.springbootproject.productservice.dto.ProductResponse;
import com.springbootproject.productservice.model.Product;
import com.springbootproject.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;
	
	
	public void createProduct(ProductRequest productRequest) {
		Product product = Product.builder()
							.name(productRequest.getName())
							.description(productRequest.getDescription())
							.price(productRequest.getPrice())
							.build();
		
		productRepository.save(product);
		log.info("Product {} is saved",product.getId());
	}


	public List<ProductResponse> getAllProduct() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(this::MapToProductResponse).collect(Collectors.toList());
	}


	private ProductResponse MapToProductResponse(Product product) {
		
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}
}

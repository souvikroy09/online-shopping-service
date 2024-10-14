package com.motivationalq.dto;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import com.motivationalq.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductResponse {
	

	private String id ;
	private String name ;
	private String description;
	private BigDecimal price ;

}

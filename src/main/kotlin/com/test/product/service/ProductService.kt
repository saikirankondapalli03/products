package com.test.product.service

import com.test.product.domain.Product
import com.test.product.repositories.ProductRepository
import org.springframework.stereotype.Service
import java.util.*


@Service
class ProductService(private val productRepository: ProductRepository){

    fun getProducts(): List<Product> {
        return productRepository.findAll().toList();
    }

    fun getProductById(id: String): Optional<Product> {
        if (!isValidId(id)) return Optional.empty();
        return productRepository.findById(id);
    }

    private fun isValidId(id: String): Boolean {
        try{
            id.toInt();
            return true;
        }catch (exception: Exception){
            return false;
        }
    }

}
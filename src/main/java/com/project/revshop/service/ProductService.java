package com.project.revshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.revshop.controller.ViewProductsController;
import com.project.revshop.entity.Category;
import com.project.revshop.entity.Product;
import com.project.revshop.entity.Review;
import com.project.revshop.entity.Size;
import com.project.revshop.repository.CategoryRepository;
import com.project.revshop.repository.ProductRepository;
import com.project.revshop.repository.SizeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private CategoryRepository categoryRepository;
	
    @Autowired
	private ProductRepository productRepository;
    
    @Autowired
    private SizeRepository sizeRepository;
    
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
//    public List<Size> getSizesByCategory(Optional<Category> category) {
//        return sizeRepository.findByCategory(category);
//    }
    
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

	public Optional<Category> getCategoryById(int categoryId) {
	        return categoryRepository.findById(categoryId);
	    }

    public List<Size> getAllSizes(int categoryId) {
	    	Optional<Category> category = categoryRepository.findById(categoryId);
	        return sizeRepository.findByCategory(category);
	    }

	public Size getSizeById(int sizeId) {
			// TODO Auto-generated method stub
			return sizeRepository.getReferenceById(sizeId);
			
		}

	public Product getProductDetails(int productId) {
			// TODO Auto-generated method stub
			return productRepository.getReferenceById(productId);
		}

	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
	}
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId).get();	
	}
	
	public Product findById(int id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		else {
			return null;
		}	
	}
	
//	public double getRating(int id) {
//		Optional<Product> product = productRepository.findById(id);
//		if(product.isPresent()) {
//			List<Review> reviews = product.get().getReviews();
//			int total = 0;
//			int count = 0;
//			for(Review review : reviews) {
//				total += review.getRating();
//				count++;
//			}
//			return total/count;
//		}
//		else {
//			return 0;
//		}	
//	}
	
}


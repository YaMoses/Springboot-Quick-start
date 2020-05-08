package elyamus.springbootstarter.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllTopics() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> getProduct(@PathVariable String id) {
		return productService.getProduct(id);
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) {
		System.out.println(product);
		productService.addProduct(product);
	}
	
	@PutMapping("/products/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable String id) {
		productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable String id) {
		 productService.deleteProduct(id);
	}
	
	
	
}

package com.app.navneet.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.app.navneet.dto.ProductDto;
import com.app.navneet.model.Product;

public class ConvertUtils {
	private static String UPLOADED_FOLDER = "D://temp//";

	public static Product convertDtoProduct(ProductDto product, MultipartFile productImage) {
		Product prod = new Product();
		prod.setPrice(product.getPrice());
		prod.setProductName(product.getProductName());
		prod.setProductDescription("");
		prod.setUnitStock("12");
		prod.setProductManufacturer("abc");
		prod.setProductCategory("AB");
		prod.setImageUrl(productImage.getOriginalFilename());
		try {
			saveUploadedFiles(productImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prod;
	}

	// save file
	private static void saveUploadedFiles(MultipartFile files) throws IOException {
		byte[] bytes = files.getBytes();

		Path path = Paths.get(new StringBuilder().append(UPLOADED_FOLDER).append(System.currentTimeMillis())
				.append(files.getOriginalFilename()).append(".")
				.append(findExtension(files.getOriginalFilename()).get()).toString());
		Files.write(path, bytes);

	}

	public static Optional<String> findExtension(String fileName) {
		int lastIndex = fileName.lastIndexOf('.');
		if (lastIndex == -1) {
			return Optional.empty();
		}
		return Optional.of(fileName.substring(lastIndex + 1));
	}
}

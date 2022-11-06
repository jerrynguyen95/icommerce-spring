package com.icommerce.icommerceproject;

import com.icommerce.icommerceproject.entity.Product;
import com.icommerce.icommerceproject.entity.ProductCategory;
import com.icommerce.icommerceproject.entity.ProductDiscount;
import com.icommerce.icommerceproject.repository.ProductCategoryRepository;
import com.icommerce.icommerceproject.repository.ProductDiscountRepository;
import com.icommerce.icommerceproject.repository.ProductRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class IcommerceprojectApplicationTests {

    @Autowired
    private ProductDiscountRepository productDiscountRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void initCategory() {
        List<ProductCategory> productCategories = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            productCategories.add(ProductCategory.builder()
                    .name(String.format("Category %d", i + 10))
                    .description(String.format("Category description %d", i + 10))
                    .build());
        }

        productCategoryRepository.saveAll(productCategories);
    }

    @Test
    void updateProducts() {

        List<Product> products = productRepository.findAll();

        for (Product product : products) {
            String[] list = {"https://dothotuongphat.net/wp-content/uploads/2022/11/product-1.jpg",
                    "https://dothotuongphat.net/wp-content/uploads/2022/11/product-2.jpg",
                    "https://dothotuongphat.net/wp-content/uploads/2022/11/55c42711fae19faeb3a1b570e43808f9.jpg",
                    "https://dothotuongphat.net/wp-content/uploads/2022/11/8e66a2e16db506e6eebd4f8d1f0e3b93.jpg",
                    "https://dothotuongphat.net/wp-content/uploads/2022/11/d32da9da060dc64248d3fb61bb24c5f7.jpg",
                    "https://dothotuongphat.net/wp-content/uploads/2022/11/9d3a65388de22c00d579498232c43ab1.jpg",
                    "https://dothotuongphat.net/wp-content/uploads/2022/11/309e98d0c002c62b867a00bc639bdbae.jpg",
                    "https://dothotuongphat.net/wp-content/uploads/2022/11/569f5566d9c55f4b3fa34d70e0d5acc3.jpg",
                    "https://dothotuongphat.net/wp-content/uploads/2022/11/1c23ccb76031614584cbdd977e31bd7a.jpg"
            };
            Random r = new Random();
            String s = list[r.nextInt(list.length)];
            product.setImageUrl(s);
        }

        productRepository.saveAll(products);
    }

    @Test
    void updateCategory() {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();

        for (ProductCategory productCategory : productCategories) {
            String[] list = {"Fashion", "Mobile", "Clothes", "Baby", "Handmade"};
            Random r = new Random();
            String s = list[r.nextInt(list.length)];

            productCategory.setName(StringUtils.join(s, new Random().nextInt(list.length), " "));
        }

        productCategoryRepository.saveAll(productCategories);
    }

    @Test
    void initProducts() {
        // Init product
        List<Product> products = new ArrayList<>();

        ProductCategory productCategory1 = productCategoryRepository.getReferenceById(new Random().nextInt(40 - 1) + 1);
        ProductDiscount productDiscount1 = productDiscountRepository.getReferenceById(new Random().nextInt(40 - 1) + 1);
        for (int i = 0; i < 100; i++) {
            int length = 15;
            boolean useLetters = true;
            boolean useNumbers = true;

            String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

            products.add(Product.builder()
                    .SKU(generatedString)
                    .category(productCategory1)
                    .cost(new BigDecimal(RandomStringUtils.randomNumeric(1000)))
                    .description(String.format("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. %d", i))
                    .name(String.format("Product name %d 1", i))
                    .discount(productDiscount1)
                    .imageUrl("https://i.ibb.co/QvYt8KF/product-2.jpg")
                    .quantity(1000 - i)
                    .build());
        }

        productRepository.saveAll(products);
    }

    @Test
    void contextLoads() {
        List<ProductDiscount> productDiscounts = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            productDiscounts.add(ProductDiscount.builder()
                    .name(String.format("Discount %d", i + 10))
                    .description(String.format("Discount description %d", i + 10))
                    .discount(new BigDecimal(i + 10))
                    .build());
        }

        productDiscountRepository.saveAll(productDiscounts);


    }

}

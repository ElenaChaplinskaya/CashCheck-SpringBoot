package com.chaplinskaya.cashCheck.model.repository;

import com.chaplinskaya.cashCheck.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {


}

package io.github.abdulroufsidhu.ambaar.apis.product

import io.github.abdulroufsidhu.ambaar.apis.core.Responser
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Transactional
@RestController
@RequestMapping("/api/products")
@CrossOrigin
class ProductRequests(
    private val productLogic: ProductLogic
) {

    @GetMapping("")
    fun getProducts(product: Product) = Responser.success {
        productLogic.getProductInclusiveId(product)
    }

}
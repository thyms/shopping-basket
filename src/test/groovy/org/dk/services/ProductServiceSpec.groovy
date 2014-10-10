package org.dk.services

import org.dk.models.Product
import org.dk.offers.StandardOffer
import spock.lang.Specification
import spock.lang.Unroll

class ProductServiceSpec extends Specification {

    @Unroll
    def 'Product service should return product date from data source'() {
        given:
        Map productsDatasource = [
                "banana": [
                        "price"    : 20,
                        "offerType": "standard"
                ]
        ]

        ProductService productService = new ProductService(productsDatasource)

        when:
        Product product = productService.getByName('banana')

        then:
        product.price == 20
        product.offer instanceof StandardOffer
    }
}

package org.dk.services

import org.dk.factories.OfferFactory
import org.dk.models.Product

class ProductService {

    // In-Memory DB
    Map productsDatasource = [
            "banana": [
                    "price"    : 20,
                    "offerType": "standard"
            ],
            "apple" : [
                    "price"    : 35,
                    "offerType": "standard"
            ],
            "melon" : [
                    "price"    : 50,
                    "offerType": "buy-one-get-one-free"
            ],
            "lime"  : [
                    "price"    : 15,
                    "offerType": "three-for-the-price-two"
            ]
    ]

    ProductService(Map productsDatasource = null) {
        if (productsDatasource) {
            this.productsDatasource = productsDatasource
        }
    }

    Product getByName(String name) {
        Map productData = productsDatasource[name];
        new Product(name: name, price: productData.price, offer: OfferFactory.getByName(productData.offerType))
    }
}
package org.dk.models

class ShoppingBasket {

    List<Product> products = new ArrayList<Product>();

    void addProduct(Product product) {
        products.add(product)
    }

    Double getTotal() {
        def totalCostPerProductType = products.groupBy { product -> product.name }.collect { productName, products ->
            Product referenceProduct = products[0];
            return referenceProduct.offer.calculateCostFor(referenceProduct.price, products.size())
        }

        def totalCost = 0
        totalCostPerProductType.each { cost ->
            totalCost += cost
        }

        return totalCost
    }
}





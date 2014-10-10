package org.dk.models

import org.dk.services.ProductService
import org.dk.services.ProductServiceSpec
import spock.lang.Specification
import spock.lang.Unroll

class ShoppingBasketSpec extends Specification {

  ShoppingBasket shoppingBasket
  ProductService productService

  def setup() {
    shoppingBasket = new ShoppingBasket()
    productService = new ProductService()
  }

  def 'Total cost should return 0 initially'() {
    expect:
      shoppingBasket.getTotal() == 0
  }

  @Unroll
  def 'Total cost should be calculated correctly with "#scenario" for the given items in the shopping basket'() {
    when:
      products.each { productName ->
        Product product = productService.getByName(productName)
        shoppingBasket.addProduct(product)
      }

    then:
      shoppingBasket.getTotal() == totalCost

    where:
      products                                                                  | totalCost  | scenario
      ['banana']                                                                | 20         | 'standard pricing'
      ['banana', 'apple']                                                       | 55         | 'standard pricing with multiple times'
      ['melon']                                                                 | 50         | 'buy one get one free offer, only one item'
      ['melon', 'melon']                                                        | 50         | 'buy one get one free offer'
      ['lime']                                                                  | 15         | 'three for the price two offer, only one item'
      ['lime', 'lime']                                                          | 30         | 'three for the price two offer, two items'
      ['lime', 'lime', 'lime']                                                  | 30         | 'three for the price two offer'
      ['banana', 'banana', 'apple', 'melon', 'lime', 'melon', 'lime', 'lime']   | 155        | 'a mixture of all pricings'
  }
}

package org.dk

import spock.lang.Specification
import spock.lang.Unroll

class ShoppingCartSpec extends Specification {

  ShoppingCart shoppingCart

  def setup() {
    shoppingCart = new ShoppingCart()
  }

  def 'Total cost should return 0 initially'() {
    expect:
      shoppingCart.getTotal() == 0
  }

  @Unroll
  def 'Total cost should be calculated correctly with "#scenario" for the given items in the shopping cart'() {
    when:
      items.each { item ->
        shoppingCart.addItem(item) 
      }

    then:
      shoppingCart.getTotal() == totalCost

    where:
    items                                                                     | totalCost  | scenario
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

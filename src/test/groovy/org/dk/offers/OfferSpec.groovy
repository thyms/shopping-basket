package org.dk.offers

import spock.lang.Specification
import spock.lang.Unroll

class OfferSpec extends Specification {

    @Unroll
    def "Standard offer should return number of items times the price"() {
        given:
        Offer offer = new StandardOffer()

        expect:
        offer.calculateCostFor(price, numberOfItems) == totalCost

        where:
        price | numberOfItems | totalCost
        25    | 3             | 75
        10    | 5             | 50
        0     | 5             | 0
        10    | 0             | 0
    }

    @Unroll
    def 'Buy to get free offer should return correct total cost for "#scenario" offer'() {
        given:
        Offer offer = new BuyToGetFreeOffer(numberOfItemsToBuy: numberOfItemsToBuy, numberOfItemsToCalculate: numberOfItemsToCalculate)

        expect:
        offer.calculateCostFor(price, numberOfItemsInBasket) == totalCost

        where:
        numberOfItemsToBuy  | numberOfItemsToCalculate | price | numberOfItemsInBasket | totalCost | scenario
        2                   | 1                        | 15    | 2                     | 15        | "buy one get one free"
        3                   | 2                        | 20    | 3                     | 40        | "three for the price two"
    }
}

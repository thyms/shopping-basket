package org.dk.offers

class BuyToGetFreeOffer implements Offer {
    Integer numberOfItemsToBuy
    Integer numberOfItemsToCalculate

    Double calculateCostFor(Double price, Integer numberOfItems) {
        return price * (Math.floor(numberOfItems / numberOfItemsToBuy) * numberOfItemsToCalculate + numberOfItems % numberOfItemsToBuy)
    }
}
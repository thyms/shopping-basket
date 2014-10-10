package org.dk.offers

class StandardOffer implements Offer {
    Double calculateCostFor(Double price, Integer numberOfItems) {
        return price * numberOfItems
    }
}
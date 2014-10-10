package org.dk.factories

import org.dk.offers.BuyToGetFreeOffer
import org.dk.offers.Offer
import org.dk.offers.StandardOffer

class OfferFactory {
    static Offer getByName(name) {
        Offer offer
        switch (name) {
            case "buy-one-get-one-free":
                offer = new BuyToGetFreeOffer(numberOfItemsToBuy: 2, numberOfItemsToCalculate: 1)
                break;
            case "three-for-the-price-two":
                offer = new BuyToGetFreeOffer(numberOfItemsToBuy: 3, numberOfItemsToCalculate: 2)
                break;
            default:
                offer = new StandardOffer()
                break;
        }

        return offer;
    }
}
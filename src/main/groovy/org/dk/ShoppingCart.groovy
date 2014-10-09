package org.dk

class ShoppingCart {

	Map<String, PricingStrategy> productPricingStrategyLookup = [
		"banana": PricingStrategy.STANDARD,
		"apple": PricingStrategy.STANDARD,
		"melon": PricingStrategy.BUY_ONE_GET_ONE_FREE,
		"lime": PricingStrategy.THREE_FOR_THE_PRICE_TWO
	]

	Map<String, Integer> productPricingLookup = [
		"banana": 20,
		"apple": 35,
		"melon": 50,
		"lime": 15
	]

	List<String> items = new ArrayList<String>();

	void addItem(String item) {
		items.add(item)
	}

	Integer getTotal() {
		def totalPricesByItem = items.groupBy { item -> item }.collect { itemName, items ->
			return productPricingStrategyLookup[itemName].calculatePriceFor(items.size(), productPricingLookup[itemName]) 
		}

		def totalCost = 0
		totalPricesByItem.each { price ->
			totalCost += price
		}

		return totalCost
	}
}

enum PricingStrategy {
	STANDARD({ numberOfitems, productPrice -> return numberOfitems * productPrice }),
	BUY_ONE_GET_ONE_FREE({ numberOfitems, productPrice -> Math.ceil(numberOfitems/2) * productPrice }),
	THREE_FOR_THE_PRICE_TWO({ numberOfitems, productPrice -> (Math.floor(numberOfitems/3)*2 + numberOfitems%3) * productPrice })

	def calculatePriceFor

	PricingStrategy(calculatePriceFor) {
		this.calculatePriceFor = calculatePriceFor
	}
}
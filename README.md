Shopping Basket
===============

## Problem
Using any language you like, write a simple program that calculates the price of a basket of shopping. Items are presented one at a time, in a list, identified by name - for example "Apple" or "Banana". Multiple items are present multiple times in the list, so for example ["Apple", "Apple", "Banana"] is a basket with two apples and one banana.

Items are priced as follows:
 - Apples are 35p each
 - Bananas are 20p each
 - Melons are 50p each, but are available as "buy one get one free"
 - Limes are 15p each, but are available in a "three for the price two" offer

Given a list of shopping, calculate the total cost of those items.

## Assumptions
As per mentioned in the problem definition, same type of items are kept separately in the basket.

## Improvements
Product data should be queried from a proper data source, currently an in-memory list is used.

## Run Test
```bash
./gradlew     clean test  # for *nix/OSX
.\gradlew.bat clean test  # for Windows
```

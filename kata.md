# Delivery Date Kata

GnomeCorp, a company manufacturing Garden Gnomes, ships its products to customers within a set number of working days.

Given a purchase date, when can you expect your Gnome to be delivered?

Implement a function `deliveryDate` such that  given a `purchaseDate` it honors each of the constraints below.

## Rules

### 1. Three-Day Delivery

* All deliveries will take 3 days.

### 2. Weekends

Paying couriers to deliver at weekends is too expensive.

* Weekends do not count towards working days.

### 3. Seasonal Deliveries

There's always a rush of orders before Christmas and during the Summer Holidays.

* Orders placed during December will take 5 days.

* Orders placed during July and August will take 4 days.

### 4. Public holidays

Public holidays do not count towards working days.

#### 4.1 Fixed 

* A fixed public holiday occurs on the same date every year.

* A fixed public holiday that takes place during a weekend moves _forward_ to the next available working day.

Examples:
 - Christmas Day: 25th December
 - New Year's Day: 1st January
 - Labour Day: 1st May

#### 4.2 Moving

A moving public holiday does not fall on the same date every year.

Examples:
 - May Day (UK): First Monday in May
 - Thanksgiving (US): Fourth Thursday of November
 
## Objectives

 - What does this kata look like in a functional style? Or Object-Oriented?
 - How would you extend this to honour an arbitrary number of one-off public holidays?
 - How would this kata change if GnomeCorp decided to do business in a country using the [International Fixed Calendar](https://en.wikipedia.org/wiki/International_Fixed_Calendar)?
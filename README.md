# sdpFinal - Сarsharing | Car Rental Management System
SE-2216 | Zharmagambetov Rustem, Ketebay Bakhtiyar, Botagariev Amirkhan

**Project Overview**
The Car Rental Management System is designed to facilitate the rental process for customers, manage available cars, handle pricing strategies, and provide a seamless payment experience. 
This system aims to streamline the rental process, offering multiple car options and flexible rental durations.

**Main Body**
1. Description
The Car Rental Management System is built to address the challenges faced in managing car rentals efficiently.
It allows users to view available cars, rent vehicles, add optional features, calculate rental prices based on different strategies, complete payments, and receive notifications about their bookings.

2. Features Implemented
View Available Cars:
  Users can view a list of cars available for rent.
Rent a Car:
  Users can select a car type and rent it for a specified duration.
Add Optional Features:
  Enhance the rental with optional features like sunroofs or spoilers.
Calculate Rental Price:
  Utilize different pricing strategies (daily, weekly) to calculate rental prices based on duration.
Complete Payment:
  Use an integrated payment system to complete rental payments securely.
Receive Notifications:
  Users are notified about booking confirmations and return dates.

3. Design Patterns Implemented
Singleton Pattern:
  Implemented in the RentalManager class to ensure a single instance for managing rentals.
![image](https://github.com/meytosty/sdpFinal/assets/106843148/bc73ab48-6837-4a72-8a47-38ac6cb1862a)


Strategy Pattern:
  DailyPricingStrategy and WeeklyPricingStrategy for flexible pricing calculation.
![image](https://github.com/meytosty/sdpFinal/assets/106843148/f81d8b4c-aff3-4e92-8f2d-212e87678429)


Observer Pattern:
  Used to notify users about changes in car status or booking confirmation.
![image](https://github.com/meytosty/sdpFinal/assets/106843148/643aebca-658e-47d4-93a1-ac48be4c2fb6)


Decorator Pattern:
  Implemented for adding optional features (e.g., sunroof, spoiler) to rented cars.
![image](https://github.com/meytosty/sdpFinal/assets/106843148/9dd0a228-0c80-4219-a715-5ff30064fc30)


Factory Pattern:
  CarFactory class to create different car types based on user selection.
![image](https://github.com/meytosty/sdpFinal/assets/106843148/adb93fe2-2be7-421a-9c58-76d436858d03)


Adapter Pattern:
  PaymentAdapter integrates the third-party payment service into the system.
![image](https://github.com/meytosty/sdpFinal/assets/106843148/b149e052-4751-4c7e-8a1e-474478b79cc7)


**Conclusion**
The Car Rental Management System effectively leverages various design patterns to enhance modularity, flexibility, and scalability. 
Challenges faced during implementation revolved around integrating external payment services and ensuring seamless notifications. 
Future improvements may include a more robust user authentication system and an expanded range of available cars.

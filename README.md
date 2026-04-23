# Online Event Booking System

A comprehensive Java console application designed to streamline the discovery and booking of various events, including Movies, Concerts, Sports, Standup Comedy and Workshops. This project was developed as a collaborative team effort to demonstrate scalable software design and robust user input validation.

## 🌟 Key Features

* **Multi-Category Event Management:** Specialized handling for different event types:
    * **Movies:** Theater selection, showtime management, and snack add-ons.
    * **Concerts:** Artist-specific details and venue-based pricing.
    * **Sports:** Matches categorized by sport type with stadium-specific seating.
    * **Stand-up Comedy:** Comedian lineups and venue-based ticket tiers.
    * **Workshops:** Skill-based sessions with limited attendee slots.
* **Tiered Ticketing System:** Implements "Gold" and "Silver" seating categories with dynamic price scaling.
* **User Authentication:** Secure login/signup flow to maintain user sessions and booking history.
* **Real-time Availability:** Tracks seat counts for each event to prevent overbooking.
* **Automated Billing:** Generates detailed invoices including base price, tax calculations, and optional add-on costs.

## 🛠️ Technical Implementation

* **Advanced OOP Principles:** Extensive use of **Inheritance** and **Method Overriding** to share common event attributes while maintaining unique category logic.
* **Data Structures:** Utilized arrays and custom objects to manage event lists.
* **Input Robustness:** Implementation of regular expressions (Regex) and loop-based validation to ensure data integrity for mobile numbers, passwords, and menu selections.

## 👥 Collaboration
This was a group project where I focused on:
* The Sports event category.
* Interactive Seating Visualization: Implemented a 2D occupancy matrix to represent the venue layout. The system renders a dynamic seating grid where:
O (Green) represents Available seats and X (Red) represents Reserved seats.
* Collaborating with teammates to integrate separate event modules into a unified system.

## 💻 Execution
1. Compile the main file:
   ```bash
   javac OnlineEventBookingSystem.java
   java Run

# BBD Coffee Application

## Overview

The BBD Coffee Application is designed to enhance the employee experience by reducing wait times at coffee stations and providing real-time availability of coffee options and shakes. This application allows users to log in and conveniently access these features, ensuring they can quickly and efficiently grab their favorite beverages.

## Problem Statement

Employees have expressed concerns about the long wait times at coffee stations, which can be frustrating and time-consuming. Additionally, there is no convenient way to check the availability of coffee options and shakes in real-time. This application aims to solve these issues by providing a platform where employees can:

- View the current availability of coffee and shake options.
- Place orders in advance to minimize wait times.
- Receive notifications when their order is ready.

## Tech Stack Overview

### Database Layer

- **Database:** MySQL
- **Tool:** MySQL Workbench
- **Migration:** Flyway
- **Deployment:** AWS RDS (Relational Database Service)

### Backend Layer

- **Framework:** Java Spring Boot
- **Tool:** IntelliJ IDEA
- **Deployment:** AWS Elastic Beanstalk

### Frontend Layer

- **Framework:** React
- **Tool:** Visual Studio Code
- **Deployment:** AWS CloudFront

## Features

- **Real-Time Availability:** Users can view the current status of coffee and shake options.
- **Order Ahead:** Employees can place orders ahead of time to reduce waiting.
- **User Authentication:** Secure login for employees to access the application.

## Requirements

### Client Side

- **Registration:** Employees can register on the platform by providing their name, last name, default BBD office, and employee number.
- **Office Selection:** Employees can select which office they are in for the day. By default, it uses the registered office setting, but employees can change this if they are working from another office.
- **Menu Access:** Employees will be presented with a menu of available items from the Baristas.
- **Order Placement:** Once an order is placed, it will be sent to the Barista's screen and marked as "Order Pending".
- **Order Tracking:** Employees can check the real time status of their orders.
- **Order Collection:** If an employee does not collect their order, their access to order on the application will be paused for the next day. During this period, they will need to walk to the coffee station if they want coffee.

### Barista Side

- **Login:** Baristas can log in to the application and select which products are available for the day at each of their bases.
- **Ready to Serve:** Baristas can click a "Ready to Serve" button that will open the app for orders to be placed by employees based at that particular office.
- **Order Management:** Once an order is received, Baristas can accept the order and mark it as "In progress".
- **Order Completion:** Once the order is ready, Baristas can update the order status to "Prepared".
- **Automatic Cancellation:** If an order is not collected within an hour, the order will be automatically canceled, and the employee will be banned from using the system for the rest of the day.

### Admin Side

- **Login:** Admin personnel can log in to the application to manage various aspects of the system.
- **Location Management:** Admins can assign new locations to the system and update existing ones.
- **Product Management:** Admins can update the list of available products for different locations.
- **User Management:** Admins can register new users to the system and manage existing user accounts.

## Installation

### Prerequisites

- Node.js
- Java (JDK 8 or higher)
- MySQL
- AWS Account for Deployment

### Database Setup

1. Navigate to the `Database` directory.
2. Run Flyway migrations to set up the database schema.

### Backend Setup

1. Navigate to the `Spring-Boot` directory.
2. Configure the database connection in `application.yaml`.
3. Build and run the Spring Boot application using the following commands
```bash
mvn clean install
mvn spring-boot:run
```

### Frontend Setup

1. Navigate to the `react` directory.
2. Install the required npm packages using the command
```bash
npm install
```
3. Start the React development server.
```bash
npm start
```

### Deployment

- Deploy the backend on AWS Elastic Beanstalk.
- Deploy the frontend on AWS CloudFront.
- Set up the database on AWS RDS.

## Usage

1. Log as an employee, barista, or admin with your unique employee ID.
2. Browse available coffee and shake options, manage orders, or administer the system as required.
3. Place your order or perform administrative tasks as needed.

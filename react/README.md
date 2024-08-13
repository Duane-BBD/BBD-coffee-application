# BBD Coffee Application - Frontend

## Overview

The BBD Coffee Application frontend is built using React, providing a user-friendly interface for employees to access coffee and shake options, place orders, and tract the status of their order.

## Tech Stack Overview

- **Framework:** React
- **Tool:** Visual Studio Code
- **Deployment:** AWS CloudFront

## Features

- **Real-Time Availability:** Users can view the current status of coffee and shake options.
- **Order Ahead:** Employees can place orders ahead of time to reduce waiting.
- **User Authentication:** Secure login for employees to access the application.

## Installation

### Prerequisites

- Node.js

### Frontend Setup

1. Navigate to the `react` directory.
2. Install the required npm packages using the following command:
```bash
   npm install
```
3. Start the React development server:
```bash
   npm start
```
The app will run in development mode. Open `http://localhost:3000` to view it in your browser. The page will reload when you make changes.

### Available Scripts

In the project directory, you can run:

- **`npm start`**: Runs the app in development mode.
- **`npm test`**: Launches the test runner in interactive watch mode.
- **`npm run build`**: Builds the app for production to the `build` folder, optimizing the build for best performance.
- **`npm run eject`**: If you need full control over the configuration.

## Deployment

- Build the app using the following command:
```bash
  npm run build
```
- Deploy the production build on AWS CloudFront.

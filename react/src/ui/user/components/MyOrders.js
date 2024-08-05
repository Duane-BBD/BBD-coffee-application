import React from 'react';
import { Link, useLocation } from 'react-router-dom'; // Import useLocation
import Navbar from './Navbar';
import "../static/MyOrders.css";
import Header from './OrdersHeader';

const MyOrders = () => {
  const location = useLocation(); // Use useLocation to access passed state

  console.log(location.state); // Optional: for debugging, check what is being passed

  return (
    <div>
      <Header />
      <div className="empty-order">
        <p><strong>Your order is empty!</strong></p>
        <p>Add drinks to your order to get started!</p>
        <Link to="/products">
          <button className="view-menu-button">View drinks menu</button>
        </Link>
      </div>
      <div className='navbar-spacing'> 
        <Navbar />
      </div>
    </div>
  );
};

export default MyOrders;

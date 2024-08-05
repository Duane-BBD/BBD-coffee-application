import React from 'react';
import Navbar from './Navbar';
import "../static/MyOrders.css";
import Header from './OrdersHeader';

const MyOrders = () => {
  return (
    <div>
      <Header />
      <div className="empty-order">
        <p><strong> You haven’t made any orders!</strong></p>
        <p>Add drinks to your order to get started! View drinks menu</p>
        <button className="view-menu-button">View drinks menu</button>
      </div>
      <div className='navbar-spacing'> 
        <Navbar />
      </div>
    </div>
  );
};

export default MyOrders;

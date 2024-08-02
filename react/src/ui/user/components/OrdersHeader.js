import React from 'react';
import { Link } from 'react-router-dom';
import '../static/CombinedOrders.css';

const Header = () => {
  return (
    <header>
      <Link to="/place-order">
        <button className="tab">Place an order</button>
      </Link>
      <Link to="/orders">
        <button className="tab active">My orders</button>
      </Link>
    </header>
  );
};

export default Header;

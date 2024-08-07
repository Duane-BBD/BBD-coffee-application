import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import '../static/CombinedOrders.css';

const Header = () => {
    const location = useLocation();
    
    const isActive = (path) => location.pathname === path;

  return (
    <header>
        <Link to="/check-out">
            <button className={`tab ${isActive('/check-out') ? 'active' : ''}`}><strong>Place an order</strong></button>
        </Link>
        <Link to="/my-orders">
            <button className={`tab ${isActive('/my-orders') ? 'active' : ''}`}><strong>My orders</strong></button>
        </Link>
    </header>
  );
};

export default Header;

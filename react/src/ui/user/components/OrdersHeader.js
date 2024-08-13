import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import '../static/OrderHistory.css';

const Header = () => {
    const location = useLocation();
    
    const isActive = (path) => location.pathname === path;

  return (
    <header>
        <Link to="/user/check-out">
            <button 
                className={`tab ${isActive('/user/check-out') ? 'active' : ''}`}
            >
                <strong>Place an order</strong>
            </button>
        </Link>
        <Link to="/user/my-orders">
            <button 
                className={`tab ${isActive('/user/my-orders') ? 'active' : ''}`}
            >
                <strong>My orders</strong>
            </button>
        </Link>
    </header>
  );
};

export default Header;

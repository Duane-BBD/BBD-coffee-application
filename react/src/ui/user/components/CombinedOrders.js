// src/components/CombinedOrders.js
import React from 'react';
import PropTypes from 'prop-types';
import Header from '../components/OrdersHeader';
import '../static/CombinedOrders.css';
import { IoIosArrowDown } from 'react-icons/io';

const OrderStatus = ({ status = 'Unknown' }) => {
  const statusClass = status ? status.toLowerCase() : 'unknown';
  return (
    <span className={`status ${statusClass}`}>
      {status}
    </span>
  );
};

OrderStatus.propTypes = {
  status: PropTypes.string,
};

const OrderItem = ({ id, status }) => {
  return (
    <details className="order-item">
      <summary>
        <div className="order-summary">
          <span>Order Number {id}</span>
          <div className="buttons">
            <OrderStatus status={status} />
            <IoIosArrowDown />
          </div>
        </div>
        <hr className="order-divider" />
      </summary>
      <hr className="order-divider" />
      <p>Additional order details...</p>
    </details>
  );
};

OrderItem.propTypes = {
  id: PropTypes.number.isRequired,
  status: PropTypes.string.isRequired,
};

const CombinedOrders = () => {
  const orders = [
    { id: 1, status: 'Complete' },
    { id: 2, status: 'Complete' },
    { id: 3, status: 'Complete' },
    { id: 4, status: 'Failed' },
    { id: 5, status: 'Unknown' },
  ];

  return (
    <div className="order-list">
      <Header /> {/* Use the Header component */}
      <section>
        <h2>Past orders</h2>
        <hr className="section-divider" />
        {orders.map(order => (
          <OrderItem key={order.id} id={order.id} status={order.status} />
        ))}
      </section>
      <footer>
        <button className="nav-button home">Home</button>
        <button className="nav-button orders active">Orders</button>
      </footer>
    </div>
  );
};

export default CombinedOrders;

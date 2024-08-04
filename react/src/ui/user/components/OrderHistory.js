import React, { useState, useEffect } from 'react';
import '../static/OrderHistory.css';

const OrderHistory = ({ officeID, orderStatusValue="" }) => {
  const [orders, setOrders] = useState([]);
  const [expandedOrderId, setExpandedOrderId] = useState(null);

  useEffect(() => {
    const fetchOrders = async () => {
      try {
        const response = await fetch(`http://localhost:8080/bbd-coffee/barista-display/3/Pending`);
        const data = await response.json();
        
        // Debugging: Check the API response
        console.log('Fetched data:', data);
        
        // Ensure the fetched data is an array
        if (Array.isArray(data)) {
          setOrders(data);
        } else {
          console.error('Unexpected data format:', data);
        }
      } catch (error) {
        console.error('Error fetching orders:', error);
      }
    };

    fetchOrders();
  }, [officeID, orderStatusValue]);

  const toggleOrderDetails = (id) => {
    setExpandedOrderId(expandedOrderId === id ? null : id);
  };

  return (
    <div className="order-history">
      <div className="header">
        <div className="header-item">Place an order</div>
        <div className="header-item active">My orders</div>
      </div>

      <div className="order-section">
        <div className="order-section-title">Orders</div>
        {orders.map(order => (
          <div className="order-item" key={order.orderID}>
            <div className="order-header" onClick={() => toggleOrderDetails(order.orderID)}>
              <span>{`Order #${order.orderID}`}</span>
              <div className={`order-status ${orderStatusValue.toLowerCase()}`}>{orderStatusValue}</div>
              <button>{expandedOrderId === order.orderID ? '▾' : '▸'}</button>
            </div>
            <div className={`order-details ${expandedOrderId === order.orderID ? 'show' : ''}`}>
              <div>
                <p>{`${order.quantity} x ${order.productName}`}</p>
                <p>Milk: {order.milkTypeValue}</p>
                <p>{order.notes ? `Notes: ${order.notes}` : ''}</p>
              </div>
            </div>
          </div>
        ))}
      </div>

      <div className="footer">
        <div className="footer-icon home-icon"></div>
        <div className="footer-icon order-icon active"></div>
      </div>
    </div>
  );
};

export default OrderHistory;

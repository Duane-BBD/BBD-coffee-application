import React, { useState } from 'react';
import '../static/OrderHistory.css';

const orders = [
  {
    id: 1,
    reference: "Order number/reference",
    status: "Complete",
    details: [
      { item: "1 Espresso", milk: "No milk", notes: "Notes: example note for complete order." }
    ],
    isInProgress: false,
  },
  {
    id: 2,
    reference: "Order number/reference",
    status: "Complete",
    details: [
      { item: "2 Cappuccinos", milk: "Whole milk", notes: "Notes: example note for complete order." }
    ],
    isInProgress: false,
  },
  {
    id: 3,
    reference: "Order number/reference",
    status: "Complete",
    details: [
      { item: "1 Latte", milk: "Soy milk", notes: "Notes: example note for complete order." }
    ],
    isInProgress: false,
  },
  {
    id: 4,
    reference: "Order number/reference",
    status: "Failed",
    details: [
      { item: "1 Hot chocolate", milk: "Oat milk", notes: "Notes: example note for failed order." }
    ],
    isInProgress: false,
  },
  {
    id: 5,
    reference: "Order number/reference",
    status: "In progress",
    details: [
      { item: "1 Cappuccino", milk: "Oat milk", notes: "Notes: whatever note was added will be placed here." },
      { item: "3 Hot chocolate", milk: "Oat milk", notes: "Notes: whatever note was added will be placed here." },
    ],
    isInProgress: true,
  }
];

const OrderHistory = () => {
  const [expandedOrderId, setExpandedOrderId] = useState(null);

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
        <div className="order-section-title">Past orders</div>
        {orders.filter(order => !order.isInProgress).map(order => (
          <div className="order-item" key={order.id}>
            <div className="order-header" onClick={() => toggleOrderDetails(order.id)}>
              <span>{order.reference}</span>
              <div className={`order-status ${order.status === 'Failed' ? 'failed' : 'complete'}`}>{order.status}</div>
              <button>{expandedOrderId === order.id ? '▾' : '▸'}</button>
            </div>
            <div className={`order-details ${expandedOrderId === order.id ? 'show' : ''}`}>
              {order.details.map((detail, index) => (
                <div key={index}>
                  <p>{detail.item}</p>
                  <p>Milk: {detail.milk}</p>
                  <p>{detail.notes}</p>
                </div>
              ))}
            </div>
          </div>
        ))}
      </div>

      <div className="order-section">
        <div className="order-section-title">In progress</div>
        {orders.filter(order => order.isInProgress).map(order => (
          <div className="order-item" key={order.id}>
            <div className="order-header" onClick={() => toggleOrderDetails(order.id)}>
              <span>{order.reference}</span>
              <div className="order-status in-progress">In progress</div>
              <button>{expandedOrderId === order.id ? '▾' : '▸'}</button>
            </div>
            <div className={`order-details ${expandedOrderId === order.id ? 'show' : ''}`}>
              {order.details.map((detail, index) => (
                <div key={index}>
                  <p>{detail.item}</p>
                  <p>Milk: {detail.milk}</p>
                  <p>{detail.notes}</p>
                </div>
              ))}
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

import React, { useState, useEffect } from 'react';
import OrderHeader from '../../user/components/OrdersHeader'
import OrderDetails from './OrderDetails';
import { Link } from 'react-router-dom';
export default function TakeOrders() {
    const orders=[
        {
            orderID: 8,
            productName: "Mocha",
            quantity: 3,
            notes: "less sugar n more milk",
            milkTypeValue: "Oat milk"
        },
        {
            orderID: 9,
            productName: "Latte",
            quantity: 1,
            notes: "",
            milkTypeValue: "Full cream milk"
        },
        {
            orderID: 10,
            productName: "Latte",
            quantity: 2,
            notes: "",
            milkTypeValue: "Full cream milk"
        }
        
    ]
    // const [orders, setOrders] = useState([]);
    const [expandedOrderId, setExpandedOrderId] = useState(null);  
  const toggleOrderDetails = (id) => {
    setExpandedOrderId(expandedOrderId === id ? null : id);
  };

  return (
    <div className='take-orders'>
        <OrderHeader/>
        <div className="order-section">
            <div className="order-section-title">
                Orders
            </div>
            {
                orders.map( order =>(
                    <div className="order-item" key={order.orderID}>
            <div className="order-header" onClick={() => toggleOrderDetails(order.orderID)}>
              <span>{`Order #${order.orderID}`}</span>
              {/* <div className={`order-status ${orderStatusValue.toLowerCase()}`}>{orderStatusValue}</div> */}
              <button>{expandedOrderId === order.orderID ? '▾' : '▸'}</button>
            </div>
            <div className={`order-details ${expandedOrderId === order.orderID ? 'show' : ''}`}>
              {/* <Link to={`OrderDetails/${order.orderID}`}> */}
                <OrderDetails quantity={order.quantity} productName={order.productName} milkTypeValue={order.milkTypeValue} notes={order.notes}/> 
              {/* </Link> */}
            </div>
          </div>
                ))
            }
        </div>    
    </div>
  )
}

import React, { useEffect } from 'react';
import '../static/OrderDetails.css';
import Navbar from '../../common/components/Navbar';
import { useFetcher, useLocation } from 'react-router-dom';
const OrderDetails = () => {
    const location=useLocation();
    const order = location.state || { name: '', quantity: 0 }; 
    useEffect(()=>{
      console.log(order,'name')  
    },[])
    return (
        <div className="orderdetails-container">
            <div className="order-header">
                <button className="back-button">&lt;</button>
                <span className="order-number">Order number</span>
                <span className="order-status">Pending</span>
            </div>

            <div className="order-items">
                <div className="list-item">
                    <h3>{order.quantity} {order.productName}</h3>
                    <p><strong>Milk:</strong> {order.milkTypeValue}</p>
                    <p><strong>Notes:</strong> {order.notes}</p>
                </div>
            </div>

            <div className="order-history">
                <h4>Order history</h4>
                <p>Time received: {order.orderTime}</p>
            </div>

            <div className="order-actions">
                <button className="decline-button">Decline order</button>
                <button className="accept-button">Accept order</button>
            </div>
            <div className='content'>
                <Navbar />
            </div>
            
     
        </div>
    );
};

export default OrderDetails;

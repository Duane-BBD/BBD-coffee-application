import React from 'react';
import '../static/OrderDetails.css';
import Navbar from '../../user/components/Navbar';

const OrderDetails = () => {
    return (
        <div className="order-details-container">
            <div className="order-header">
                <button className="back-button">&lt;</button>
                <span className="order-number">Order number</span>
                <span className="order-status">Pending</span>
            </div>

            <div className="order-items">
                <div className="list-item">
                    <h3>1 Cappuccino</h3>
                    <p><strong>Milk:</strong> Oat milk</p>
                    <p><strong>Notes:</strong> whatever note was added will be placed here.</p>
                </div>

                <div className="list-item">
                    <h3>3 Hot chocolate</h3>
                    <p><strong>Milk:</strong> Oat milk</p>
                    <p><strong>Notes:</strong> whatever note was added will be placed here.</p>
                </div>
            </div>

            <div className="order-history">
                <h4>Order history</h4>
                <p>Time received: 12:02pm</p>
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

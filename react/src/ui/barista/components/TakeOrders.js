import React, { useState } from 'react';
import '../static/TakeOrders.css';
import Navbar from '../../user/components/Navbar';

const TakeOrders = () => {
    const [tab, setTab] = useState('incoming');

    return (
        <div className="orders-page-container">
            <div className="orders-page-header">
                <button 
                    className={`orders-tab ${tab === 'incoming' ? 'active' : ''}`} 
                    onClick={() => setTab('incoming')}
                >
                    Incoming orders
                </button>
                <button 
                    className={`orders-tab ${tab === 'past' ? 'active' : ''}`} 
                    onClick={() => setTab('past')}
                >
                    Past orders
                </button>
            </div>

            <div className="orders-status">
                <div className="status-indicator">
                    Accepting orders
                </div>
            </div>

            <div className="orders-list">
                <div className="order-section">
                    <h3>Pending acceptance</h3>
                    <div className="order-item">
                        <p>Order number/reference</p>
                        <p className="order-time">Received 11:28 am</p>
                        <span className="order-arrow">&gt;</span>
                    </div>
                </div>

                <div className="order-section">
                    <h3>In progress</h3>
                    <div className="order-item">
                        <p>Order number/reference</p>
                        <p className="order-time">Accepted 11:28 am</p>
                        <span className="order-arrow">&gt;</span>
                    </div>
                </div>
            </div>

            <div className="content">
                <Navbar />
            </div>
        </div>
    );
};

export default TakeOrders;

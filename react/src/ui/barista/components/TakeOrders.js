import React, { useEffect, useState } from 'react';
import '../static/TakeOrders.css';
import Navbar from '../../common/components/Navbar';
import { detailsForBarista } from '../../../services/baristaDisplayService';
import { SlArrowRight } from "react-icons/sl";
import { useNavigate } from 'react-router-dom';
import OrderLists from './OrderLists';

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
                <OrderLists status={'Pending'}/>

                <OrderLists status={'In progress'}/>
                <OrderLists status={'Prepared'}/>
                <OrderLists status={'Complete'}/>
                <OrderLists status={'Cancelled'}/>



                {/* <div className="order-section">
                    <h3>In progress</h3>
                    <div className="order-item">
                        <p>Order number/reference</p>
                        <p className="order-time">Accepted 11:28 am</p>
                        <span className="order-arrow">&gt;</span>
                    </div>
                </div> */}
            </div>

            <div className="content">
                <Navbar />
            </div>
        </div>
    );
};

export default TakeOrders;

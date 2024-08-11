import React, { useState } from 'react';
import '../static/TakeOrders.css';
import Navbar from '../../common/components/Navbar';
import OrderLists from './OrderLists';
import { useNavigate } from 'react-router-dom';

const TakeOrders = () => {
    const [tab, setTab] = useState('incoming');
    const navigate = useNavigate();

    const pastpage =() => {
        navigate('/barista/past-orders')
        setTab('past')
    }

    const incomingpage=()=>{
        navigate('/barista/take-orders')
        setTab('incoming')
    }

    return (
        <div className="orders-page-container">
            <div className="orders-page-header">
                <button 
                    className={`orders-tab ${tab === 'incoming' ? 'active' : ''}`} 
                    onClick={() => incomingpage()}
                >
                    Incoming orders
                </button>
                <button 
                    className={`orders-tab ${tab === 'past' ? 'active' : ''}`} 
                    onClick={() => pastpage()}
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
            </div>

            <div className="content">
                <Navbar  />
            </div>
        </div>
    );
};

export default TakeOrders;

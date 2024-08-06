import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import OrderLists from './OrderLists';
import Navbar from '../../common/components/Navbar';

const PastOrders = () => {
    const [tab, setTab] = useState('past');
    const navigate =useNavigate();
    const pastpage =()=>{
        navigate('/past-orders')
        setTab('past')
    }
    const incomingpage=()=>{
        navigate('/take-orders')
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
  )
}

export default PastOrders
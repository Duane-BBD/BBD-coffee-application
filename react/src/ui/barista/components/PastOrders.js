import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import OrderLists from './OrderLists';
import Navbar from '../../common/components/Navbar';

const PastOrders = () => {
    const [tab, setTab] = useState('past');
    const navigate = useNavigate();

    const pastpage = () => {
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
            <OrderLists status={'Complete'}/>
            <OrderLists status={'Cancelled'}/>
        </div>

        <div className="content">
            <Navbar />
        </div>
    </div>
  )
}

export default PastOrders
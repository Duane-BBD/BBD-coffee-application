import React, { useState } from 'react'
import FrontPage from '../../common/components/FrontPage'
import "../static/HomePage.css"
import { useNavigate } from 'react-router-dom';
export default function HomePage() {
    const [isAcceptingOrders,setIsAcceptingOrders]=useState(true);
    const navigate=useNavigate();

    const openTakeOrders=()=>{
        setIsAcceptingOrders(!isAcceptingOrders);
        navigate(`/barista/take-orders`);
    };
    const openClosedOrders =()=>{
        setIsAcceptingOrders(!isAcceptingOrders);
        navigate(`/`);
    }
  return (
    <div className='homepage-container'>
        <div className='left-homepage'>
            <FrontPage/>
        </div>
        <div className='right-homepage'>
            <button className={isAcceptingOrders?'barista-avail':'change-color'} onClick={openTakeOrders}>
                {isAcceptingOrders? 'Accepting orders': 'Closed for orders'} 
            </button>
            <button className='barista-not-avail' onClick={openClosedOrders}>
                {isAcceptingOrders? 'Closed for orders': 'Open for orders'} 
            </button>
        </div>
    </div>
  )
}

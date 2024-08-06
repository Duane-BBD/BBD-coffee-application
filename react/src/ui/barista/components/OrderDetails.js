import React from 'react'
import { useNavigate } from 'react-router-dom'
import { MdKeyboardArrowLeft } from "react-icons/md";
import "../static/TakeOrders.css"
export default function OrderDetails({quantity,productName,milkTypeValue ,notes}) {
    const navigate=useNavigate();
  return (
    <div>
        <div className='top-nav'>
            <button className='arrow-left' onClick={e => navigate(-1)} >  
            <MdKeyboardArrowLeft/>
            </button>  
            <h4>Order number</h4>
        </div>
        <div className='orderdetails-css'>
            <h3>{`. ${quantity}   ${productName}`}</h3>
            {/* <p>{`${quantity} x ${productName}`}</p> */}
            <div className='details-container'>
            <h4>Milkstyle:</h4><p> {milkTypeValue}</p>
            </div>
            <div className='details-container'>
            <h4>Notes:</h4><p>{notes ? notes : ''}</p>
            </div>

            </div>
    </div>
)
}

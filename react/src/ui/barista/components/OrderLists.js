import React, { useEffect, useState } from 'react'
import { detailsForBarista } from '../../../services/baristaDisplayService';
import { useNavigate } from 'react-router-dom';
import { SlArrowRight } from 'react-icons/sl';
import useUserDetails from '../../../hooks/useUserDetails';

const OrderLists = ({ status }) => {
    const navigate = useNavigate()
    const [orderDetails, setOrderDetails] = useState([]);
    const { userDetails } = useUserDetails()

    useEffect(() => {
        
        detailsForBarista(userDetails.officeID, status, setOrderDetails);
    })

  return (
    <div>
        <div className="order-section">
            <h3>{status}</h3>
            {orderDetails.map((order, index) => 
            <button className="orderitem" key={index} onClick={() => navigate(`/barista/order-details/?status=${encodeURIComponent(status)}`, { state: order })}>
                <div>
                <p>Order number: {order.orderID}</p>
                {status === 'Pending'
                    ? <p className="ordertime">Received at {order.orderTime}</p>
                    : status === 'In progress'
                        ? <p className="ordertime">Accepted at {order.orderTime}</p>
                        : status === 'Prepared'
                            ? <p className="ordertime">Prepared at {order.orderTime}</p>
                            : status === 'Complete'
                                ? <p className="ordertime">Completed at {order.orderTime}</p>
                                : <p className="ordertime">Cancelled at {order.orderTime}</p>
                }
                </div>
                <span className="order-arrow"><SlArrowRight/></span>
            </button>)}
        </div>
    </div>
  )
}

export default OrderLists
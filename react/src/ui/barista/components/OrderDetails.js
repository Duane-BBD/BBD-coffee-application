import React, { useEffect, useState } from 'react';
import '../static/OrderDetails.css';
import Navbar from '../../common/components/Navbar';
import { useLocation, useNavigate } from 'react-router-dom';
import { cancelOrders, progressStatus } from '../../../services/updateStatusService';
import { MdKeyboardArrowLeft } from "react-icons/md";
import { getTimeDetails } from '../../../services/orderHistoryService';

const OrderDetails = () => {
    const location=useLocation();
    const navigate = useNavigate();
    const order = location.state || {};
    const searchParams = new URLSearchParams(location.search);
    let status = searchParams.get('status') || '';

    const [timeDetails, setTimeDetails] = useState([])

    useEffect(() => {
        if (order.orderID == null) navigate(-1)
        getTimeDetails(order.orderID, setTimeDetails)
        console.log(timeDetails)
    }, [])

    return (
        <div className="orderdetails-container">
            <div className="orderdetail-header">
                <button className="back-button" onClick={() => navigate(-1)}><MdKeyboardArrowLeft/></button>
                <span className="order-number">Order Number {order.orderID}</span>
                <span className={status + " order-status"}>{status}</span>
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
                {timeDetails.map((time) => <>
                    <p>{time.orderStatusID.orderStatusValue}: {time.orderTime}</p>
                </>)}
                {/* <p>Time received: {order.orderTime}</p> */}
            </div>

            {status === "Pending"
                ? <div className="order-actions">
                    <button 
                        className="decline-button"
                        onClick={() => {
                            cancelOrders(order.orderID)
                            navigate(`/barista/take-orders`)
                        }}
                    >Decline order</button>
        
                    <button 
                        className="accept-button"
                        onClick={() => {
                            progressStatus(order.orderID)
                            navigate(`/barista/take-orders`)
                        }}
                    >Accept order</button>
                </div>
                : status === "In progress"
                    ? <div className="order-actions">
                        <button 
                            className="decline-button"
                            onClick={() => {
                                cancelOrders(order.orderID)
                                navigate(`/barista/take-orders`)
                            }}
                        >Incomplete</button>

                        <button 
                            className="accept-button"
                            onClick={() => {
                                progressStatus(order.orderID)
                                navigate(`/barista/take-orders`)
                            }}
                        >Order ready</button>
                    </div>
                    : status === "Prepared"
                        ? <div className="order-actions">
                            <button 
                                className="decline-button"
                                onClick={() => {
                                    progressStatus(order.orderID)
                                    navigate(`/barista/take-orders`)
                                }}
                            >Not collected</button>

                            <button 
                                className="accept-button"
                                onClick={() => {
                                    progressStatus(order.orderID)
                                    navigate(`/barista/take-orders`)
                                }}
                            >Order collected</button>
                        </div>
                        : <></>
            }

            <div className='content'>
                <Navbar  navtype={'barista'}  />
            </div>
        </div>
    );
};

export default OrderDetails;

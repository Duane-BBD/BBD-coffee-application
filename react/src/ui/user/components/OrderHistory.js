// import React, { useState, useEffect } from 'react';
// import axios from 'axios';
// import '../static/OrderHistory.css';
// import OrdersHeader from '../components/OrdersHeader';
// import { RiArrowDropDownLine } from "react-icons/ri";

// const OrderHistory = ({ officeID, orderStatusValue = "" }) => {
//     const [orders, setOrders] = useState([]);
//     const [expandedOrderId, setExpandedOrderId] = useState(null);

//     useEffect(() => {
//         const fetchOrders = async () => {
//             try {
//                 const orderIDs = [1, 2, 3, 4]; // Example order IDs, replace with actual logic to get order IDs
//                 const requests = orderIDs.map(orderID => axios.get(`/orders/get-order-details/${orderID}`));
//                 const responses = await Promise.all(requests);
//                 const fetchedOrders = responses.map(response => response.data);
//                 setOrders(fetchedOrders);
//             } catch (error) {
//                 console.error('Error fetching orders:', error);
//             }
//         };

//         fetchOrders();
//     }, [officeID, orderStatusValue]);

//     const toggleOrderDetails = (id) => {
//         setExpandedOrderId(expandedOrderId === id ? null : id);
//     };

//     const getStatusColor = (status) => {
//         if (!status) return 'gray';
//         switch (status.toLowerCase()) {
//             case 'pending':
//                 return 'gray';
//             case 'in progress':
//                 return 'lightblue';
//             case 'complete':
//                 return 'green';
//             case 'cancelled':
//                 return 'red';
//             case 'prepared':
//                 return 'green';
//             default:
//                 return 'gray';
//         }
//     };

//     if (orders.length === 0) {
//         return <div>No orders found</div>;
//     }

//     return (
//         <div className="order-history">
//             <OrdersHeader />
//             <div className="order-section">
//                 <div className="order-section-title">Orders</div>
//                 {orders.map(order => (
//                     <div className="order-item" key={order.orderID}>
//                         <div className="order-header" onClick={() => toggleOrderDetails(order.orderID)}>
//                             <span>{`Order Number: ${order.orderID}`}</span>
//                             <button
//                                 className="order-status"
//                                 style={{ backgroundColor: getStatusColor(order.status) }}
//                             >
//                                 {order.status || 'Unknown'}
//                             </button>
//                             <div className="dropdown-arrow">
//                                 <RiArrowDropDownLine />
//                             </div>
//                         </div>
//                         <div className={`order-details ${expandedOrderId === order.orderID ? 'show' : ''}`}>
//                             <ol>
//                                 <li>{`• ${order.quantity} x ${order.productName}`}</li>
//                                 <li>Milk: {order.milkTypeValue || 'None'}</li>
//                                 {order.note && <li>Notes: {order.note}</li>}
//                             </ol>
//                         </div>
//                     </div>
//                 ))}
//             </div>
//         </div>
//     );
// };

// export default OrderHistory;

import React, { useEffect, useState } from 'react';
import { Link, useLocation } from 'react-router-dom';
import Navbar from '../../common/components/Navbar';
import axios from '../../../api/axios';
import "../static/MyOrders.css";
import "../static/CombinedOrders.css";
import "../static/OrderHistory.css";
import OrdersHeader from './OrdersHeader';
import UserOrderHistory from './UserOrderHistory';
import useUserDetails from '../../../hooks/useUserDetails';

const MyOrders = () => {
    const { userDetails } = useUserDetails()
    const [orders, setOrders] = useState([]);
    const location = useLocation();

    useEffect(() => {
        const fetchOrders = async () => {
            try {
                const response = await axios.get(`/order-list/past-orders/${userDetails.userID}`);
                console.log("print success");
                setOrders(response.data);
            } catch (error) {
                console.error('Error fetching orders:', error);
            }
        };

        fetchOrders();
    }, [userDetails.userID]);

    if (orders.length != 0) {
        return <UserOrderHistory/>;
    }

    return (
        <div>
            <OrdersHeader />
            <div className="empty-order">
                <p><strong>Your order is empty!</strong></p>
                <p>Add drinks to your order to get started!</p>
                <Link to="/">
                    <button className="view-menu-button">View drinks menu</button>
                </Link>
            </div>
            <div className='content'>
                <Navbar />
            </div>
        </div>
    );
};

export default MyOrders;

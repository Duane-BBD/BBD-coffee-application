import React, { useState, useEffect } from 'react';
import axios from '../../../api/axios';
import '../static/OrderHistory.css';
import OrdersHeader from '../components/OrdersHeader';
import { RiArrowDropDownLine } from "react-icons/ri";
import Navbar from '../../common/components/Navbar';
import MyOrders from './MyOrders';
import useUserDetails from '../../../hooks/useUserDetails';

const UserOrderHistory = ({ userIDx = 1056, orderStatusValue = "" }) => {
    const [orders, setOrders] = useState([]);
    const [expandedOrderID, setExpandedOrderID] = useState(null);
    const { userDetails } = useUserDetails();

    useEffect(() => {
        const fetchOrders = async () => {
            try {
                if (!userIDx) return;

                const response = await axios.get(`/order-list/past-orders/${userIDx}`);
                setOrders(response.data);
            } catch (error) {
                console.error('Error fetching orders:', error);
            }
        };

        fetchOrders();
    }, [userIDx, orderStatusValue]);

    const toggleOrderDetails = (id) => {
        setExpandedOrderID(expandedOrderID === id ? null : id);
    };

    const getStatusColor = (status) => {
        if (!status) return 'gray';
        switch (status.toLowerCase()) {
            case 'pending':
                return 'gray';
            case 'in progress':
                return 'lightblue';
            case 'complete':
                return 'green';
            case 'cancelled':
                return 'red';
            case 'prepared':
                return 'green';
            default:
                return 'gray';
        }
    };

    if (orders.length === 0) {
        return <MyOrders />;
    }

    return (
        <div className="order-history">
            <div className="order-container">
                <OrdersHeader />
                <div className="order-section">
                    <div className="order-section-title">In Progress</div>
                    <hr />
                    {orders.map(order => (
                        <React.Fragment key={order.ID}>
                            <div className="order-item">
                                <div className="order-header" onClick={() => toggleOrderDetails(order.orderID)}>
                                    <span>{`Order Number: ${order.orderID}`}</span>
                                    <div className="order-summary">
                                        <button
                                            className="order-status"
                                            style={{ backgroundColor: getStatusColor(order.status) }}
                                        >
                                            {order.status || 'Unknown'}
                                        </button>
                                        <RiArrowDropDownLine className="dropdown-arrow" />
                                    </div>
                                </div>
                            </div>
                            <div className={`order-details ${expandedOrderID === order.orderID ? 'show' : ''}`}>
                                <div>
                                    <li>{`${order.quantity} ${order.productName}`}</li>
                                    <p>Milk: {order.milkTypeValue || 'None'}</p>
                                    {order.note && <p>Notes: {order.note}</p>}
                                </div>
                            </div>
                        </React.Fragment>
                    ))}
                </div>
            </div>
            <Navbar />
        </div>
    );
};

export default UserOrderHistory;

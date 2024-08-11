import React, { useState, useEffect } from 'react';
import axios from '../../../api/axios';
import '../static/OrderHistory.css';
import OrdersHeader from '../components/OrdersHeader';
import { RiArrowDropDownLine } from "react-icons/ri";
import Navbar from '../../common/components/Navbar';
import useUserDetails from '../../../hooks/useUserDetails';

const UserOrderHistory = ({ orderStatusValue = "" }) => {
    const [orders, setOrders] = useState([]);
    const [expandedOrderID, setExpandedOrderID] = useState(null);
    const { userDetails } = useUserDetails();

    useEffect(() => {
        const fetchOrders = async () => {
            try {
                if (!userDetails) return;

                const response = await axios.get(`/order-history/search-history/${userDetails.userID}`);
                setOrders(response.data);
            } catch (error) {
                console.error('Error fetching orders:', error);
            }
        };

        fetchOrders();
    }, [userDetails.userID, orderStatusValue]);

    const toggleOrderDetails = (id) => {
        setExpandedOrderID(expandedOrderID === id ? null : id);
    };

    const getStatusColor = (status) => {
        if (!status) return '#767676';
        switch (status.toLowerCase()) {
            case 'pending':
                return '#767676';
            case 'in progress':
                return '#0080B7';
            case 'complete':
                return '#4caf50';
            case 'cancelled':
                return '#D30000';
            case 'prepared':
                return '#4caf50';
            default:
                return '#767676;';
        }
    };

    const cancelOrder = async (orderID) => {
        try {
            console.log(`Cancelling order with ID: ${orderID}`);
            const response = await axios.patch(`/cancel-order/${orderID}`);
            console.log('Cancel response:', response);

            setOrders(orders.map(order => 
                order.orderID === orderID ? { ...order, orderStatusValue: 'Cancelled' } : order
            ));
        } catch (error) {
            console.error('Error cancelling order:', error);
        }
    };

    const renderOrderSection = (title, filterCondition, showCancelButton = false) => (
        <div className="order-section">
            <div className="order-section-title">{title}</div>
            <hr />
            {orders
                .filter(order => filterCondition(order))
                .map(order => (
                    <React.Fragment key={order.orderID}>
                        <div className="order-item">
                            <div className="order-header" onClick={() => toggleOrderDetails(order.orderID)}>
                                <span>{`Order Number: ${order.orderID}`}</span>
                                <div className="order-summary">
                                    <button
                                        className="order-status"
                                        style={{ backgroundColor: getStatusColor(order.orderStatusValue) }}
                                    >
                                        {order.orderStatusValue || 'Unknown'}
                                    </button>
                                    {showCancelButton && order.orderStatusValue.toLowerCase() === 'pending' && (
                                        <button
                                            className="order-status Cancelled"
                                            onClick={(e) => {
                                                e.stopPropagation(); 
                                                cancelOrder(order.orderID);
                                            }}
                                        >
                                            Cancel
                                        </button>
                                    )}
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
    );

    return (
        <div className="order-history">
            <div className="order-container">
                <OrdersHeader />
                {renderOrderSection("Pending Orders", order => order.orderStatusValue && order.orderStatusValue.toLowerCase() === 'pending', true)}
                {renderOrderSection("In Progress", order => order.orderStatusValue && order.orderStatusValue.toLowerCase() === 'in progress')}
                {renderOrderSection("Prepared Orders", order => order.orderStatusValue && order.orderStatusValue.toLowerCase() === 'prepared')}
                <div className="order-section">
                    <div className="order-section-title">Past Orders</div>
                    <hr />
                    {orders
                        .filter(order => order.orderStatusValue && order.orderStatusValue.toLowerCase() === 'complete')
                        .map(order => (
                            <React.Fragment key={order.orderID}>
                                <div className="order-item">
                                    <div className="order-header" onClick={() => toggleOrderDetails(order.orderID)}>
                                        <span>{`Order Number: ${order.orderID}`}</span>
                                        <div className="order-summary">
                                            <button
                                                className="order-status"
                                                style={{ backgroundColor: getStatusColor(order.orderStatusValue) }}
                                            >
                                                {order.orderStatusValue || 'Unknown'}
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
            <Navbar navtype='users' />
        </div>
    );
};

export default UserOrderHistory;

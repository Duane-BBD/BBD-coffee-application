import React, { useEffect, useState } from 'react';
import { Link, useLocation } from 'react-router-dom';
import Navbar from '../../common/components/Navbar';
import axios from '../../../api/axios';
import "../static/MyOrders.css";
import "../static/CombinedOrders.css";
import "../static/OrderHistory.css";
import OrdersHeader from './OrdersHeader';
import UserOrderHistory from './UserOrderHistory'; // Import the UserOrderHistory component

const MyOrders = ({ userIDx = 1025 }) => {
    const [orders, setOrders] = useState([]);
    const location = useLocation();

    useEffect(() => {
        const fetchOrders = async () => {
            try {
                const response = await axios.get(`/order-list/past-orders/${userIDx}`);
                setOrders(response.data);
            } catch (error) {
                console.error('Error fetching orders:', error);
            }
        };

        fetchOrders();
    }, [userIDx]);

    if (orders.length != 0) {
        return <UserOrderHistory userIDx={userIDx} />;
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
            <div className='navbar-spacing'>
                <Navbar />
            </div>
        </div>
    );
};

export default MyOrders;

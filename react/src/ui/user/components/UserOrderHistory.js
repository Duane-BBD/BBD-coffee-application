import React, { useState, useEffect } from 'react';
import axios from '../../../api/axios';
import '../static/OrderHistory.css';
import PlaceOrder from '../components/PlaceOrder';
import OrdersHeader from '../components/OrdersHeader';
import { RiArrowDropDownLine } from "react-icons/ri";

const OrderHistory = ({ officeID, orderStatusValue = "" }) => {
    const userID = 1056;
    const [orders, setOrders] = useState([]);
    const [expandedOrderId, setExpandedOrderId] = useState(null);

    useEffect(() => {
        const fetchOrders = async () => {
        try {
            let list = []
            const responses = axios.get(`/order-list/past-orders/${userID}`)
            if (responses.data) {
                console.log(responses.data)
                responses.data.map((item) => {
                    list.push(item)
                })
                setOrders(list)
            }
            // const orderIDs = [1, 2, 3, 4]; 
            // const requests = orderIDs.map(orderID => axios.get(`http://localhost:8080/bbd-coffee/orders/get-order-details/${orderID}`));
            // // const responses = await Promise.all(requests);
            // const fetchedOrders = responses.map(response => response.data);
            // setOrders(fetchedOrders);
        } catch (error) {
            console.error('Error fetching orders:', error);
        }
        };

        fetchOrders();
    }, [officeID, orderStatusValue]);

  const toggleOrderDetails = (id) => {
    setExpandedOrderId(expandedOrderId === id ? null : id);
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
    return <PlaceOrder />;
  }

  return (
    <div className="order-history">
      <OrdersHeader />
      <div className="order-section">
        <div className="order-section-title">Orders</div>
        {orders.map(order => (
            <>
          <div className="order-item" key={order.orderID}>
            <div className="order-header" onClick={() => toggleOrderDetails(order.orderID)}>
              <span>{`Order Number: ${order.orderID}`}</span>
              <div className="order-header-right">
                <button 
                  className="order-status" 
                  style={{ backgroundColor: getStatusColor(order.status) }}
                >
                  {order.status || 'Unknown'}
                </button>
                <div className="dropdown-arrow">
                  <RiArrowDropDownLine />
                </div>
              </div>
            </div>
            
          </div>
          <div className={`order-details-container`}>
              <div className={`order-details ${expandedOrderId === order.orderID ? 'show' : ''}`}>
                <div>
                  <li>{`${order.quantity} ${order.productName}`}</li>
                  <li>Milk: {order.milkTypeValue || 'None'}</li>
                  {order.note && <li>Notes: {order.note}</li>}
                </div>
              </div>
            </div>
          </>
        ))}
        
      </div>

      <div className="footer">
        <div className="footer-icon home-icon"></div>
        <div className="footer-icon order-icon active"></div>
      </div>
    </div>
  );
};

export default OrderHistory;

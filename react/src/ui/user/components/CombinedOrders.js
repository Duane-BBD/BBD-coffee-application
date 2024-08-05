// import React, { useEffect, useState } from 'react';
// import PropTypes from 'prop-types';
// import Header from '../components/OrdersHeader';
// import { IoIosArrowDown } from 'react-icons/io';
// import Navbar from './Navbar';
// import '../static/CombinedOrders.css';
// import '../../../services/orderStatusService';
  
//   const OrderStatus = ({ status = 'Unknown' }) => {
//     const statusClass = status ? status.toLowerCase() : 'unknown';
//     return (
//       <span className={`status ${statusClass}`}>
//         {status}
//       </span>
//     );
//   };
  
//     OrderStatus.propTypes = {
//         status: PropTypes.string,
//     };
  
//     const OrderItem = ({ id, status }) => {
//         return (
//         <details className="order-item">
//             <summary>
//             <div className="order-summary">
//                 <span>Order Number {id}</span>
//                 <div className="buttons">
//                 <OrderStatus status={status} />
//                 <IoIosArrowDown />
//                 </div>
//             </div>
//             <hr className="order-divider" />
//             </summary>
//             <hr className="order-divider" />
//             <p>Additional order details...</p>
//         </details>
//         );
//     };
  
//     OrderItem.propTypes = {
//         id: PropTypes.number.isRequired,
//         status: PropTypes.string.isRequired,
//     };
  
//     const CombinedOrders = ({ userID }) => {
//         const [orders, setOrders] = useState([]);
    
//         return (
//         <div className="order-list">
//             <Header />
//             <section>
//             <h2>Past orders</h2>
//             <hr className="section-divider" />
//             {orders.map(order => (
//                 <OrderItem key={order.id} id={order.id} status={order.status} />
//             ))}
//             </section>
//             <Navbar />
//         </div>
//         );
//     };
    
// CombinedOrders.propTypes = {
//     userID: PropTypes.number.isRequired, // Ensure userID is passed and is a number
// };
    
// export default CombinedOrders;
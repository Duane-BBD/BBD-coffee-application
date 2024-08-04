// import axios from "../api/axios"

// const API_ENDPOINT_URL = '/bbd-coffee/orders';

// // Fetch list of orders
// export const fetchOrders = async () => {
//   try {
//     const response = await axios.get(API_ENDPOINT_URL);
//     return response.data;
//   } catch (error) {
//     console.error('Error fetching orders:', error);
//     throw error;
//   }
// };

// // Fetch order details by order ID
// export const fetchOrderDetails = async (orderId) => {
//   try {
//     const response = await axios.get(`${API_ENDPOINT_URL}/get-order-details/${orderId}`);
//     return response.data;
//   } catch (error) {
//     console.error('Error fetching order details:', error);
//     throw error;
//   }
// };

import axios from '../api/axios';

const App = async (userID, setOrders) => {
    // const [users, setUsers] = useState([]);
    let orderList = []

    try {
        const response = await axios.get(`/order-history/search-history/${userID}`);
        if (response.data) {
            response.data.map(item => {
                orderList.push(item)
            })
        }
        setOrders(orderList)
    } catch (error) {
        console.error('Error fetching users:', error);
    }
  };
  
  export { App };
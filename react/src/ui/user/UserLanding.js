import React from 'react';
import AllOffices from './components/AllOffices';
import Products from './components/Products';
import ProductDetails from './components/ProductDetails';
import CheckOut from './components/CheckOut';
import PlaceOrder from './components/PlaceOrder';
import { Route, Routes } from 'react-router-dom';
import OrderHistory from './components/OrderHistory';
import UserOrderHistory from './components/UserOrderHistory';
import MyOrders from './components/PlaceOrder';

const UserLanding = () => {
  return (
    <Routes>
        <Route path="/all-office" element={<AllOffices/>} />
		<Route path="/product" element={<Products/>} />
		<Route path="/product-details" element={<ProductDetails/>}/>
		<Route path="/check-out" element={<CheckOut/>}/>
        <Route path="/place-order" element={<PlaceOrder/>}/>
        <Route path="/order-history" element={<OrderHistory/>}/>
        <Route path="/user-order-history" element={<UserOrderHistory/>}/>
        <Route path="/my-orders" element={<MyOrders/>}/>
    </Routes>
  )
}

export default UserLanding
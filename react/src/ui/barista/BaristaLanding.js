import React from 'react'
import HomePage from './components/HomePage'
import TakeOrders from './components/TakeOrders'
import OrderDetails from './components/OrderDetails'
import PastOrders from './components/PastOrders'
import { Route, Routes } from 'react-router-dom'

const BaristaLanding = () => {
  return (
    <Routes>
        <Route path="/home-page" element={<HomePage/>} />
        <Route path="/take-orders" element={<TakeOrders/>}/>
        <Route path="/order-details" element={<OrderDetails />}/>
		<Route path="/past-orders" element={<PastOrders/>} />
    </Routes>
  )
}

export default BaristaLanding
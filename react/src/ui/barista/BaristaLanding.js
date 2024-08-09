import React from 'react'
import HomePage from './components/HomePage'
import TakeOrders from './components/TakeOrders'
import OrderDetails from './components/OrderDetails'
import PastOrders from './components/PastOrders'
import { Route, Routes } from 'react-router-dom'
import Missing from '../common/components/Missing'

const BaristaLanding = () => {
  return (
    <Routes>
        <Route path="/home-page" element={<HomePage/>} />
        <Route path="/take-orders" element={<TakeOrders/>}/>
        <Route path="/order-details" element={<OrderDetails/>}/>
		<Route path="/past-orders" element={<PastOrders/>} />
        <Route path="/*" element={<Missing/>}/>
    </Routes>
  )
}

export default BaristaLanding
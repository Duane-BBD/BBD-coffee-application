import React from 'react'
import { Route, Routes } from 'react-router-dom'
import AdminHome from './components/AdminHome'
import RegisterUser from './components/RegisterUser'
import AddAvailProduct from './components/AddAvailProduct'
import AddLocation from './components/AddLocation'

const AdminLanding = () => {
  return (
    <Routes>
        <Route path="/admin-home" element={<AdminHome/>} />
        <Route path="/register-user" element={<RegisterUser/>} />
        <Route path="/add-availproducts" element={<AddAvailProduct/>} />
        <Route path="/add-location" element={<AddLocation/>} />
    </Routes>
  )
}

export default AdminLanding
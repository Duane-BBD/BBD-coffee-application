import React from "react";
import Location from "./ui/user/components/FrontPage"
import Products from "./ui/user/components/Products";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import UserLanding from "./ui/user/UserLanding";
import AllOffices from "./ui/user/components/AllOffices";
import ProductDetails from "./ui/user/components/ProductDetails";
import Navbar from "./ui/user/components/Navbar";
function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route exact path="/" element={<AllOffices/>} />
            <Route exact path="/product" element={<Products/>} />
            <Route exact path="/productdetail" element={<ProductDetails/>}/>
            <Route exact path="/navbar" element={<Navbar/>}/>

        </Routes>
    </BrowserRouter>
  )
}

export default App;

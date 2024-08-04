import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Products from "./ui/user/components/Products";
import AllOffices from "./ui/user/components/AllOffices";
import ProductDetails from "./ui/user/components/ProductDetails";
import CheckOut from "./ui/user/components/CheckOut";
import CombinedOrders from "./ui/user/components/CombinedOrders";
import HomePage from "./ui/barista/components/HomePage";
function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route exact path="/" element={<AllOffices/>} />
            <Route exact path="/product" element={<Products/>} />
            <Route exact path="/product-details" element={<ProductDetails/>}/>
            <Route exact path="/check-out" element={<CheckOut/>}/>
            <Route exact path="/my-orders" element={<CombinedOrders/>}/>
            <Route exact path="/Home-page" element={<HomePage/>} />
        </Routes>
    </BrowserRouter>
  );
}

export default App;
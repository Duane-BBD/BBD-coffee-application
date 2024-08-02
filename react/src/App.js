import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Location from "./ui/user/components/FrontPage";
import Products from "./ui/user/components/Products";
import UserLanding from "./ui/user/UserLanding";
import AllOffices from "./ui/user/components/AllOffices";

import ProductDetails from "./ui/user/components/ProductDetails";
import CheckOut from "./ui/user/components/CheckOut";
import CombinedOrders from "./ui/user/components/CombinedOrders";

function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route exact path="/" element={<AllOffices/>} />
            <Route exact path="/product" element={<Products/>} />
            <Route exact path="/product-details" element={<ProductDetails/>}/>
            <Route exact path="/check-out" element={<CheckOut/>}/>
            <Route exact path="/my-order" element={<CombinedOrders/>}/>

        </Routes>

    </BrowserRouter>
  );
}

export default App;

import React from "react";
import Location from "./ui/user/components/FrontPage"
import Products from "./ui/user/components/Products";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import UserLanding from "./ui/user/UserLanding";
import AllOffices from "./ui/user/components/AllOffices";
function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route exact path="/" element={<AllOffices/>} />
            <Route exact path="/page1" element={<Products/>} />
            {/* <Route exact path="/user" element={<UserLanding/>}/> */}
        </Routes>
    </BrowserRouter>
  )
}

export default App;

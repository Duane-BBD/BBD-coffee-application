import React from "react";
import Location from "./components/location"
import Products from "./components/Products";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<Location/>} />
            <Route path="/page1" element={<Products/>} />
        </Routes>
    </BrowserRouter>
  )
}

export default App;

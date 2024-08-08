import React from "react";
import { Route, Routes } from "react-router-dom";
import UserLanding from "./ui/user/UserLanding";
import Login from "./ui/common/components/Login";
import BaristaLanding from "./ui/barista/BaristaLanding";
import AdminLanding from "./ui/admin/AdminLanding";

import Missing from "./ui/common/components/Missing";

function App() {
  return (
    <Routes>
        <Route path="/" element={<Login/>}>
			<Route path="/user/*" element={<UserLanding/>} />

			<Route path="/barista/*" element={<BaristaLanding/>}/>

			<Route path="/admin/*" element={<AdminLanding />}/>
		</Route>
    </Routes>
  );
}

export default App;
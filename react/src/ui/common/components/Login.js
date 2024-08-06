import React, { useState } from "react";
import "../static/Login.css";
import { useNavigate } from "react-router-dom";
import { getUserDetails } from "../../../services/userDetailsService";
import useUserDetails from "../../../hooks/useUserDetails";

const Login = () => {
    const navigate = useNavigate()
    const [userID, setUserID] = useState();
    const { setUserDetails } = useUserDetails()

    const handleLogin = () => {
        if (userID) {
            getUserDetails(userID, setUserDetails)
            navigate("/")
        }
    }

  return (
    <div className="page-container">
        <div className="login-container">
            <div className="login-content">
                <h1>Coffee at BBD</h1>
                <input
                    type="number"
                    placeholder="Enter your Employee ID"
                    value={userID}
                    onChange={(e) => setUserID(e.target.value)}
                    className="login-input"
                    autoComplete="off"
                    required
                />
                <button onClick={handleLogin} className="login-button">
                    Login
                </button>
            </div>
        </div>
    </div>
  );
};

export default Login;

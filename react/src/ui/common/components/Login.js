import React, { useState } from "react";
import "../static/Login.css";
import { useNavigate } from "react-router-dom";

const Login = () => {
    const navigate = useNavigate()
    const [userID, setUserID] = useState();

  return (
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
            <button onClick={() => navigate("/")} className="login-button">
                Login
            </button>
        </div>
    </div>
  );
};

export default Login;

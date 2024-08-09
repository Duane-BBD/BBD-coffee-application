import React, { useEffect, useState } from "react";
import "../static/Login.css";
import { Outlet, useLocation, useNavigate } from "react-router-dom";
import { getUserDetails } from "../../../services/userDetailsService";
import useUserDetails from "../../../hooks/useUserDetails";

const Login = () => {
    const navigate = useNavigate();
    const location = useLocation();
    const [userID, setUserID] = useState();
    const [isLogged, setIsLogged] = useState(localStorage.getItem('logged') || "false");
    const { userDetails, setUserDetails } = useUserDetails();

    useEffect(() => {
        console.log(userDetails)
        if (isLogged && location.pathname === '/')
            switch (userDetails.userTypeID) {
                case 1:
                    navigate('/user/all-office');
                    break;
                case 2:
                    navigate('/barista/home-page');
                    break;
                case 3:
                    navigate('/admin/admin-home');
                    break;
                default:
                    navigate('/');
                    // window.location.reload()
            }
    }, [isLogged, location.pathname])

    const handleLogin = async () => {
        if (userID) {
            try {
                await getUserDetails(userID, setUserDetails)
            } catch (error) {
                console.log(error)
            } finally {
                setIsLogged("true")
                localStorage.setItem('logged', "true");
            }
            
        }
    }

    const handleSignOut = () => {
        localStorage.clear()
        location.pathname = '/';
        window.location.reload()
    }

  return (
    <>
        {isLogged === "true"
            ? <>
                <Outlet />
                <button className="sign-out-button" onClick={() => handleSignOut()}>Sign Out</button>
            </>
            : <div className="page-container">
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
        }
    </>
  );
};

export default Login;

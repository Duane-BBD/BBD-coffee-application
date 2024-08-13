import React, { useEffect, useState } from "react";
import "../static/Login.css";
import { GoogleLogin } from '@react-oauth/google';
import { jwtDecode } from 'jwt-decode';
import { Outlet, useLocation, useNavigate } from "react-router-dom";
import useUserDetails from "../../../hooks/useUserDetails";
import AskID from "./AskID";

const Login = () => {
    const navigate = useNavigate();
    const location = useLocation();
    const [isLogged, setIsLogged] = useState(localStorage.getItem('logged') || "false");
    const [googleSigned, setGoogleSiged] = useState(localStorage.getItem('googleS') || "false");
    const { userDetails, setUserDetails } = useUserDetails();

    useEffect(() => {
        if (isLogged === "true" && location.pathname === '/') {
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
            }
        }
        console.log(userDetails);
    }, [isLogged, location.pathname, userDetails, navigate]);

    const handleSignOut = () => {
        localStorage.clear();

        setUserDetails({});
        setIsLogged("false");
        setGoogleSiged("false");

        navigate('/');
    };

    return (
        <>
            {isLogged === "true"
                ? <>
                    <Outlet />
                    <button className="sign-out-button" onClick={handleSignOut}>Sign Out</button>
                </>
                : googleSigned === 'true'
                    ? <AskID setIsLogged={setIsLogged} />
                    : <div className="page-container">
                        <div className="login-container">
                            <div className="login-content">
                                <h1>Coffee at BBD</h1>
                                <GoogleLogin
                                    onSuccess={(credentialResponse) => {
                                        console.log(credentialResponse);
                                        const decoded = jwtDecode(credentialResponse.credential);
                                        localStorage.setItem('googleS', 'true');
                                        setGoogleSiged('true');
                                        console.log(decoded);
                                    }}
                                    onError={() => {
                                        console.log('Login Failed');
                                    }}
                                />
                            </div>
                        </div>
                    </div>
            }
        </>
    );
};

export default Login;

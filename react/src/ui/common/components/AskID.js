import React, { useEffect, useState } from 'react'
import useUserDetails from '../../../hooks/useUserDetails';
import { getUserDetails } from '../../../services/userDetailsService';
import "../static/Login.css";



const AskID = ({setIsLogged}) => {
    const [userID, setUserID] = useState();
    const { userDetails, setUserDetails } = useUserDetails()
  
    const handleLogin = async () => {
        if (userID) {
            try {
                await getUserDetails(userID, setUserDetails);
            } catch (error) {
                console.log(error);
            } finally {
                if (userDetails.userID) {
                    setIsLogged("true");
                    localStorage.setItem('logged', "true");
                }
            }
        }
    }

  return (
    <div className="page-container">
                <div className="login-container">
                    <div className="login-content">
                        <h1>Please enter userID to continue with</h1>
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
                            Submit
                        </button>
                        
                    </div>
                </div>
        </div>
  )
}

export default AskID
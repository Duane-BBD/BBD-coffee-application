import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { registerUserService } from '../../../services/registerUserService';

function RegisterUser() {
    const navigate = useNavigate();
    const [firstName,setFirstName]=useState("");
    const [lastName,setLastName]=useState("");
    const [userID,setUserID]=useState("");
    const [officeName,setOfficeName]=useState("");
    
    const registerUser=()=>{
        if(firstName !== '' && lastName !== '' && userID !== '' && officeName !== '') 
            registerUserService(firstName, lastName, userID, officeName)
    }
  return (
    <div className="page-container">
    <div className="login-container">
        <div className="login-content">
            <h1>Register user</h1>
            <input
                type="text"
                placeholder="Enter first name"
                value={firstName}
                onChange={(e) => setFirstName(e.target.value)}
                className="login-input"
                autoComplete="off"
                required
            />
            <input
                type="text"
                placeholder="Enter last name"
                value={lastName}
                onChange={(e) => setLastName(e.target.value)}
                className="login-input"
                autoComplete="off"
                required
            />
            <input
                type="text"
                placeholder="Enter userID"
                value={userID}
                onChange={(e) => setUserID(e.target.value)}
                className="login-input"
                autoComplete="off"
                required
            />            
            <input
                type="text"
                placeholder="Enter office name"
                value={officeName}
                onChange={(e) => setOfficeName(e.target.value)}
                className="login-input"
                autoComplete="off"
                required
            />
            <button onClick={registerUser} className="login-button">
                submit
            </button>
        </div>
    </div>
</div>
  )
}

export default RegisterUser
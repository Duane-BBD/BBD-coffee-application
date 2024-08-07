import React, { useState } from 'react'
import "../../common/static/Login.css";
import { useNavigate } from "react-router-dom";
import { addAvailableService } from '../../../services/addAvailableService';

function AddAvailProduct() {
    const navigate=useNavigate();
    const [productName,setProductName]=useState("");
    const [officeName,setOfficeName]=useState("");

    const submitAddAvail =()=>{
        if(productName!=='' && officeName!=='') 
            addAvailableService(productName,officeName)
            navigate('/admin-home')
        
    }
  return (
    <div className="page-container">
        <div className="login-container">
            <div className="login-content">
                <h1>Add new products availababilty to a location</h1>
                <input
                    type="text"
                    placeholder="Enter product name"
                    value={productName}
                    onChange={(e) => setProductName(e.target.value)}
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
                <button onClick={submitAddAvail} className="login-button">
                    submit
                </button>
            </div>
        </div>
    </div>
  )
}

export default AddAvailProduct
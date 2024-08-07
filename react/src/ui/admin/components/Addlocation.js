import React, { useState } from "react";
import "../../common/static/Login.css";
import { useNavigate } from "react-router-dom";
import { newLocationService } from "../../../services/newLocationService";

function Addlocation() {
    const [offices, setOffices] = useState([]);
    const navigate = useNavigate()
    const [officeName,setOfficeName]= useState("")

    const submitproductname =()=>{
        console.log(officeName,'officename')
        let ofname={officeName};
        newLocationService(ofname);
        navigate('/admin-home')
    }
  return (
    <div className="page-container">
        <div className="login-container">
            <div className="login-content">
                <h1>Add new locations</h1>
                <input
                    type="text"
                    placeholder="Enter new location"
                    value={officeName}
                    onChange={(e) => setOfficeName(e.target.value)}
                    className="login-input"
                    autoComplete="off"
                    required
                />
                <button onClick={submitproductname} className="login-button">
                    submit
                </button>
            </div>
        </div>
    </div>
  );
}

export default Addlocation


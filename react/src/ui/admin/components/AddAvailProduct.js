import React, { useEffect, useState } from 'react';
import "../../common/static/Login.css";
import { useNavigate } from "react-router-dom";
import { addAvailableService } from '../../../services/addAvailableService';
import { allproductService } from '../../../services/productService';
import { allLocation } from '../../../services/locationService';
function AddAvailProduct() {
    const navigate = useNavigate();
    const [productName, setProductName] = useState("");
    const [officeName, setOfficeName] = useState("");
    const [errors, setErrors] = useState({});
    const [productOptions,setProductOptions]=useState([]); 
    const [officeOptions,setOfficeOptions]=useState([]);
    
    useEffect( ()=>{
        allproductService(setProductOptions);
    },[productOptions])    
    
    useEffect( ()=>{
        allLocation(setOfficeOptions);
    },[officeOptions])    

    const submitAddAvail = () => {
        addAvailableService(productName, officeName);
        navigate('/admin/admin-home');
    };

    return (
        <div className="page-container">
            <div className="login-container">
                <div className="login-content">
                    <h1>Add new product availability to a location</h1>

                    <select
                        value={productOptions.productName}
                        onChange={(e) => setProductName(e.target.value)}
                        className="login-input"
                        required
                    >
                        <option value="" disabled>Select product</option>
                        {productOptions.map((product, index) => (
                            <option key={index} value={product.productName}>{product.productName}</option>
                        ))
                        }
                    </select>

                    <select
                        value={officeOptions.officeName}
                        onChange={(e) => setOfficeName(e.target.value)}
                        className="login-input"
                        required
                    >
                        <option value="" disabled>Select office</option>
                        {officeOptions.map((office, index) => (
                            <option key={index} value={office.officeName}>{office.officeName}</option>
                        ))}
                    </select>
                    
                    <button onClick={submitAddAvail} className="login-button">
                        Submit
                    </button>
                </div>
            </div>
        </div>
    );
}

export default AddAvailProduct;

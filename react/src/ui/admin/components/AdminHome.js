import React from 'react';
import { useNavigate } from 'react-router-dom';
import { PiBuildingOfficeBold } from "react-icons/pi";
import { MdProductionQuantityLimits } from "react-icons/md";
import { GiArchiveRegister } from "react-icons/gi";
import backgroundimg from "../../common/images/front-page-backgroundimg.png";
import "../static/AdminHome.css";

const AdminHome = () => {
    const navigate = useNavigate();
    return (
        <div>
            <img src={backgroundimg} className='adminbackgroundimg' alt="Background" />
            <div className="flex-container">
                <button className="flex-item" onClick={() => navigate("/add-location")}>
                    <PiBuildingOfficeBold />
                    <h3>Add new office</h3>
                </button>
                <button className="flex-item" onClick={() => navigate("/add-availproducts")}>
                    <MdProductionQuantityLimits />
                    <h3>Add more products</h3>
                </button>
                <button className="flex-item" onClick={() => navigate("/register-user")}>
                    <GiArchiveRegister />
                    <h3>Register user</h3>
                </button>
            </div>
        </div>
    );
};

export default AdminHome;

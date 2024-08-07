import React, { useEffect, useState } from 'react'
import FrontPage from '../../common/components/FrontPage'
import { Link, useNavigate } from 'react-router-dom';
import { SlArrowRight } from 'react-icons/sl';
import Coffeebean from "../../common/images/coffeebean.png";
import { allLocation } from "../../../services/locationService";
import { IoIosAddCircleOutline } from "react-icons/io";
import { IoAddCircleSharp } from "react-icons/io5";
import { newLocationService } from '../../../services/newLocationService';
import "../static/AdminHome.css"
import { PiBuildingOfficeBold } from "react-icons/pi";
import { MdProductionQuantityLimits } from "react-icons/md";
import backgroundimg from "../../common/images/front-page-backgroundimg.png"
import { GiArchiveRegister } from "react-icons/gi";

const AdminHome = () => {
    const navigate = useNavigate()
  return (
    <div>
        <img src={backgroundimg} className='adminbackgroundimg'/>
        <div class="flex-container">
            <button class="flex-item" onClick={() => navigate("/add-location")}>
                <PiBuildingOfficeBold/>
                <h3>Add new office</h3>
            </button>
            <button class="flex-item" onClick={() => navigate("/add-availproducts")}>
                <MdProductionQuantityLimits/>
                <h3>Add more products</h3>
            </button>
            <button class="flex-item" onClick={()=>navigate("/register-user")}>
                <GiArchiveRegister/>
                <h3>Register user</h3>
            </button>
        </div>
    </div>
  )
}

export default AdminHome
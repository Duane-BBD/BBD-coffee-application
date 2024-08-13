import React from 'react'
import "../static/Navbar.css"
import { PiHouseFill } from "react-icons/pi";
import { IoBag } from "react-icons/io5";
import { useNavigate } from 'react-router-dom';
import { FaRegListAlt } from "react-icons/fa";

export default function Navbar({colorChange,navtype}) {
    const navigate = useNavigate();
  return (
    <div className='nav'>
        <div className='navbar'>
            <button className='home-button' onClick={() => navtype==='users'? navigate('/user/all-office') : navigate('/barista/home-page') }>
                <PiHouseFill className={colorChange?'home-change' : 'home'}/> 
            </button>
            <button className='cart-button' onClick={() => navtype==='users'? navigate('/user/check-out'): navigate('/barista/take-orders')}>
                { navtype=='users'? <IoBag className={colorChange? 'home':  'home-change'}/>: <FaRegListAlt className={colorChange? 'home':  'home-change'} /> }
            </button>
    
        </div>
    </div>
  )
}

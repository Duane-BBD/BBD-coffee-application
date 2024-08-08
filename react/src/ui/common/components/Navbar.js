import React, { useState } from 'react'
import "../static/Navbar.css"
import { PiHouseFill } from "react-icons/pi";
import { IoBag } from "react-icons/io5";
import { useNavigate } from 'react-router-dom';

export default function Navbar({colorChange}) {
    const navigate = useNavigate();
  return (
    <div className='nav'>
        <div className='navbar'>
            <button className='home-button' onClick={() => navigate('/user/all-office') }>
                <PiHouseFill className={colorChange?'home-change' : 'home'}/> 
            </button>
            <button className='cart-button' onClick={() => navigate('/user/check-out')}>
                <IoBag className={colorChange? 'home':  'home-change'}/>
            </button>
            
        </div>
    </div>
  )
}

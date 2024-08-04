import React from 'react'
import "../static/Navbar.css"
import { PiHouseFill } from "react-icons/pi";
import { IoBag } from "react-icons/io5";

export default function Navbar() {
  return (
    <div className='nav'>
        <div className='navbar'>
            <button className='home-button'>
                <PiHouseFill/> 
            </button>
            <button className='cart-button'>
                <IoBag/>
            </button>
            
        </div>
    </div>
  )
}

import React from 'react'
import "../static/Navbar.css"
import { PiHouseFill } from "react-icons/pi";
import { IoBag } from "react-icons/io5";

export default function Navbar() {
  return (
    <div className='nav'>
        <div className='navbar'>
            <PiHouseFill/>
            <IoBag/>
        </div>
    </div>
  )
}

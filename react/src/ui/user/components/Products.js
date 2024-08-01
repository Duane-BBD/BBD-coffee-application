import React, { useEffect, useState } from 'react';
import "../static/Products.css";
import backgroundimg from "../../common/images/coffeeheader.png";
import { BiSearch } from 'react-icons/bi';
import {IoIosArrowDown} from 'react-icons/io';
import coffee from "../../common/images/coffee.png";
import Logo from "../../common/images/logo2.png";
import allproductService from '../../../services/productService';

export default function Products() {
    const [menu, setMenu] = useState([])

    useEffect(() => {
        allproductService(setMenu)
    }, [menu])

  return (
    <div>
        <img 
            src={backgroundimg}
            className="backroundimg2"
        />
        <div className='on-backgroundimg'>
            <h5>Office</h5>

            <div className='dropdown'>
                <button className='dropdown-button'> Johannesburg</button>
                <div className='dropdown-content'>
                    <a href="#">Pune</a>
                    <a href="#">Cape town</a>
                    <a href="#">Link 3</a>
                </div>
                <IoIosArrowDown/>
            </div>
        <div >
          <img src={Logo} className='logo'/>
        </div>
        </div>
        <div className='search-bar-wrapper'>
            <div className='search-bar'>
                <BiSearch className='search-icon' />
                <input type='text' className='search-baris' placeholder='Search drinks' />
            </div>
        </div>
        <div class="scrollable-menu">
            {category.map( (category,index)=>(
            <button key={index} >{category.name}</button>
            ))}
        </div>
      <div className='card-container'>
        {menu.map((menus, index) => (
        <div className='card-disp' key={index}>
            <div className="card">
            <img
                src={menus.img}
                alt="Cappuccino"
                className="card-img-top"
            />     
                <h5 className="card-title">{menus.name}</h5>
                <p className="card-text">{menus.description}
                </p>
            
            </div>
        </div>
        ))}
        </div>
    </div>
  )
}


import React, { useEffect, useState } from 'react';
import "../static/Products.css";
import backgroundimg from "../../common/images/front-page-backgroundimg.png";
import { BiSearch } from 'react-icons/bi';
import {IoIosArrowDown} from 'react-icons/io';
import coffee from "../../common/images/coffee.png";
import Logo from "../../common/images/logo2.png";
import allproductService from '../../../services/productService';

export default function Products() {
    const category=[
        {
            name:"All",
            link:"s"
        },
        {
            name:"Coffee",
            link:"s"
        },
        {
            name:"Other hot drinks",
            link:"s"
        },
        {
            name:"Tea",
            link:"s"
        },
        {
            name:"Ice tea",
            link:"s"
        },
        {
            name:"Other hot drinks",
            link:"s"
        },
        {
            name:"Tea",
            link:"s"
        },
        {
            name:"Ice tea",
            link:"s"
        },
    ]

    const [menu, setMenu] = useState([])
    // const [offices,setOffices]=useState([])

    useEffect(() => {
        allproductService(setMenu)
    }, [menu])
    
    // useEffect(()=>{

    // })
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
        <img src={Logo} className='logo'/>
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
                src={coffee}
                alt="Cappuccino"
                className="card-img-top"
            />     
                <h5 className="card-title">{menus.productName}</h5>
                <p className="card-text">{menus.description}
                </p>
            
            </div>
        </div>
        ))}
        </div>
    </div>
  )
}


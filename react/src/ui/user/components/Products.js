import React, { useEffect, useState } from 'react';
import "../static/Products.css";
import backgroundimg from "../../common/images/front-page-backgroundimg.png";
import { BiSearch } from 'react-icons/bi';
import {IoIosArrowDown} from 'react-icons/io';
import coffee from "../../common/images/coffee.png";
import Logo from "../../common/images/logo2.png";
import { productsAvailable } from '../../../services/productService';
import { useLocation, useNavigate } from 'react-router-dom';
import { allLocation } from '../../../services/locationService';

export default function Products() {
    const navigate = useNavigate()
    const location = useLocation()
    const searchParams = new URLSearchParams(location.search)
    const [offices, setOffices] = useState([])
    const officeID = searchParams.get('officeID')

    useEffect(() => {
        allLocation(setOffices)
    }, [offices])

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
    const [dummyMenu,setDummyMenu] = useState([])
    // const [offices,setOffices]=useState([])

    useEffect(() => {
        productsAvailable(officeID, setMenu)
    }, [menu])

    const searchProducts=(searchParam)=>{
        // if(searchParam==''){
        //     setDummyMenu(menu)
        //     return
        // }
        let prod = []
        for(let item in menu) {
            let name = item.productName
            console.log(name)
            // if(name.indexOf(searchParam) !== -1){
            //     prod.push(item);
            // }
        }
        setDummyMenu(prod)
    }
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
                    {offices.map((office, index) => (
                        <a href={`/product?officeID=${encodeURIComponent(office.officeID)}`} key={index}>{office.officeName}</a>
                    ))}
                </div>
                <IoIosArrowDown/>
            </div>
        <img src={Logo} className='logo'/>
        </div>
        <div className='search-bar-wrapper'>
            <div className='search-bar'>
                <BiSearch className='search-icon' />
                <input 
                    type='text' 
                    className='search-baris' 
                    placeholder='Search drinks' 
                    // value=""
                    onChange={e => {
                        e.preventDefault()
                        searchProducts(e.target.value)
                    }}
                />
            </div>
        </div>
        <div class="scrollable-menu">
            {category.map( (category,index)=>(
            <button key={index} >{category.name}</button>
            ))}
        </div>
      <div className='card-container'>
        {menu.map((menus, index) => (
        <div className='card-disp' key={index} onClick={e => navigate(`/product-details?productID=${encodeURIComponent(menus.productID)}`)}>
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

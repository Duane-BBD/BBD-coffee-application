import React, { useEffect, useState } from 'react';
import "../static/Products.css";
import backgroundimg from "../../common/images/front-page-backgroundimg.png";
import { BiSearch } from 'react-icons/bi';
import {IoIosArrowDown} from 'react-icons/io';
import coffee from "../../common/images/coffee.png";
import Logo from "../../common/images/logo2.png";
import { productsAvailable } from '../../../services/productService';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { allLocation } from '../../../services/locationService';

export default function Products() {
    const navigate = useNavigate()
    const location = useLocation()
    let office = location.state
    // const searchParams = new URLSearchParams(location.search)
    const [offices, setOffices] = useState([])
    const [search, setSearch] = useState(false)
    // const officeID = searchParams.get('officeID')

    useEffect(() => {
        if (!office) navigate("/");
    }, [])

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
    const [dummyMenu,setDummyMenu] = useState(menu)
    // const [offices,setOffices]=useState([])

    useEffect(() => {
        if (office) {
            productsAvailable(office.officeID, setMenu)
            if (!search) setDummyMenu(menu)
        }
    }, [menu])

    const searchProducts=(searchParam)=>{
        if(searchParam==''){
            setDummyMenu(menu)
            setSearch(false)
            return
        }
        setSearch(true)
        let prod = []
        for (let i = 0; i < menu.length; i++) {
            let name = menu[i].productName;
            if (name.toLowerCase().indexOf(searchParam.toLowerCase()) !== -1) {
                // console.log('Avail: ' + name);
                prod.push(menu[i]);
            }
        }
        setDummyMenu(prod)
        // console.log("Dummy: "+dummyMenu)
    }
  return ( 
    <>
        {office.officeID != null
            ? <div>
                <img 
                    src={backgroundimg}
                    className="backroundimg2"
                />
                <img src={Logo} className='logo'/>

                <div className='on-backgroundimg'>
                    <h5>Office</h5>
                    <div className='dropdown'>
                        <button className='dropdown-button'> {office.officeName} </button>
                        <div className='dropdown-content'>
                            {offices.map((off, index) => (
                                <Link to={`/product`} state={off} key={index}>{off.officeName}</Link>
                            ))}
                        </div>
                        <IoIosArrowDown/>
                    </div>
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
                    {category.map((category,index)=>(
                        <button key={index} >{category.name}</button>
                    ))}
                </div>
            <div className='card-container'>
                {dummyMenu.map((menus, index) => (
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
            : <div>Something!</div>
        }
    </>
  )
}

import React, { useEffect, useState } from 'react';
import "../static/Products.css";
import backgroundimg from "../../common/images/front-page-backgroundimg.png";
import { BiSearch } from 'react-icons/bi';
import {IoIosArrowDown} from 'react-icons/io';
import Logo from "../../common/images/logo2.png";
import { productsAvailable } from '../../../services/productService';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { allLocation } from '../../../services/locationService';
import Navbar from '../../common/components/Navbar';
import { allTags } from '../../../services/tagService';

const BASE_URL = "http://localhost:3000"

export default function Products() {
    const navigate = useNavigate()
    const location = useLocation()
    let office = location.state || {}
    const [offices, setOffices] = useState([])
    const [search, setSearch] = useState(false)
    const [tags, setTags] = useState([])
    const [selectedTag, setSelectedTag] = useState({tagID: 0, tagName: 'All'})

    useEffect(() => {
        if (office.officeID == null) navigate("/user/all-office");
    }, [])

    useEffect(() => {
        allLocation(setOffices)
    }, [offices])

    useEffect(() => {
        allTags(setTags);
    }, [tags])

    const [menu, setMenu] = useState([])
    const [dummyMenu,setDummyMenu] = useState(menu)

    useEffect(() => {
        if (office) {
            productsAvailable(office.officeID, setMenu)
            if (!search && selectedTag.tagID === 0) setDummyMenu(menu)
        }
    }, [menu])
    
    useEffect(() => {
        if (selectedTag.tagID === 0) {
            setDummyMenu(menu);
        }
        if (selectedTag.tagID !== 0) {
            const filteredMenu = menu.filter(item => {
                const tagsArray = JSON.parse(item.associatedTags);
                return tagsArray.includes(selectedTag.tagID);
            });
            setDummyMenu(filteredMenu);
        } else {
            setDummyMenu(menu);
        }
    }, [selectedTag])

    const searchProducts=(searchParam) => {
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
                prod.push(menu[i]);
            }
        }
        setDummyMenu(prod)
    }
    
  return ( 
    <div>
        <img 
            src={backgroundimg}
            className="backroundimg2"
        />
        <img src={Logo} className='logo'/>
        
        <div className='on-backgroundimg'>
            <h5>Office</h5>
            <div className='dropdown'>
                <button className='dropdown-button'> {office.officeName}<IoIosArrowDown /></button>
                <div className='dropdown-content'>
                    {offices.map((off, index) => (
                        <Link 
                            to="/user/product" state={off} key={index}
                        >
                            {off.officeName}
                        </Link>
                    ))}
                </div>
                
            </div>
        </div>

        <div className='search-bar-wrapper'>
            <div className='search-bar'>
                <BiSearch className='search-icon' />
                <input 
                    type='text' 
                    className='search-baris' 
                    placeholder='Search drinks' 
                    onChange={e => {
                        e.preventDefault()
                        searchProducts(e.target.value)
                    }}
                />
            </div>
        </div>
        <div class="scrollable-menu">
            <button className={selectedTag.tagID === 0 ? 'selected-tag' : 'notselected'} onClick={() => setSelectedTag({tagID: 0, tagName: 'All'})}>All</button>
            {tags.map((tag,index) => (
                <button key={index}  className={selectedTag.tagID === tag.tagID ? 'selected-tag' : 'notselected'} onClick={() => setSelectedTag(tag)}>{tag.tagName}</button>
            ))}
        </div>
        <div className='card-container'>
            {dummyMenu.map((menus, index) => (
                <div 
                    className='card-disp' 
                    key={index} 
                    onClick={() => navigate(`/user/product-details?productID=${encodeURIComponent(menus.productID)}`, { state: office })}
                >
                    <div className="card">
                    <img
                        src={menus.imageURL}
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
        <div className="content">
        <Navbar colorChange={true} navtype='users'/>

        </div>
    </div>
  )
}

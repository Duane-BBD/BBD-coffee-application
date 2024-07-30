import React from 'react'
import "../static/Products.css"
import backgroundimg from "../images/coffeebeans.png";
import { BiSearch } from 'react-icons/bi';
import {IoIosArrowDown} from 'react-icons/io'
import coffee from "../images/coffee.png"
import Logo from "../images/logo2.png"
const menu=[
    {
        name: " Cappuccino",
        link: "/page1",
        img:coffee,
        description:"A description about the drink can go here and can take 2 I..."
      },
      {
        name: " Cappuccino",
        link: "/page1",
        img:coffee,
        description:"A description about the drink can go here and can take 2 I..."
      },
      {
        name: " Cappuccino",
        link: "/page1",
        img:coffee,
        description:"A description about the drink can go here and can take 2 I..."
      },
]
export default function Products() {
  return (
    <div>
        <img src={backgroundimg}
        className="backroundimg2"
        />
        <div className='on-backgroundimg'>
        <h5>Office</h5>
        <div className='inner-DropDown'>
        <h4>Johannesburg</h4>
        <IoIosArrowDown/>
        </div>
        <div >
          <img src={Logo} className='logo'/>
        </div>
        </div>

        <div>
            <div className='products-page'>
                <div className='search-bar'>
                    <BiSearch/>
                    <h4> Search drinks</h4>
                </div>
            </div>
        </div>
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
  )
}


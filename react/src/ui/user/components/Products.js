import React from 'react'
import "../../static/Products.css"
import backgroundimg from "../../common/images/coffeeheader.png";
import { BiSearch } from 'react-icons/bi';
import {IoIosArrowDown} from 'react-icons/io'
import coffee from "../../common/images/coffee.png"
import Logo from "../../common/images/logo2.png"
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


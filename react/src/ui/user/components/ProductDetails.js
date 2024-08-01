import React from 'react'
import { SlArrowRight } from 'react-icons/sl'
import "../static/ProductDetails.css"
import drink from "../../common/images/coffee.png"
import { TbMilk } from "react-icons/tb";
import { MdKeyboardArrowLeft } from "react-icons/md";
import {IoIosArrowDown} from 'react-icons/io';
import { CgNotes } from "react-icons/cg";
import Navbar from './Navbar';
export default function ProductDetails() {
    const drinks=[
        {
            name: "cappucino",
            img:{drink},
            description:"sedfsfsd dfsfsfssf sesfffs sdfsdffsd sfdfdsfdfds dsfsdfdsdfs fsddfdff dsfsfdfddf dfsfddfddfs dffdfd fdsdffdfd ffdsdfd sfsdf dsfds fdsfsd f fdf dfds  fdfd fdfdsfds fds sfd s ffds sfddfs"
        }
    ]
    const milktype =[
        {
            name:"milk",
        },
        {
            name:"almond milk",
        }, 
        {
            name:"lactose milk",
        },
    ]
  return (
    <div className='productdetails'> 
        <div className='top-nav'>
            <div className='arrow-left'>  
                <MdKeyboardArrowLeft/>
            </div>  
            <h4>ProductDetails</h4>
        </div>
        <div className='product-content'>
            <img className='productimg' src={drink}/>
            <h2> Cappuccino </h2>
            <p> A concentrated coffee brewed with 30 ml of hot water forced through finely-ground beans. Each shot delivers a bold flavor with a rich crema on top.</p> 
        </div>
        <div className='milkdropdown'>
            <div className='milky'>
                <TbMilk/>
                <button className='milkdropdown-button'> Almond milk</button>
                <IoIosArrowDown/>
            </div>
            <div className='milkdropdown-content'>
            {
                milktype.map((milktypes, index) => (
                    <div className='milk-dropdown' key={index}>
                        <a href="#">{milktypes.name}</a>
                    </div>
                ))
            }   
            </div>
        </div>
        <div>
            <input type='text' className='search-notes' placeholder='Add notes' /> 
            <div className='notes'>
                <CgNotes/>
            </div>
        </div>
        <div >
                <button className='submit'> Add to order</button>
        </div>
    <Navbar/>
    </div>
  )
}

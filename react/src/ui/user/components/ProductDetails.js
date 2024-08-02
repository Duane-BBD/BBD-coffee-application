import React, { useEffect, useState } from 'react'
import { SlArrowRight } from 'react-icons/sl'
import "../static/ProductDetails.css"
import { productDetails } from '../../../services/productService'
import { allMilkType, searchMilkType } from '../../../services/milkTypeService';
import drink from "../../common/images/coffee.png"
import { TbMilk } from "react-icons/tb";
import { MdKeyboardArrowLeft } from "react-icons/md";
import {IoIosArrowDown} from 'react-icons/io';
import { CgNotes } from "react-icons/cg";
import Navbar from './Navbar';
import { useLocation } from 'react-router-dom';

const ProductDetails = () => {
    const location = useLocation()
    const searchParams = new URLSearchParams(location.search)
    let productID = searchParams.get('productID');
    let officeID = 1;
    let updatedCart = []
    const [flag, setFlag] = useState(false)
    const [cart, setCart] = useState(JSON.parse(localStorage.getItem("cart")) || [])
    const [product, setProduct] = useState({})
    const [milkType, setMilkType] = useState([])
    const [selected, setSelected] = useState({milkTypeID: 1, milkTypeValue: "Full cream milk"})
    const [note, setNote] = useState("")

    useEffect(() => {
        productDetails(productID, setProduct);
    }, [product]);

    useEffect(() => {
        allMilkType(setMilkType);
    }, [milkType]);

    const addToCart = () => {
        for (let i = 0; i < cart.length; i++) {
            if(cart[i].milkTypeValue == selected.milkTypeValue && cart[i].note == note && !flag) {
                cart[i].quantity += 1;
                setFlag(true);
            }
        }
        const toAdd = {
            productName: product.productName,
            quantity: 1,
            userID: 1056,
            officeID: officeID,
            milkTypeValue: selected.milkTypeValue,
            note: note
        };

        updatedCart = flag ? [...cart] : [...cart, toAdd];
        localStorage.setItem("cart", JSON.stringify(updatedCart));
        console.log('\nupdatedCart: ')
        console.log(JSON.stringify(updatedCart))
        console.log('\nCart: ')
        console.log(cart)
        console.log('\nTo Add:')
        console.log(toAdd)
        setCart(JSON.parse(localStorage.getItem("cart")))
        setFlag(false)
        // localStorage.removeItem("cart")
    }

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
            <h2> {product.productName} </h2>
            <p> {product.description} </p> 
        </div>
        <div className='milkdropdown'>
            <div className='milky'>
                <TbMilk className='bottle-icon'/>
                <button className='milkdropdown-button'> {selected.milkTypeValue} </button>
                <IoIosArrowDown className='arrow-down'/>
            </div>
            <div className='milkdropdown-content'>
            {
                milkType.map((types, index) => (
                    <div className='milk-dropdown' key={index}>
                        <a onClick={() => {searchMilkType(types, setSelected)}}>{types.milkTypeValue}</a>
                    </div>
                ))
            }   
            </div>
        </div>
        <div className='search-notes'>
            <input type='text'  placeholder='Add notes' onChange={e => setNote(e.target.value)}/> 
            <div className='notes'>
                <CgNotes/>
            </div>
        </div>
        <div className='submiting' >
            <button className='submit' onClick={addToCart}> Add to order </button>
        </div>
        <div className='navbar-spacing'> 
        <Navbar/>
        </div>
    </div>
  )
}

export default ProductDetails
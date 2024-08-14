import React, { useEffect, useState } from 'react';
import "../static/ProductDetails.css";
import { productDetails } from '../../../services/productService';
import { allMilkType, searchMilkType } from '../../../services/milkTypeService';
import { TbMilk } from "react-icons/tb";
import { MdKeyboardArrowLeft } from "react-icons/md";
import {IoIosArrowDown} from 'react-icons/io';
import { CgNotes } from "react-icons/cg";
import Navbar from '../../common/components/Navbar';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import useUserDetails from '../../../hooks/useUserDetails';
import Modal from '../../common/components/Modal';
import { MdCancel } from "react-icons/md";

const ProductDetails = () => {
    const navigate = useNavigate();
    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);
    let productID = searchParams.get('productID');
    let office = location.state || {}
    const [count, setCount] = useState(0)
    const { userDetails } = useUserDetails();
    const [cart, setCart] = useState(JSON.parse(localStorage.getItem("cart")) || [])
    const [product, setProduct] = useState({})
    const [milkType, setMilkType] = useState([])
    const [selected, setSelected] = useState({milkTypeID: 1, milkTypeValue: "Full cream milk"})
    const [note, setNote] = useState("")
    const [open, setOpen] = React.useState(false);
 
    const handleClose = () => {
        setOpen(false);
    };
 
    const handleOpen = () => {
        setOpen(true);
    };
    useEffect(() => {
        productDetails(productID, setProduct);
    }, [product]);

    useEffect(() => {
        allMilkType(setMilkType);
    }, [milkType]);

    const addToCart = () => {
        let updatedCart = [...cart];
        let itemFound = false;
        for (let i = 0; i < updatedCart.length; i++) {
            if (updatedCart[i].productName === product.productName && updatedCart[i].milkTypeValue === selected.milkTypeValue && updatedCart[i].note === note) {
                updatedCart[i].quantity += 1;
                itemFound = true;
                setCount(updatedCart[i].quantity);
                break;
            }
        }
    
        if (!itemFound) {
            updatedCart.push({
                productName: product.productName,
                quantity: 1,
                userID: userDetails.userID,
                officeID: office.officeID,
                milkTypeValue: selected.milkTypeValue,
                note: note,
                imageURL: product.imageURL
            });
            setCount(count+1);

        }

        
        localStorage.setItem("cart", JSON.stringify(updatedCart));
        setCart(updatedCart);
        handleOpen();
    }
    
  return (
    <div className='productdetails'> 
        <div className='top-nav'>
            <button className='arrow-left' onClick={e => navigate(-1)} >  
                <MdKeyboardArrowLeft/>
            </button>  
            <h4> {product.productName}</h4>
        </div>
        <Modal isOpen={open} onClose={handleClose}>
            <div  className='modalcss'>
                <div >
                    {count} items added to cart!
                </div>
                <div className='modal-button'>
                    <MdCancel />
                </div>
            </div>
        </Modal>
        <div className='product-container'>
            <div className='product-content'>
                <img className='productimg' src={product.imageURL}/>
                {/* <h2> {product.productName} </h2>
                <p> {product.description} </p>  */}
            </div>
            <div className='product-right'>
                <div className='product-content'>
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
                    <input type='text'  placeholder='Add notes' className='add-notes' onChange={e => setNote(e.target.value)}/> 
                        <div className='notes'>
                            <CgNotes/>
                        </div>
                    </div>
                    <div className='submiting' >
                        <button className='submit' onClick={addToCart}> Add to order </button>
                    </div>
                </div>
            </div>
        <div className='content'> 
        <Navbar colorChange={true} navtype='users'/>
        </div>
    </div>
  )
}

export default ProductDetails
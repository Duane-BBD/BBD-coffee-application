import React from 'react'
import "../static/Missing.css"
import backgroundimg from '../images/front-page-backgroundimg.png'
const Missing = () => {
  return (
    <div className='missing-container'>
        <img src={backgroundimg} className='adminbackgroundimg' alt="Background" />
        <img />
        <div className='missing-content'>
            <a href='/' className='missing-head' >
                <h1 >404!</h1>
                <br />
                <h1>
                    Page Does not Exist
                </h1>
            </a>
        </div>
    </div>
  )
}
 
export default Missing
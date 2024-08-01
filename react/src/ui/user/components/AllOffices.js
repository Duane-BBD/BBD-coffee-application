import React from 'react'
import FrontPage from './FrontPage';
import { SlArrowRight } from "react-icons/sl";
import { Link } from "react-router-dom";
import Coffeebean from "../../common/images/coffeebean.png"
import "../../static/AllOffices.css"
export default function AllOffices() {
    const locations = [
        {
            name: "Johannesburg",
            link: "/page1"
        },
        {
            name: "Pretoria",
            link: "/page1"
        },
        {
            name: "Cape Town",
            link: "/page1"
        },
        {
            name: "Pune",
            link: "/"
        }
    ];
  return (
    <div>
    <FrontPage/>
    <h3 className="pick-location">Pick your location</h3>
        {locations.map((location, index) => (
            <div className="mapping" key={index}>
                <Link to={location.link} className="location-option">
                    <img src={Coffeebean} className="coffeebean" />
                    <span>{location.name}</span>
                    <div className="arrow">
                        <SlArrowRight />
                    </div>
                </Link>
            </div>
        ))}
    </div>
  )
}
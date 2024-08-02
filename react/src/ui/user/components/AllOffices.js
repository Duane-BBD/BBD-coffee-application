import React, { useEffect, useState } from "react";
import FrontPage from './FrontPage';
import { SlArrowRight } from "react-icons/sl";
import { Link } from "react-router-dom";
import "../static/AllOffices.css";
import Coffeebean from "../../common/images/coffeebean.png";
import allLocation from "../../../services/locationService";

export default function AllOffices() {
    const [locations, setLocations] = useState([]);

    useEffect(() => {
        allLocation(setLocations)
    }, [locations])
    // const locations = [
    //     {
    //         name: "Johannesburg",
    //         link: "/page1"
    //     },
    //     {
    //         name: "Pretoria",
    //         link: "/page1"
    //     },
    //     {
    //         name: "Cape Town",
    //         link: "/page1"
    //     },
    //     {
    //         name: "Pune",
    //         link: "/"
    //     }
    // ];

  return (
    <div className="container">
        <div className="frontpage-container">
            <FrontPage/>
        </div>
        <div className="alloffices-container">
            <div className='alloffices'>
                <h3 className="pick-location">Pick your location</h3>
                    {locations.map((location, index) => (
                        <div className="mapping" key={index}>
                            <Link to={location.link} className="location-option">
                                <img src={Coffeebean} className="coffeebean" />
                                <span>{location.officeName}</span>
                                <div className="arrow">
                                    <SlArrowRight />
                                </div>
                            </Link>
                        </div>
                    ))}
            </div>
        </div>
    </div>
  )
}
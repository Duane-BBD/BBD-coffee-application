import React from "react";
import backgroundimg from "../../common/images/logo.png";
import "../../static/Location.css";
import { SlArrowRight } from "react-icons/sl";
import { Link } from "react-router-dom";
import Coffeebean from "../../common/images/coffeebean.png"
function Location() {
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
    <div className="location">
        <img className="backroundimg" src={backgroundimg} alt="background" />
        <h3 className="locatpick">Pick your location</h3>
        {locations.map((location, index) => (
            <div className="locat" key={index}>
                <Link to={location.link} className="locationoption">
                    <img src={Coffeebean} className="coffeebean" />
                    <span>{location.name}</span>
                    <div className="arrow">
                        <SlArrowRight />
                    </div>
                </Link>
            </div>
        ))}
    </div>
  );
}

export default Location;

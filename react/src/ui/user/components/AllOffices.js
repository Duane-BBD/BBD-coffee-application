import React, { useEffect, useState } from "react";
import FrontPage from './FrontPage';
import { SlArrowRight } from "react-icons/sl";
import { Link } from "react-router-dom";
import "../static/AllOffices.css";
import Coffeebean from "../../common/images/coffeebean.png";
import { allLocation } from "../../../services/locationService";
import { useLocationContext } from '../../../context/LocationContext';

export default function AllOffices() {
    const { setLocation } = useLocationContext();
    const [offices, setOffices] = useState([]);

    useEffect(() => {
        allLocation(setOffices);
    }, []);

    return (
        <div className="container">
            <div className="frontpage-container">
                <FrontPage />
            </div>
            <div className="alloffices-container">
                <div className='alloffices'>
                    <h3 className="pick-location">Pick your location</h3>
                    {offices.map((locate, index) => (
                        <div className="mapping" key={index}>
                            <Link
                                to={`/products`}
                                onClick={() => setLocation(locate)} // Set location on click
                                className="location-option"
                            >
                                <img src={Coffeebean} className="coffeebean" alt="Coffee bean" />
                                <span>{locate.officeName}</span>
                                <div className="arrow">
                                    <SlArrowRight />
                                </div>
                            </Link>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}

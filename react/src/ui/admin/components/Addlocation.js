import React, { useEffect, useState } from "react";
import "../static/AddLocation.css";
import { useNavigate } from "react-router-dom";
import { allLocation, newLocationService } from "../../../services/locationService";
import CoffeBean from "../../common/images/coffeebean.png";
import { BiSearch } from "react-icons/bi";

function AddLocation() {
    const [offices, setOffices] = useState([]);
    const navigate = useNavigate()
    const [officeName,setOfficeName]= useState("");
    const [search,setSearch]=useState(false);

    useEffect(() => {
        if(allLocation(setOffices)) {}
    }, [offices]);
 
    const [dummyOffice,setDummyOffice] = useState(offices);

    useEffect(() => {
        if (!search)
            setDummyOffice(offices);
    },[offices]) 

    const submitproductname =()=>{
        for (let i = 0; i < offices.length; i++) {
            if (offices[i].officeName.toLowerCase() === officeName.toLowerCase()) {
                alert('Location already exists ');
                break;
            }
        newLocationService(officeName)
    }}

    const searchOffices=(searchParam)=>{
        if(searchParam==''){
            setDummyOffice(offices)
            setSearch(false)
            return
        }
        setSearch(true)
        let off=[]
        for (let i=0; i<offices.length; i++){
            let name=offices[i].officeName;
            if(name.toLowerCase().indexOf(searchParam.toLowerCase())!==-1){
                off.push(offices[i]);
            } 
        }
        setDummyOffice(off)
    }
  return (
    <div className="page-container">
        <div className="addlocation-container">
            <div className="addlocation-content">
                <h1>Add new locations</h1>
                <input
                    type="text"
                    placeholder="Enter new location"
                    value={officeName}
                    onChange={(e) => setOfficeName(e.target.value)}
                    className="addlocation-input"
                    autoComplete="off"
                    required
                />
                <button onClick={submitproductname} className="addlocation-button">
                    submit
                </button>
                
            </div>
            <div className="get-office-div">
            <div className='search-bar-wrapper'>
                <div className='search-bar'>
                    <BiSearch className='search-icon' />
                    <input 
                        type='text' 
                        className='search-baris' 
                        placeholder='Search office' 
                        onChange={e => {
                            e.preventDefault()
                            searchOffices(e.target.value)
                        }}
                    />
                </div>
            </div>
                {dummyOffice.map((locate, index) => (
                    <div className="addlocation-mapping" key={index}>
                        <div
                        className="addlocation-option"
                        >
                            <img src={CoffeBean} className="coffeebean" />
                            <span>{locate.officeName}</span>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    </div>
  );
}

export default AddLocation


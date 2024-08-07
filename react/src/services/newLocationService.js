import axios from "../api/axios";

const newLocationService =async (officeName) => {
    try{
        const response =await axios.post("/office/add-location",officeName);
        if (response.data){
            console.log(response.data)
        }
    } catch(error){
        console.log(error);
    }
}
export {newLocationService};
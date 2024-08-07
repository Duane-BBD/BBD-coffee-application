import axios from "../api/axios";

const addAvailableService =async (productName, officeName) => {
    try{
        console.log(productName,officeName)
        const response =await axios.post("/availability/add-products", { "productName": productName, "officeName": officeName});
        if (response.data){
            console.log(response.data)
        }
    } catch(error){
        console.log(error);
    }
}
export {addAvailableService};
import axios from "../api/axios";

const registerUserService = async (firstName, lastName, userID, officeName) => {
    try{
        console.log(firstName, lastName, userID, officeName)
        const response = await axios.post("/users/register", { "firstName": firstName, "lastName": lastName, "userID": userID, "officeName": officeName });
        if (response.data){
            console.log(response.data)
        }
    } catch(error){
        console.log(error);
    }
}
export {registerUserService};
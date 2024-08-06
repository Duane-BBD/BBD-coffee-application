import axios from "../api/axios";

const getUserDetails = async (userID, setUserDetails) => {
    try {
        const response = await axios.get(`/app-user/get-user/${userID}`)
        if (response.data) {
            setUserDetails(response.data)
        }
    } catch (error) {
        console.log(error)
    }
}

export { getUserDetails };
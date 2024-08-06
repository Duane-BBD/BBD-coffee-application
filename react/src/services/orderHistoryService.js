import axios from "../api/axios";

const getTimeDetails = async (orderID, setTimeDetails) => {
    try {
        const response = await axios.get(`order-history/time-details/${orderID}`)
        if (response.data) {
            setTimeDetails(response.data)
        }
    } catch (error) {
        console.log(error)
    }
}

export { getTimeDetails }
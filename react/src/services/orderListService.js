import axios from "../api/axios";

const getAllOrders = () => {
    
}

const placeOrders = async (orderCart) => {
    try {
        const response = await axios.post("/order-creation", orderCart)
        if (response.data) {
            alert(response.data)
        }
    } catch (error) {
        console.log(error)
    }
}

export { getAllOrders, placeOrders }
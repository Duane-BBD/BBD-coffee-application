import axios from "../api/axios"

const allproductService = async (setMenu) => {
    let products = []

    try {
        const response = await axios.get("/products/get-all-products")
        if (response.data) {
            response.data.map(item => {
                products.push(item)
            })
            setMenu(products);
        }
    } catch (error) {
        console.log(error)
    }
}

export default allproductService
import axios from "../api/axios"

const allLocation = async (setLocations) => {
    let locations = []

    try {
        const response = await axios.get("/office/list-all-office")
        if (response.data) {
            response.data.map(item => {
                locations.push(item)
            })
            setLocations(locations);
        }
    } catch (error) {
        console.log(error)
    }
}

export default allLocation
import axios from "../api/axios"

const allLocation = async (setOffices) => {
    let locations = []

    try {
        const response = await axios.get("/office/list-all-office")
        if (response.data) {
            response.data.map(item => {
                locations.push(item)
            })
            setOffices(locations);
        }
    } catch (error) {
        console.log(error);
    }
}

const newLocationService =async (officeName) => {
    try{
        const response =await axios.post(`/office/add-location`, {"officeName": officeName});
        if (response.data){
            console.log(response.data)
            return true;
        }
    } catch(error){
        console.log(error)
        console.log(error.response.data.Error)
        return false;
    }
}

export { allLocation, newLocationService}
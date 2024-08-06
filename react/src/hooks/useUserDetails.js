import { useContext } from "react"
import UserDetailsContext from "../context/UserDetailsProvider"

const useUserDetails = () => {
    return useContext(UserDetailsContext)
}

export default useUserDetails
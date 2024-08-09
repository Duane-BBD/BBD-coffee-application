import axios from "axios";

const BASE_URL = "http://coffee-dev.us-east-1.elasticbeanstalk.com/bbd-coffee"

export default axios.create({
    baseURL: BASE_URL
});
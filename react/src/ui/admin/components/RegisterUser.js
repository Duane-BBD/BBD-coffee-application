import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import '../static/RegisterUser.css'
import { registerUserService } from '../../../services/registerUserService';
import { AiFillCheckCircle, AiFillCloseCircle, AiFillInfoCircle } from 'react-icons/ai';

const NAME_REGEX = /^[A-Z][a-z]{3,7}$/;
const USERID_REGEX = /^\d{4}$/;

function RegisterUser() {
    // const navigate = useNavigate();
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [userID, setUserID] = useState("");
    const [officeName, setOfficeName] = useState("");

    const [validFirstName, setValidFirstName] = useState(false);
    const [firstNameFocus, setFirstNameFocus] = useState(false);

    const [validLastName, setValidLastName] = useState(false);
    const [lastNameFocus, setLastNameFocus] = useState(false);

    const [validUserID, setValidUserID] = useState(false);
    const [userIDFocus, setUserIDFocus] = useState(false);

    useEffect(() => {
        setValidFirstName(NAME_REGEX.test(firstName));
    }, [firstName]);

    useEffect(() => {
        setValidLastName(NAME_REGEX.test(lastName));
    }, [lastName]);

    useEffect(() => {
        setValidUserID(USERID_REGEX.test(userID));
    }, [userID]);

    const registerUser = () => {
        if (validFirstName && validLastName && validUserID && officeName !== '') {
            registerUserService(firstName, lastName, userID, officeName);
        }
    }

    return (
        <div className="page-container">
            <div className="login-container">
                <div className="login-content">
                    <h1>Register user</h1>
                    <div className="mb-2">
                        <label htmlFor="firstName">
                            First Name:
                            <span className={validFirstName ? 'valid text-success' : 'd-none'}>
                                <AiFillCheckCircle />
                            </span>
                            <span className={validFirstName || !firstName ? 'd-none' : 'invalid text-danger'}>
                                <AiFillCloseCircle />
                            </span>
                        </label>
                        <input
                            type="text"
                            id="firstName"
                            placeholder="Enter first name"
                            value={firstName}
                            onChange={(e) => setFirstName(e.target.value)}
                            className="login-input"
                            autoComplete="off"
                            required
                            aria-invalid={validFirstName ? 'false' : 'true'}
                            onFocus={() => setFirstNameFocus(true)}
                            onBlur={() => setFirstNameFocus(false)}
                        />
                        <p id='firstNameNote' style={{ fontSize: '0.75rem' }} className={firstNameFocus && firstName && !validFirstName ? 'instructions text-danger' : 'd-none'}>
                            <AiFillInfoCircle />
                            First Name must be 4 to 8 characters long and start with a capital letter.
                        </p>
                    </div>
                    
                    <div className="mb-2">
                        <label htmlFor="lastName">
                            Last Name:
                            <span className={validLastName ? 'valid text-success' : 'd-none'}>
                                <AiFillCheckCircle />
                            </span>
                            <span className={validLastName || !lastName ? 'd-none' : 'invalid text-danger'}>
                                <AiFillCloseCircle />
                            </span>
                        </label>
                        <input
                            type="text"
                            id="lastName"
                            placeholder="Enter last name"
                            value={lastName}
                            onChange={(e) => setLastName(e.target.value)}
                            className="login-input"
                            autoComplete="off"
                            required
                            aria-invalid={validLastName ? 'false' : 'true'}
                            onFocus={() => setLastNameFocus(true)}
                            onBlur={() => setLastNameFocus(false)}
                        />
                        <p id='lastNameNote' style={{ fontSize: '0.75rem' }} className={lastNameFocus && lastName && !validLastName ? 'instructions text-danger' : 'd-none'}>
                            <AiFillInfoCircle />
                            Last Name must be 4 to 8 characters long and start with a capital letter.
                        </p>
                    </div>

                    <div className="mb-2">
                        <label htmlFor="userID">
                            User ID:
                            <span className={validUserID ? 'valid text-success' : 'd-none'}>
                                <AiFillCheckCircle />
                            </span>
                            <span className={validUserID || !userID ? 'd-none' : 'invalid text-danger'}>
                                <AiFillCloseCircle />
                            </span>
                        </label>
                        <input
                            type="text"
                            id="userID"
                            placeholder="Enter userID"
                            value={userID}
                            onChange={(e) => setUserID(e.target.value)}
                            className="login-input"
                            autoComplete="off"
                            required
                            aria-invalid={validUserID ? 'false' : 'true'}
                            onFocus={() => setUserIDFocus(true)}
                            onBlur={() => setUserIDFocus(false)}
                        />
                        <p id='userIDNote' style={{ fontSize: '0.75rem' }} className={userIDFocus && userID && !validUserID ? 'instructions text-danger' : 'd-none'}>
                            <AiFillInfoCircle />
                            User ID must be exactly 4 digits.
                        </p>
                    </div>

                    <div className="mb-2">
                        <label htmlFor="officeName">Office Name:</label>
                        <input
                            type="text"
                            id="officeName"
                            placeholder="Enter office name"
                            value={officeName}
                            onChange={(e) => setOfficeName(e.target.value)}
                            className="login-input"
                            autoComplete="off"
                            required
                        />
                    </div>

                    <button 
                        onClick={registerUser} 
                        className="login-button"
                        disabled={!validFirstName || !validLastName || !validUserID || officeName === ''}
                    >
                        Submit
                    </button>
                </div>
            </div>
        </div>
    )
}

export default RegisterUser;
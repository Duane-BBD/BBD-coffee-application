import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { UserDetailsProvider } from './context/UserDetailsProvider';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <BrowserRouter>
            <UserDetailsProvider>
                <Routes>
                    <Route exact path="/*" element={<App/>} />
                </Routes>
            </UserDetailsProvider>
        </BrowserRouter>
    </React.StrictMode>
);

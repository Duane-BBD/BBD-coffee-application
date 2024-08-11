import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { UserDetailsProvider } from './context/UserDetailsProvider';
import { GoogleOAuthProvider } from '@react-oauth/google';

const root = ReactDOM.createRoot(document.getElementById('root'));
const clientId = "746000984795-463uft2qmfiv15s2235cp9ein8hbgpsj.apps.googleusercontent.com"

root.render(
    <React.StrictMode>
        <BrowserRouter>
            <UserDetailsProvider>
                <GoogleOAuthProvider 
                    clientId={clientId}
                    // projectId={process.env.configs.web.project_id}
                    // authUri={process.env.configs.web.auth_uri}
                    // clientSecret={process.env.configs.web.client_secret}
                    // redirectUris={process.env.configs.web.redirect_uris}
                    // javascriptOrigins={process.env.configs.web.javascript_origins}
                >
                    <Routes>
                        <Route exact path="/*" element={<App/>} />
                    </Routes>
                </GoogleOAuthProvider>
            </UserDetailsProvider>
        </BrowserRouter>
    </React.StrictMode>
);

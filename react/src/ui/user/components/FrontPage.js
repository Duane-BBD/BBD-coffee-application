import React from "react";
import backgroundimg from "../../common/images/logo.png";
import "../static/FrontPage.css";

function FrontPage() {
  return (
    <div className="Front-page">
        <img className="backroundimg" src={backgroundimg} alt="background" />        
    </div>
  );
}

export default FrontPage;

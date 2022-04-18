import React from 'react'
import "./Home.css";
import Componenteenconst from "./Componenteenconst.jpg"

function Appointment() {
  return (
    <div id='home' className='home__wait'>
      <img
          className="header__logo"
          src={Componenteenconst}
          alt="wait"
        />
    </div>
  )
}

export default Appointment
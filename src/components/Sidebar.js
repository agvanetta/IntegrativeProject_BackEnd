import React from 'react'
import "./Sidebar.css";
import { Link } from "react-router-dom";


function Sidebar() {
  return (
      <>
       <div className='sidebar'>
        <Link to="/dentist" className="links"> <div className='sidebar__options'>Dentists</div> </Link> 
        <Link to="/patient" className="links"> <div className='sidebar__options'>Patients</div> </Link> 
        <Link to="/appointment" className="links"> <div className='sidebar__options'>Appointments</div> </Link> 
       </div>
    </>
  )
}

export default Sidebar
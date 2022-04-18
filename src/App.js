import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Dentist from "./components/Apis/Dentist"
import Header from "./components/Header";
import Patient from "./components/Apis/Patient";
import Appointment from "./components/Apis/Appointment";
import Sidebar from "./components/Sidebar";
// import Footer from "./components/Footer";


function App() {
  return (
    <Router  Redirect to="/" >
      <div className="app">
        <Routes>
          <Route path="/" element={<>{" "} <Header/> <Sidebar/> <Dentist/>  {" "}</>}  />
          <Route path="/dentist" element={<>{" "}<Header /> <Sidebar/> <Dentist/> {" "}</> }  />
          <Route path="/patient"    element={  <>  {" "} <Header /> <Sidebar/> <Patient/>{" "}  </> } />
          <Route path="/appointment" element={   <>{" "}  <Header /> <Sidebar/> <Appointment/> {" "} </> } />
        </Routes>
      </div>
    </Router>
  );
}

export default App;